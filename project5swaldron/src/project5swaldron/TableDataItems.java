package project5swaldron;

/**
 * Container class for Presidents objects into the hash table.
 * @author Stephen_Waldron
 */
public class TableDataItems {
    private Presidents presidentData;
    private int deletedData = 0;
    
    
    /**
     * Constructor for table data items class.
     * @param thePresident Presidents
     */
    public TableDataItems (Presidents thePresident) {
        presidentData = thePresident;
    } // end First TableDataItems constructor
    
    
    /**
     * Changes the value of deleted data based on number passed in from calling environment.
     * @param number Integer
     * @return None
     */
    public void changeDeletedDataValue (int number) {
        deletedData = number;
    } // end changeDeletedDataValue method
    
    
    /**
     * Gets the president data and returns it to the calling environment.
     * @param None
     * @return Presidents
     */
    public Presidents getPresidentData () {
        return presidentData;
    } // end getPresidentData method
    
    
    /**
     * Gets the value of deleted data and returns it to the calling environment.
     * @param None
     * @return Integer
     */
    public int getDeletedData () {
        return deletedData;
    } // end getDeletedData method
} // end TableDataItems class