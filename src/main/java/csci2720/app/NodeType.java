package csci2720.app;

/**
 * Class NodeType to create nodes in the linked list
 */
public class NodeType {

    public ItemType info;
    public NodeType next;

    /**
     * Constructor for the NodeType class.
     * Initializes the next and info variables.
     */
    public NodeType (ItemType item) {
        this.info = item;
        this.next = null;
    } // NodeType

} // NodeType
