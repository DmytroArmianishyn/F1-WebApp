<%--
  Created by IntelliJ IDEA.
  User: safar
  Date: 02.06.2024
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/sylepage3.css">
    <title>Title</title>
</head>
<body>

<video autoplay muted loop id="myVideo">
    <source src="video/F1%202023%20_%20This%20Is%20No%20Ordinary%20Sport.mp4" type="video/mp4">
</video>
<div class="container">


<div class="content-input">
<form action="race" class="input-group">
    Name<input type="text" name="name">
    City<input type="text" name="city">
    Racer<input type="text" name="racer">
    Place<input type="number" name="place">
    <input type="submit" value="send">
</form>
    <form action="race" class="input-group">
        Gearbox<input type="text" name="gearbox">
        Telemetry Equipment<input type="text" name="telemetry_equipment">
        Engine<input type="text" name="engine">
        Team Name<input type="text" name="team_name">
        <input type="submit" value="send">
    </form>
</div>
</div>
</body>

</html>
