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
		<h2 class="text-3xl font-bold text-center mb-6 text-gray-800">Sign
			Up</h2>

		<form action="signup" method="post" class="space-y-4">
			<span style="color: green">${msg}</span>
			<span style="color: red">${err}</span>
			<div class="flex space-x-4">
				<div class="w-1/2">
					<label class="block text-gray-700">First Name</label> <input
						type="text" name="fname" placeholder="John"
						class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
				</div>
				<div class="w-1/2">
					<label class="block text-gray-700">Last Name</label> <input
						type="text" name="lname" placeholder="Doe"
						class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
				</div>
			</div>

			<div>
				<label class="block text-gray-700">Email</label> <input type="email"
					name="email" placeholder="you@example.com"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			<div>
				<label class="block text-gray-700">Phone</label> <input type="tel"
					name="phone" placeholder="123-456-7890"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			<div>
				<label class="block text-gray-700">Password</label> <input
					type="password" name="pass" placeholder="••••••••"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			<div>
				<label class="block text-gray-700">Confirm Password</label> <input
					type="password" name="cpass" placeholder="••••••••"
					class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
			</div>

			<button type="submit"
				class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition duration-300">
				Create User</button>
			<a href="display"
				class="block text-center w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition duration-300">
				View Users Info </a>
				<a href="login.jsp"
				class="block text-center w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition duration-300">
				Already Register </a>

		</form>
	</div>

</body>
</html>
