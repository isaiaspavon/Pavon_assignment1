package csci2720.app;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 *
 */
public class LinkedListDriver {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error in Format: java sortedLinkedList.LinkedListDriver <file>");
            return;
        } // if

        String filePath = args[0];
        SortedLinkedList list = new SortedLinkedList();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                ItemType item = new ItemType();
                item.initialize(num);

                list.insertItem(item);
            } // while
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: Unable to open the file " + filePath);
            fnfe.printStackTrace();
            return;
        } // try

        System.out.print("Commands:\n" +
                         "(i) - Insert value\n" +
                         "(d) - Delete value\n" +
                         "(s) - Search value\n" +
                         "(a) - Delete alternate nodes\n" +
                         "(m) - Merge lists\n" +
                         "(t) - Find intersection\n" +
                         "(p) - Print list\n" +
                         "(l) - Print length\n" +
                         "(q) - Quit program\n\n");

        boolean quit = false;

        while (!quit) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a command: ");
            String command = input.nextLine();

            switch (command) {
            case "i":
                System.out.print("Enter a number to insert: ");
                int intInserted = input.nextInt();
                System.out.print("Original List: ");
                list.printList();
                ItemType itemInserted = new ItemType();
                itemInserted.initialize(intInserted);
                list.insertItem(itemInserted);
                System.out.print("New List: ");
                list.printList();
                break;
            case "d":
                System.out.print("Enter a number to delete: ");
                int deleteInt = input.nextInt();
                System.out.print("Original List: ");
                list.printList();
                ItemType deleteItem = new ItemType();
                deleteItem.initialize(deleteInt);
                list.deleteItem(deleteItem);
                System.out.print("New List: ");
                list.printList();
                break;
            case "s":
                System.out.print("Enter a number to search: ");
                int numSearched = input.nextInt();
                input.nextLine();
                System.out.print("Orignal list : ");
                list.printList();
                ItemType itemSearched = new ItemType();
                itemSearched.initialize(numSearched);
                list.searchItem(itemSearched);
                break;
            case "a":
                System.out.print("Orignal list : ");
                list.printList();
                list.deleteAltNodes();
                System.out.print("New List: ");
                list.printList();
                break;
            case "t":
                System.out.print("Enter the length of the new list: ");
                int lengthList = input.nextInt();
                input.nextLine();

                System.out.print("Enter the numbers ");
                String newList = input.nextLine();
                String [] numsInList2 = newList.split("\\s+");

                SortedLinkedList list2 = new SortedLinkedList();
                for (int i = 0; i < lengthList; i++) {
                    int intForList2 = Integer.parseInt(numsInList2[i]);
                    ItemType itemForList2 = new ItemType();
                    itemForList2.initialize(intForList2);
                    list2.insertItem(itemForList2);
                } // for

                System.out.print("List 1: ");
                list.printList();
                System.out.print("List 2: ");
                list2.printList();
                System.out.print("Intersection of lists: ");
                list.intersection(list2);
                break;
            case "m":
                System.out.print("Enter the length of the new list: ");
                int lenOfList = input.nextInt();
                input.nextLine();

                System.out.print("Enter the numbers ");
                String inputList = input.nextLine();
                String [] numsInList = inputList.split("\\s+");

                SortedLinkedList newMergeList = new SortedLinkedList();
                newMergeList.printMessages(false);

                for (int i = 0; i < lenOfList; i++) {
                        int num = Integer.parseInt(numsInList[i]);
                        ItemType newItem = new ItemType();
                        newItem.initialize(num);
                        newMergeList.insertItem(newItem);
                } // for

                list.printMessages(false);

                System.out.print("List 1: ");
                list.printList();
                System.out.print("List 2: ");
                newMergeList.printList();
                list.mergeList(newMergeList);
                System.out.print("Merged list: ");
                list.printList();

                list.printMessages(true);
                break;
            case "p":
                System.out.print("The list is: ");
                list.printList();
                break;

            case "l":
                int length = list.getLength();
                System.out.println("The length of the list is "+ length);
                break;
            case "q":
                System.out.println("Exiting...");
                quit = true;
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command, try again");
                break;
            } // switch
        } // while

    } // main

} // LinkedListDriver
