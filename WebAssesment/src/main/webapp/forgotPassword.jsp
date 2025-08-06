<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h2>Forgot Password</h2>
    <form method="post" action="ForgotPasswordServlet">
        <div class="mb-3">
            <label>Enter Registered Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
            <small id="emailError" class="text-danger"></small>
        </div>
        <button type="submit" class="btn btn-primary">Send OTP</button>
    </form>
</div>
</body>
</html>
