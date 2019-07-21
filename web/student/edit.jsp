<%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 7/21/2019
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit Student</h1>
<jsp:include page="/include/header.jsp"></jsp:include>
<form method="post">
    Name: <input type="text" name="updatename"><br>
    Rollnumber: <input type="text" name="updaterollnumber"><br>
    <input type="submit" value="Send Edit">
</form>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
