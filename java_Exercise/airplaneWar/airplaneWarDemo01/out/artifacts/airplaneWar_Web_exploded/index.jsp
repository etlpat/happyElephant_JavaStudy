<%@ page import="com.airplaneWar.game.gameMian.GameStart" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/23
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    GameStart gameStart = new GameStart();
    gameStart.launch();
%>

</body>
</html>
