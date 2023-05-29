<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN Page</title>
    <link rel="stylesheet" href="/WebBanDienThoai/views/style-login.css">
</head>
<body>
    <div class="container">
        <div class="login-left">
            <div class="login-header">
                <h1>Welcome to Mobile Store&#174;</h1>
                <c:if test="${not empty newlg}">
                <p>Created account successfully with ...</p>
                <p>Username: ${newlg.name}</p>
                <p>Password: ${newlg.password}</p>
                </c:if>
                <p>Please sign-in to discover and shopping.</p>
            </div>
            <form action="login" class="login-form" method="post">
                <div  class="login-form-content">
                    <div class="form-item">
                        <label for="username">Username</label>
                        <input type="text" name="name">
                    </div>
                    <div class="form-item">
                        <label for="password">Password</label>
                        <input type="password" name="password">
                    </div>
                    <div class="form-item">
                        <div class="checkbox">
                            <input type="checkbox" name="" id="rememberMeCheckbox">
                            <label for="rememberMeCheckbox" id="chechboxLabel">Remember me</label>
                        </div>
                     </div>
                     <button type="submit">Sign In</button>
                </div>
			</form>
                <div class="login-form-footer">
                    <a href="sign-up">
                        Don't have account. SIGN UP here!
                    </a>
                    <a href="home">
                        <img src="data:image/png;base64,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" 
                            alt="">
                        Back to HOMEPAGE
                    </a>
                </div>
           
        </div>
        <div class="login-right">
            <img src="http://unblast.com/wp-content/uploads/2021/11/Perspective-iPhone-12-Mockup-2.jpg" 
                alt="Image unloaded!!">
        </div>
    </div>
</body>
</html>