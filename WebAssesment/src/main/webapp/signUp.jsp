<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h2>User Signup</h2>
    <form id="signupForm" method="post" action="RegisterServlet">
        <div class="mb-3">
            <label>First Name</label>
            <input type="text" name="fname" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Last Name</label>
            <input type="text" name="lname" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
            <small id="emailError" class="text-danger"></small>
        </div>
        <div class="mb-3">
            <label>Mobile</label>
            <input type="text" name="mobile" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Address</label>
            <textarea name="address" class="form-control" required></textarea>
        </div>
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male" required> Male
            <input type="radio" name="gender" value="Female" required> Female
        </div>
        <div class="mb-3">
            <label>Password</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Confirm Password</label>
            <input type="password" id="cpassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Sign Up</button>
        <div id="formError" class="text-danger mt-2"></div>
    </form>
</div>

<script>
    // AJAX Email Check
    $('#email').on('blur', function() {
        var email = $(this).val();
        $.ajax({
            url: 'CheckEmailServlet',
            method: 'POST',
            data: { email: email },
            success: function(response) {
                if (response.trim() === "exists") {
                    $('#emailError').text("Email is already registered.");
                } else {
                    $('#emailError').text("");
                }
            }
        });
    });

    // JS Form Validation
    $('#signupForm').on('submit', function(e) {
        if ($('#password').val() !== $('#cpassword').val()) {
            e.preventDefault();
            $('#formError').text("Passwords do not match.");
        }
        if ($('#emailError').text() !== "") {
            e.preventDefault();
            $('#formError').text("Please fix email issue.");
        }
    });
</script>
</body>
</html>
