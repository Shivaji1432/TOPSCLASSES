<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("userEmail") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>Change Your Password</h2>
    <form method="post" action="ChangePasswordServlet">
        <div class="mb-3">
            <label>Old Password</label>
            <input type="password" name="oldPassword" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>New Password</label>
            <input type="password" name="newPassword" id="newPassword" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Confirm New Password</label>
            <input type="password" id="cnewPassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-warning">Change Password</button>
        <div id="formError" class="text-danger mt-2"></div>
    </form>
</div>

<script>
    document.querySelector('form').addEventListener('submit', function(e) {
        if (document.getElementById("newPassword").value !== document.getElementById("cnewPassword").value) {
            e.preventDefault();
            document.getElementById("formError").innerText = "New passwords do not match!";
        }
    });
</script>
</body>
</html>
