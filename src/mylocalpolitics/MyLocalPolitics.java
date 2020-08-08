/* MyLocalPolitics.java - Main class
 *  Allows users to create accounts and provide information
 *  about politicians. The information is then submitted to admins to review
 *  and validate before publishing.
 * 
 * Update for Use Case Extensions
 *  
 */
package mylocalpolitics;

import mylocalpolitics.domain.*;
import mylocalpolitics.presentation.LoginUI;

/**
 *
 * @author Nels Haugen
 * @version 2
 */
public class MyLocalPolitics {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * I use this part to check that my authenticator use case works.
         * When making a new account, entering "password" will change the account
         * to an authenticator account
         * Remove comments to use
        Politician politician = new Politician("John", "Smith", "Senator", "WA", "22");
        Politician.addToAuthList(politician);
        */
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
    
    
}
