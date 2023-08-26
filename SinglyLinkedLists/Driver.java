package SinglyLinkedLists;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {
        
        SinglyLinkedList list = new SinglyLinkedList();

        list.appendNode(10);
        list.appendNode(20);
        System.out.println();

        list.prependNode(9);
        list.prependNode(8);
        System.out.println();

        list.insertNode(5, 30);
        list.insertNode(1, 7);
        list.insertNode(6, 25);
        list.insertNode(6, 23);
        list.insertNode(5,40);
        list.insertNode(6,40);
        list.insertNode(7,40);
        list.insertNode(8,40);
        System.out.println();
        
        list.removeFirst();
        list.removeLast();
        list.removeNodePosition(4);
        list.removeNodePosition(90);
        list.removeNodeElement(40);
        System.out.println();

        System.out.println("searchKey: " + 2 + "\nfound: " + list.searchNode(2));
        System.out.println();

        list.reverseList();
        System.out.println();

        System.out.println("The middle element is " + list.getMiddleNode().getData() + ".");
        System.out.println();

        System.out.println("The 1st node from the end of the list is " + list.nthNodeFromEnd(1).getData() + ".");
        System.out.println();

        SinglyLinkedList sortedList = new SinglyLinkedList();
        sortedList.appendNode(0);
        sortedList.appendNode(1);
        sortedList.appendNode(2);
        sortedList.appendNode(2);
        sortedList.appendNode(6);
        sortedList.appendNode(10);
        sortedList.appendNode(15);

        sortedList.removeDuplicates();
        sortedList.insertInSortedList(3);

        SinglyLinkedList single = new SinglyLinkedList(10);
        single.removeNodeElement(10);

 
    }
}