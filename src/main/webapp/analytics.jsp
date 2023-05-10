<%@ page import="com.example.lab2backtomcat.classes.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab2backtomcat.db.DBManager" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: miko
  Date: 28.04.2023
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.bundle.min.js"></script>
  <title>Analytics</title>
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
  if(currentUser!=null){
%>
<canvas id="myChart" style = "width: 100%; height: 400px"></canvas>
<%
  ArrayList<Integer> xData = DBManager.getX();
  ArrayList<Integer> yData = DBManager.getY();
%>
<script>
  var ctx = document.getElementById('myChart').getContext('2d');
  var chart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: [<%= xData.stream().mapToInt(i -> i).boxed().map(String::valueOf).collect(Collectors.joining(", ")) %>],
      datasets: [{
        label: 'Number of Answers',
        data: [<%= yData.stream().mapToInt(i -> i).boxed().map(String::valueOf).collect(Collectors.joining(", ")) %>],
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true
          }
        }]
      }
    }
  });
</script>
<%
  } else {
%>
<h2>This page available only for admins</h2>
<%
  }
%>
</body>
</html>
