<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ID and Class Styling</title>
    <style>
        /* Unique styling for an element with ID */
        #unique-heading {
            color: #ff6600;
            font-size: 24px;
            text-align: center;
            background-color: #f8f8f8;
            padding: 10px;
            border-radius: 5px;
        }

        /* Common styling for multiple elements using class */
        .common-box {
            background-color: #e0e0e0;
            padding: 15px;
            margin: 10px;
            border-radius: 10px;
            text-align: center;
            font-size: 18px;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <!-- Element with ID (Styled Uniquely) -->
    <h1 id="unique-heading">Welcome to My Webpage</h1>

    <!-- Multiple Elements Using Class -->
    <div class="common-box">Box 1 - Styled with class</div>
    <div class="common-box">Box 2 - Styled with class</div>
    <div class="common-box">Box 3 - Styled with class</div>

</body>
</html>
    