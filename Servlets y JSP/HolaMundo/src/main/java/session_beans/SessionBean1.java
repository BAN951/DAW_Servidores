/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@Stateless
public class SessionBean1 implements SessionBeanLocal1 {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public boolean isValidLength(String text) {
        return text.length() >= 6;
    }
    
    
    @Override
    public boolean isValidEmail(String email) {
        String regex = "^(.+)@(.*)$"; // Regular expression. (muy simple) 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(email); 
        return matcher.matches(); // True si coincide con el patrón (la expresión regular). 
    }

    // No usar sin parametro. 
    @Override
    public boolean isValidEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
