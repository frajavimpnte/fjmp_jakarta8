<%-- 
    Document   : index
    Created on : 2 jun. 2024, 22:53:10
    Author     : FJMP <frajavimopu@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page: Servlet</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="<%=request.getContextPath()%>/UserServlet"><%=request.getContextPath() %>/UserServlet</a>
    </body>
</html>
