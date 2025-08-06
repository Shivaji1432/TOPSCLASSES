<%@include file="header.jsp"%>
<%@ page session="true" %>
<%
    String email = (String) session.getAttribute("userEmail");
    String name = (String) session.getAttribute("userName");

    if (email == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <div class="container mt-4">
        <h2>Welcome, <%= name %>!</h2>
        <p>You are logged in with email: <%= email %></p>
        <a href="changePassword.jsp" class="btn btn-warning">Change Password</a>
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>
</body>
</html>
