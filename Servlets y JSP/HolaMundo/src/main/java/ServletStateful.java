/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.beanutils.BeanUtils;
import session_beans.StatefulBeanLocal;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/ServletStateful"})
public class ServletStateful extends HttpServlet {

    // Validator
    
    @Resource
    Validator validador; // de javax.validation.Validator; 
    
    
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
            throws ServletException, IOException, NamingException, IllegalAccessException, InvocationTargetException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletStateful</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletStateful at " + request.getContextPath() + "</h1>");
            
            /* Obtenemos bean stateful */
            StatefulBeanLocal bean = (StatefulBeanLocal) new InitialContext().lookup("java:module/StatefulBean"); 
            
            /* Propagamos parametros sin populate */ /*
            String edad = request.getParameter("edad"); 
            String password = request.getParameter("password"); 
            String dni = request.getParameter("dni");
            
            bean.setEdad(edad); 
            bean.setPassword(password);
            bean.setDNI(dni);
            
            out.println("<h1>Datos recibidos del formulario: </h1>");
            out.println("<p>Edad: " + bean.getEdad() + "</p>");
            out.println("<p>Password: " + bean.getPassword() + "</p>");
            out.println("<p>DNI: " + bean.getDNI()+ "</p>");
            */
            
            
            /* Propagamos parametros con populate */
            out.println("<h1>Datos recibidos del formulario</h1>"); 
            
            BeanUtils.populate(bean, request.getParameterMap());
            out.println("<p>" + bean.print() + "</p>"); 
            
            
            // Alistamos las validaciones
            out.println("<h1>Listado de validaciones:</h2>"); 
                    
            // Necesitamos un validator (se añade arriba) 
            
            for(ConstraintViolation c: validador.validate(bean)) {
                out.println("<p>" + c.getMessage() + "</p>");
            }
                    
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletStateful.class.getName()).log(Level.SEVERE, null, ex);
        }
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
