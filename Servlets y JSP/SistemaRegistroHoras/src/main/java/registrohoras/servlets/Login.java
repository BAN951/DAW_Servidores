/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrohoras.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Hashtable;
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
import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import org.apache.commons.beanutils.BeanUtils;
import registrohoras.beans.RegistroHora;
import registrohoras.beans.User;
import registrohoras.beans.UserList;
import registrohoras.ejbs.LogInBeanLocal;

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
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.IllegalAccessException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, IllegalAccessException, InvocationTargetException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext(); 
        
        LogInBeanLocal bean = (LogInBeanLocal) new InitialContext().lookup("java:global/SistemaRegistroHoras/LogInBean");
        BeanUtils.populate(bean, request.getParameterMap());
        
        UserList listaUsuarios; 
        RequestDispatcher rd; 
        
        if(validator.validate(bean).isEmpty()) {
            
            if(((UserList) context.getAttribute("listaUsuarios")) != null) {
                
                listaUsuarios = (UserList) context.getAttribute("listaUsuarios"); 
                
                if(((Hashtable<String, ArrayList<RegistroHora>>) context.getAttribute("horas")) == null) {
                        Hashtable<String, ArrayList<RegistroHora>> horas = new Hashtable<>(); 
                        context.setAttribute("horas", horas);
                }
                
                for(User u : listaUsuarios.getListaUsuarios()) {
                
                    if(u.getNombreUsuario().equals(bean.getNombreUsuario())
                            && u.getPasswordUsuario().equals(bean.getPasswordUsuario())) {
                        
                        User usuario = new User(u.getNombreUsuario(),
                                                u.getPasswordUsuario(),
                                                u.getEmailUsuario());
                        
                        HttpSession session = request.getSession();
                        session.setAttribute("Usuario", usuario); 
                        
                        // redirect a ""principal.jsp""
                        // Tenemos que redireccionar al jsp principal, y el action
                        // para mostrar el panel central tiene que ser la tabla de horas. 
                        
                        request.setAttribute("action", "pages/RegistroHoras");
                        request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response); 
                        
                    }
                }
          
                request.setAttribute("action", "pages/Login"); 
                
                request.setAttribute("ErrorLogin", new ArrayList<>()
                        .add("El nombre de usuario o la contraseña no coinciden con ningún registro."));
                
                request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response);
                
            }
            else {
                
                // Si entra aquí es porque no existe una lista de usuarios. 
                // Eso significa que no hay ningún usuario; y si no hay nadie registrado, 
                // no podemos hacer login. --> Volvemos a la misma página sacando el error correspondiente. 
                
                request.setAttribute("action", "pages/Login"/* request.getAttribute("action") */ );

                request.setAttribute("ErrorLogin", new ArrayList<>()
                        .add("No existen usuarios en el sistema, tienes que registrarte antes de entrar."));
                
                request.getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response);
                
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
