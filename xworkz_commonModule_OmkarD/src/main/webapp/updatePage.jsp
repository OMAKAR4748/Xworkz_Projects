<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
      body {
                 background-size: cover;
                 font-family: 'Montserrat', sans-serif;
                 color: black;
                 height: 100vh;
                overflow:auto;
             }
             .container {
                 margin-top: 1rem;
                 max-width: 700px;
                 height: 500px;
                 background: rgba(255, 255, 255, 0.8);
                 padding: 2rem;
                 border-radius: 10px;
             }

             #logo{
                         height:100px;
                     }
             h1 {
                 margin-bottom: 2rem;
                 color: red;
                 font-weight:bold;
                 text-shadow: 2px 2px 4px #000;
                 text-align: center;
             }
             .form-container {
                 background: skyblue;
                 padding: 2rem;
                 border-radius: 10px;
                 box-shadow: 0 4px 8px rgba(0, 0, 0, 1);
             }
             .btn-custom {
                 margin: 0.5rem 10;
                 padding: 0.95rem 2.5rem;
                 background-color: red;
                 border: none;
                 color: white;
                 width: 30%;
                 transition: background-color 0.3s;
             }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
        }
        .form-label{
            font-weight:bold;
        }

        .navbar-custom {
            background-color: black;
            }
        .navbar-custom .navbar-brand,
        .navbar-custom .nav-link {
            color: white;
            text-align:center;
        }
        .nav-link:hover {
            background-color: white;
            color: white;
        }
        .nav-item{
        text-align:right;
        }
        .error-message {
            color: red;
            font-size: 0.9rem;
        }

        #span1{
                color:red;
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
                        <a class="nav-link" href="signin.jsp">SignIn</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



   <div class="container">
           <h1>Update Form</h1>
           <div class="form-container">
               <form action="updateUser" method="post">

                   <label for="id" class="form-label">id<span id="span1">*</span></label>
                   <input type="hidden"   name="id" value="${user.id}" ><br>

                   <label for="fullName" class="form-label">Full Name<span id="span1">*</span></label>
                   <input type="text"  name="fullName" value="${user.fullName}" ><br>

                   <label for="email" class="form-label">Email<span id="span1">*</span></label>
                   <input type="email" id="email" name="email" value="${user.email}" ><br>

                   <label for="gender" class="form-label">Gender<span id="span1">*</span></label><br>
                   <input type="hidden" id="male" name="gender" value="${user.gender}"><br>

                   <label for="age" class="form-label">Age<span id="span1">*</span></label>
                   <input type="number"  id="age" name="age" value="${user.age}" ><br>

                   <label for="phoneNumber" class="form-label">Phone Number<span id="span1">*</span></label>
                   <input type="number"  id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" ><br>

                   <label for="location" class="form-label">Location<span id="span1">*</span></label>
                   <select id="location" name="location" >
                           <option value="">Select Location</option>
                           <option value="Belagavi" ${user.location == 'Belagavi' ? 'selected' : ''}>Belagavi</option>
                           <option value="Bangalore" ${user.location == 'Bangalore' ? 'selected' : ''}>Bangalore</option>
                           <option value="Mysore" ${user.location == 'Mysore' ? 'selected' : ''}>Mysore</option>
                           <option value="Tumkur" ${user.location == 'Tumkur' ? 'selected' : ''}>Tumkur</option>
                           <option value="Hassan" ${user.location == 'Hassan' ? 'selected' : ''}>Hassan</option>
                           <option value="Mandya" ${user.location == 'Mandya' ? 'selected' : ''}>Mandya</option>
                           <option value="Gadag" ${user.location == 'Gadag' ? 'selected' : ''}>Gadag</option>
                           <option value="Bidar" ${user.location == 'Bidar' ? 'selected' : ''}>Bidar</option>
                           <option value="Raichur" ${user.location == 'Raichur' ? 'selected' : ''}>Raichur</option>
                   </select><br>

                   <label for="password" class="form-label">Password<span id="span1">*</span></label>
                   <input type="hidden"  id="password" name="password"  value="${user.password}"><br>

                   <label for="profileImage" class="form-label">Profile picture<span id="span1">*</span></label>
                   <input type="hidden" class="form-control" id="profileImage" name="multipartFile" ><br>

                   <span>${msg}</span>

                   <button type="submit" class="btn btn-custom">Update</button>
               </form>
           </div>
   </div>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
   </body>
   </html>