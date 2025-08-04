<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container">
    <div class="row mt-5">
      <div class="col-5  mt-5 p-5 card">
        <h3 class="text-center mb-4">Add Product</h3>

        <form action="add" method="post">
        <input type="hidden" name="id" value="${product.id }">

          <!-- Category Dropdown -->
          <div class="mb-3">
            <label for="category" class="form-label">Category</label> <select name="category" id="category" class="form-select">
              <option value="">-- Select Category --</option>
              <c:forEach items="${categories}" var="dt">
                <option value="${dt.id}">${dt.name}</option>
              </c:forEach>
            </select>
          </div>

          <!-- Product Text -->
          <div class="mb-3">
            <label for="name" class="form-label">Product Name</label> <input type="text" name="name" id="name" class="form-control" required value="${product.name }"> 
          </div>

          <!-- Price -->
          <div class="mb-3">
            <label for="price" class="form-label">Price</label> <input type="number" name="price" id="price" class="form-control" required value="${product.price }">
          </div>

          <!-- Quantity -->
          <div class="mb-3">
            <label for="qty" class="form-label">Quantity</label> <input type="number" name="qty" id="qty" class="form-control" required value="${product.qty }">
          </div>


          <!-- Gender Radio -->
          <div class="mb-3">
            <label class="form-label">Gender</label><br>
            <div class="form-check form-check-inline">
              <input type="radio" name="gender" value="male" id="male" class="form-check-input" value="${product.gender}"> <label for="male" class="form-check-label">Male</label>
            </div>
            <div class="form-check form-check-inline">
              <input type="radio" name="gender" value="female" id="female" class="form-check-input" value="${product.gender }"> <label for="female"
                class="form-check-label">Female</label>
            </div>
          </div>

          <!-- Size Checkboxes -->
          <div class="mb-3">
            <label class="form-label">Available Sizes</label><br>
            <div class="form-check form-check-inline">
              <input type="checkbox" name="size" value="S" id="sizeS" class="form-check-input" > <label for="sizeS" class="form-check-label">S</label>
            </div>
            <div class="form-check form-check-inline">
              <input type="checkbox" name="size" value="M" id="sizeM" class="form-check-input"> <label for="sizeM" class="form-check-label">M</label>
            </div>
            <div class="form-check form-check-inline">
              <input type="checkbox" name="size" value="L" id="sizeL" class="form-check-input" > <label for="sizeL" class="form-check-label">L</label>
            </div>
            <div class="form-check form-check-inline">
              <input type="checkbox" name="size" value="XL" id="sizeXL" class="form-check-input" > <label for="sizeXL" class="form-check-label">XL</label>
            </div>
          </div>

          <button type="submit" class="btn btn-primary w-100">Submit</button>

        </form>
      </div>
      <div class="col-6 mt-5 p-5 card">
        <h3 class="text-center mb-4">Add Product</h3>
        <hr>
        <table class="table">
          <tr>
            <th>Id</th>
            <th>Category</th>
            <th>Name</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Gender</th>
            <th>size</th>
            <th>Action</th>
          </tr>

          <%
          ArrayList<Product> prods = (ArrayList) request.getAttribute("products");
          for (Product p : prods) {
          %>
          <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getCategory().getName()%></td>
            <td><%=p.getName()%></td>
            <td><%=p.getPrice()%></td>
            <td><%=p.getQty()%></td>
            <td><%=p.getGender()%></td>
            <td class="badge badge-primary">
              <%
              String str[] = p.getSize().split(",");
              for (String s : str) {
              %> <span><%=s%></span> <%
            		  }
                  %>
            </td>
            <td><a href="update?action=update&id=<%=p.getId()%>" class="btn btn-primary">Update</a></td>
            <td><a href="update?action=delete&id=<%=p.getId()%>" class="btn btn-danger">Delete</a></td>

          </tr>
          <%
          }
          %>


        </table>
      </div>
    </div>
  </div>
</body>
</html>
