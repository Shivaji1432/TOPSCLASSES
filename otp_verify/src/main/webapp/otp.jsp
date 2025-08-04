<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
            <h2 class="text-center text-success mb-4">Otp Verification</h2>
           <span> ${msg}</span>
                <form action="otp">
                <div class="mb-3">
                    <label class="label">Enter OTP</label>
                    <input type="text" class="form-control" name="otp" required>
                </div>
                
                <div class="text-center">
                    <input type="submit" class="btn btn-success">
                </div>
                </form>
                </div>
           
        </div>
</body>
</html>