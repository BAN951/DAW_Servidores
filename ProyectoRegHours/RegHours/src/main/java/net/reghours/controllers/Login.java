/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import net.reghours.datamodel.actions.UserList;
import net.reghours.datamodel.entities.User;
import net.reghours.validation.ejbs.LoginBeanLocal;
import org.apache.commons.beanutils.BeanUtils;
import net.reghours.validation.UserValidator;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        
        if("GET".equals(request.getMethod())) {
            
            if(request.getAttribute("errorLogin") != null)
                request.setAttribute("errorLogin", null);
            
            request.setAttribute("action", "login");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
        
        if("POST".equals(request.getMethod())) {
            
            LoginBeanLocal bean = (LoginBeanLocal) new InitialContext().lookup("java:global/RegHours/LoginBean");
            BeanUtils.populate(bean, request.getParameterMap());
            
            UserValidator userValidator = new UserValidator();
            ArrayList<String> errorLogin = new ArrayList();
            
            if(validator.validate(bean).isEmpty()) {
                
                if(userValidator.userExists(request.getParameter("username"))) {
                    
                    if(userValidator.loginPasswordCorrect(request.getParameter("username"), 
                                                          request.getParameter("passwd"))) {
                    
                        UserList userList = new UserList();
                        User user = userList.getUserByUsername(request.getParameter("username"));
                        
                        request.getSession().setAttribute("User", user);
                        
                        request.setAttribute("action", "userpage");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                       
                    }
                    else {
                        errorLogin.add("Incorrect password or username");
                    }
                    
                } 
                else {
                    errorLogin.add("Incorrect password or username");
                }

            }
            else {
                for(ConstraintViolation c : validator.validate(bean))
                    errorLogin.add(c.getMessage());
            }
            
            if(!(errorLogin.isEmpty())) {
                
                request.setAttribute("errorLogin", errorLogin);
                request.setAttribute("action", "login");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
