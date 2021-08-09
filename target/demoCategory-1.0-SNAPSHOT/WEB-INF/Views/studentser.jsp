<%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 2021-08-08
  Time: 10:04 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Information</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Add an entry</h1>
    <form method="POST">
        <fieldset class="form-group">
            <label> Student ID :</label>
            <input name="studentid" type="text" class="form-control" required />

        </fieldset>


        <fieldset class="form-group">
            <label> First name :</label>
            <input name="firstname" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Last name :</label>
            <input name="lastname" type="text" class="form-control" required />

        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>
