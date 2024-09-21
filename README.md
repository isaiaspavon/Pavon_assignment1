# Pavon_assignment1

Project 1 for Data Structures at UGA
> Isaias Pavon
> ip13488@uga.edu

To build the Project:

    $ mvn package

To compile the project:

    $ mvn compile

To run the project:

    $ mvn exec:java -Dexec.mainClass="csci2720.app.LinkedListDriver" -Dexec.args="src/main/java/csci2720/app/input.txt"

### Time Complexities:

- **`insertItem`**: \( O(n) \) - Inserts an item while maintaining sorted order.
- **`deleteAltNodes`**: \( O(n) \) - Deletes every alternate node in the list.
- **`intersection`**: \( O(n + m) \) - Finds the intersection of two sorted linked lists.
