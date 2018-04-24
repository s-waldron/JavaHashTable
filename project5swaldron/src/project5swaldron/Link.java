package project5swaldron;

/**
 * Data container class for the Linked List.
 * @author Stephen_Waldron
 */
public class Link {
    private TableDataItems theData;
    private Link next;
    
    /**
     * Link constructor.
     * @param data TableDataItems
     */
    public Link (TableDataItems data) {
        theData = data;
    } // end Link constructor
    
    
    /**
     * Allows the nodes to keep track of the next node in the linked list.
     * @param nextLink Link
     * @return None
     */
    public void setNextPointer (Link nextLink) {
        next = nextLink;
    } // end setNextPointer method
    
    
    /**
     * Gets the next link in the linked list address and returns it to the calling environment.
     * @param None
     * @return Link
     */
    public Link getNextLink () {
        return next;
    } // end getNextLink method
    
    
    /**
     * Gets the link data and returns it to the calling environment.
     * @param None
     * @return TableDataItems
     */
    public TableDataItems getLinkData () {
        return theData;
    } // end getLinkData method
} // end Link class