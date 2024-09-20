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

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: Unable to open the file " + filePath);
            return;
        } // try

    } // main

} // LinkedListDriver
