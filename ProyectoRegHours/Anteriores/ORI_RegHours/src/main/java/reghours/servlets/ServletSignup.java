/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reghours.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.beanutils.BeanUtils;
import reghours.beans.User;
import reghours.beans.UserList;
import reghours.ejbs.SignUpBeanLocal;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class ServletSignup extends HttpServlet {

    @Resource
    Validator validator; 
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.naming.NamingException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, IllegalAccessException, InvocationTargetException {
        
        ServletContext context = request.getServletContext();
        UserList listaUsuarios; 
        
        SignUpBeanLocal bean = (SignUpBeanLocal) new InitialContext().lookup("java:global/RegHours/SignUpBean");
        
        BeanUtils.populate(bean, request.getParameterMap()); 
        
        if(validator.validate(bean).isEmpty() && (String) request.getParameter("confirmarPasswordUsuario") != null &&
                (((String) request.getParameter("passwordUsuario")).equals((String) request.getParameter("confirmarPasswordUsuario")))) {
            
            User usuario = new User(request.getParameter("nombreUsuario"), 
                    request.getParameter("passwordUsuario"), request.getParameter("emailUsuario")); 
            
            
            if(context.getAttribute("listaUsuarios") == null) {
                listaUsuarios = new UserList();
                context.setAttribute("listaUsuarios", listaUsuarios); 
            }
            else {
                listaUsuarios = (UserList) context.getAttribute("listaUsuarios");
            }
            
            listaUsuarios.addUser(usuario);
            
            request.setAttribute("action", "login");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
            
        } 
        else {
            
            ArrayList<String> err = new ArrayList<>();
            
            if(!(((String) request.getParameter("passwordUsuario")).equals((String) request.getParameter("confirmarPasswordUsuario")))) {
                err.add((String) request.getParameter("confirmarPasswordUsuario") == null? 
                        "Tiene que confirmar la contraseña." : "El password y su confirmación no coinciden.");
            }
            
            for(ConstraintViolation c : validator.validate(bean)) {
                err.add(c.getMessage());
            }
            
            if((ArrayList) request.getAttribute("err") != null) request.setAttribute("err", null);
            
            request.setAttribute("err", err);
            request.setAttribute("action", "signup");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
            
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
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletSignup.class.getName()).log(Level.SEVERE, null, ex);
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
