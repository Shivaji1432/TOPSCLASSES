<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Form</title>
<style>
.logout {
    display: inline-block;
    margin: 10px 0;
    background-color: #008CBA;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 4px;
}

.logout:hover {
    background-color: #007bb5;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: white;
}

th, td {
    border: 1px solid #ccc;
    padding: 10px;
    text-align: left;
}

thead {
    background-color: #f2f2f2;
}
</style>
</head>
<body>
<%
User user=(User)session.getAttribute("user");
if(user==null){
	request.setAttribute("err", "please login first");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	return;
}

%>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Pass</th>
			<th colspan="2">Action</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<User> users= (ArrayList) request.getAttribute("user");
		for(User u: users){
			%>
			<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getUserName()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPass()%></td>
					<td><a href="update?id=<%=u.getId()%>&action=delete"
						class="logout">Delete</a></td>
					<td><a href="update?id=<%=u.getId()%>&action=update"
						class="logout">Update</a></td>
				</tr>
			
			<%
		}
		%>
	</tbody>
</table>
<fieldset style="display: flex;justify-content: center;">
<a href="logout" class="logout" style="padding: 5px;">LogOut</a><br>
<a href="index.jsp" class="logout" style=" padding: 5px;">Home</a>
</fieldset>
</body>
</html>
