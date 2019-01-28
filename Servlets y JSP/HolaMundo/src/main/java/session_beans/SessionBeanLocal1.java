/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface SessionBeanLocal1 {

    boolean isValidLength(String text);

    boolean isValidEmail();

    boolean isValidEmail(String email);
    
}
