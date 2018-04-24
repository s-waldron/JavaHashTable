package project5swaldron;

/**
 * Container class for presidents data that comes in from files outside the program.
 * @author Stephen_Waldron
 */
public class Presidents {
    private String presidentNumber;
    private String presidentLastName = "";
    private String presidentYearsInOffice;
    private String presidentParty;
    private String presidentHomeState;
    private String presidentUpdateCode;
    
    
    /**
     * Primary constructor for Presidents class.
     * @param input String
     */
    public Presidents (String input) {
        String[] inputSplit = input.split(",");
        presidentNumber = inputSplit[0];
        presidentLastName = inputSplit[1];
        presidentYearsInOffice = inputSplit[2];
        presidentParty = inputSplit[3];
        presidentHomeState = inputSplit[4];
    } // end first Presidents constructor
    
    
    /**
     * Secondary constructor for presidents update objects read in from outside the program.
     * @param input String
     * @param number Integer
     */
    public Presidents (String input, int number) {
        String[] inputSplit = input.split(",");
        presidentUpdateCode = inputSplit[0];
        if (inputSplit.length == 2)
            presidentLastName = inputSplit[1];
        else if (inputSplit.length == 5) {
            presidentLastName = inputSplit[1];
            presidentYearsInOffice = inputSplit[2];
            presidentParty = inputSplit[3];
            presidentHomeState = inputSplit[4];
        } // end else if
        else {
            presidentNumber = inputSplit[1];
            presidentLastName = inputSplit[2];
            presidentYearsInOffice = inputSplit[3];
            presidentParty = inputSplit[4];
            presidentHomeState = inputSplit[5];
        } // end else
    } // end second Presidents constructor
    
    
    /**
     * Gets the value of president number and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentNumber () {
        return presidentNumber;
    } // end getPresidentNumber method
    
    
    /**
     * Gets the value of president last name and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentLastName () {
        return presidentLastName;
    } // end getPresidentLastName method
    
    
    /**
     * Gets the value of president years in office and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentYearsInOffice () {
        return presidentYearsInOffice;
    } // end getPresidentYearsInOffice method
    
    
    /**
     * Gets the value of president party and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentParty () {
        return presidentParty;
    } // end getPresidentParty method
    
    
    /**
     * Gets the value of president home state and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentHomeState () {
        return presidentHomeState;
    } // end getPresidentHomeState method
    
    
    /**
     * Gets the value of president update code and returns it to the calling environment.
     * @param None
     * @return String
     */
    public String getPresidentUpdateCode () {
        return presidentUpdateCode;
    } // end getPresidentUpdateCode method
} // end Presidents class