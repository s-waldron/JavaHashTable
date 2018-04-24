package project5swaldron;
import java.io.*;
/**
 * This class is for file reading and storing of records until used in the
 * program.
 * @author Stephen_Waldron
 */
public class FileInterface {
    private String[] hashMain = new String[16];
    private String[] hashUpdate = new String[9];
    private String[] hashTable = new String[27];
    private int countHashMain = 0;
    private int countHashUpdate = 0;
    private int countHashTable = 0;
    
    
    /**
     * Reads the main hash table file.
     * @param  None
     * @return None
     * @throws IOException 
     */
    public void readMainFile () throws IOException {
        String inputString;
        FileReader fr = new FileReader("HashHeap.txt");
        BufferedReader br = new BufferedReader(fr);
        inputString = br.readLine();
        while (inputString != null) {
            hashMain[countHashMain] = inputString;
            countHashMain = countHashMain + 1;
            inputString = br.readLine();
        } // end while loop
        fr.close();
        br.close();
    } // end readMainFile method
    
    
    /**
     * Reads the hash table update file.
     * @param None
     * @return None
     * @throws IOException 
     */
    public void readUpdateFile () throws IOException {
        String inputString;
        FileReader fr = new FileReader("HashHeapUpdate.txt");
        BufferedReader br = new BufferedReader(fr);
        inputString = br.readLine();
        while (inputString != null) {
            hashUpdate[countHashUpdate] = inputString;
            countHashUpdate = countHashUpdate + 1;
            inputString = br.readLine();
        } // end while loop
        fr.close();
        br.close();
    } // end readUpdateFile method
    
    
    /**
     * Reads the hash table file for hash table values.
     * @param None
     * @return None
     * @throws IOException 
     */
    public void readHashTableFile () throws IOException {
        String inputString;
        FileReader fr = new FileReader("HashValues.txt");
        BufferedReader br = new BufferedReader(fr);
        inputString = br.readLine();
        while (inputString != null) {
            hashTable[countHashTable] = inputString;
            countHashTable = countHashTable + 1;
            inputString = br.readLine();
        } // end while loop
        fr.close();
        br.close();
    } // end readHashTableFile method
    
    
    /**
     * Gets the array size of the main hash table file array.
     * @param None
     * @return Integer
     */
    public int getHashMainSize () {
        return hashMain.length;
    } // end getHashMainSize method
    
    
    /**
     * Gets the elements from the main hash table file array.
     * @param count Integer
     * @return String
     */
    public String getHashMainElements (int count) {
        return hashMain[count];
    } // end getHashMainElements method
    
    
    /**
     * Gets the size of the hash update file array.
     * @param None
     * @return Integer
     */
    public int getHashUpdateSize () {
        return hashUpdate.length;
    } // end getHashUpdateSize method
    
    
    /**
     * Gets the elements from the hash update array and returns them to the
     * calling environment.
     * @param count Integer
     * @return String
     */
    public String getHashUpdateElements (int count) {
        return hashUpdate[count];
    } // end getHashUpdateElements method
    
    
    /**
     * Gets the size of the hash table array and returns it to the calling
     * environment.
     * @param None
     * @return Integer
     */
    public int getHashTableSize () {
        return hashTable.length;
    } // end getHashTableSize method
    
    
    /**
     * Gets the elements of the hash table array and return them to the calling
     * environment.
     * @param count Integer
     * @return String
     */
    public String getHashTableElements (int count) {
        return hashTable[count];
    } // end getHashTableElements method
    
    
    /**
     * Displays the hash main array for testing purposes.
     * @param None
     * @return None
     */
    public void displayHashMain () {
        for (int count = 0; count < getHashMainSize(); count = count + 1) 
            System.out.println(hashMain[count]);
    } // end displayHashMain method
    
    
    /**
     * Displays the hash update array for testing purposes.
     * @param None
     * @return None
     */
    public void displayHashUpdate () {
        for (int count = 0; count < getHashUpdateSize(); count = count + 1)
            System.out.println(hashUpdate[count]);
    } // end displayHashUpdate method
    
    
    /**
     * Displays the hash table values array for testing purposes.
     * @param None
     * @return None
     */
    public void displayHashTable () {
        for (int count = 0; count < getHashTableSize(); count = count + 1)
            System.out.println(hashTable[count]);
    } // end displayHashTable method
} // end FileInterface class