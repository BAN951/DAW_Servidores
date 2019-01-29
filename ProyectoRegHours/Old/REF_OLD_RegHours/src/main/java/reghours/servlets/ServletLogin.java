/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reghours.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.apache.commons.beanutils.BeanUtils;
import javax.validation.Validator;
import reghours.beans.RegistroHora;
import reghours.beans.User;
import reghours.beans.UserList;

import reghours.ejbs.LogInBeanLocal;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class ServletLogin extends HttpServlet {

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
        
        LogInBeanLocal bean = (LogInBeanLocal) new InitialContext().lookup("java:global/RegHours/LogInBean");
        BeanUtils.populate(bean, request.getParameterMap());
        
        ArrayList<String> err;
        
        if(validator.validate(bean).isEmpty()) {
            
            if((UserList) context.getAttribute("listaUsuarios") != null) {
                
                UserList listaUsuarios = (UserList) context.getAttribute("listaUsuarios");
                
                if((HashMap<String, ArrayList<RegistroHora>>) context.getAttribute("horasUsuario") == null) {
                    HashMap<String, ArrayList<RegistroHora>> horasUsuario = new HashMap<>();
                    context.setAttribute("horasUsuario", horasUsuario);
                }
            
                for(User u : listaUsuarios.getListaUsuarios()) {
                    
                    if(u.getNombreUsuario().equals(bean.getNombreUsuario()) &&
                            u.getPasswordUsuario().equals(bean.getPasswordUsuario())) {
                    
                        User usuario = new User(u.getNombreUsuario(), u.getPasswordUsuario(), u.getEmailUsuario());
                    
                        request.getSession().setAttribute("Usuario", usuario);
                        
                        request.setAttribute("action", "user_hours");
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    
                    } 
                    
                }

                err = new ArrayList<>();
                err.add("Su nombre de usuario o contraseña no coincide con ninguno en nuestro sistema.");
                request.setAttribute("err", err);
                request.getRequestDispatcher("Index.jsp").forward(request, response);
                
                
            } 
            else {
                
                err = new ArrayList<>();
                err.add("No hay ningún usuario en el sistema. Por favor créase una cuenta.");
                request.setAttribute("err", err);
                request.getRequestDispatcher("Index.jsp").forward(request, response);
               
            }
        }
        else {
        
            err = new ArrayList<>();
            for(ConstraintViolation c : validator.validate(bean)) {
                err.add(c.getMessage());
            }
            
            request.setAttribute("err", err);
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
        } catch (NamingException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
