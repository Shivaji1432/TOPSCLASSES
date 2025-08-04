<%@page import="dao.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <div class="col-lg-10  mx-auto mt-5 p-5 card">
      <h1 style="color: green; font-weight: bold">Display User</h1>
      <hr>
      <table>
        <tr>
          <th>Id</th>
          <th>Username</th>
          <th>Email</th>
          <th>Action</th>
        </tr>

        <c:forEach items="${users}" var="dt">

          <tr>
            <td>${dt.getId()}</td>
            <td>${dt.getName()}</td>
            <td>${dt.getEmail()}</td>
            <td><a href="update?action=update&id=${dt.getId()}" class="btn btn-primary">Update</a></td>
            <td><a href="update?action=delete&id=${dt.getId()}" class="btn btn-danger">Delete</a></td>

          </tr>

        </c:forEach>


      </table>
    </div>
  </div>

</body>
</html>
