<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigation & Form Styling</title>
    <style>
        /* Navigation Menu Styling */
        nav {
            background-color: #333;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            font-size: 18px;
            display: inline-block;
        }

        /* Change link color on hover */
        nav a:hover {
            background-color: #ff6600;
            color: white;
            border-radius: 5px;
        }

        /* Form Styling */
        form {
            width: 300px;
            margin: 20px auto;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 2px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        /* Change input border and background on focus */
        input:focus {
            border-color: #ff6600;
            background-color: #fff5e6;
            outline: none;
        }

        button {
            background-color: #ff6600;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 18px;
            border-radius: 5px;
        }

        button:hover {
            background-color: #cc5500;
        }
    </style>
</head>
<body>

    <!-- Navigation Menu -->
    <nav>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Contact</a>
    </nav>

    <!-- Form with Pseudo-Classes -->
    <form>
        <input type="text" placeholder="Enter your name">
        <input type="email" placeholder="Enter your email">
        <input type="password" placeholder="Enter your password">
        <button type="submit">Submit</button>
    </form>

</body>
</html>
    