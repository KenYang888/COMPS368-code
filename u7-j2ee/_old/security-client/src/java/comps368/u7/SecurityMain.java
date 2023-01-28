/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.u7;

import javax.ejb.EJB;
/**
 *
 * @author cyrus
 */
public class SecurityMain {

    /**
     * @param args the command line arguments
     */
    
    @EJB
    public static SecurityGreetingRemote _bean;
    
    public static void main(String[] args) {
        System.out.println(_bean.GeneralGreeting());
        
        System.out.println(_bean.AdminGreeting("Secret Text"));
    }
    
}
