package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UserDao;
import tools.JdbcUtil;
import vo.User;

public class test {
	public static void main(String[] args) {
		String userName ="admin";
		User user =null;
		UserDao udao = new UserDao();
		user=udao.getInfo("admin");
		System.out.println(user);
	}
}
