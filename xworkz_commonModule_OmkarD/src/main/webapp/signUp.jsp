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
          height: 100vh;
          overflow: auto;
      }

      .container {
          margin-top: 1rem;
          max-width: 900px;
          height: auto;
          background: rgba(255, 255, 255, 0.9);
          padding: 2rem;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      }

      #logo {
          height: 100px;
      }

      h1 {
          margin-bottom: 2rem;
          color: #007bff;
          text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
          text-align: center;
      }

      .form-container {
          padding: 2rem;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
          background-color: #f8f9fa;
      }

      .btn-custom {
          margin: 0.5rem 10;
          padding: 0.75rem 1.5rem;
          background-color: #17a2b8;
          border: none;
          color: white;
          width: 30%;
          transition: background-color 0.3s ease;
      }

      .btn-custom:hover {
          background-color: #138496;
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
          text-align: center;
      }

      .nav-link:hover {
          background-color: #007bff;
          color: white;
          border-radius: 5px;
      }

      .nav-item {
          text-align: right;
      }

      .error-message {
          color: red;
          font-size: 0.9rem;
      }

        /* Hover effects for input fields */
        input[type="text"]:hover,
        input[type="email"]:hover,
        input[type="number"]:hover,
        input[type="password"]:hover,
        select:hover {
            border-color: #17a2b8;
            background-color: #f1f9fb;
            box-shadow: 0 0 10px rgba(23, 162, 184, 0.5);
            transition: all 0.3s ease;
        }

        /* Focus effect for consistency with hover */
        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="number"]:focus,
        input[type="password"]:focus,
        select:focus {
            border-color: #007bff;
            box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
            transition: all 0.3s ease;
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
                    <li class="nav-item">
                        <a class="nav-link" href="signin.jsp">SignIn</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



   <div class="container">
           <h1>Sign Up </h1>
           <div class="form-container">
               <form action="userSignUp" method="post">

                       <div class="col-md-6 mb-3">
                           <label for="fullName" class="form-label">Full Name:</label>
                           <input type="text" class="form-control" id="fullName" name="fullName" value="${moduleDto.fullName}" placeholder="Enter your full name">
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="email" class="form-label">Email:</label>
                           <input type="email" class="form-control" id="email" name="email" value="${moduleDto.email}" placeholder="Enter your email">
                       </div>

                       <div class="col-md-6 mb-3">
                           <label for="age" class="form-label">Age:</label>
                           <input type="number" class="form-control" id="age" name="age" value="${moduleDto.age}" placeholder="Enter your age">
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="gender">Gender:</label><br>
                           <input type="radio" id="male" name="gender" value="Male">
                           <label for="male">Male</label>

                           <input type="radio" id="female" name="gender" value="Female">
                           <label for="female">Female</label>

                           <input type="radio" id="others" name="gender" value="Others">
                           <label for="others">Others</label>
                       </div>

                       <div class="col-md-6 mb-3">
                           <label for="location">Location:</label>
                           <select id="location" name="location" class="form-control"  value="${moduleDto.location}">
                               <option value="">--Select Location--</option>
                               <option value="Belagavi">Belagavi</option>
                               <option value="Bangalore">Bangalore</option>
                               <option value="Mysore">Mysore</option>
                               <option value="Tumkur">Tumkur</option>
                               <option value="Hassan">Hassan</option>
                               <option value="Mandya">Mandya</option>
                               <option value="Gadag">Gadag</option>
                               <option value="Bidar">Bidar</option>
                               <option value="Raichur">Raichur</option>
                           </select>
                       </div>
                       <div class="col-md-6 mb-3">
                           <label for="phoneNumber" class="form-label">Phone Number:</label>
                           <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" value="${moduleDto.phoneNumber}" placeholder="Enter your phone number">
                       </div>



                       <div class="col-md-6 mb-3">
                           <label for="password" class="form-label">Password:</label>
                           <input type="password" class="form-control" id="password" name="password" value="${moduleDto.password}" placeholder="Enter your password">
                       </div>

                       <div class="col-md-6 mb-3">
                           <label for="confirmPassword" class="form-label">Confirm Password:</label>
                           <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="${moduleDto.confirmPassword}" placeholder="Confirm your password">
                       </div>

                    <br>
                   <span>${inValid}</span>

                   <button type="submit" class="btn btn-custom">Submit</button>
                    <button type="reset" class="btn btn-custom">Reset</button>
               </form>
           </div>
       </div>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
   </body>
   </html>