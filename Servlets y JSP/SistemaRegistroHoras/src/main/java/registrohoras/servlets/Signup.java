/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrohoras.servlets;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.beanutils.BeanUtils;
import registrohoras.beans.User;
import registrohoras.beans.UserList;
import registrohoras.ejbs.SignUpBeanLocal;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

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
            throws ServletException, IOException, NamingException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
        UserList listaUsuarios; 
      
        SignUpBeanLocal bean = (SignUpBeanLocal) new InitialContext().lookup("java:global/SistemaRegistroHoras/SignUpBean");
        
        BeanUtils.populate(bean, request.getParameterMap());
        
        if(validator.validate(bean).isEmpty()) {
            
            if(request.getParameter("confirmarPasswordUsuario") == null || 
               !(request.getParameter("confirmarPasswordUsuario").equals((String) request.getParameter("passwordUsuario")))) {
                
                // Confirmación del password es null o no coincide. 
                String errorConfirmarPasswd = (request.getParameter("confirmarPasswordUsuario") == null 
                        || request.getParameter("confirmarPasswordUsuario") == "") ?  
                        "Tiene que confirmar el password. No puede dejarlo vacío." : 
                        "La confirmación del password tiene coincidir con el password."; 
                
                request.setAttribute("action", "pages/Signup");
                request.setAttribute("ErrorSignup", new ArrayList().add(errorConfirmarPasswd));
                request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response);
                
            }
            else {
                
                User usuario = new User(request.getParameter("nombreUsuario"),
                               request.getParameter("passwordUsuario"),
                               request.getParameter("emailUsuario"));
            
                if(context.getAttribute("listaUsuarios") == null) {
                    listaUsuarios = new UserList();
                    context.setAttribute("listaUsuarios", listaUsuarios);
                }
                else {
                    listaUsuarios = (UserList) context.getAttribute("listaUsuarios"); 
                }
                
                // Si ahy lista de usuarios ya en el contexto, comprobar que algun dato del usuario nuevo que queremos 
                // añadir no coincide con usuarios anteriores. 
                // No pueden coincidir. 

                listaUsuarios.addUser(usuario);

                request.setAttribute("action", "pages/Login");
                request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response); 
            }
            
        }
        else {
            
            ArrayList<String> cvs = new ArrayList<>(); 
            
            for(ConstraintViolation c : validator.validate(bean)) {
                cvs.add("ConstraintViolation: " + c.getMessage());
            }
            
            request.setAttribute("ErrorSignup", cvs);
            request.setAttribute("action", "pages/Signup"); 
            request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response); 
            
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
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
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
