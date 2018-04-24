package project5swaldron;

/**
 * This class contains all the methods needed to work with a singly linked list.
 * @author Stephen_Waldron
 */
public class LinkedList {
    private Link first;
    private Link newLink;
    
    
    /**
     * Constructor for the linked list.
     * @param None
     */
    public LinkedList () {
        first = null;
    } // end LinkedList constructor
    
    
    /**
     * Checks to see if the list is empty and returns the truth value to the calling environment.
     * @param None
     * @return True or False
     */
    public boolean isLinkedListEmpty () {
        return (first == null);
    } // end isLinkedListEmpty method
    
    
    /**
     * Inserts a new link into the singly linked list.
     * @param data Link
     * @return None
     */
    public void insert (Link data) {
        if (isLinkedListEmpty()) {
            first = data;
        } // end if
        else {
            Link parent = null;
            Link current = first;
            while (current != null) {
                parent = current;
                current = current.getNextLink();
            } // end while loop
            parent.setNextPointer(data);
        }// end else
    } // end insert method
    
    
    /**
     * Gets and returns the data from the link in the list.
     * @param theLink Link
     * @return TableDataItems
     */
    public TableDataItems getLinkData (Link theLink) {
        return theLink.getLinkData();
    } // end getLinkData method
    
    
    /**
     * Gets the first node in the singly linked list and returns it to the calling environment.
     * @param None
     * @return Link
     */
    public Link getFirst () {
        return first;
    } // end getFirst method
} // end LinkedList class