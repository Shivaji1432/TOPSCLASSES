<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Table</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <h2 class="text-center mb-4">User Data Table</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>City</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Roshan Gupta</td>
                        <td>roshan@example.com</td>
                        <td>9876543210</td>
                        <td>Surat</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Amit Sharma</td>
                        <td>amit@example.com</td>
                        <td>9123456789</td>
                        <td>Mumbai</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Pooja Verma</td>
                        <td>pooja@example.com</td>
                        <td>9988776655</td>
                        <td>Delhi</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Rahul Singh</td>
                        <td>rahul@example.com</td>
                        <td>9900112233</td>
                        <td>Bangalore</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
