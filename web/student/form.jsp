<%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 7/19/2019
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Create Student</h1>
<jsp:include page="/include/header.jsp"></jsp:include>
<form action="/student/create" method="post">
    Username: <input type="text" name="username"><br>
    Rollnumber: <input type="text" name="rollnumber"><br>
    <input type="submit" value="SEND">
</form>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
