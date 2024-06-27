<%--
  Created by IntelliJ IDEA.
  User: safar
  Date: 26.05.2024
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="service" class="com.example.tpot6web.service.RacerService" scope="request"/>
<html>
<head>
    <link rel="stylesheet" href="css/stylepage2.css">
    <title>Formula 1 roster</title>
</head>
<body>
<video autoplay muted loop id="myVideo">
    <source src="video/Epic%20Racing%20And%20Records%20Broken%20_%20The%20Best%20of%20F1%20in%202023.mp4" type="video/mp4">
</video>
<a href="http://localhost:8080/TpoT6Web/race"><button class="butt" ><img class="photo-button" src="photo/0_6c7c6_f17436ab_orig.png"></button> </a>
<div class="content-all">

<h1 class="slogon">Welcome to Formula 1 Roster</h1 >


<table  class="tableracer">
    <caption>F1 Racers</caption>
    <c:forEach var="racer" items="${requestScope.Racers}">
        <tr>
            <td>${racer.fullname}</td>
            <td>${racer.age} age old  </td>
            <td> ${racer.points} points</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
