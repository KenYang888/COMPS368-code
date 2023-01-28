/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.u7;

import javax.ejb.Remote;

/**
 *
 * @author cyrus
 */
@Remote
public interface SecurityGreetingRemote {
    String GeneralGreeting();
    String AdminGreeting(String _msg);
}
