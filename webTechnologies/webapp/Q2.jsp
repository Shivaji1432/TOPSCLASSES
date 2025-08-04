<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS Example</title>
    
    <!-- External CSS Link -->
    <link rel="stylesheet" href="Style.css">

    <!-- Internal CSS -->
    <style>
        .internal-style {
            color: white;
            background-color: blue;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Inline CSS -->
    <h1 style="color: red; text-align: center;">This is an Inline Styled Heading</h1>

    <!-- Internal CSS -->
    <p class="internal-style">This paragraph is styled using Internal CSS.</p>

    <!-- External CSS -->
    <div class="external-style">This div is styled using External CSS.</div>

</body>
</html>
