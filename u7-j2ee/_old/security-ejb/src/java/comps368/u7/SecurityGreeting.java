/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.u7;

import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;
/**
 *
 * @author cyrus
 */
@Stateless
public class SecurityGreeting implements SecurityGreetingRemote {

    @Override
    @RolesAllowed({"admin","user"})
    public String GeneralGreeting() {
        return "Hello, World";
    }

    @Override
    @RolesAllowed("admin")
    public String AdminGreeting(String _msg) {
        return "Hello, Admin. This is your message : " + _msg;
    }
    
}
