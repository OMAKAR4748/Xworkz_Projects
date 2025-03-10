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
                    <li class="nav-item">
                        <a class="nav-link" href="fetchUsers?email=${validData}">View Profile</a>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
              <h2 style="text-align:center"> <span style="color: black;">${validData} Thank you </span></h2>
    <div class="container" style="display: flex; justify-content: center;">
         <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS44eQvO5mL9nHlPy3jWaZ5I4W5_MUfORQe5g&s" alt="Image">
     </div>

  <h2 style="text-align:center"> <span style="color: green;"> SignIn Success...!</span></h2>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
