<%-- 
    Document   : user_hours
    Created on : 16-ene-2019, 11:40:52
    Author     : Benjamin Adam Nagy
--%>

<%@page import="reghours.beans.RegistroHora"%>
<%@page import="java.util.HashMap"%>
<%@page import="reghours.beans.RegistroHora"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id='user_hours'>
    <h1>Horas usuario</h1>
    <div>
        <p>¡Bienvenido al sistema de fichar entradas y salidas!</p>
        
    <%  if(((HashMap<String, ArrayList<RegistroHora>>) application.getAttribute("horasUsuario")).isEmpty()) { %>
    
        <p>Aún no tienes ninguna hora registrada en nuestro sistema.</p>
        <p>Haz click en el botón entrada para empezar a registrar tus horas.</p>
        <form id='form-entrada-salida' name='form-entrada-salida' method='POST' action='ServletHorasUsuario'>
            <button type='submit' name='buttonEntrada' value='Entrada'>Entrada</button>
        </form>
    
    <%  } else { %>

        <p>Dale a <b>'Entrada'</b> para fichar la entrada y a <b>'Salida'</b> para fichar la salida.</p>
        <form id='form-entrada-salida' name='form-entrada-salida' method='POST' aciton='ServletHorasUsuario'>
            <button type='submit' name='buttonEntrada' value='Entrada'>Entrada</button>
            <button type='submit' name='buttonSalida' value='Salida'>Salida</button>
        </form>

        <% if(request.getAttribute("operacionIncorrecta") != null) { %>
            
            <p class="text-danger"<b>Operación incorrecta.</b></p>
        
            <% if("entradaIncorrecta".equals(request.getAttribute("operacionIncorrecta"))) { %>
                
                <p class="text-danger">Tienes que salir antes de entrar de nuevo.</p>
                <p class="text-danger">No puedes entrar si no has salido.</p>
            
            <%  } else { %>
            
                <p class="text-danger">Tienes que entrar antes de salir.</p>
                <p class="text-danger">No puedes salir si no has entrado.</p>
            
            <%  } %>
        
        <%  } %>
        
        <%--  AQUÍ VA LA TABLA CON LAS HORAS  --%>
        <%-- Al darle al botón va al servlet, añade el dato que toca al HashMap de horas y redirige de vuelta
             a la página de las horas, alli se recarga el panel central y saca con un for todos los registros que hay
             de horas en el HashMap. --%>
        
    <%  }  %>
    </div> 
</div>  

