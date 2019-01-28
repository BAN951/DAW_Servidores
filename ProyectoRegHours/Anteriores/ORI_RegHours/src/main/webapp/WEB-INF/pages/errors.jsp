<%-- 
    Document   : error.jsp
    Created on : 11-ene-2019, 19:50:17
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  if ((ArrayList) request.getAttribute("err") != null && !(((ArrayList) request.getAttribute("err")).isEmpty())) { %>
<div id="errors" class='alert alert-danger'>
    <ul>
        <%

            for (String err : (ArrayList<String>) request.getAttribute("err")) {
                out.write("<li style='color: red'>" + err + "</li>");
            }

        %>
    </ul>
</div>
<% }%>