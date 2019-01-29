<%-- 
    Document   : signup
    Created on : 13-ene-2019, 13:18:46
    Author     : Benjamin Adam Nagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Sign Up</h2>
<form name='signup-form' id='signup-form' method='POST' action='ServletSignup'>
    <label for='nombreUsuario'>Nombre de usuario:</label>
    <input id='nombreUsuario' name='nombreUsuario' type='text' class='form-control' />
    <br/>
    <label for='passwordUsuario'>Password:</label>
    <input id='passwordUsuario' name='passwordUsuario' type='password' class='form-control' />
    <br/>
    <label for='confirmarPasswordUsuario'>Confirmar password:</label>
    <input id='confirmarPasswordUsuario' name='confirmarPasswordUsuario' type='password' class='form-control' />
    <br/>
    <label for='emailUsuario'>Email: </label>
    <input id='emailUsuario' name='emailUsuario' type='text' class='form-control' />
    <br/>
    <button type='reset' class='btn btn-secondary'>Vaciar datos</button>
    <button type='submit' class='btn btn-success'>Enviar</button>
</form>