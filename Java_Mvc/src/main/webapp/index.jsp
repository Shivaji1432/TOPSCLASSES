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

    <script>

        function validation()
        {
            var uname = document.getElementById("uname").value
            var email = document.getElementById("email").value
            var pass = document.getElementById("pass").value
            var cpass = document.getElementById("cpass").value


            var unameErr  =document.getElementById("unameErr")
            var emailErr  =document.getElementById("emailErr")
            var passErr  =document.getElementById("passErr")
            var cpassErr  =document.getElementById("cpassErr")

            var btn = document.getElementById("smbtn")

            var unameExp = /^[a-zA-Z]+$/
            var emailExp = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-z]+$/
        	    // abc@gmail.com
            if(uname==null || uname=="")
            {
                unameErr.innerHTML="Username Required !!!"
                btn.disabled=true
            }
            else if(!unameExp.test(uname))
            {
                unameErr.innerHTML="Only alphabates are allowed"
                btn.disabled=      
            }
            else{
                unameErr.innerHTML=""
                btn.disabled=false
            }

            if(email==null || email=="")
            {
                emailErr.innerHTML="Email Required !!!"
                btn.disabled=true
            }
            else if(!emailExp.test(email))
            {
                emailErr.innerHTML="Invalid email format"
                btn.disabled=true
            }
            else{
                emailErr.innerHTML=""
                btn.disabled=false
            }

            if(pass==null || pass=="")
            {
                passErr.innerHTML="password Required !!!"
                btn.disabled=true
            }
            else{
                passErr.innerHTML=""
                btn.disabled=false
            }

            if(cpass==null || cpass=="")
            {
                cpassErr.innerHTML="Cpass required"
                btn.disabled=true
            }
            else if(pass!=cpass)
            {
                cpassErr.innerHTML="cpass must be same as pass"
                btn.disabled=true
            }
            else{
                cpassErr.innerHTML=""
                btn.disabled=false
            }

          
        }

    </script>


</head>
<body>


    <div class="container">
    <div class="col-md-5 col-lg-5 col-sm-12 mx-auto mt-5 p-5 card">
    <span style="color: green">${msg}</span>
    <span style="color: green">${err}</span>
    <h2>Registration Form</h2>
        <hr>
    <form action="reg" method="post">

        <div class="form-group">
        <label for="uname">Username</label>
        <input type="text" id="uname" name="uname" class="form-control" onkeyup="validation()">
        <span id="unameErr" class="text-danger"></span>
         </div>

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

        <div class="form-group">
        <label for="cpass">Confirm Password</label>
        <input type="text" id="cpass" name="cpass" class="form-control" onkeyup="validation()">
        <span id="cpassErr" class="text-danger"></span>
        </div>

        <br>
        <input type="submit" class="btn btn-success" id="smbtn">
        <input type="reset" class="btn btn-info">
        <a href="Display">View All Users</a>
        <a href="login.jsp">Login Here</a>
    </form> 
</div>
</div>


</body>
</html>