<%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 2021-08-08
  Time: 2:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student Page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }
    </style>
</head>
<body>
<h1>Student Information</h1>

<div class="container">

    <form method="GET">
        <div class="form-group">
            <label for="id">Student ID:</label>
            <input type="text" name="studentid" class="form-control" id="id" value="${id}">
        </div>
        <div class="form-group">
            <label for="fname">First name:</label>
            <input type="text" name="firstname" class="form-control" id="fname" value="${fname}">
        </div>
        <div class="form-group">
            <label for="lname">Last name:</label>
            <input type="text" name="lastname" class="form-control" id="lname" value="${lname}">
        </div>





        <a class="btn btn-success" href="add-todo">Add</a>




    </form>

    <h1 id = "mes">${errorMessage}</h1>
    <div class="container2">
        <h2>Students</h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Student ID</th>
                <th>First name</th>
                <th>Last name</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">



                <tr>
                    <td>${todo.studentid}</td>
                    <td>${todo.firstname}</td>
                    <td>${todo.lastname}</td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.studentid}" >Edit</a> </td>



                    <td>    <a type="button" class="btn btn-primary"
                               href="delete-todo?id=${todo.studentid}" >Delete</a> </td>



                    <td> <a type="button" class ="btn btn-primary" onmouseout="myFunction()"
                            href="see-todo?id=${todo.studentid}">Take Course</a></td>

                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<script>

    function  myFunction(){
        document.getElementById("mes").innerHTML="";
    }



</script>




</body>
</html>
