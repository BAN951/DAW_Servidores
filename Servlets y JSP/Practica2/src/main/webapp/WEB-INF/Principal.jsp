<%-- 
    Document   : layout.jsp
    Created on : 10-dic-2018, 1:10:03
    Author     : Benjamin Adam Nagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div id="panel-central">
            <jsp:include page="<%= ((String) request.getAttribute("action")) + ".jsp" %>" />
        </div>
        <%@ include file="Footer.jsp" %>
    </body>
</html>
