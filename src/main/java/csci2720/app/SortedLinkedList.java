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
            curr = curr.next;
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

            while (curr.next != null && curr.next.info.compareTo(item) < 0) {
                curr = curr.next;
            } // while

            if (curr.next != null && curr.next.info.compareTo(item) == 0) {
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
            System.out.println("You cannot delete from an empty list");
        } // if

        NodeType sentinel = new NodeType(null);
        sentinel.next = head;

        NodeType curr = sentinel;

        while (curr.next != null && curr.next.info.compareTo(item) != 0) {
            curr = curr.next;
        } // while

        if (curr.next == null) {
            System.out.println("The item is not present in the list");
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
        NodeType curr = this.head;
        int pos = 1;

        while (curr != null) {
            if (curr.info.compareTo(item) == 0) {
                System.out.println("The item is present at index " + pos);
                return pos;
            } // if

            curr = curr.next;
            pos++;
        } // while

        System.out.println("Item is not present in the list.");
        return -1;
    } // searchItem

    /**
     * Prints the list
     */
    public void printList() {
        if (this.head == null) {
            System.out.print(" ");
        } // if

        NodeType current = this.head;
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        } // while
        System.out.println("");
    } // printList

    private boolean printMess = true;

    /**
     * Handles preventing messages being printed
     */
    public void printMessages(boolean shouldPrint) {
        this.printMess = shouldPrint;
    } // printMessages

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
    public void intersection(SortedLinkedList list2) {
        NodeType head1 = this.head;
        NodeType head2 = list2.head;

        SortedLinkedList intersectionList = new SortedLinkedList();

        // transverse both lists until one of them reaches the end
        while (head1 != null && head2 != null) {
            int comparison = head1.info.compareTo(head2.info);

            // if nodes are equal, adds the value to the intersection list
            if (comparison == 0) {
                intersectionList.insertItem(head1.info);
                head1 = head1.next;
                head2 = head2.next;
            } else if (comparison < 0) { // if head1's value is smaller, moves head1 to next node
                head1 = head1.next;
            } else { // if head2's value is smaller, moves head2 to next node
                head2 = head2.next;
            } // if
        } // while

        intersectionList.printList();
    } // intersection

} // SortedLinkedList
