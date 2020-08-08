/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocalpolitics.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nels
 */
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testValidate() {
        Account account = new Account();
        boolean result = account.validate();
        assertFalse(result);
        account.setFirstName("Bob");
        result = account.validate();
        assertFalse(result);
        account.setLastName("Villa");
        result = account.validate();
        assertFalse(result);
        Login login = new Login();
        login.setUsername("Bob");
        login.setPassword("123456");
        account.setLogin(login);
        result = account.validate();
        assertTrue(result);
    }
    
    @Test
    public void testDeleteAccount() {
        Account account = new Account();
        account.setFirstName("Bob");
        account.setLastName("Villa");
        Login login = new Login();
        login.setUsername("Bob");
        login.setPassword("123456");
        account.setLogin(login);
        boolean result = account.validate();
        assertTrue(result);
        
        account.deleteAccount(account);
        result = account.validate();
        assertFalse(result);
    }
}
