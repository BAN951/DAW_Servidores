/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.examenservlets.servlets;

import des.examenservlets.beans.RegistroProducto;
import des.examenservlets.ejbs.ValidarAddProductsLocal;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletAddProduct", urlPatterns = {"/ServletAddProduct"})
public class ServletAddProduct extends HttpServlet {

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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, IllegalAccessException, InvocationTargetException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConfirmar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConfirmar at " + request.getContextPath() + "</h1>");
            
            ValidarAddProductsLocal bean = (ValidarAddProductsLocal) new InitialContext().lookup("java:global/ExamenServlets/ValidarAddProdcuts");
            BeanUtils.populate(bean, request.getParameterMap()); 
            
            RequestDispatcher rd; 
            
            if(validator.validate(bean).isEmpty()) {
                
                ServletContext context = request.getServletContext();
                                                   
                RegistroProducto regProducto = new RegistroProducto(request.getParameter("id"),
                                                   request.getParameter("cmbProductos"),
                                                   Integer.parseInt(request.getParameter("cantidad")));
                
                context.setAttribute("productoNuevo", regProducto);
                
                HttpSession session = request.getSession(); 
                session.setAttribute("AddProduct", regProducto);
                
                Cookie cookieID = new Cookie("id", request.getParameter("id"));
                Cookie cookieProducto = new Cookie("producto", request.getParameter("cmbProductos"));
                Cookie cookieCantidad = new Cookie("cantidad", request.getParameter("cantidad")); 
                
                response.addCookie(cookieID);
                response.addCookie(cookieProducto);
                response.addCookie(cookieCantidad);
                
                rd = request.getRequestDispatcher("ServletConfirmado"); 
                rd.forward(request, response);
            
            } 
            else {
            
                rd = request.getRequestDispatcher("index.html"); 
                rd.include(request, response);
                
                out.println("<p>Error datos introducidos:</p>");
                
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
        } catch (NamingException ex) {
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ServletAddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
