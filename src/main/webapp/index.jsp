<%@ page import="com.example.lab2backtomcat.classes.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Test application</title>
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
<h1><%= "Welcome to test app!" %>
</h1>
<br/>
</body>
</html>