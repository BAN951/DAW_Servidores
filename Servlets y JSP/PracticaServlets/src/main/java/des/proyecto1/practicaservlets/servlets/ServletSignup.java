/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.proyecto1.practicaservlets.servlets;

import des.proyecto1.practicaservlets.beans.User;
import des.proyecto1.practicaservlets.beans.UserList;
import des.proyecto1.practicaservlets.ejbs.SignUpBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "ServletSignup", urlPatterns = {"/ServletSignup"})
public class ServletSignup extends HttpServlet {

    @Resource
    Validator validator; // Creamos el objeto validador. 

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
            out.println("<title>Servlet ServletSignup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSignup at " + request.getContextPath() + "</h1>");

            ServletContext context = request.getServletContext(); 
            UserList listaUsuarios;
            User usuario;
            RequestDispatcher rd;
            
            SignUpBeanLocal bean = (SignUpBeanLocal) new InitialContext().lookup("java:global/PracticaServlets/SignUpBean");
 
            BeanUtils.populate(bean, request.getParameterMap());
            
            if (validator.validate(bean).isEmpty()) {
                usuario = new User(request.getParameter("nombreUsuario"),
                        request.getParameter("passwordUsuario"),
                        request.getParameter("emailUsuario"));

                if (context.getAttribute("listaUsuarios") == null) {
                    listaUsuarios = new UserList();
                    context.setAttribute("listaUsuarios", listaUsuarios);
                
                } 
                else {
                    listaUsuarios = (UserList) context.getAttribute("listaUsuarios");
                }

                listaUsuarios.addUser(usuario);

                rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);

            } 
            else {

                rd = request.getRequestDispatcher("signup.html");
                rd.include(request, response);
 
                for (ConstraintViolation c : validator.validate(bean)) {
                    out.println("<p>ContraintViolations: " + c.getMessage() + "</p>");
                }
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
        } catch (NamingException | IllegalAccessException | InvocationTargetException ex) {
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
