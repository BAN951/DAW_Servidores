<%-- 
    Document   : login
    Created on : 13-ene-2019, 13:18:30
    Author     : Benjamin Adam Nagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Log In</h2>
<form name='login-form' id='login-form' method='POST' action='ServletLogin'>
    <label for='nombreUsuario'>Nombre de usuario:</label>
    <input id='nombreUsuario' name='nombreUsuario' type='text' class='form-control' />
    <br/>
    <label for='passwordUsuario'>Password:</label>
    <input id='passwordUsuario'  name='passwordUsuario' type='password' class='form-control' />
    <button class='btn btn-secondary'>Vaciar datos</button>
    <button class='btn btn-success' type='submit'>Entrar</button>
</form>