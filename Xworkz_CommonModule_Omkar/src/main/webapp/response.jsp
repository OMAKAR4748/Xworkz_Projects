
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
       pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <title>Response</title>

    <style>
       /* Reset and Base Styles */
       * {
           margin: 0;
           padding: 0;
           box-sizing: border-box;
           font-family: 'Poppins', sans-serif;
       }

       body {
           background: linear-gradient(135deg, #56ab2f, #a8e063);
           display: flex;
           justify-content: center;
           align-items: center;
           height: 100vh;
           padding: 20px;
       }

       /* Response Container */
       .response-container {
           background: rgba(255, 255, 255, 0.95);
           text-align: center;
           border-radius: 16px;
           padding: 35px;
           max-width: 450px;
           width: 100%;
           box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
           animation: slideIn 0.8s ease-in-out;
           transform: translateY(0);
       }

       /* Heading Styles */
       h2 {
           color: #2c3e50;
           font-size: 24px;
           font-weight: 600;
           margin-bottom: 15px;
       }

       h3 {
           color: white;
           background: #27ae60;
           padding: 10px;
           font-size: 18px;
           font-weight: bold;
           border-radius: 8px;
           display: flex;
           align-items: center;
           justify-content: center;
           gap: 10px;
           margin-bottom: 20px;
           box-shadow: 0 4px 10px rgba(39, 174, 96, 0.4);
           animation: pulse 1.5s infinite alternate;
       }

       /* Success Icon */
       .success-icon {
           width: 65px;
           height: 65px;
           margin-top: 10px;
           animation: bounce 1.5s infinite;
       }

       /* Back Button */
       .back-link {
           display: inline-block;
           margin-top: 20px;
           padding: 12px 20px;
           background: #2c3e50;
           color: white;
           text-decoration: none;
           font-size: 16px;
           font-weight: 500;
           border-radius: 8px;
           transition: all 0.3s ease;
       }

       .back-link:hover {
           background: #1a252f;
           transform: scale(1.05);
       }

       /* Animations */
       @keyframes bounce {
           0%, 100% { transform: translateY(0); }
           50% { transform: translateY(-8px); }
       }

       @keyframes slideIn {
           from { opacity: 0; transform: translateY(-20px); }
           to { opacity: 1; transform: translateY(0); }
       }

       @keyframes pulse {
           0% { transform: scale(1); }
           100% { transform: scale(1.05); }
       }



    </style>
</head>

<body>
    <div class="response-container">
        <h2>THANK YOU </h2>
        <H3><i class="bi bi-check2-circle"></i> REGISTRED SUCCESSFUL...!<i class="bi bi-check2-circle"></i></H3>
    </div>
</body>

</html>
