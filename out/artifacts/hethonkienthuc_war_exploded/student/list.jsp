<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 7/19/2019
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> list =(List<Student>) request.getAttribute("list");
%>
<html>
<head>
    <title>List</title>
    <style type="text/css">
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>List Student</h1>
<jsp:include page="/include/header.jsp"></jsp:include>
<%
    if(list.size()==0){
%>
<b>Chưa có đối tượng nào được thêm mới</b><br><a href="/student/create">thêm</a>

<%
    }
%>
<ul>
    <%
        for (int i=0;i<list.size();i++){
    %>
    <li><a href="/student/detail?id=<%=list.get(i).getId()%>">ID: <%=list.get(i).getId()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/student/edit?id=<%=list.get(i).getId()%>">edit</a>  <a href="/student/delete?id=<%=list.get(i).getId()%>" >detele</a></li>
    <%
        }
    %>
</ul>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
