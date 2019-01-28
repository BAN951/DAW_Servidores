<%-- 
    Document   : Signup
    Created on : 18-dic-2018, 1:06:04
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="signup">
    <form name="SignupForm" action="Signup" method="POST">
        <h1>Sign up</h1>
        <form id="signupform" method="POST" action="ServletSignup">
            <label for="nombreUsuario">Nombre de usuario:</label>
            <input id="nombreUsuario" name="nombreUsuario" type="text"/>
            <br/>
            <label for="passwordUsuario">Password:</label>
            <input id="passwordUsuario" name="passwordUsuario" type="password"/>
            <br/>
            <label for="confirmarPasswordUsuario">Confirmar password:</label>
            <input id="passwordUsuario" name="confirmarPasswordUsuario" type="password"/>
            <br/>
            <label for="emailUsuario">Email:</label>
            <input id="emailUsuario" name="emailUsuario" type="text"/>
            <br/>
            <input type="reset" value="Vaciar formulario"/>
            <input type="submit" value="Registrar"/>
        </form>
    </form>
    <% 
        if ((ArrayList<String>) request.getAttribute("ErrorSignup") != null &&
            !((ArrayList<String>) request.getAttribute("ErrorSignup")).isEmpty()) {
            out.write("<div><ul>");
            for (String errorValidacion : (ArrayList<String>) request.getAttribute("ErrorSignup")) {
                out.write("<li style='color: red'>" + errorValidacion + "</li>");
            }
            out.write("</ul></div>");
        }
    %>
</div>
