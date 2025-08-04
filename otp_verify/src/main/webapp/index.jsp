<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <style>
        .label {
            color: black;
            font-weight: bold;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="col-md-4 mx-auto mt-5 p-4 card shadow rounded">
            <h2 class="text-center text-success mb-4">Login Form</h2>
            <form action="sendotp" method="post">
                
                <div class="mb-3">
                    <label class="label">Enter your Email</label>
                    <input type="text" class="form-control" name="email" required>
                </div>
                
                <div class="mb-3">
                    <label class="label">Enter your Password</label>
                    <input type="password" class="form-control" name="pass" required>
                </div>

                <div class="text-center">
                    <input type="submit" class="btn btn-success" value="Login">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
