
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
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
                }

                h2{
                text-align:center;
                margin:7rem;
                color:green;
                }
                .update{
                text-align:center;
                margin:7rem;
                padding:1rem;
                }
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

    <h2>${msg}</h2>

    <button type="submit" class="update"><a href="fetchUsers?email=${emailId}">Updated Profile</a></button>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
