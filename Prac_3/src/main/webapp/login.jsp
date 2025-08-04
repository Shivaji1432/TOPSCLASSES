<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sign Up</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

	<div class="bg-white p-8 rounded-2xl shadow-lg w-full max-w-lg">
		<h2 class="text-3xl font-bold text-center mb-6 text-gray-800">Login Page</h2>

		<form action="login" method="post" class="space-y-4">
			<span style="color: green">${msg}</span>
			<span style="color: red">${err}</span>
			<div class="flex space-x-4">
				
			</div>

			<div>
				<label class="block text-gray-700">Email</label> <input type="email"
					name="email" placeholder="you@example.com"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			
			<div>
				<label class="block text-gray-700">Password</label> <input
					type="password" name="pass" placeholder="••••••••"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			

			<button type="submit"
				class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition duration-300">
				Login User</button>
			<a href="index.jsp"
				class="block text-center w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition duration-300">
				Register here </a>

		</form>
	</div>

</body>
</html>
