package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.JdbcUtil;
import vo.User;
import dao.UserDao;
@WebServlet(urlPatterns="/login.do")
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String vcode=request.getParameter("userCode");
		String forwardPath="";
		HttpSession session = request.getSession();
		String saveCode=(String)session.getAttribute("verifyCode");
		String msg ;
		if(!vcode.equalsIgnoreCase(saveCode)){
			request.setAttribute("info","验证码不正确" );
			forwardPath="/error.jsp";
		}
		else{
			UserDao userDao = new UserDao();
			if(userDao.getInfo(userName) == null){
				request.setAttribute("info","您输入的用户名有误"+"user:"+userName+"用户"+userDao.getInfo(userName));
				System.out.println(userName+userDao.getInfo(userName));
				forwardPath="/error.jsp";
			}
			else{
				User currentUser = userDao.getInfo(userName);
				if(currentUser.getPassword().equals(password)){
					session.setAttribute("userName",currentUser.getChrName());
					System.out.println(currentUser);
					forwardPath="/main.jsp";
				}
				else{
					request.setAttribute("info", "您输入的密码不正确");
					forwardPath="/error.jsp";
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
