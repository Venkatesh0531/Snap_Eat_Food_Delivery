<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="com.tap.model.User" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
<title>Snap Eat | Register</title>

    <link rel="stylesheet" href="Styles.css">

</head>
<body>

    <!-- Background Video -->
    <video autoplay muted loop playsinline class="bg-video">
        <source src="./assets/bg-video.mp4" type="video/mp4">
    </video>


	<div class="main-content">
        <form action="register" method="get">
            <h1 class="heading">Registration Form</h1>
            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><input required type="text" name="name" placeholder="Enter your Name"></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><input required type="email" name="email" placeholder="Enter your Email"></td>
                </tr>
                <tr>
                    <td><label>Create Password</label></td>
                    <td><input required type="password" name="createpassword" placeholder="Create your Password"></td>
                </tr>
                <tr>
                    <td><label>Confirm Password</label></td>
                    <td><input required type="password" name="confirmpassword" placeholder="Confirm your Password"></td>
                </tr>
                <tr>
                    <td><label>Age</label></td>
                    <td><input required type="number" name="age" placeholder="Enter Your Age"></td>
                </tr>
                <tr>
                    <td><label>Phone Number</label></td>
                    <td><input required type="text" name="phonenumber" placeholder="Enter your Mobile Number"></td>
                </tr>
                <tr>
                    <td><label>Address</label></td>
                    <td><input required type="text" name="address" placeholder="Enter your Address"></td>
                </tr>
                <tr>
                    <td colspan="2" class="reg"><input type="submit" value="Register"></td>
                </tr>
                <tr>
                    <td colspan="2" class="login">Already have an Account ?
                        <a href="Login.jsp">Login</a>
                    </td>
                </tr>
            </table>

        </form>

    </div>
</body>
</html>