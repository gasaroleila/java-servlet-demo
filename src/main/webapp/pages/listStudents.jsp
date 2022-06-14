<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: uwamg
  Date: 6/10/2022
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <p>List students</p>
  <table>
  <%
      ArrayList Students = (ArrayList) request.getAttribute("Students");
      for (int i=0; i < Students.size(); ++i) {
  %>
  <tr>
      <td><%=Students.get(i)%></td>
  </tr>
  <%
      }
  %>
  </table>

<a href="/servletDemo">Back</a>
</body>
</html>
