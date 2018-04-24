package project5swaldron;
import java.io.*;
/**
 * This is the main user interface for Project 5.
 * @author Stephen_Waldron
 */
public class UserInterface {
    private FileInterface theFile = new FileInterface();
    private Presidents thePresident;
    private HashTable myHashTable = new HashTable();
    
    
    /**
     * Calls read main file method in file interface class to read the main file.
     * @param None
     * @return None
     * @throws IOException 
     */
    public void readMainFile () throws IOException {
        theFile.readMainFile();
    } // end readMainFile method
    
    
    /**
     * Calls display hash main method in file interface class to display the array for testing purposes.
     * @param None
     * @return None
     */
    public void displayMainFile () {
        theFile.displayHashMain();
    } // end displayMainFile method
    
    
    /**
     * Calls read update file method in file interface class to read the update file.
     * @param None
     * @return None
     * @throws IOException 
     */
    public void readUpdateFile () throws IOException {
        theFile.readUpdateFile();
    } // end readUpdateFile method
    
    
    /**
     * Calls display hash update method in file interface class to display the array for testing purposes.
     * @param None
     * @return None
     */
    public void displayUpdateFile () {
        theFile.displayHashUpdate();
    } // end displayUpdateFile method
    
    
    /**
     * Calls read hash table file method in file interface class to read the hash table file.
     * @param None
     * @return None
     * @throws IOException 
     */
    public void readHashTableFile () throws IOException {
        theFile.readHashTableFile();
    } // end readHashTableFile method
    
    
    /**
     * Calls display hash table method in file interface class to display the array for testing purposes.
     * @param None
     * @return None
     */
    public void displayHashTableFile () {
        theFile.displayHashTable();
    } // end displayHashTableFile method
    
    
    /**
     * Builds the hash table arrays for letters and values.
     * @param None
     * @return None
     */
    public void buildHashTableArrays () {
        for (int count = 0; count < theFile.getHashTableSize(); count = count + 1) {
            String input = theFile.getHashTableElements(count);
            //System.out.println(input);
            myHashTable.buildLetterAndValueArrays(input);
        } // end for loop
    } // end buildHashTableArrays method
    
    
    /**
     * Calls display letter and value arrays in hash table class to display the arrays for testing purposes.
     * @param None
     * @return None
     */
    public void displayHashTableArrays () {
        myHashTable.displayLetterAndValueArrays();
    } // end displayHashTableArrays method
    
    
    /**
     * Builds hash table 1 in hash table class.
     * @param None
     * @return None
     */
    public void buildHashTable1 () {
        for (int count = 0; count < theFile.getHashMainSize(); count = count + 1){
            thePresident = new Presidents(theFile.getHashMainElements(count));
            myHashTable.buildHashTable1(thePresident);
        } // end for loop
    } // end buildHashTable1 method
    
    
    /**
     * Builds hash table 2 in hash table class.
     * @param None
     * @return None
     */
    public void buildHashTable2 () {
        for (int count = 0; count < theFile.getHashMainSize(); count = count + 1){
            thePresident = new Presidents(theFile.getHashMainElements(count));
            myHashTable.buildHashTable2(thePresident);
        } // end for loop
    } // end buildHashTable1 method
    
    
    /**
     * Displays hash table 1 to the user.
     * @param None
     * @return None
     */
    public void displayHashTable1 () {
        myHashTable.displayHashTable1();
        //myHashTable.alternativeDisplayHashTable1(); // not for grading do not turn on
    } // end displayHashTable1 method
    
    
    /**
     * Display hash table 2 to the user.
     * @param None
     * @return None
     */
    public void displayHashTable2 () {
        myHashTable.displayHashTable2();
        //myHashTable.alternativeDisplayHashTable2(); // not for grading do not turn on
    } // end displayHashTable2 method
    
    
    /**
     * Updates hash table 1 and 2.
     * @param None
     * @return None
     */
    public void updateHashTables1And2 () {
        for (int count = 0; count < theFile.getHashUpdateSize(); count = count + 1){
            thePresident = new Presidents(theFile.getHashUpdateElements(count), 1);
            switch (thePresident.getPresidentUpdateCode()) {
                case "A":
                    myHashTable.updateInsertTable1(thePresident);
                    myHashTable.updateInsertTable2(thePresident);
                    break;
                case "D":
                    myHashTable.deleteFromHashTable1(thePresident);
                    myHashTable.deleteFromHashTable2(thePresident);
                    break;
            } // end switch
        } // end for loop
    } // end updateHashTables1And2 method
    
    
    /**
     * Displays the statistics to the user.
     * @param None
     * @return None
     */
    public void displayStatistics () {
        System.out.println();
        System.out.println("Hash Table Performance Statistics ");
        System.out.printf("%-12s%-20s%-20s%-20s\n", "Name", "Type", "Table 1", "Table 2");
        myHashTable.displayStatistics();
    } // end displayStatisticsTree1 method
    
    
    /**
     * Builds hash table 3.
     * @param None
     * @return None
     */
    public void buildHashTable3 () {
        for (int count = 0; count < theFile.getHashMainSize(); count = count + 1) {
            thePresident = new Presidents(theFile.getHashMainElements(count));
            myHashTable.buildHashTable3(thePresident);
        } // end for loop
    } // end buildHashTable3 method
    
    
    /**
     * Displays hash table 3 to the user.
     * @param None
     * @return None
     */
    public void displayHashTable3 () {
        myHashTable.displayHashTable3();
    } // end displayHashTable3 method
    
    
    /**
     * Updates hash table 3.
     * @param None
     * @return None
     */
    public void updateHashTable3 () {
        for (int count = 0; count < theFile.getHashUpdateSize(); count = count + 1){
            thePresident = new Presidents(theFile.getHashUpdateElements(count), 1);
            switch (thePresident.getPresidentUpdateCode()) {
                case "A":
                    myHashTable.updateInsertHashTable3(thePresident);
                    break;
                case "D":
                    myHashTable.updateDeleteHashTable3(thePresident);
                    break;
            } // end switch
        } // end for loop
    } // end updateHashTable3 method
} // end UserInterface class