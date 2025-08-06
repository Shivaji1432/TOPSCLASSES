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
                        <td>ShivShankar</td>
                        <td>shiv@example.com</td>
                        <td>9825361532</td>
                        <td>Surat</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Ashish Sharma</td>
                        <td>amit@example.com</td>
                        <td>9534455289</td>
                        <td>Bombay</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Sitesh malptra</td>
                        <td>pooja@example.com</td>
                        <td>9846276655</td>
                        <td>Pune</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Shiva Singh</td>
                        <td>Shiva@example.com</td>
                        <td>9782152233</td>
                        <td>Bhuj</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
