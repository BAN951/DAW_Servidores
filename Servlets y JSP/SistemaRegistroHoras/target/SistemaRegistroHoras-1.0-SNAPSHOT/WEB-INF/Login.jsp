<%-- 
    Document   : login.jsp
    Created on : 10-dic-2018, 1:09:21
    Author     : Benjamin Adam Nagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>Log in</h1>
<div>
    <form id="loginform" method="POST" action="Login">
        <label for="nombreUsuario">Nombre de usuario:</label>
        <input id="nombreUsuario" type="text" name="nombreUsuario"/>
        <br/>
        <label for="passwordUsuario">Password:</label>
        <input id="passwordUsuario" type="password" name="passwordUsuario"/>
        <br/>
        <input type="submit" value="Login"/>
    </form>
    <p>¿No tienes cuenta?<a href="#"> ¡Registrate aquí! </a></p>
</div>
