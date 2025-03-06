<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-size: cover;
            font-family: 'Montserrat', sans-serif;
            color: black;
        }
        .container {
            margin-top: 5rem;
            max-width: 500px;
        }
        #logo{
            height:100px;
        }
        h1 {
            margin-bottom: 2rem;
            color: blue;
            font-width:bold;
            text-shadow: 2px 2px 4px #000;
            text-align: center;
        }
        .card {
            background: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .btn-custom {
            margin: 0.5rem;
            padding: 0.75rem 1.5rem;
            background-color: red;
            border: none;
            color: white;
            width: 100%;
        }
        .btn-custom:hover {
            background-color: red;
        }
        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
        }
        .navbar-custom {
            background-color: rgba(0, 0, 0, 0.8);
        }
        .navbar-custom .navbar-brand,
        .navbar-custom .nav-link {
            color: white;
            text-align:center;
        }
        .nav-link:hover {
            background-color: #007bff;
            color: white;
        }
        .nav-item{
        text-align:right;
        }
        .error-message {
            color: red;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
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

                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
            <h1>Sign In Form</h1>
            <div class="card">
             <form action="userSignIn" method="post">

              <div class="mb-3">
                 <label for="email" class="form-label">Email:</label>
                   <input type="email" class="form-control" id="email" name="email" value="${moduleDto.email}" placeholder="Enter your email" >
                      <span style="color: red;">${emailError}</span>
                   </div>

                <div class="mb-3">
                     <label for="password" class="form-label">Password:</label>
                      <input type="password" class="form-control" id="password" name="password" value="${moduleDto.password}" placeholder="Enter your password" >
                      <span style="color: red;">${error}</span>
                  </div>

       <button type="submit" class="btn btn-custom">SignIn</button>
                  </form>
              </div>
          </div>

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
      </body>
      </html>