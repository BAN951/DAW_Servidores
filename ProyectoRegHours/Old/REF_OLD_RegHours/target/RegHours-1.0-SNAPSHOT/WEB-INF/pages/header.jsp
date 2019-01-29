<%-- 
    Document   : header
    Created on : 13-ene-2019, 12:03:51
    Author     : Benjamin Adam Nagy
--%>

<%@page import="reghours.beans.User"%>
<%@page import="reghours.beans.UserList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 id='title' onclick='window.location.href="http://localhost:8080/RegHours/"'>RegHours</h1>
<div id="user-section">
    
    <% if((User) session.getAttribute("Usuario") != null) { %>
    
        <p>Bienvenido, <bold><%= (String) ((User) session.getAttribute("Usuario")).getNombreUsuario() %></bold>!</p>
        <form method='POST' action='ServletLogout'>
            <button class='btn btn-secondary' type='submit' name='btnUser' value='btnLogout'>Log Out</button>
        </form>

    <%  } else { %>
    
        <%  if((UserList) application.getAttribute("listaUsuarios") == null 
                   || ((UserList) application.getAttribute("listaUsuarios")).getListaUsuarios().isEmpty()) { %>
                   
            <p>No hay usuarios registrados.</p>       
            <form method='POST' action='Redirector'>
                <button class='btn btn-primary' type='submit' name='btnUser' value='btnSignup'>Sign Up</button>
            </form>       
                   
        <%  } else { %> 
        
            <form method='POST' action='Redirector'>
                <button class='btn btn-primary' type='submit' name='btnUser' value='btnLogin'>Log In</button>
            </form>
            <form method='POST' action='Redirector'>
                <button class='btn btn-primary' type='submit' name='btnUser' value='btnSignup'>Sign Up</button>
            </form>
                
        <%  } %>
        
    <%  } %>
</div>