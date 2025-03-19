<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;

            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            color: white;
        }
        .container {
            margin-top: 5rem;
            text-align: center;
        }
        .container1 {
            margin-top: -3rem;
            text-align: center;
            width:60px;
            height:550px;
            padding-left:700px;
        }
        #logo{
            height:100px;
        }
        h1 {
            padding-top:0px;
            margin-bottom: 1rem;
            font-size:30px;
            color: black;
            font-weight: bold;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);

        }
        p{
            padding-bottom:80px;
            margin-bottom: 1rem;
            color: black;
            font-size:25px;

        }
        .btn-custom {
            margin: 0.5rem;
            padding: 0.75rem 1.5rem;
            background-color: pink;
            border: none;
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
        .nav-link:hover {
            background-color: red;
        }
        .navbar-nav {
            text-align: center;
        }


        @keyframes textGlow {
            0% {
                text-shadow: 0 0 5px #ff00ff, 0 0 10px #ff00ff, 0 0 20px #ff00ff;
            }
            100% {
                text-shadow: 0 0 20px #00ffff, 0 0 40px #00ffff, 0 0 60px #00ffff;
            }
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
                        <a class="nav-link" href="signUpPage">Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signin.jsp">Sign In</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container1" style="display: flex; justify-content: center;">
        <img src="https://x-workz.in/static/media/coding_img.bef297f81da57125500a.png" alt="Image">
    </div>

    <h1 style="text-align:center;">Welcome to Xworkz</h1>
    <p style="text-align:center;">Your journey to mastering Java and web development starts here!</p>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
