/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Almacendando cookie en tu navegador</h1>");
            
            // Almacenar datos del cliente en el navegador (en el cookie). 
            String user = request.getParameter("user");
            out.println("<p>Usuario " + user + "</p>"); 
            
            
            // ALMACENO USUARIO EN COOKIE.
            // Objeto cookie: (key, value) en los parámetros. Cómo un hashtable. 
            // El navegador del cliente tiene un array de cookies y se van almacenando allí todos. 
            Cookie cookie = new Cookie("user", user);
            response.addCookie(cookie);// Añadimos el cookie al navegador del cliente en la response (que és lo que visualiza el cliente).  
            
            // Obtiene max age de la cookie. 
            // cookie.getMaxAge(0);
            
            // Con setMaxAge podemos poner la fecha y hora de caducidad de la cookie. 
            // cookie.setMaxAge(); 
            
            // Si no ponemos el age, cuando el navegador se cierra. 
            
            // Si ponemos un valor 0 cierra la cookie desde la parte del servidor, no desde la parte del cliente. 
            // se cierra cuando se cierra la página. Se suele usar cuando cierras sesión, un logout. 
            // request.getSession().invalidate(); También se puede hacer esto. 
            // Invalidar la sesión y borrar las cookies. 
            
            // request.getSession().getId();
            /* Siempre tendremos una tabla de sesiones en la base de datos. Para esa tabla como id, 
               podemos usar el id de sesión como primary key. */
            
            
            out.println("<br><form action='CookieServlet2' method=GET>");
            out.println("<input type='submit' value='go'/>");
            out.println("</form>");
            
            out.println("<br/>");
            out.println("<br/>");
          
            // ALMACENO USUARIO EN EL CLIENTE. 
            
            /* Sobre escribo URL. */
            out.println("<a href='URLServlet?user=" + user + "'>go<a/>");
            
            /* AÑADO INPUT OCULTO AL FORMULARIO */
            // Esto es en caso de que tengamos un formulario. 
            // Si no tenemos otro formulario no lo podemos hacer(?)
            
            out.println("<br/><br/>");
            out.println("<h1>Form con input oculto</h1>");
            
            out.println("<br><form action='HiddenServlet' method='POST'>"); // en este caso tiene que ser method=POST para que no se vea en la url nada. 
            out.println("<input type='hidden' id='oculto' name='oculto' value'" + user + "'/>"); 
            out.println("<input type='submit' value='Hidden-Go'/>");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
