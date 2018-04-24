package project5swaldron;

/**
 * This class contains the hash tables and all methods to control the hash tables.
 * @author Stephen_Waldron
 */
public class HashTable {
    private String[] letterArray = new String [27];
    private int[] valueArray = new int[27];
    private int letterArrayCounter = 0;
    private int valueArrayCounter = 0;
    private TableDataItems[] hashTable1 = new TableDataItems[37];
    private TableDataItems[] hashTable2 = new TableDataItems[23];
    private LinkedList[] hashTable3 = new LinkedList[17];
    private TableDataItems tableData;
    private String[] updateStatisticsType = new String[9];
    private String[] updateStatisticsLastName = new String[9];
    private int[] updateStatisticsCountTree1 = new int[9];
    private int[] updateStatisticsCountTree2 = new int[9];
    private int updateStatisticsTypeCounter = 0;
    private int updateLastNameCounter = 0;
    private int updateStatisticsCountCounterTree1 = 0;
    private int updateStatisticsCountCounterTree2 = 0;
    private Link theLink;
    
    
    
    /**
     * Second constructor for HashTable class used for the chain hash table.
     * @param number Integer
     */
    public HashTable () {
        for (int count = 0; count < hashTable3.length; count = count +1)
            hashTable3[count] = new LinkedList();
    } // end HashTable constructor
    
    
    /**
     * Builds the letter and value arrays based on the table provided by Dr. Roggio.
     * @param input String
     * @return None
     */
    public void buildLetterAndValueArrays (String input) {
        String[] inputSplit = input.split(",");
        letterArray[letterArrayCounter++] = inputSplit[0];
        valueArray[valueArrayCounter++] = Integer.parseInt(inputSplit[1]);
    } // end buildLeterAndValueArrays method
    
    
    /**
     * Displays the letter and value arrays for testing purposes.
     * @param None
     * @return None
     */
    public void displayLetterAndValueArrays () {
        for (int count = 0; count < letterArray.length; count = count + 1)
            System.out.println(letterArray[count] + ", " + valueArray[count]);
    } // end displayLetterAndValueArrays method
    
    
    /**
     * Calculates the hash value for hash table 1 based on the last name passed in from the calling environment
     * and return the value.
     * @param name String
     * @return Integer
     */
    public int getHashValueForTable1 (String name) {
        int hashValue = 0;
        String[] nameSplit = name.split("");
        String character;
        for (int count = 0; count < nameSplit.length; count = count + 1) {
            character = nameSplit[count];
            for (int count1 = 0; count1 < letterArray.length; count1 = count1 + 1) {
                if (character.equalsIgnoreCase(letterArray[count1]))
                    hashValue = hashValue + valueArray[count1];
            } // end for loop
        } // end for loop
        return (hashValue % hashTable1.length);
    } // end getHashValueForTable1 method
    
    
    /**
     * Inserts the items coming into this method from the calling environment into hash table 1 based on the value
     * returned from getHashValueForTable1 method.
     * @param thePresident Presidents
     * @return None
     */
    public void buildHashTable1 (Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        int hashValue = getHashValueForTable1 (tableData.getPresidentData().getPresidentLastName());
        while (hashTable1[hashValue] != null && hashTable1[hashValue].getDeletedData() != -1) {
            hashValue = hashValue + 1;
            if (hashValue == hashTable1.length)
                hashValue = hashValue % hashTable1.length;
        } // end while loop
        hashTable1[hashValue] = tableData;
    } // end buildHashTable1 method
    
    
    /**
     * Calculates the hash value for hash table 2 based on the last name passed in from the calling environment
     * and return the value.
     * @param name String
     * @return Integer
     */
    public int getHashValueForTable2 (String name) {
        int hashValue = 0;
        String[] nameSplit = name.split("");
        String character;
        for (int count = 0; count < nameSplit.length; count = count + 1) {
            character = nameSplit[count];
            for (int count1 = 0; count1 < letterArray.length; count1 = count1 + 1) {
                if (character.equalsIgnoreCase(letterArray[count1]))
                    hashValue = hashValue + valueArray[count1];
            } // end for loop
        } // end for loop
        return (hashValue % hashTable2.length);
    } // end getHashValueForTable2 method
    
    
    /**
     * Inserts the items coming into this method from the calling environment into hash table 2 based on the value
     * returned from getHashValueForTable2 method.
     * @param thePresident Presidents
     * @return None
     */
    public void buildHashTable2 (Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        int hashValue = getHashValueForTable2 (tableData.getPresidentData().getPresidentLastName());
        while (hashTable2[hashValue] != null && hashTable2[hashValue].getDeletedData() != -1) {
            hashValue = hashValue + 1;
            if (hashValue == hashTable2.length)
                hashValue = hashValue % hashTable2.length;
        } // end while loop
        hashTable2[hashValue] = tableData;
    } // end buildHashTable2 method
    
    
    /**
     * Displays hash table 1 based on a single column as called for in updated specs.
     * @param None
     * @return None
     */
    public void displayHashTable1 () {
        System.out.println("\nHash Table 1");
        System.out.printf("%-7s%-20s", "Index", "Name");
        for (int out = 0; out < hashTable1.length; out = out + 1) {
            System.out.printf("\n%2d%5s", out, "");
            if (hashTable1[out] != null) {
                if (hashTable1[out].getDeletedData() == -1)
                    System.out.printf("%-20s", ("*" + hashTable1[out].getPresidentData()
                        .getPresidentLastName()));
                else
                    System.out.printf("%-20s", hashTable1[out].getPresidentData()
                        .getPresidentLastName());
            } // end if not null for out for loop
        } // end out for loop
        System.out.println();
    } // end displayHashTable1 method
    
    
    /**
     * Displays hash table 1 based on columns and rows for actual hash value as called for in original specs.
     * @param None
     * @return None
     */
    public void alternativeDisplayHashTable1 () {
        System.out.println("\nAlternative Display Hash Table 1:");
        System.out.printf("%-7s%-20s%-20s%-20s", "Index", "Name", "Name", "Name");
        for (int out = 0; out < hashTable1.length; out = out + 1) {
            System.out.printf("\n%2d%5s", out, "");
            if (hashTable1[out] != null) {
                for (int in = 0; in < hashTable1.length; in = in + 1) {
                    if (hashTable1[in] != null) {
                        if (getHashValueForTable1(hashTable1[in].getPresidentData()
                        .getPresidentLastName()) == out && hashTable1[in].getDeletedData() == -1)
                            System.out.printf("%-20s", ("*" + hashTable1[in].getPresidentData()
                                .getPresidentLastName()));
                        if (getHashValueForTable1(hashTable1[in].getPresidentData()
                        .getPresidentLastName()) == out && hashTable1[in].getDeletedData() != -1)
                            System.out.printf("%-20s", hashTable1[in].getPresidentData()
                                .getPresidentLastName());
                    } // end if not null for in for loop
                } // end in for loop
            } // end if not null for out for loop
        } // end out for loop
        System.out.println();
    } // end alternativeDisplayHashTable1 method
    
    
    /**
     * Displays hash table 2 based on a single column as called for in updated specs.
     * @param None
     * @return None
     */
    public void displayHashTable2 () {
        System.out.println("\nHash Table 2");
        System.out.printf("%-7s%-20s", "Index", "Name");
        for (int out = 0; out < hashTable2.length; out = out + 1) {
            System.out.printf("\n%2d%5s", out, "");
            if (hashTable2[out] != null) {
                if (hashTable2[out].getDeletedData() == -1)
                    System.out.printf("%-20s", ("*" + hashTable2[out].getPresidentData()
                        .getPresidentLastName()));
                else
                    System.out.printf("%-20s", hashTable2[out].getPresidentData()
                        .getPresidentLastName());
            } // end if not null for out for loop
        } // end out for loop
        System.out.println();
    } // end displayHashTable2 method
    
    
    /**
     * Displays hash table 2 based on columns and rows for actual hash value as called for in original specs.
     * @param None
     * @return None
     */
    public void alternativeDisplayHashTable2 () {
        System.out.println("\nAlternative Display Hash Table 2:");
        System.out.printf("%-7s%-20s%-20s%-20s", "Index", "Name", "Name", "Name");
        for (int out = 0; out < hashTable2.length; out = out + 1) {
            System.out.printf("\n%2d%5s", out, "");
            if (hashTable2[out] != null) {
                for (int in = 0; in < hashTable2.length; in = in + 1) {
                    if (hashTable2[in] != null) {
                        if (getHashValueForTable2(hashTable2[in].getPresidentData()
                        .getPresidentLastName()) == out && hashTable2[in].getDeletedData() == -1)
                            System.out.printf("%-20s", ("*" + hashTable2[in].getPresidentData()
                                .getPresidentLastName()));
                        if (getHashValueForTable2(hashTable2[in].getPresidentData()
                        .getPresidentLastName()) == out && hashTable2[in].getDeletedData() != -1)
                            System.out.printf("%-20s", hashTable2[in].getPresidentData()
                                .getPresidentLastName());
                    } // end if not null for in for loop
                } // end in for loop
            } // end if not null for out for loop
        } // end out for loop
        System.out.println();
    } // end alternativeDisplayHashTable2 method
    
    
    /**
     * Used to delete an item logically from hash table 1.  Also gathers statistics based on how many times it
     * takes to find the item.
     * @param thePresident Presidents
     * @return None
     */
    public void deleteFromHashTable1 (Presidents thePresident) {
        String found = "Not Found";
        int numberOfProbes = 0;
        Presidents temp = thePresident;
        String lastName = temp.getPresidentLastName();
        String updateCode = temp.getPresidentUpdateCode();
        int hashValue = getHashValueForTable1(lastName);
        while (hashTable1[hashValue] != null) {
            numberOfProbes = numberOfProbes + 1;
            if (hashTable1[hashValue].getPresidentData().getPresidentLastName()
                    .equals(lastName) && hashTable1[hashValue].getDeletedData() != -1) {
                found = "Found";
                hashTable1[hashValue].changeDeletedDataValue(-1);
                break;
            } // end if
            hashValue = hashValue + 1;
            if (hashValue == hashTable1.length)
                hashValue = hashValue % hashTable1.length;
        } // end while loop
        if (!found.equals("Found"))
            numberOfProbes = -1;
        updateStatisticsType[updateStatisticsTypeCounter++] = updateCode.trim();
        updateStatisticsLastName[updateLastNameCounter++] = lastName.trim();
        updateStatisticsCountTree1[updateStatisticsCountCounterTree1++] = numberOfProbes;
    } // end deleteFromHashTable1 method
    
    
    /**
     * Used to insert update items for hash table 1.  Also gathers statistics based on how many times it
     * takes to find the item.
     * @param thePresident Presidents
     * @return None
     */
    public void updateInsertTable1(Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        int numberOfProbes = 1;
        int hashValue = getHashValueForTable1 (tableData.getPresidentData().getPresidentLastName());
        while (hashTable1[hashValue] != null && hashTable1[hashValue].getDeletedData() != -1) {
            numberOfProbes = numberOfProbes + 1;
            hashValue = hashValue + 1;
            if (hashValue == hashTable1.length)
                hashValue = hashValue % hashTable1.length;
        } // end while loop
        hashTable1[hashValue] = tableData;
        String lastName = hashTable1[hashValue].getPresidentData().getPresidentLastName();
        String updateCode = hashTable1[hashValue].getPresidentData().getPresidentUpdateCode();
        updateStatisticsType[updateStatisticsTypeCounter++] = updateCode.trim();
        updateStatisticsLastName[updateLastNameCounter++] = lastName.trim();
        updateStatisticsCountTree1[updateStatisticsCountCounterTree1++] = numberOfProbes;
    } // end updateInsertTable1 method

    
    /**
     * Used to delete an item logically from hash table 2.  Also gathers statistics based on how many times it
     * takes to find the item.
     * @param thePresident Presidents
     * @return None
     */
    public void deleteFromHashTable2 (Presidents thePresident) {
        String found = "Not Found";
        int numberOfProbes = 0;
        Presidents temp = thePresident;
        String lastName = temp.getPresidentLastName();
        int hashValue = getHashValueForTable2(lastName);
        while (hashTable2[hashValue] != null) {
            numberOfProbes = numberOfProbes + 1;
            if (hashTable2[hashValue].getPresidentData().getPresidentLastName()
                    .equals(lastName) && hashTable2[hashValue].getDeletedData() != -1) {
                found = "Found";
                hashTable2[hashValue].changeDeletedDataValue(-1);
                break;
            }// end if
            hashValue = hashValue + 1;
            if (hashValue == hashTable2.length)
                hashValue = hashValue % hashTable2.length;
        } // end while loop
        if (!found.equals("Found"))
            numberOfProbes = -1;
        updateStatisticsCountTree2[updateStatisticsCountCounterTree2++] = numberOfProbes;
    } // end deleteFromHashTable2 method
    
    
    /**
     * Used to insert update items for hash table 2.  Also gathers statistics based on how many times it
     * takes to find the item.
     * @param thePresident Presidents
     * @return None
     */
    public void updateInsertTable2 (Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        int numberOfProbes = 1;
        int hashValue = getHashValueForTable2(tableData.getPresidentData().getPresidentLastName());
        while (hashTable2[hashValue] != null && hashTable2[hashValue].getDeletedData() != -1) {
            numberOfProbes = numberOfProbes + 1;
            hashValue = hashValue + 1;
            if (hashValue == hashTable2.length)
                hashValue = hashValue % hashTable2.length;
        } // end while loop
        hashTable2[hashValue] = tableData;
        updateStatisticsCountTree2[updateStatisticsCountCounterTree2++] = numberOfProbes;
    } // end updateInsertTable2 method
    
    
    /**
     * Displays the statistics gathered from the update process adding items into the hash tables and 
     * deleting items from the hash tables.
     * @param None
     * @return None
     */
    public void displayStatistics () {
        for (int count = 0; count < updateStatisticsType.length; count = count + 1) {
            System.out.printf("\n%-12s", updateStatisticsLastName[count]);
            if (updateStatisticsType[count].equals("A"))
                System.out.printf("%-20s", "Add");
            if (updateStatisticsType[count].equals("D"))
                System.out.printf("%-20s", "Delete");
            if (updateStatisticsCountTree1[count] == -1)
                System.out.printf("%-20s", "Not Found");
            if (updateStatisticsCountTree1[count] >= 0)
                System.out.printf("%9d%11s", updateStatisticsCountTree1[count], "");
            if (updateStatisticsCountTree2[count] == -1)
                System.out.printf("%-20s", "Not Found");
            if (updateStatisticsCountTree2[count] >= 0)
                System.out.printf("%9d", updateStatisticsCountTree2[count]);
        } // end for loop
        System.out.println();
    } // end displayStatistics method
    
    
    /**
     * Calculates the hash value for hash table 3 based on the last name passed in from the calling environment
     * and return the value.
     * @param name String
     * @return Integer
     */
    public int getHashValueForTable3 (String name) {
        int hashValue = 0;
        String[] nameSplit = name.split("");
        String character;
        for (int count = 0; count < nameSplit.length; count = count + 1) {
            character = nameSplit[count];
            for (int count1 = 0; count1 < letterArray.length; count1 = count1 + 1) {
                if (character.equalsIgnoreCase(letterArray[count1])) {
                    hashValue = hashValue + valueArray[count1];
                    break;
                } // end if
            } // end for loop
        } // end for loop
        return (hashValue % hashTable3.length);
    } // end getHashValueForTable3 method
    
    
    /**
     * Inserts the items coming into this method from the calling environment into hash table 3 based on the value
     * returned from getHashValueForTable3 method.
     * @param thePresident Presidents
     * @return None
     */
    public void buildHashTable3 (Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        theLink = new Link(tableData);
        int hashValue = getHashValueForTable3 (theLink.getLinkData().getPresidentData()
                .getPresidentLastName());
        hashTable3[hashValue].insert(theLink);
    } // end buildHashTable3 method
    
    
    /**
     * Displays the chained hash table 3 to the user with columns and rows.
     * @param None
     * @return None
     */
    public void displayHashTable3 () {
        System.out.println("\nHash Table 3");
        System.out.printf("%-7s%-20s%-20s%-20s%-20s", "Index", "Name", "Name", "Name", "Name");
        for (int out = 0; out < hashTable3.length; out = out + 1) {
            System.out.printf("\n%2d%5s", out, "");
            if (!hashTable3[out].isLinkedListEmpty()) {
                Link current = hashTable3[out].getFirst();
                while (current != null) {
                    if (current.getLinkData().getDeletedData() == -1)
                        System.out.printf("%-20s", ("*" + current.getLinkData().getPresidentData()
                        .getPresidentLastName()));
                    else
                        System.out.printf("%-20s", current.getLinkData().getPresidentData()
                        .getPresidentLastName());
                    current = current.getNextLink();
                } // end current not equal null while loop
            } // end if for out for loop
        } // end for loop
        System.out.println();
    } // end displayHashTable3 method
    
    
    /**
     * Used to update hash table 3 with updates to the chains.
     * @param thePresident Presidents
     * @return None
     */
    public void updateInsertHashTable3 (Presidents thePresident) {
        tableData = new TableDataItems(thePresident);
        theLink = new Link(tableData);
        int hashValue = getHashValueForTable3 (theLink.getLinkData().getPresidentData()
                .getPresidentLastName());
        hashTable3[hashValue].insert(theLink);
    } // end updateInsertHashTable3 method
    
    /**
     * Used to delete an item logically from hash table 3 with chain.
     * @param thePresident Presidents
     * @return None
     */
    public void updateDeleteHashTable3 (Presidents thePresident) {
        Presidents temp = thePresident;
        String lastName = temp.getPresidentLastName();
        int hashValue = getHashValueForTable3(lastName);
        Link current = hashTable3[hashValue].getFirst();
        while (current != null) {
            if (current.getLinkData().getPresidentData().getPresidentLastName()
                    .equals(lastName))
                current.getLinkData().changeDeletedDataValue(-1);
            current = current.getNextLink();
        } // end current not equal null while loop
    } // end updateDeleteHashTable3 method
} // end HashTable class