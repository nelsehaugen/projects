/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocalpolitics.service;

import mylocalpolitics.domain.*;
import java.util.*;

/**
 *
 * @author Nels
 */
public class AccountSvcCacheImpl implements IAccountSvc {
    
    private List<Account> cache = new ArrayList();
    private int nextId = 0;
    
    AccountSvcCacheImpl() {
    }
    
    private static AccountSvcCacheImpl instance = new AccountSvcCacheImpl();
    
    public static AccountSvcCacheImpl getInstance() {
        return instance;
    }
    
    @Override
    public Account create(Account account) {
        account.setId(++nextId);
        cache.add(account);
        return account;
    }
    
    @Override
    public List<Account> retrieveAll() {
        return cache;
    }
    
    @Override
    public Account update(Account account) {
        for (int i = 0; i < cache.size(); i++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.set(i, account);
                break;
            }
        }
        
        return account;
    }
    
    @Override
    public Account delete(Account account) {
        for (int i = 0; i < cache.size(); i++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.remove(i);
                break;
            }
        }
        
        return account;
    }
    
    @Override
    public Account authenticate(Login login) {
        Account account = null;
        for (int i = 0; i < cache.size(); i++) {
            account = cache.get(i);
            Login accountLogin = account.getLogin();
            if (login.equals(accountLogin)) return account;
        }
        return null;
    }
}
