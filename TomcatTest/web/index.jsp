<%--
  Created by IntelliJ IDEA.
  User: Betta
  Date: 2022/4/27
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>
</head>
<body>
<%
  String loginName = (String) request.getSession().getAttribute("loginName");
%>
<%
  if (loginName == null || loginName.isEmpty()) {
%>
<a href="Login">去登录</a>
<% } else { %>
Hello, <%=loginName%>
<% } %>
</body>
</html>