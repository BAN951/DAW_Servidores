/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/PrimeraVez", "/Primera"})
public class PrimeraVez extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Override de los métodos heredados(insert code (alt+ insert) --> Override methods... )
    
    private static Hashtable<String, String> listaIps; 
    private static int visitas; 
    
    @Override
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        
        this.listaIps = new Hashtable<String, String>(); 
        this.visitas = 0; 
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PrimeraVez</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PrimeraVez at " + request.getContextPath() + "</h1>");
          
            // Visitas totales
//            out.println("<h2>Visitas totales: " + this.visitas + "</h2>"); 
            
            String ip = request.getRemoteAddr(); // Saca la dirección ip del cliente o del último servidor proxy que se ha utilizado. 
            
            if(PrimeraVez.listaIps.contains(ip)) {
//                response.sendRedirect("noprimera.html");
                
                RequestDispatcher rd = request.getRequestDispatcher("noprimera.html"); 
                rd.forward(request, response); 
                
            } else {
//                response.sendRedirect("primera.html");

                RequestDispatcher rd = request.getRequestDispatcher("primera.html"); 
                rd.forward(request, response); 

                listaIps.put(ip, ip); 
            }
            
//            out.println("</body>");

//            out.println("</html>");
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
        processRequest(request, response);
    
        this.visitas++; 
        
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
        processRequest(request, response);
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

// a. Request dispatcher --> hace un forward, lo reenvia y lo redirige. 
// b. En la response, tiene que poner que el contenido que tiene que mostrar esa pagina 
// es un archivo en concreto. 
