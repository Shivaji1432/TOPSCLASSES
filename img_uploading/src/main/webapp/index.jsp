<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     
			<form action="upload" method="post" enctype="multipart/form-data">
			<input type="text" name="name" placeholder="Enter name"> 
			<input type="file" name="img">
			<input type="submit">		
			</form>
			
			<br>
			<br>
			<table>
			<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Image</td>
			</tr>
			
			
			<%
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn  =DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork","root","Pubg@1432");
		
			PreparedStatement ps = cn.prepareStatement("select * from upload");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{ %>
				
					<tr>
					<td><%=rs.getInt(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><img  src="img/<%=rs.getString(3)%>" width="25px" height="25px"></td>
					</tr>
				
			<%}
			
			
			%>
			
			</table>
</body>
</html>