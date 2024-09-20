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
        NodeType curr = head;

        while (curr != null) {
            curr = curr.next();
            length++;
        } // while

        return length;
    } // getLength

    /**
     * Item should be inserted to the linked list maintaining the sorted order.
     * @param item The item to be inserted into the linked list
     */
    public void insertItem(ItemType item) {
        NodeType insertedNode = new NodeType(item);
        //insertedNode.info = item;
        insertedNode.next = null;

        if (head == null || head.info.compareTo(item) > 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else {
            NodeType curr = head;

            while (curr != null && curr.next.info.compareTo(item) < 0) {
                curr = curr.next;
            } // while

            if (curr != null && curr.next.info.compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            } // if

            insertedNode.next = curr.next;
            curr.next = insertedNode;
        } // if
    } // insertItem

    /**
     * Deletes an item from the list if it exists.
     * @param item The item to be deleted from the list
     */
    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("Sorry. You cannot delete from an empty list");
        } // if

        NodeType sentinel = new NodeType();
        sentinel.next = head;

        NodeType curr = sentinel;

        while (curr.next != null && curr.next.info.compareTo(item) != 0) {
            curr = curr.next;
        } // while

        if (curr.next == null) {
            System.out.println("Sorry. The item is not in the list");
        } else {
            curr.next = curr.next.next;
        } // if

        head = sentinel.next;
    } // deleteItem

    /**
     * Searches for an item in the linked list and returns its position.
     * @param item The item to search for in the linked list.
     * @return The 1-based position of the item in the list, or -1 if not found.
     */
    public int searchItem(ItemType item) {
        NodeType curr = head;
        int pos = 1;

        while (curr != null) {
            if (curr.info.compareTo(item) == 0) {
                return pos;
            } // if

            curr = curr.next;
            pos++;
        } // while

        return -1;
    } // searchItem

    /* -------------------------------------------------------------------------*/
    /* Next three methods below must be implemented to follow the sample output */
    /*            They must include the time complexity as well
    /* -------------------------------------------------------------------------*/

    /**
     * Merges another sorted list into the current list.
     * @param listToMerge The sorted list to merge into current list.
     */
    public void mergeList(SortedLinkedList listToMerge) {
        NodeType nodeToMerge = listToMerge.head;

        while (nodeToMerge != null) {
            ItemType newItem = nodeToMerge.info;
            if (searchItem(newItem) == -1) {
                insertItem(newItem);
            } // if

            nodeToMerge = nodeToMerge.next;
        } // while
    } // mergeList

    /**
     * Deletes every alternate node in the list.
     * If the list is empty or contains one node the method does nothing.
     */
    public void deleteAltNodes() {
        if (head == null || head.next == null) {
            return;
        } // if

        NodeType curr = head;
        while (curr != null && curr.next != null) {
            curr.next = curr.next.next;
            curr = curr.next;
        } // while
    } // deleteAltNodes

    /**
     * Returns a new list containing the intersection of the current and another list
     *
     * @param listToCompare The list to compare and find common elements
     * @return a new sorted list
     */
    public SortedLinkedList intersection(SortedLinkedList listToCompare) {
        SortedLinkedList intersected = new SortedLinkedList();
        NodeType curr = head;

        while (curr != null) {
            if (listToCompare.searchItem(curr.info) != -1) {
                intersected.insertItem(curr.info);
            } // if

            curr = curr.next;
        } // while

        return intersected;
    } // intersection

} // SortedLinkedList
