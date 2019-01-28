/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.proyecto1.practicaservlets.servlets;

import des.proyecto1.practicaservlets.beans.RegistroHora;
import des.proyecto1.practicaservlets.beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import des.proyecto1.practicaservlets.beans.UserList;
import des.proyecto1.practicaservlets.ejbs.LogInBeanLocal;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import javax.validation.ConstraintViolation; 
import org.apache.commons.beanutils.BeanUtils;


/**
 *
 * @author admin
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>"); 
            out.println("<meta charset='utf-8'/>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
            
            ServletContext context = request.getServletContext(); 
            
            LogInBeanLocal bean = (LogInBeanLocal) new InitialContext().lookup("java:global/PracticaServlets/LogInBean");
            BeanUtils.populate(bean, request.getParameterMap());
             
            UserList listaUsuarios; 
            RequestDispatcher rd; 
            
            if(validator.validate(bean).isEmpty()) {
               
                if((UserList) context.getAttribute("listaUsuarios") != null) {
                    
                    listaUsuarios = (UserList) context.getAttribute("listaUsuarios");
                    
                    if((Hashtable<String, ArrayList<RegistroHora>>) context.getAttribute("horas") == null) {
                        Hashtable<String, ArrayList<RegistroHora>> horas = new Hashtable<>(); 
                        context.setAttribute("horas", horas);
                    }
                    
                    for(User u : listaUsuarios.getListaUsuarios()) {
                        
                        if(u.getNombreUsuario().equals(bean.getNombreUsuario())
                            && u.getPasswordUsuario().equals(bean.getPasswordUsuario())) {
                            
                            User usuario = new User(u.getNombreUsuario(), u.getPasswordUsuario(), u.getEmailUsuario()); 
                            
                            HttpSession session = request.getSession();
                            session.setAttribute("Usuario", usuario);
                            
                            rd = request.getRequestDispatcher("principal.html");
                            rd.forward(request, response);
                            
                        } 
                    }
                    
                    rd = request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                    
                    out.println("<p>El nombre de usuario o la contraseña no coinciden con ningún registro.</p>");
                    
                } 
                else {
                    
                    rd = request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                    
                    out.println("<p>No existen usuarios en el sistema. Debes registrate antes de entrar.</p>"); 
                    
                }
                
            }
            
            for(ConstraintViolation c : validator.validate(bean)) {
                out.println("<p>ConstraintViolation: " + c.getMessage() + "</p>");
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
