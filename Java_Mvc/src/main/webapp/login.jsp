<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

    


</head>
<body>


    <div class="container">
    <div class="col-md-5 col-lg-5 col-sm-12 mx-auto mt-5 p-5 card">
    <span style="color: green">${err}</span>
    <span style="color: green">${msg}</span>
    <h2>login Form</h2>
        <hr>
    <form action="login" method="post">
         <div class="form-group">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" class="form-control" onkeyup="validation()">
        <span id="emailErr" class="text-danger"></span>
</div>

<div class="form-group">
        <label for="pass">Password</label>
        <input type="text" id="pass" name="pass" class="form-control" onkeyup="validation()">
        <span id="passErr" class="text-danger"></span>
        </div>

      

        <br>
        <input type="submit" class="btn btn-success" id="smbtn">
        <input type="reset" class="btn btn-info">
        <a href="index.jsp">register user</a>
    </form> 
</div>
</div>


</body>
</html>