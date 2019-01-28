/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.proyecto1.practicaservlets.servlets;

import des.proyecto1.practicaservlets.beans.RegistroHora;
import des.proyecto1.practicaservlets.beans.User;
import des.proyecto1.practicaservlets.types.EntradaSalida;
import static des.proyecto1.practicaservlets.types.EntradaSalida.ENTRADA;
import static des.proyecto1.practicaservlets.types.EntradaSalida.SALIDA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebServlet(name = "ServletPrincipal", urlPatterns = {"/ServletPrincipal"})
public class ServletPrincipal extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEntradaSalida</title>"); 
            out.println("<meta charset='utf-8'/>");
            out.println("<style type='text/css'>"
                    + "table, th, td { border: 1px solid black; border-collapse: collapse; padding: .5em; }"
                    + "#aviso-fichar { color: red; font-weight: bold; }"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEntradaSalida at " + request.getContextPath() + "</h1>");
            
            ServletContext context = request.getServletContext(); 
            RequestDispatcher rd = request.getRequestDispatcher("principal.html"); 
            
            Hashtable<String, ArrayList<RegistroHora>> tablaHoras; 
            tablaHoras = (Hashtable<String, ArrayList<RegistroHora>>) context.getAttribute("horas");
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("Usuario"); 
            
            long[] entradaYSalidas = {0, 0}; // Array donde guardo entrada y salida para calcular la diferencia.
            int totalHoras = 0, totalMinutos = 0, totalSegundos = 0; 
           
            if(request.getParameter("buttonEntrada") != null) {

                if(tablaHoras.containsKey(user.getNombreUsuario()) && !(tablaHoras.get(user.getNombreUsuario()).isEmpty()) 
                        && tablaHoras.get(user.getNombreUsuario()).get(tablaHoras.get(user.getNombreUsuario()).size() - 1).getTipo() == ENTRADA){
                    
                    rd.include(request, response);
                    out.println("<p id='aviso-fichar'>¡Tienes que fichar SALIDA antes de poder entrar de nuevo!</p>");
                
                } 
                else {
                    if(tablaHoras.containsKey(user.getNombreUsuario())) {
                        tablaHoras.get(user.getNombreUsuario()).add(new RegistroHora(user, EntradaSalida.ENTRADA, new GregorianCalendar()));
                    } 
                    else {
                        tablaHoras.put(user.getNombreUsuario(), new ArrayList<RegistroHora>());
                        tablaHoras.get(user.getNombreUsuario()).add(new RegistroHora(user, EntradaSalida.ENTRADA, new GregorianCalendar())); 
                    }
                
                    rd.include(request, response);
                    out.println("<p>Entrada registrada correctamente.</p>"); 
                }
    
            } 
            else if(request.getParameter("buttonSalida") != null) { 
                
                if(tablaHoras.containsKey(user.getNombreUsuario()) && !(tablaHoras.get(user.getNombreUsuario()).isEmpty()) 
                        && tablaHoras.get(user.getNombreUsuario()).get(tablaHoras.get(user.getNombreUsuario()).size() - 1).getTipo() == SALIDA){
                    
                    rd.include(request, response);
                    out.println("<p id='aviso-fichar'>¡Tienes que fichar ENTRADA antes de poder salir!</p>");
                }
                else {
                    if(tablaHoras.containsKey(user.getNombreUsuario())) {
                       tablaHoras.get(user.getNombreUsuario()).add(new RegistroHora(user, EntradaSalida.SALIDA, new GregorianCalendar()));
                    } 
                    else {
                        tablaHoras.put(user.getNombreUsuario(), new ArrayList<RegistroHora>());
                        tablaHoras.get(user.getNombreUsuario()).add(new RegistroHora(user, EntradaSalida.SALIDA, new GregorianCalendar())); 
                    }
                
                rd.include(request, response);
                out.println("<p>Salida registrada correctamente.</p>"); 
                }
            }
            
            if(!tablaHoras.isEmpty()) {

                out.println("<h2>Usuario: " + user.getNombreUsuario() + "</h2>");
                out.println("<table>"); 
                out.println("<tr>"
                        + "<th>Usuario</th>"
                        + "<th>Entrada / Salida</th>"
                        + "<th>Día</th>"
                        + "<th>Mes</th>"
                        + "<th>Año</th>"
                        + "<th>Hora</th>"
                        + "<th>Diferencia</th>"
                        + "<th>Total</th>"
                        + "</tr>"); 
                for(RegistroHora rh : tablaHoras.get(user.getNombreUsuario())) {
                    out.println("<tr>");
                    out.println("<td>" + rh.getUser().getNombreUsuario() + "</td>");
                    out.println("<td>" + rh.getTipo().toString() + "</td>");
                    
                    String datetime = rh.getDate().getTime().toString();
                    String[] datetimeSplitted = datetime.split(" "); 
                    
                    out.println("<td>" + datetimeSplitted[0] + " " + datetimeSplitted[2] + "</td>");
                    out.println("<td>" + datetimeSplitted[1] + "</td>");
                    out.println("<td>" + datetimeSplitted[5] + "</td>");
                    out.println("<td>" + datetimeSplitted[3] + "</td>");
                    
                    if(rh.getTipo() == ENTRADA) {
                        entradaYSalidas[0] = rh.getDate().getTimeInMillis() / 1000; 
                    }
                    else {
                        entradaYSalidas[1] = rh.getDate().getTimeInMillis() / 1000;
                        
                        long diff = entradaYSalidas[1] - entradaYSalidas[0];
                        int horas = 0, minutos = 0, segundos;
                        
                        if(diff > 3600) {
                            horas = (int) Math.floor((diff / 60) / 60);
                            minutos = (int) Math.floor((diff / 60) % 60); 
                            segundos = (int) Math.floor(diff % 60);
                        }
                        else if(diff > 60 ){
                            minutos = (int) Math.floor(diff / 60); 
                            segundos = (int) Math.floor(diff % 60);
                        } 
                        else {
                            segundos = (int) Math.floor(diff);  
                        }
                        
                        out.println("<td>" + horas + ":" + minutos + ":" + segundos + "</td>");
                        
                        totalHoras = totalHoras + horas; 
                        totalMinutos = totalMinutos + minutos;
                        if(totalMinutos > 60) {
                            totalHoras = totalHoras + 1; 
                            totalMinutos = totalMinutos - 60; 
                        }
                        totalSegundos = totalSegundos + segundos;
                        if(totalSegundos > 60) {
                            totalMinutos = totalMinutos + 1; 
                            totalSegundos = totalSegundos - 60; 
                        }
                        
                        out.println("<td>" + totalHoras + ":" + totalMinutos + ":" + totalSegundos + "</td>");
                        
                    }
                    
                    out.println("</tr>");
                }
                out.println("</table>"); 
                
            } 
            else {
                out.println("<p>Todavía no hay registros de entrada/salida.</p>");
            }
            
            out.println("<p></p>");
            
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
        processRequest(request, response);
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
