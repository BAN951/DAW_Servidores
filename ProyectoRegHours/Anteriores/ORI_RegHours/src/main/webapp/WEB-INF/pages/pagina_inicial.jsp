<%-- 
    Document   : pagina_inicial
    Created on : 11-ene-2019, 19:59:46
    Author     : admin
--%>

<%@page import="reghours.beans.UserList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id='pagina-inicial'>
    <h3>¡Bienvenido a RegHours!</h3>
    <p>RegHours es un sistema online para registrar horas trabajadas por un empleado o usuario.</p>
    <p>Para utilizar esta página se debe estar registrado.</p><br/>   

    <% if ((UserList) application.getAttribute("listaUsuarios") == null || ((UserList) application.getAttribute("listaUsuario")).getListaUsuarios().isEmpty()) { %>

        <p>Actualmente no hay ningún usuario registrado en el sistema.<bold>¡Sé el primero!<bold></p>
        <form method='POST' action='Redirector'>
            <button class='btn btn-info' type='submit' name='btnUser' value='btnSignup'>Click aquí para registrarse</button>
        </form>      

    <%  } else { %>

        <p>Entra con tu cuenta para registrar tus horas.</p><br/>
        <p>¿No tienes cuenta? - </p>
        <<form method='POST' action='Redirector'>
        <button class='btn btn-info' type='submit' name='btnUser' value='btnSignup'>¡Regístrate!</button>
        </form>  

    <%  }%>
    </div>