package project5swaldron;
import java.io.*;
/**
 * User class for Project 5 for Data Structures using OOP.
 * @author Stephen_Waldron
 */
public class Main {

    /**
     * This is the main method.
     * @param args the command line arguments
     * @return None
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        ui.readMainFile();
        ui.readUpdateFile();
        ui.readHashTableFile();
        ui.buildHashTableArrays();
        ui.buildHashTable1();
        ui.buildHashTable2();
        ui.displayHashTable1();
        ui.displayHashTable2();
        System.out.println();
        System.out.println("After Updating HashTable1:");
        ui.updateHashTables1And2();
        ui.displayHashTable1();
        System.out.println();
        System.out.println("After Updating HashTable2:");
        ui.displayHashTable2();
        ui.displayStatistics();
        ui.buildHashTable3();
        ui.displayHashTable3();
        System.out.println();
        System.out.println("After Updating HashTable3:");
        ui.updateHashTable3();
        ui.displayHashTable3();
    } // end main method
} // end Main class