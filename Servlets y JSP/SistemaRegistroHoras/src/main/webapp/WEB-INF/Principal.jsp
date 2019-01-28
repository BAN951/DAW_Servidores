<%-- 
    Document   : layout.jsp
    Created on : 10-dic-2018, 1:10:03
    Author     : Benjamin Adam Nagy
--%>

<%@page import="registrohoras.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reg-Hours</title>
        <style>
            
            * {margin: 0; padding: 0;}
            body {
                font-family: Arial, sans-serif; 
            }
            header { 
                padding-top: 1em; 
                position: absolute; 
                width: 100%; 
            }
            header h1 { 
                float: left; 
                margin: 1em; 
            }
            .userSection { 
                float: right; 
                padding: 2em; 
            }

            .userSection .userbtn {
                margin: .5em;
                padding: 1em;
            }

            .clear { clear: both; }
            main {
                position: absolute; 
                top: 25%; 
            }
            main div {
                padding: 1em 2em; 
            }
            #paginaInicial h1 {
                margin-bottom: 1em; 
            }
            footer {
                position: absolute;
                bottom: 5%; 
                width: 100%; 
            }
            
        </style>
    </head>
    <body>
        <div id="header">
            <header>
                <h1>Reg-Hours</h1>
                <div class="userSection">
                    <form action="RedirectUserSection" method="post"> 
                        <%
                            if (session.getAttribute("Usuario") != null) {
                                out.write("<p>Bienvenido, " + ((User) session.getAttribute("Usuario")).getNombreUsuario() + "</p>");
                                out.write("<button type='submit' name='btnUser' value='Logout' class='userbtn'>Log Out</button>");
                            } else {
                                out.write("<button type='submit' name='btnUser' value='Login' class='userbtn'>Log In</button>");
                                out.write("<button type='submit' name='btnUser' value='Signup' class='userbtn'>Sign Up</button>");
                            }
                        %>
                    </form>
                </div>
                <div class="clear"></div>
                <hr/>
            </header>
            <hr/>
        </div>
        <main>
            <div style="display: none;"><!-- Por ahora hidden así -->
                Mensaje error 
            </div>
            <div id="panel-central">
                <jsp:include page="<%= ((String) request.getAttribute("action")) + ".jsp"%>" />
            </div>
        </main>
        <footer>
            <hr/>
            <p>This is the footer</p>
        </footer>
    </body>
</html>
