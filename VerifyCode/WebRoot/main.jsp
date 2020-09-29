<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <img src="image/brightStar.png" alt="1">
<span class="user">欢迎您：<%=session.getAttribute("userName") %> <a onclick="window.location.href='login.html'">【安全退出】</a></span>
<ul>
    <li><a href="main.jsp">首页</a></li>
    <li>|</li>
    <li><a href="getDownloadList.do">下载</a></li>
</ul>
  </body>
</html>
