/* PoliticianTableModel - a model for each politician object in the main menu 
 *  table.
 */
package mylocalpolitics.presentation;

import mylocalpolitics.domain.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nels Haugen
 * @version 1
 */
public class PoliticianTableModel extends AbstractTableModel{
    
    private String[] columnNames = {"First name", "Last name", "Office", "State",
        "District"};
    
    private List<Politician> politicians = new LinkedList<Politician>();
    
    /** Politician list setter
     *
     * @param politicians - a Politician object
     */
    public void setPoliticians(List<Politician> politicians) {
        this.politicians = politicians;
    }
    
    /** gets the number of rows
     *
     * @return number of rows
     */
    @Override
    public int getRowCount() {
        return politicians.size();
    }
    
    /** column length getter
     *
     * @return the number of columns
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    /** returns one piece of information on a politician, based on the row 
     * number and column selected and passed in.
     *
     * @param row - the desired row number
     * @param column - the desired column number
     * @return name or office information for a politician depending on what is 
     *  requested.
     */
    @Override
    public Object getValueAt(int row, int column) {
        Politician politician = politicians.get(row);
        switch (column) {
            case 0:
                return politician.getFirstName();
            case 1:
                return politician.getLastName();
            case 2:
                return politician.getOffice();
            case 3:
                return politician.getState();
            case 4:
                return politician.getDistrict();
        }
        return "";
    }
    
    /** columnNames getter
     *
     * @param column - number representing which column is selected
     * @return columnNames - a String of the name of the column.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
