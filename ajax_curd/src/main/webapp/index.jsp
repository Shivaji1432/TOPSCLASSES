<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	load()
})

// Load and display student data
const load = () => {
	$.get("display", {}, function(rt){
		const allData =  JSON.parse(rt)
		var rows = "";

		allData.map(ele => {
			rows += "<tr><td>" + ele.id + "</td>";
			rows += "<td>" + ele.name + "</td>";
			rows += "<td>" + ele.email + "</td>";
			rows += "<td>" + ele.pass + "</td>";
			rows += "<td><button class='btn btn-primary' onclick='getStudentById(" + ele.id + ")'>Update</button></td>";
			rows += "<td><button class='btn btn-danger' onclick='deleteStudent(" + ele.id + ")'>Delete</button></td></tr>";
		})

		$("#tdata").html(rows);
		$("#registerBtn").show();
		$("#updateBtn").hide();
	})
}

// Register new student
const addStudent = () => {
	var uname = $("#uname").val()
	var email = $("#email").val()
	var pass = $("#pass").val()

	$.post("register", {uname, email, pass}, function(rt){
		alert(rt)
		load()

		$("#uname").val("")
		$("#email").val("")
		$("#pass").val("")
	})
}

// Delete student
const deleteStudent = (id) => {
	$.get("delete", {id: id, "action": "delete"}, function(rt){
		alert(rt)
		load()
	})
}

// Get student by ID for editing
const getStudentById = (id) => {
		  $.get("delete", {id: id, action: "update"}, function(rt){
		    const dt = JSON.parse(rt);

		    if (!dt || !dt.id) {
		      alert("User data not found.");
		      return;
		    }

		    $("#id").val(dt.id);
		    $("#uname").val(dt.name);
		    $("#email").val(dt.email);
		    $("#pass").val(dt.pass);

		    $("#registerBtn").hide();
		    $("#updateBtn").show();

	})
}

// Update existing student
const updateStudent = () => {
	var id = $("#id").val()
	var uname = $("#uname").val()
	var email = $("#email").val()
	var pass = $("#pass").val()

	$.post("register", {id, uname, email, pass}, function(rt){
		alert(rt)
		load()

		$("#id").val("")
		$("#uname").val("")
		$("#email").val("")
		$("#pass").val("")

		$("#registerBtn").show()
		$("#updateBtn").hide()
	})
}
const checkusername = (uname)=>{
	
	$.get('validation',{uname},function(rt){
		
		if(rt)
		{
			$("#unameErr").html(rt)
			$("#uname").css("border","1px solid red")
			$("#smbtn").attr('disabled','disabled');
			
		}
		else
		{
			$("#unameErr").html("")
			$("#uname").css("border","")
			$("#smbtn").attr('disabled',false);
		}
	})	
	
}
const search = (uname)=>{
	
	$.get("search",{uname},function(rt){
		
		const allData =  JSON.parse(rt)
		
	 	var rows = "";
		allData.map(ele=>{
			
			rows+="<tr><td>"+ele.id+"</td>"
			rows+="<td>"+ele.name+"</td>"
			rows+="<td>"+ele.email+"</td>"
			rows+="<td>"+ele.phone+"</td>"
			rows+="<td><button class='btn btn-primary' onclick='getStudentById("+ele.id+")'>Update</button></td>"
			rows+="<td><button class='btn btn-danger' onclick='deleteStudent("+ele.id+")'>Delete</button></td></tr>"
			
		})
		
		$("#tdata").html(rows)
	
	})	
	
}
</script>

</head>
<body>


  <div class="container">
    <div class="row mt-5">

      <div class="col-4 card p-3">
        <h1>User Registration</h1>
        <hr>
        <input type="text" name="uname" id="uname" placeholder="Enter username" class="form-control" onblur="checkusername(value)"> <span
          id="unameErr" class="text-danger"></span> <br> <input type="text" name="email" id="email" placeholder="Enter email"
          class="form-control"> <br> <input type="text" name="pass" id="pass" placeholder="Enter pass" class="form-control"> <br>
        <button class="btn btn-success" id="registerBtn" onclick="addStudent()">Register</button>
        <button class="btn btn-warning" id="updateBtn" onclick="updateStudent()" style="display: none;">Update</button>

      </div>
      <div class="col-1"></div>
      <div class="col-7 card p-3">
        <h2 align="center">User Details</h2>
        <hr>
        <input type="text" class="form-control" placeholder="search..." onkeyup="search(value)">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Username</th>
              <th>Email</th>
              <th>pass</th>
            </tr>
          </thead>
          <tbody id="tdata">

          </tbody>
        </table>

      </div>

    </div>
  </div>

</body>
</html>