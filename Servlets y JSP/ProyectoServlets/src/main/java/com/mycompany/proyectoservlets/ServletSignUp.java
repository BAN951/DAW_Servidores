/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoservlets;

import com.mycompany.proyectoservlets.ejbs.SignUpBeanLocal;
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

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletSignUp", urlPatterns = {"/ServletSignUp"})
public class ServletSignUp extends HttpServlet {

    
    @Resource
    Validator validador; 
    
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
            out.println("<title>Servlet ServletSignUp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSignUp at " + request.getContextPath() + "</h1>");
            
            SignUpBeanLocal bean = (SignUpBeanLocal) new InitialContext().lookup("java:global/ProyectoServlets/SignUpBean");
            
            out.println("<h3>Datos recibidos del registro de usuario: </h3>");
            
            // Propagamos parametros sin populate 
            String username = request.getParameter("nombreUsuario");
            String password = request.getParameter("passwordUsuario");
            String email = request.getParameter("emailUsuario");
            
            bean.setNombreUsuario(username);
            bean.setPasswordUsuario(password);
            bean.setEmailUsuario(email);
            
            out.println("<p>DATOS DE USUARIO: </p><br/>");
            out.println("<p>Nombre de usuario: " + bean.getNombreUsuario() + "</p>");
            out.println("<p>Password usuario: " + bean.getPasswordUsuario() + "</p>");
            out.println("<p>Email usuario: " + bean.getEmailUsuario() + "</p>");
            
            
            // Con populate, primero intentamos sin populate y comprobamos datos
            /*BeanUtils.populate(bean, request.getParameterMap());
            out.println("<p>Datos de usuario introducidos:" + bean.getDatosUsuario() + "</p><br/>");*/
            
            out.println("<p><b>Listado de validaciones: </b></p>");
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
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletSignUp.class.getName()).log(Level.SEVERE, null, ex);
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
