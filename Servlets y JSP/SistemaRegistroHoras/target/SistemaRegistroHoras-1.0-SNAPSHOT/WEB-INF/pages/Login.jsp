<%-- 
    Document   : login.jsp
    Created on : 10-dic-2018, 1:09:21
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>Log in</h1>
<div id="loginform">
    <form method="POST" action="Login">
        <label for="nombreUsuario">Nombre de usuario:</label>
        <input id="nombreUsuario" type="text" name="nombreUsuario"/>
        <br/>
        <label for="passwordUsuario">Password:</label>
        <input id="passwordUsuario" type="password" name="passwordUsuario"/>
        <br/>
        <input type="submit" value="Login"/>
    </form>
    <p>¿No tienes cuenta?<a href="/SistemaRegistroHoras/RedirectToSignup"> ¡Registrate aquí! </a></p>
    <div>
        <ul>
        <%
         
            if(request.getAttribute("ErrorLogin") != null && !((ArrayList<String>) request.getAttribute("ErrorLogin")).isEmpty()) {
                
                for(String err : (ArrayList<String>) request.getAttribute("ErrorLogin")) {
                    out.write("<li style=\"color='red'\">" + err + "</li>");
                }
                
            }
            
            
//            if((ArrayList<String>) request.getAttribute("ErrorLogin") != null) {
//                         // !(((ArrayList<String>) request.getAttribute("ErrorLogin")).isEmpty()) )
//                for(String err : (ArrayList<String>) request.getAttribute("ErrorLogin")) {
//                    out.write("<p>" + err + "</p>");
//                }
//            }
        %>
        </ul>
    </div>
</div>
