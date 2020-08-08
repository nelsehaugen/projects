/* Login - a class representing a user's login info, consisting of username and
 *  password.
 * 
 * Update for Use Case Extensions
 *  Added pass phrase to login so that both password and pass phrase are required
 * for login as well as which pass question was selected. Also updated the 
 * validate and equals methods to reflect this new requirement.
 */
package mylocalpolitics.domain;

/**
 *
 * @author Nels Haugen
 * @version 2
 */
public class Login {
    
    private String username = "";
    private String password = "";
    private String passPhrase = "";
    private int passOption;
    // Option 1: What was the name of your first pet?
    // Option 2: What was the name of your high school?
    // Option 3: What is your mother's maiden name?
    // Option 4: Name the hospital you were born in?
    
    

    /** username getter
     *
     * @return username - the account username
     */
    public String getUsername() {
        return username;
    }

    /** username setter
     *
     * @param username - the account username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** password getter
     *
     * @return password - the user's password
     */
    public String getPassword() {
        return password;
    }

    /** password setter
     *
     * @param password - the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /** passPhrase getter
     * 
     * @return passPhrase - the phrase selected by the user
     */
    public String getPassPhrase() {
        return passPhrase;
    }
    
    /** passPhrase setter
     * 
     * @param passPhrase - the phrase selected by the user
     */
    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }
    
    /** passOption getter
     * 
     * @return passOption - which pass phrase question was selected
     */
    public int getPassOption() {
        return passOption;
    }
    
    /** passOption setter
     * 
     * @param passOption - the pass phrase question that was selected
     */
    public void setPassOption(int passOption) {
        this.passOption = passOption;
    }
    
    /**
     *
     * @return true if username and password is not left blank
     */
    public boolean validate() {
        if (username == null || username.equals("")) return false;
        if (password == null || password.equals("")) return false;
        if (passPhrase == null || passPhrase.equals("")) return false;
        if (passOption == -1) return false;
        return true;
    }
    
    /**
     *
     * @param obj - generic object, desired input is a Login object
     * @return true if the object passed in is the correct login name and
     *  password
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (! (obj instanceof Login)) return false;
        Login login = (Login)obj;
        if (!this.username.equals(login.getUsername())) return false;
        if (!this.password.equals(login.getPassword())) return false;
        if (!this.passPhrase.equals(login.getPassPhrase())) return false;
        if (!(this.passOption == login.getPassOption())) return false;
        return true;
    }
}
