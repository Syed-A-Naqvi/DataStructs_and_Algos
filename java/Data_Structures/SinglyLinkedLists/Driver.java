package SinglyLinkedLists;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {
        
        // SinglyLinkedList list = new SinglyLinkedList();

        // list.appendNode(10);
        // list.appendNode(20);
        // System.out.println();

        // list.prependNode(9);
        // list.prependNode(8);
        // System.out.println();

        // list.insertNode(5, 30);
        // list.insertNode(1, 7);
        // list.insertNode(6, 25);
        // list.insertNode(6, 23);
        // list.insertNode(5,40);
        // list.insertNode(6,40);
        // list.insertNode(7,40);
        // list.insertNode(8,40);
        // System.out.println();
        
        // list.removeFirst();
        // list.removeLast();
        // list.removeNodePosition(4);
        // list.removeNodePosition(90);
        // list.removeNodeElement(40);
        // System.out.println();

        // System.out.println("searchKey: " + 2 + "\nfound: " + list.searchNode(2));
        // System.out.println();

        // list.reverseList();
        // System.out.println();

        // System.out.println("The middle element is " + list.getMiddleNode().getData() + ".");
        // System.out.println();

        // System.out.println("The 1st node from the end of the list is " + list.nthNodeFromEnd(1).getData() + ".");
        // System.out.println();

        SinglyLinkedList sortedList1 = new SinglyLinkedList();
        sortedList1.appendNode(0);
        sortedList1.appendNode(1);
        sortedList1.appendNode(2);
        sortedList1.appendNode(2);
        sortedList1.appendNode(6);
        sortedList1.appendNode(10);
        sortedList1.appendNode(15);

        sortedList1.removeDuplicates();
        // sortedList.insertInSortedList(3);

        // SinglyLinkedList single = new SinglyLinkedList(10);
        // single.removeNodeElement(10);

        // SinglyLinkedList loop = new SinglyLinkedList(0);
        // loop.appendNode(10);
        // loop.appendNode(20);
        // loop.appendNode(30);
        // loop.appendNode(40);
        // loop.appendNode(50);
        // loop.appendNode(60);
        // loop.appendNode(70);

        // Node middleNode = loop.getHead();
        // for (int i = 1; i < 5; i++) {
        //     middleNode = middleNode.getNext();
        // }

        // System.out.println(middleNode.getData());
        
        // Node lastNode = loop.getHead();
        // while (lastNode.getNext() != null) {
        //     lastNode = lastNode.getNext();
        // }

        // lastNode.setNext(middleNode);
        // System.out.println(loop.detectLoop());
        // loop.removeLoop();
        // System.out.println(loop.detectLoop());

        SinglyLinkedList sortedList2 = new SinglyLinkedList();
        sortedList2.appendNode(3);
        sortedList2.appendNode(4);
        sortedList2.appendNode(5);
        sortedList2.appendNode(8);
        sortedList2.appendNode(9);
        sortedList2.appendNode(11);
        sortedList2.appendNode(18);

        System.out.println();
        System.out.println();
        sortedList1.display();
        System.out.println();
        sortedList2.display();
        System.out.println();

        SinglyLinkedList mergedList = new SinglyLinkedList();
        mergedList.setHead(SinglyLinkedList.mergeSortedLists(sortedList1, sortedList2));
        mergedList.display();
 
    }
}