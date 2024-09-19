package csci2720.app;

/**
 *
 */
public class ItemType {

    private int value;

    /**
     * Compares the value of item with the current object's value and returns -1
     * if value of the current object is less than value in item, 0 if equal and
     * 1 if greater.
     */
    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value == item.value) {
            return 0;
        } else {
            return 1;
        }
    } // compareTo

    /**
     * Returns the value instance variable
     */
    int getValue() {
        return this.value;
    } // getValue

    /**
     * Initializes the data member by variable num
     */
    public void initialize(int num) {
        this.value = num;
    } // initialize
} // ItemType
