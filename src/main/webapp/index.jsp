<%@ page import="com.example.tpot6web.service.RacerService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="service" class="com.example.tpot6web.service.TeamService" scope="request"/>

<!DOCTYPE html>
<html>

<style>
    table {
        width: 300px;
        border: 1px solid black;
        margin: auto;
    }

    td {
        border: 1px solid #333;
        text-align: center;
    }
</style>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>F1</title>
</head>
<body>
<header>
    <nav>
        <img src="photo/img_1.png" class="logo">
        <div id="line">
            <form class="formButton">
                <button type="submit" name="showTeams" class="butt1">Show F1 Teams</button>
                <button type="submit" name="hideTeams" class="butt1">Hide F1 Teams</button>
            </form>
        </div>
        <div class="video">
            <video src="video/videoplayback.mp4" autoplay muted loop class="video-media"></video>
        </div>
    </nav>
</header>

<main>
<div class="content">
    <div class="first-content">
        <h1 align="center"><%= "Formula 1 \uD83C\uDFCE\uFE0F" %></h1>
        <br/>
        <h3 align="center">The FIA Formula One World Championship has been one of the world's premier forms of racing since its inaugural running in 1950.</h3>
        <h3 align="center">The word formula in the name refers to the set of rules all participants' cars must follow. A
            Formula One season consists of a series of races, known as Grands Prix.</h3>
    </div>

    <div class="second-content">
        <c:if test="${param.showTeams != null}">
            <table class="tableteam">
                <caption>F1 teams</caption>
                <c:forEach var="team" items="${service.allTeams}">
                    <tr>
                        <td class="each-team">${team}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>

    <div class="third-content">
        <form action="hello-servlet" class="input-group">
            Name<input type="text" name="name">
            Age<input type="number" name="id">
            Team<input type="text" name="team">
            Engine<input type="text" name="engine">
            Points<input type="number" name="points">
            From<input type="number" name="from">
            To<input type="number" name="to">
            <input type="submit" value="send">
        </form>
    </div>
</div>

    <div class="image">
        <img src="https://i.pinimg.com/originals/ea/a6/98/eaa698b63df39e7c9cad20ba9b35d0c8.jpg" class="image-media">
    </div>

</main>


</body>
</html>
