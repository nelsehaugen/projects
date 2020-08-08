/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocalpolitics.service;

import java.util.ArrayList;
import java.util.List;
import mylocalpolitics.domain.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nels
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
        List<Account> cache = new ArrayList();
        int nextId = 0;
    }

    @Test
    public void testCRUD() {
        
        AccountSvcCacheImpl impl = new AccountSvcCacheImpl();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        
        Account account = new Account();
        assertEquals(account.getId(), 0);
        account.setFirstName("John");
        account.setLastName("Doe");
        Login login = new Login();
        login.setUsername("jdoe@email.com");
        login.setPassword("12345");
        account.setLogin(login);
        
        //test create
        account = impl.create(account);
        assertNotNull(account);
        assertNotEquals(account.getId(), 0);
        
        //test retrieveAll
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        
        //test update
        account.setFirstName("Jane");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        assertEquals(account.getFirstName(), "Jane");
        
        //test delete
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        
        //test authenticate
        Account account1 = new Account();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        Login login1 = new Login();
        login1.setUsername("jdoe@mail.com");
        login1.setPassword("12345");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
        
        Account account2 = new Account();
        account2.setFirstName("jane");
        account2.setLastName("McDoe");
        Login login2 = new Login();
        login2.setUsername("jmcdoe@mail.com");
        login2.setPassword("5678");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUsername("blah");
        login3.setPassword("yada");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setUsername("jdoe@mail.com");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("12345");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        login3.setUsername("jmcdoe@mail.com");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("5678");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
    }
    
}
