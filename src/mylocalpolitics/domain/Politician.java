/* Politician - a class holding biographical information about a politician,
 *  including their name and the office they hold
 */
package mylocalpolitics.domain;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nels Haugen
 * @version 1
 */
public class Politician {
    
    private String firstName = "";
    private String lastName = "";
    private String office = "";
    private String state = "";
    private String district = "";
    private int id = 0;
    private int nextId = 0;
    private static List<Politician> authenticatorList = new LinkedList<>();
    
    /**
     *
     * @param firstName - first name of the Politician
     * @param lastName - last name of the Politician
     * @param office - office held by the Politician
     * @param state - state in which the Politician is elected
     * @param district - district in which the Politician is elected
     */
    public Politician(String firstName, String lastName, String office,
            String state, String district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.state = state;
        this.district = district;
    }
    
    /**
     *
     * @param politician - Politician object
     */
    public static void addToAuthList(Politician politician) {
        authenticatorList.add(politician);
    }
    
    /**
     *
     * @return authenticatorList - a list of users who can verify politicians
     */
    public static List<Politician> getAuthList() {
        return authenticatorList;
    }
    
    /**
     *
     * @return firstName - the first name of the Politician
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName - the first name of the Politician
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return lastName - the last name of the Politician
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName - the last name of the Politician
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return office - the office the Politician is elected to
     */
    public String getOffice() {
        return office;
    }

    /**
     *
     * @param office - the office the Politician is elected to
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     *
     * @return state - the State the Politician resides in
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state - the State the Politician resides in
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return district - the legislative district in which the politician resides
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @param district - the legislative district in which the politician resides
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     *
     * @return id - the id number assigned to the politician
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - the id number assigned to the politician
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return true if all the fields have been filled in
     */
    public boolean validate() {
        if (firstName == null || firstName.equals("")) return false;
        if (lastName == null || lastName.equals("")) return false;
        if (office == null || office.equals("")) return false;
        if (state == null || state.equals("")) return false;
        if (district == null || district.equals("")) return false;
        return true;
    }
}
