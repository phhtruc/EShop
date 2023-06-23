<%-- 
    Document   : index
    Created on : Jun 8, 2023, 9:08:51 PM
    Author     : t
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/uf-style.css">
    <title>Login</title>
  </head>
  <body>
    <div class="uf-form-signin">
      <div class="text-center">
        <a><img src="images/logo-fb.png" alt="" width="100" height="100"></a>
      <h1 class="text-white h3">Account Login</h1>
      </div>
        <form action="login" class="mt-4" method="post">
            <div class="input-group uf-input-group input-group-lg mb-3">
                <label class="form-check-label text-white" for="exampleCheck1">${erorr}</label>
            </div>
            <div class="input-group uf-input-group input-group-lg mb-3">
              <span class="input-group-text fa fa-user"></span>
              <input name="user" value="${username}" type="text" class="form-control" placeholder="Username or Email address">
            </div>
            <div class="input-group uf-input-group input-group-lg mb-3">
              <span class="input-group-text fa fa-lock"></span>
              <input name="pass" value="${password}" type="password" class="form-control" placeholder="Password">
              <!--Hoặc có thể sử dụng value="${cookie.pass.value}" để thay thế-->
            </div>
            <div class="d-flex mb-3 justify-content-between">
              <div class="form-check">
                <input name="rem" value="${(cookie.rem.value eq 'ON')?"checked":""}" value="ON" type="checkbox" class="form-check-input uf-form-check-input" id="exampleCheck1">
                <label class="form-check-label text-white" for="exampleCheck1">Remember Me</label>
              </div>
              <a href="#">Forgot password?</a>
            </div>
            <div class="d-grid mb-4">
              <button type="submit" class="btn uf-btn-primary btn-lg">Login</button>
            </div>
            <div class="d-flex mb-3">
                <div class="dropdown-divider m-auto w-25"></div>
                <small class="text-nowrap text-white">Or login with</small>
                <div class="dropdown-divider m-auto w-25"></div>
            </div>
            <div class="uf-social-login d-flex justify-content-center">
              <a href="#" class="uf-social-ic" title="Login with Facebook"><i class="fab fa-facebook-f"></i></a>
              <a href="#" class="uf-social-ic" title="Login with Twitter"><i class="fab fa-twitter"></i></a>
              <a href="#" class="uf-social-ic" title="Login with Google"><i class="fab fa-google"></i></a>
            </div>
            <div class="mt-4 text-center">
              <span class="text-white">Don't have an account?</span>
              <a href="register.jsp">Sign Up</a>
            </div>
        </form>
    </div>

    <!-- JavaScript -->

    <!-- Separate Popper and Bootstrap JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

