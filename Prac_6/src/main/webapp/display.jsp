<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="model.Users"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">

<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
	background-color: #f5f5f5;
}

table {
	border-collapse: collapse;
	width: 100%;
	background-color: #ffffff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	text-align: left;
	padding: 12px;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: #f1f1f1;
}

h1 {
	color: #333;
}
</style>
</head>
<body>
	<div class="container">
		<div class="col-lg-5  mx-auto mt-5 p-5 card">
			<%
			String email = (String) session.getAttribute("users");
			if (email == null) {
				request.setAttribute("err", "Please login first");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
			%>
			<table>
				<tr>
					<th>Id</th>
					<th>FName</th>
					<th>LName</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Pass</th>
					<th colspan="2">Action</th>
					<th><a href="logout" class="btn btn-primary">Log Out</a></th>
				</tr>
				<%
				List<Users> users = (ArrayList) request.getAttribute("users");
				for (Users u : users) {
				%>
				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getFname()%></td>
					<td><%=u.getLname()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPhone()%></td>
					<td><%=u.getPass()%></td>
					<td><a href="update?id=<%=u.getId()%>&action=delete"
						class="btn btn-danger">Delete</a></td>
					<td><a href="update?id=<%=u.getId()%>&action=update"
						class="btn btn-primary">Update</a></td>
				</tr>

				<%
				}
				%>
				<tr>
					<th colspan="8" style="text-align: center"><a href="logout"
						class="block text-center w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition duration-300">Log
							Out</a></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
