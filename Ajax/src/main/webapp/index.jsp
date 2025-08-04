<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

<script type="text/javascript">
		$(document).ready(function(){
			//alert("hello")
			getCountries()
	     		})
	    const getCountries = ()=>{

				$.get("countries",{},function(rt){
					country.innerHTML=rt;
				})	
		}
		
		const getState = (cid)=>{
			
				$.get("states",{cid},function(rt){
					state.innerHTML = rt
				})
		
		}
		
		const getCities = (sid)=>{
				
				$.get("cities",{sid},function(rt){
					city.innerHTML=rt
				})	
		
		}
		
		const hello=()=>{
		var uname=$("#uname").val()
						
						
		$.get("hello",{uname},function(rt){
				alert(rt)
								
						
				})
		}
		function search(value) {

		$.get("search",{value},function(rt){
		$("#data").html(rt)
							
				})
						
					
		}
</script>
</head>
<body>
	<input type="text" id="uname">
	<button onclick="hello()">submit</button>

	<hr>

	<input type="text" placeholder="serach here " onkeyup="search(value)">
	<div id="data"></div>

<hr>

	<select id="country" onchange="getState(value)">
		<option>---Select country---</option>
	</select>

	<select id="state" onchange="getCities(value)">
		<option>---Select state---</option>
	</select>

	<select id="city">
		<option>---Select city ---</option>
	</select>
</body>
</html>