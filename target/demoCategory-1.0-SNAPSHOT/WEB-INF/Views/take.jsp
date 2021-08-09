<%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 2021-08-08
  Time: 11:00 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Items</title>
</head>
<body>
<div class="container">
    <h1>Course ${fname} ${lname} takes</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Course</th>
            <th>Building</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos1}" var="todo">
            <tr>
                <td>${todo.coursename}</td>
                <td>${todo.building}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="POST">
        <input class="btn btn-back" type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
