<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="col-lg-5  mx-auto mt-5 p-5 card">
		<%
		String name=(String)session.getAttribute("user");
		if(name==null){
			request.setAttribute("err", "Please login first");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		%>
			<table>
				<tr>
					<th>Id</th>
					<th>Username</th>
					<th>Email</th>
					<th>Action</th>
					 <th><a href="logout" class="btn btn-primary">Log Out</a></th>
				</tr>

				<%
				List<User> users = (ArrayList) request.getAttribute("users");
				for (User u : users) {
				%>

				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getUname()%></td>
					<td><%=u.getEmail()%></td>
					<td><a href="update?id=<%= u.getId() %>&action=delete"
                           class="btn btn-danger">Delete</a></td>
                    <td><a href="update?id=<%= u.getId() %>&action=update"
                           class="btn btn-primary">Update</a></td>
				</tr>

				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>