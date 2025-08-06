<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>Reset Your Password</h2>
    <form method="post" action="ResetPasswordServlet">
        <div class="mb-3">
            <label>New Password</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Confirm Password</label>
            <input type="password" id="cpassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Update Password</button>
        <div id="formError" class="text-danger mt-2"></div>
    </form>
</div>

<script>
    // Client-side check
    document.querySelector('form').addEventListener('submit', function (e) {
        if (document.getElementById("password").value !== document.getElementById("cpassword").value) {
            e.preventDefault();
            document.getElementById("formError").innerText = "Passwords do not match!";
        }
    });
</script>
</body>
</html>
