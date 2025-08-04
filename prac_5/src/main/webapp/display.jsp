<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="col-ld-12 mx-auto mt-5 p-5 card">
			<%
			User loggedInUser = (User) session.getAttribute("user");
			if (loggedInUser == null) {
				request.setAttribute("err", "Please login first");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			%>
			<table>
				<thead style="font-style: italic; font: bold; background: gray;">
					<tr>
						<th>Id</th>
						<th>Uname</th>
						<th>Email</th>
						<th>pass</th>
						<th colspan="2">Action</th>
						<th><a href="logout" class="btn btn-primary">Logout</a></th>
					</tr>
				</thead>
				<tbody style="background: silver;">
					<%
					List<User> user = (ArrayList) request.getAttribute("user");
					if (user != null) {
						for (User u : user) {
					%>
					<tr>
						<td><%=u.getId()%></td>
						<td><%=u.getUname()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getPass()%></td>
						<td><a href="update?id=<%=u.getId()%>&action=Delete"
							class="btn btn-danger">Delete</a></td>
						<td><a href="update?id=<%=u.getId()%>&action=Update"
							class="btn btn-success">Update</a></td>
					</tr>
					<%
					}
					}
					%>

				</tbody>
			</table>
			<a href="index.jsp" class="btn btn-primary">Home</a>
		</div>
	</div>
</body>
</html>