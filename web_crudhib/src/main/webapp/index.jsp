<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>
  <div class="container">
    <div class="col-md-5 mt-5 mx-auto p-4 card">
    <h2 style="font-weight: bold;color: red;" class="mb-3 text-center">REGISTER USER</h2>
    <span style="color: green">${msg}</span>
    <span style="color: red">${err}</span>
      <form action="reg" method="post">
          <input type="hidden" id="id" name="id" class="form-control" value="${user.id}">
          <label for="name" class="form-label">Name</label>
          <input type="text" id="name" name="name" class="form-control" value="${user.name}">
        
          <label for="email" class="form-label">Email</label>
          <input type="email" id="email" name="email" class="form-control"value="${user.email}">

        <div class="text-center mt-3">
          <button type="submit" class="btn btn-primary">Submit</button>
          <button type="submit" class="btn btn-primary">Reset</button>
          <a href="display" class="btn btn-primary">View Users</a>
          
          </div>
      </form>
    </div>
  </div>
</body>
</html>
