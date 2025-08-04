<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Margin and Padding Example</title>
    <style>
        /* Margin Example */
        .margin-example {
            background-color: lightblue;
            margin: 50px; /* Creates space outside */
            padding: 10px;
            text-align: center;
        }

        /* Padding Example */
        .padding-example {
            background-color: lightgreen;
            padding: 20px; /* Creates space inside */
            border: 2px solid green;
            width: 50%;
            margin: auto; /* Centers the div */
            text-align: center;
        }

        /* Different Margin and Padding Effect */
        .box {
            background-color: coral;
            margin: 30px 60px; /* 30px top-bottom, 60px left-right */
            padding: 15px 40px; /* 15px top-bottom, 40px left-right */
            border: 2px solid red;
            text-align: center;
        }
    </style>
</head>
<body>

    <h1 class="margin-example">This heading has a margin of 50px</h1>

    <div class="padding-example">
        This div has padding of 20px, creating space inside the border.
    </div>

    <div class="box">
        This box has different margin and padding values.
    </div>

</body>
</html>
    