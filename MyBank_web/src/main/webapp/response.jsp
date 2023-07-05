<%--
  Created by IntelliJ IDEA.
  User: Asmae
  Date: 08/04/2023
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>R E S P O N S E </title>
</head>
<body>
<p> Nom    : <%= request.getParameter("nom")%> </p>
<p> Prenom : <%= request.getParameter("prenom")%> </p>
<% if (request.getParameterValues("radio1")[0].equals("mas")){
    %>
C'est un homme
<%}else{%>
C'est une femme. Elle <% } %>
a écrit : <%= request.getParameter("textarea")%>
</p>
</body>
</html>
