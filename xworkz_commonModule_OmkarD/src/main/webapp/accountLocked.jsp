<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp Response Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .container {
                margin-top: 5rem;
                text-align: center;
            }
            #logo{
                        height:100px;
            }
            h1 {
                margin-bottom: 2rem;
                color: #007bff;
            }
            .btn-custom {
                margin: 0.5rem;
                padding: 0.75rem 1.5rem;
                background-color: #17a2b8;
                border: none;
                background-color:pink;
            }
            .btn-custom a {
                color: white;
                text-decoration: none;
            }
            .btn-custom:hover {
                background-color: red;
            }
            .navbar-custom {
                background-color: black;
            }
            .navbar-custom .navbar-brand,
            .navbar-custom .nav-link {
                color: white;
            }
            .nav-link:hover{
            background-color:red;
            }
            .navbar-nav{
            text-align:center;
        </style>


</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-custom">
        <div class="container-fluid">
<img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo" id="logo">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                     </li>

                    <li class="nav-item">
                        <a class="nav-link" href="signUp.jsp">SignUp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signin.jsp">SignIn</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <h2>Account Locked</h2>
        <div class="message">
            Your account is locked due to multiple failed login attempts. Try again after:
        </div>
        <p>You can try again after: <span class="unlock-time"><c:out value="${unlockTime}" /></span> (in 24 hours)</p>
        <a class="back-link" href="forgotPassword.jsp">Forgot Password</a>
    </div>
</body>
</html>
