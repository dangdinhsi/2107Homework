<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 7/19/2019
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student =(Student) request.getAttribute("student");
%>
<html>
<head>
    <title>Detail</title>
</head>
<body><h2>Detail Student</h2>
<jsp:include page="/include/header.jsp"></jsp:include>
Id: <%=student.getId()%><br>
Username: <%=student.getUsername()%><br>
Rollnumber: <%=student.getRollnumber()%><br>
Status: <%=student.getStatus()%>
<jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html>
