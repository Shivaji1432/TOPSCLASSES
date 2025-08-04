<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<style>
/* Table styling */
.table-container {
	margin-top: 50px;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	background-color: #ffffff;
}

/* Header cells */
.th {
	font-size: 14px;
	text-transform: uppercase;
	background-color: #f1f1f1;
	padding: 10px;
	font-weight: bold;
	text-align: center;
}

/* Body cells */
td {
	padding: 10px;
	vertical-align: middle;
}

/* Zebra striping */
table tr:nth-child(even) {
	background-color: #f9f9f9;
}

/* Hover effect */
table tr:hover {
	background-color: #e9ecef;
	cursor: pointer;
}
</style>


</head>
<body>
  <div class="container">
    <div class="col-lg-10  mx-auto mt-5 p-5 card">
      <h1 style="color: green; font-weight: bold">Display User</h1>
      <hr>
      <table>
        <tr>
          <th>Id</th>
          <th>Username</th>
          <th>Email</th>
          <th>Action</th>
        </tr>

        <%
        List<User> users = (ArrayList) request.getAttribute("users");
        for (User u : users) {
        %>

        <tr>
          <td><%=u.getId()%></td>
          <td><%=u.getName()%></td>
          <td><%=u.getEmail()%></td>
          <td><a href="update?id=<%=u.getId()%>&action=delete" class="btn btn-danger">Delete</a></td>
          <td><a href="update?id=<%=u.getId()%>&action=update" class="btn btn-primary">Update</a></td>

        </tr>

        <%
        }
        %>
      </table>
    </div>
  </div>
</body>
</html>