<%-- 
    Document   : RegistroHoras
    Created on : 05-ene-2019, 18:20:25
    Author     : Benjamin Adam Nagy
--%>

<%@page import="registrohoras.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="horasEmpleado">
    <h2>Registro de Horas</h2>
    <% 
        out.write("<p>Usuario: " + ((User) session.getAttribute("Usuario")).getNombreUsuario() + "</p>");
    %>
</div>