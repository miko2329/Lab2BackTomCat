<%@ page import="com.example.lab2backtomcat.classes.User" %><%--
  Created by IntelliJ IDEA.
  User: miko
  Date: 28.04.2023
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <title>Add question</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="login">Login</a>
        <a class="nav-link" href="register">Register</a>
        <a class="nav-link" href="test">Test</a>
        <%
          User currentUser = (User) request.getSession().getAttribute("CURRENT_USER");
          if(currentUser!=null){
            if(currentUser.getPrivilege().equals("admin")){
        %>
        <a class="nav-link" href="addQuestion">Add question</a>
        <a class="nav-link" href="analytics">Analytics</a>
        <%
            }
          }
        %>
      </div>
    </div>
  </div>
</nav>
<%
  Object success = request.getParameter("success");
  if(success!=null){
%>
<div class="alert alert-success" role="alert">
  Question added successfully
</div>
<%
  }
%>
<form action="addQ" method="post">
  <div class="mb-3">
    <label for="questionText" class="form-label">Question text</label>
    <input type="text" class="form-control" id="questionText" name="questionText">
  </div>
  <div class="mb-3">
    <label for="optionA" class="form-label">Option A</label>
    <input type="text" class="form-control" id="optionA" name="optionA">
  </div>
  <div class="mb-3">
    <label for="optionB" class="form-label">Option B</label>
    <input type="text" class="form-control" id="optionB" name="optionB">
  </div>
  <div class="mb-3">
    <label for="optionC" class="form-label">Option C</label>
    <input type="text" class="form-control" id="optionC" name="optionC">
  </div>
  <div class="mb-3">
    <label for="correctOption" class="form-label">Correct option (A, B, C)</label>
    <input type="text" class="form-control" id="correctOption" name="correctOption">
  </div>
  <button class="btn btn-primary">Add question</button>
</form>
</body>
</html>
