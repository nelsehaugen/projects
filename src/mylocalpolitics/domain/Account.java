/* Account - a class representing an account, either for a user or authenticator
 *  This class holds the information for each account including name and Login
 *  as well as whether or not that account belongs to an authenticator who can
 *  review and verify information. Also keeps track of which Politician objects
 *  have been created with this account so they can be edited.
 */
package mylocalpolitics.domain;

import java.util.*;


/**
 *
 * @author Nels Haugen
 * @version 1
 */
public class Account {
    private String firstName = "";
    private String lastName = "";
    private Login login = null;
    private int id;
    private boolean authenticator = false;
    
    private List<Politician> politicians = new LinkedList<Politician>();
    
    /**
     *
     * @param politician - politician object where information is stored
     * @return politician - politician object where information is stored
     */
    public Politician add(Politician politician) {
        politicians.add(politician);
        return politician;
    }

    /**
     *
     * @return firstName - the first name of the person with the account
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName - the first name of the person with the account
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return lastName - the last name of the person with the account
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName - the last name of the person with the account
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return login - the login object for the account
     */
    public Login getLogin() {
        return login;
    }

    /**
     *
     * @param login - the login object for the account
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     *
     * @return id - the number used to identify the account
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - the number used to identify the account
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return authenticator - boolean value, true if the account belongs to an
     *  authenticator, who can validate other users politician info
     */
    public boolean isAuthenticator() {
        return authenticator;
    }

    /**
     *
     * @param authenticator - boolean value, true if the account belongs to an
     *  authenticator, who can validate other users politician info
     */
    public void setAuthenticator(boolean authenticator) {
        this.authenticator = authenticator;
    }
    
    /**
     *
     * @return politicians - a list of politicians added by the account holder
     */
    public List<Politician> getPoliticians() {
        return politicians;
}
    
    /**
     *
     * @return true if first name, last, and login are not blank
     */
    public boolean validate() {
        if (firstName == null || firstName.equals("")) return false;
        if (lastName == null || lastName.equals("")) return false;
        if (login == null) return false;
        return true;
    }
    
    /**
     *
     * @param account - a user's Account object
     */
    public void deleteAccount(Account account) {
        account.firstName = "";
        account.lastName = "";
        account.login = null;
    }
}
