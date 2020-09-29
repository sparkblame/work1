package controller;

import dao.DownloadDao;
import vo.Download;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(urlPatterns = "/getDownloadList.do")
public class GetDownloadListController extends HttpServlet {
    static Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8&useSSL=false","root","Syf123456l");

			DownloadDao downDao = new DownloadDao(con);
            List<Download> downloadList = downDao.selectAll();
            System.out.println(downloadList);
            req.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession();
            session.setAttribute("dList",downloadList);
            System.out.println(downloadList);
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.sendRedirect("download.jsp");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
