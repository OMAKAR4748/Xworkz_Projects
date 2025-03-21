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

          padding: 2rem;
          border-radius: 10px;
      }

      #logo {
          height: 100px;
      }

      h1 {
          margin-bottom: 2rem;
          color: red;
          font-weight:bold;
          text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
          text-align: center;
      }

      .form-container {
          padding: 2rem;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 1);
          background-color: skyblue;
      }

      .form-label{
                  font-weight:bold;
      }

      .btn-custom {
          margin: 0.5rem 10;
          padding: 0.75rem 1.5rem;
          background-color: red;
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
          background-color: black;
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
           <h1>Sign Up </h1>
           <div class="form-container">
               <form action="userSignUp" method="post" enctype="multipart/form-data">

                   <div class="col-md-6 mb-3">
                       <label for="fullName" class="form-label">Full Name<span id="span1">*</span></label>
                       <input type="text" class="form-control" id="fullName" name="fullName"  placeholder="Enter your full name" onblur="userName()" value="${moduleDto.fullName}">
                       <span id="UserNameError" style="color: red;"></span>
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="email" class="form-label">Email<span id="span1">*</span></label>
                       <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" onblur="validateEmail()" value="${moduleDto.email}">
                        <span id="emailError" style="color: red;" ></span>
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="age" class="form-label">Age<span id="span1">*</span></label>
                       <input type="number" class="form-control" id="age" name="age"  placeholder="Enter your age" onblur="Age()" value="${moduleDto.age}">
                       <span id="CheckAge" style="color: red;"></span>
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="gender" class="form-label">Gender<span id="span1">*</span></label><br>
                       <input type="radio" id="male" name="gender" value="Male">
                       <label for="male">Male</label>

                       <input type="radio" id="female" name="gender" value="Female">
                       <label for="female">Female</label>

                       <input type="radio" id="others" name="gender" value="Others">
                       <label for="others">Others</label>
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="location" class="form-label">Location<span id="span1">*</span></label>
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
                       <label for="phoneNumber" class="form-label">Phone Number<span id="span1">*</span></label>
                       <input type="number" class="form-control" id="phoneNumber" name="phoneNumber"  placeholder="Enter your phone number" onblur="phoneNo()" value="${moduleDto.phoneNumber}">
                       <span id="phoneNumber" style="color: red;"></span>
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="password" class="form-label">Password<span id="span1">*</span></label>
                       <input type="password" class="form-control" id="password" name="password"  placeholder="Enter your password" value="${moduleDto.password}">
                   </div>

                   <div class="col-md-6 mb-3">
                       <label for="confirmPassword" class="form-label">Confirm Password<span id="span1">*</span></label>
                       <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"  placeholder="Confirm your password" value="${moduleDto.confirmPassword}">
                   </div>

                   <div class="col-md-6 mb-3">
                        <label for="profileImage" class="form-label">Profile picture<span id="span1">*</span></label>
                       <input type="file" class="form-control" id="profileImage" name="multipartFile" >
                       <span id="phoneNumber" style="color: red;"></span>
                   </div>

                   <br>
                   <span>${inValid}</span>

                   <button type="submit" class="btn btn-custom">Submit</button>
                   <button type="reset" class="btn btn-custom">Reset</button>
               </form>
           </div>
       </div>

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


       <script>
            function validateEmail()
            {
                 var emailId=document.getElementById("email").value;
                 console.log(emailId);
                 var xhttp = new XMLHttpRequest();

                 if(emailId !==""){
                    xhttp.onload = function ()
                     {
                       document.getElementById("emailError").innerHTML = this.responseText;
                       console.log(this.responseText);
                    }

                    xhttp.open("GET", "http://localhost:8081/xworkz_commonModule_omkarD/checkEmail?email=" + emailId);
                    xhttp.send();

                 }

            }

            function userName()
            {
                var fullName = document.getElementById("fullName").value;
                console.log(fullName);
                var xhttp = new XMLHttpRequest();

                if(fullName !==""){
                    xhttp.onload = function ()
                     {
                        document.getElementById("UserNameError").innerHTML = this.responseText;
                        console.log(this.responseText);
                    }

                    xhttp.open("GET", "http://localhost:8081/xworkz_commonModule_omkarD/fullName?fullName=" +fullName);
                    xhttp.send();

                }

            }



            function phoneNo() {
                var phoneNumber = document.getElementById("phoneNumber").value.trim();
                console.log("Phone Number:", phoneNumber);

                if (phoneNumber !== "" && /^\d{10}$/.test(phoneNumber)) { r
                    var xhttp = new XMLHttpRequest();

                    xhttp.onload = function () {
                        document.getElementById("checkPhoneNo").innerHTML = this.responseText;
                        console.log("Response:", this.responseText);
                    };

                    xhttp.onerror = function () {
                        console.error("Error: Failed to fetch phone number details.");
                        document.getElementById("checkPhoneNo").innerHTML = "Error checking phone number.";
                    };

                    xhttp.open("GET", "http://localhost:8081/xworkz_commonModule_omkarD/checkPhoneNumber?phoneNumber=" + encodeURIComponent(phoneNumber), true);
                    xhttp.send();
                } else {
                    alert("Please enter a valid 10-digit phone number.");
                }
            }
       </script>


   </body>
   </html>