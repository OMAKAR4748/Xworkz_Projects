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
         background: linear-gradient(to right, white, white);
         font-family: 'Montserrat', sans-serif;
         color: #333;
         height: 100vh;
         display: flex;
         flex-direction: column;
         align-items: center;
         margin: 0;
         padding: 0;
     }

    header{
         position:sticky;
    }
     .navbar {
         width: 100%;
         background-color: rgba(0, 0, 0, 0.8);
         padding: 15px 0;
         text-align: center;
         position: fixed;
         top: 0;
         left: 0;
         z-index: 1000;
     }

     .navbar a {
         color: white;
         text-decoration: none;
         padding: 10px 20px;
         display: inline-block;
     }

     .navbar a:hover {
         background-color: #ff5e62;
     }

     .container {
         max-width: 600px;
         background: #fff;
         padding: 2rem;
         border-radius: 12px;
         box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
         text-align: center;
         margin-top: 100px;

     }
     #logo{
                 height:80px;
             }

     h1 {
         color: blue;
         font-weight: bold;
         margin-bottom: 1.5rem;
         text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);
     }

     .form-control {
         width: 100%;
         border-radius: 8px;
         border: 1px solid #ccc;
         padding: 12px;
         font-size: 1rem;
         margin-top: 5px;
         transition: 0.3s;
     }

     .form-control:focus {
         border-color: #ff5e62;
         box-shadow: 0 0 10px rgba(255, 94, 98, 0.5);
         outline: none;
     }

     .btn-custom {
         background-color: red;
         color: white;
         padding: 12px 20px;
         border: none;
         border-radius: 8px;
         cursor: pointer;
         transition: 0.3s;
         width: 100%;
         font-size: 1rem;
         margin-top: 15px;
     }

     .btn-custom:hover {
         background-color: red;
         transform: scale(1.05);
     }

     .error-message {
         color: red;
         font-size: 0.9rem;
         margin-top: 5px;
     }

     label {
         font-weight: 600;
         display: block;
         text-align: left;
         margin-top: 10px;
     }

    </style>
</head>
<body>
<header>
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
</header>

   <div class="container">
           <h1>Update Form</h1>
           <div class="form-container">
               <form action="UpdateDetails" method="post">
                   <div class="row">
                       <div class="col-md-6 mb-3">
                           <label for="name" class="form-label">Full Name:</label>
                           <input type="text" class="form-control" id="name" name="name" value="${moduleDto.name}" placeholder="Enter your full name">
                           <span style="color: red;">${nameError}</span>
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="email" class="form-label">Email:</label>
                           <input type="email" class="form-control" id="email" name="email" value="${moduleDto.email}" placeholder="Enter your email">
                           <span style="color: red;">${emailError}</span>
                       </div>
                   </div>

                   <div class="row">
                       <div class="col-md-6 mb-3">
                           <label for="age" class="form-label">Age:</label>
                           <input type="number" class="form-control" id="age" name="age" value="${moduleDto.age}" placeholder="Enter your age">
                           <span style="color:red;">${ageError}</span>
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="gender">Gender:</label><br>
                           <input type="radio" id="male" name="gender" value="Male">Male

                           <input type="radio" id="female" name="gender" value="Female">Female

                           <input type="radio" id="others" name="gender" value="Others"> others
                           <span style="color:red;">${genderError}</span>
                       </div>
                   </div>

                   <div class="row">
                       <div class="col-md-6 mb-3">
                           <label for="location">Location:</label>
                           <select id="location" name="location" class="form-control"  value="${moduleDto.location}"required>
                               <option value="">--Select Location--</option>
                               <option value="Bangalore">Bangalore</option>
                               <option value="Mysore">Mysore</option>
                               <option value="Tumkur">Tumkur</option>
                               <option value="Hassan">Hassan</option>
                               <option value="Mandya">Mandya</option>
                               <option value="Belagavi">Belagavi</option>
                           </select>
                           <span style="color:red;">${locationError}</span>
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="phoneNumber" class="form-label">Phone Number:</label>
                           <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" value="${moduleDto.phoneNumber}" placeholder="Enter your phone number">
                           <span style="color: red;">${phoneNumberError}</span>
                       </div>
                   </div>

                   <div class="row">
                       <div class="col-md-6 mb-3">
                           <label for="password" class="form-label">Password:</label>
                           <input type="password" class="form-control" id="password" name="password" value="${moduleDto.password}" placeholder="Enter your password">
                           <span style="color: red;">${passwordError}</span>
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="confirmPassword" class="form-label">Confirm Password:</label>
                           <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="${moduleDto.confirmPassword}" placeholder="Confirm your password">
                           <span style="color: red;">${confirmPasswordError}</span>
                       </div>
                   </div>

                   <button type="submit" class="btn btn-custom">Update</button>
               </form>
           </div>
       </div>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
   </body>
   </html>