package csci2720.app;

/**
 *
 */
public class SortedLinkedList {

    private NodeType head;

    /**
     * Initialize a sorted linked list object
     */
    public SortedLinkedList() {
        head = null;
    } // SortedLinkedList

    /**
     * Return the length of the linked list.
     * Must loop over the list and get the number of nodes in the list
     */
    public int getLength() {
        int length = 0;
        NodeType temp = head;

        while (temp != null) {
            temp = temp.next();
            length++;
        } // while

        return length;
    } // getLength

    /**
     * Item should be inserted to the linked list maintaining the sorted order
     */
    public void insertItem(ItemType item) {
        // If trying to insert duplicate item
        if (item == value) {
            System.out.println("Sorry. You cannot insert the duplicate item");
        } // if

        // If an empty list
        if () {

        } // if


    } // insertItem

    /**
     *
     */
    public void deleteItem(ItemType item) {

    } // deleteItem

    /**
     *
     *
     */
    public int searchItem(ItemType item) {

    } // searchItem

    /* -------------------------------------------------------------------------*/
    /* Next three methods below must be implemented to follow the sample output */
    /*            They must include the time complexity as well
    /* -------------------------------------------------------------------------*/

    /**
     *
     */
    public void mergeList() {

    } // mergeList

    /**
     *
     */
    public void deleteAltNodes() {

    } // deleteAltNodes

    /**
     *
     */
    public void intersection() {

    } // intersection

} // SortedLinkedList
