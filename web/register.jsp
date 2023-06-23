<%-- 
    Document   : register
    Created on : Jun 16, 2023, 2:10:17 PM
    Author     : t
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="imgages/favicon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/uf-style.css">
    <title>Register</title>
  </head>
  <body>
    <div class="uf-form-signin">
      <div class="text-center">
        <a href="https://uifresh.net/"><img src="images/logo-fb.png" alt="" width="100" height="100"></a>
      <h1 class="text-white h3">Account Register</h1>
      </div>
        <form action="register" class="mt-4" method="post">
            <div class="input-group uf-input-group input-group-lg mb-3">
                <label class="form-check-label text-white" for="exampleCheck1">${tb}</label>
                <label class="form-check-label text-white" for="exampleCheck1">${tb1}</label>
            </div>
         <div class="input-group uf-input-group input-group-lg mb-3">
            <span class="input-group-text fa fa-user"></span>
            <input name="name" type="text" class="form-control" placeholder="Họ và Tên">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-user"></span>
          <input name="user" type="text" class="form-control" placeholder="Tài khoản">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-lock"></span>
          <input name="pass" type="password" class="form-control" placeholder="Mật khẩu">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-lock"></span>
          <input name="pass2" type="password" class="form-control" placeholder="Nhập lại mật khẩu">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-envelope"></span>
          <input name="email" type="text" class="form-control" placeholder="Email">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-phone"></span>
          <input name="add"type="text" class="form-control" placeholder="Địa chỉ">
        </div>
        <div class="input-group uf-input-group input-group-lg mb-3">
          <span class="input-group-text fa fa-phone"></span>
          <input name="phone"type="text" class="form-control" placeholder="Phone">
        </div>
        <div class="d-grid mb-4">
          <button type="submit" class="btn uf-btn-primary btn-lg">Sign Up</button>
        </div>
        <div class="mt-4 text-center">
          <span class="text-white">Already a member?</span>
          <a href="login.jsp">Login</a>
        </div>
      </form>
    </div>

    <!-- JavaScript -->

    <!-- Separate Popper and Bootstrap JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
