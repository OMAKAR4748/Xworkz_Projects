<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz Index Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
        }

        #logo {
            height: 50px;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        nav ul li {
            margin-left: 20px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
        }

        main {
            text-align: center;
            padding: 50px 20px;
        }

        h1 {
            color: #333;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header>
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo" id="logo">
        <nav>
            <ul>
                <li><a href="signup.jsp">Signup</a></li>
                <li><a href="signIn.jsp">SignIn</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Welcome to Xworkz</h1>
        <p>Your journey to mastering Java and web development starts here!</p>
    </main>
    <footer>
        <p>&copy; 2025 Xworkz. All rights reserved.</p>
    </footer>
</body>
</html>
