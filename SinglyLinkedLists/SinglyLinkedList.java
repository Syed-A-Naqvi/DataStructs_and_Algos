package SinglyLinkedLists;

/**
 * Node
 */
class Node {

    private int data; //generic data field
    private Node next; //pointer to next node in a single linked list

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}

/**
 * LinkedList
 */
public class SinglyLinkedList {

    private Node head;

    //getter
    public Node getHead() {
        return head;
    }

    // setter
    public void setHead(Node head) {
        this.head = head;
    }

    //constructors
    public SinglyLinkedList(){
        this.head = null;
    }
    public SinglyLinkedList(int data){
        
        Node node = new Node(data);
        this.head = node;

    }

    //adding nodes
    public void appendNode(int data) {

        Node node = new Node(data);
        
        if(this.head == null){
            this.head = node;
        }
        else{
            Node currentNode = this.head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }

    }
    public void prependNode(int data) {
        
        Node node = new Node(data);

        if (this.head == null){
            this.head = node;
        }
        else{
            node.setNext(this.head);
            this.head = node;
        }

    }
    public void insertNode(int position, int data) {
        
        if(position == 1){
            this.prependNode(data);
        }
        else if (position == this.length()+1 || this.head == null){
            this.appendNode(data);
        }
        else if (position < 1 || position > this.length()+1){
            System.out.printf("Please enter a valid position for node insertion. [1 - %d]", this.length()+1);
        }
        else{
            Node previousNode = this.head;
            int index = 1;
            while(index+1 != position){
                previousNode = previousNode.getNext();
                index++;
            }
            Node newNode = new Node(data);
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }

    }
    //insert a node in a sorted linked list
    public void insertInSortedList(int data) {
        
        Node node = new Node(data);
        
        Node currentNode = this.head;
        Node previousNode = null;

        if(this.head == null){
            this.head = node;
        }
        else if(currentNode.getData() > data){
            node.setNext(currentNode);
            this.head = node;
        }
        else {
            while (currentNode != null){
                if(currentNode.getData() < data){
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
                else{
                    break;
                }
            }
            previousNode.setNext(node);
            node.setNext(currentNode);
        }

    }

    //removing nodes
    public Node removeFirst() {
        
        if(this.head == null){
            System.out.println("Nothing to delete. exitting...");
            return null;
        }
        else{
            Node tempNode = this.head;
            this.head = this.head.getNext();
            tempNode.setNext(null);
            System.out.println("First node removed successfully.");
            return tempNode;
        }

    }
    public Node removeLast() {
        
        if(this.head == null){
            System.out.println("Nothing to delete. exitting...");
            return null;
        }
        else if(this.head.getNext() == null){
            return this.removeFirst();
        }
        else{
            Node currentNode = this.head;
            while(currentNode.getNext().getNext() != null){
                currentNode = currentNode.getNext();
            }
            Node tempNode = currentNode.getNext();
            currentNode.setNext(null);
            System.out.println("Last node removed successfully.");
            return tempNode;
        }        
    }
    public Node removeNodePosition(int position) {

        if(position == 1){
            return removeFirst();
        }
        else if(position == length()){
            return removeLast();
        }
        else if( position > 1 && position < length()){
            
            int index = 1;
            Node currentNode = this.head;

            while( (index + 1) != position){
                currentNode = currentNode.getNext();
                index++;
            }

            Node temp = currentNode.getNext();
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("Node at position " + position + " removed successfully.");
            return temp;
        }
        else{
            System.out.println("Position " + position + " out of bounds. Nothing removed.");
            return null;
        }
        
    }
    public void removeNodeElement(int searchKey) {
        Node currentNode = this.head;
        Node previousNode = null;
        int removedCount = 0;

        if(this.head == null){
            System.out.println("List empty. Exiting...");
        }
        else if (this.head.getData() == searchKey){
            currentNode = currentNode.getNext();
            this.head = currentNode;
            removedCount++;
        }
        else{
            while(currentNode != null){
                if(currentNode.getData() != searchKey){
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
                else{
                    previousNode.setNext(currentNode.getNext());
                    currentNode = currentNode.getNext();
                    removedCount++;
                }
            }
        }

        System.out.println("Removed " + removedCount + " nodes matching the searchkey " + searchKey + ".");

    }

    //searching list for elements
    public boolean searchNode(int searchKey) {
        Node currentNode = this.head;
        while(currentNode != null){
            if(currentNode.getData() == searchKey){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    } 

    //print list
    public void display() {
        
        Node currentNode = this.head;

        while(currentNode != null){
            System.out.print(currentNode.getData() + "-->");
            currentNode = currentNode.getNext();
        }
        System.out.print("null\n");
        System.out.println("length = " + this.length());

    }

    //get length of list
    public int length() {
        
        Node currentNode = this.head;

        int counter = 0;

        while(currentNode != null){
            counter++;
            currentNode = currentNode.getNext();
        }
        
        return counter;
    }

    //reverse list
    public void reverseList() {
        
        System.out.println("Original list: ");
        this.display();

        if (this.head == null){
            System.out.println("Empty list, nothing to reverse.");
            return;
        }

        //-----------------------------------------------------------METHOD 1-----------------------------------------------------------
        //this method is not the best as it first creates a new array of the same length as the linked list O(n) space complexity 
        //then it pupulates the array by traversing the linked list O(n) time complexity
        //it then traverses the array in reverse reassigning each next node pointer, again O(n) time

        // Node currNode = this.head;
        // Node[] nodeArray = new Node[this.length()];

        // for (int i = 0; i < nodeArray.length; i++) {
        //     nodeArray[i] = currNode;
        //     currNode = currNode.getNext();
        // }

        // this.head = nodeArray[this.length()-1];
        // for (int i = nodeArray.length-1; i > 0; i--) {
        //     nodeArray[i].setNext(nodeArray[i-1]);
        // }
        // nodeArray[0].setNext(null);

        //-----------------------------------------------------------METHOD 2-----------------------------------------------------------
        //This is a far better and simpler approach. Only three pointers are used to reverse the linked list resulting in O(3) space complexity and a single
        //list traversal requiring O(n) time complexity
        //There are 3 node pointers: previous, current and next and a while loop that executes until current = null meaning the list has been fully traversed.
        //each iteration, the next pointer is moved ahead, the current pointer sets the current node's next pointer to the node pointed to by the previous node pointer.
        //the previous node pointer is set equal to the current node and the current node pointer is set equal to the next node pointer.
        Node currNode = this.head;
        Node prevNode = null;
        Node nextNode = null;
        while (currNode != null) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }
        this.head = prevNode;

        System.out.println("Reversed List:");
        this.display();

    }

    //find the middle node
    public Node getMiddleNode() {
        
        if(this.head == null){
            System.out.println("Empty list!");
            return null;
        }
        else if (this.head.getNext() == null){
            return this.head;
        }

        // int middle = this.length()/2;
        // Node currNode = this.head;

        // for (int i = 0  ; i < middle; i++) {
        //     currNode = currNode.getNext();
        // }

        // return currNode;

        //this is another middle node retrieving algorithm that uses less time complexity
        Node slowPtr = this.head;
        Node fastPtr = this.head;

        while (fastPtr != null && fastPtr.getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        return slowPtr;

    }

    //find nth node from the end of the list
    public Node nthNodeFromEnd(int n) {
        
        int count = 1;
        Node lastNode = this.head;
        Node nthNode = this.head;

        while (lastNode.getNext() != null){
            if(count >= n){
                nthNode = nthNode.getNext();
            }
            lastNode = lastNode.getNext();
            count++;
        }

        return nthNode;

    }

    //remove duplicates from sorted linked list
    public void removeDuplicates() {

        System.out.println("\n Original List: ");
        this.display();

        Node currentNode = this.head;

        while (currentNode != null && currentNode.getNext() != null){

            if(currentNode.getData() == currentNode.getNext().getData()){
                currentNode.setNext(currentNode.getNext().getNext());
            }
            else{
                currentNode = currentNode.getNext();
            }

        }

        System.out.println("Duplicates Removed:");
        this.display();
        
    }

    //Detect a loop in a linked list
    public boolean detectLoop() {
        
        Node slowPtr = this.head;
        Node fastPtr = this.head;

        while(true){

            if(fastPtr == null || fastPtr.getNext() == null){
                return false;
            }

            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();

            if(fastPtr == slowPtr){
                return true;
            }

        }

    }

    //Get node at start of loop
    public Node getStartOfLoop() {
        
        Node slowPtr = this.head;
        Node fastPtr = this.head;

        while(true){

            if(fastPtr == null || fastPtr.getNext() == null){
                return null;
            }

            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();

            if(fastPtr == slowPtr){
                break;
            }

        }

        fastPtr = this.head;

        while (fastPtr != slowPtr){
            fastPtr = fastPtr.getNext();
            slowPtr = slowPtr.getNext();
        }

        return slowPtr;

    }

    //Detect and remove a loop from a singly linked list
    public boolean removeLoop() {

        Node loopStart = this.getStartOfLoop();
        Node lastNode = loopStart;

        while (lastNode.getNext() != loopStart){
            lastNode = lastNode.getNext();
        }

        lastNode.setNext(null);

        return true;

    }

    //merge two sorted singly linked lists
    public static Node mergeSortedLists(SinglyLinkedList list1, SinglyLinkedList list2){

        Node a = list1.getHead();
        Node b = list2.getHead();
        Node dummy = new Node(0);
        Node tail = dummy;

        while(a != null && b != null){

            if (a.getData() <= b.getData()){
                tail.setNext(a);
                a = a.getNext();
            }
            else{
                tail.setNext(b);
                b = b.getNext();
            }
            tail = tail.getNext();

        }

        if(list1.getHead() == null && list2.getHead() == null){
            return null;
        }
        else if (list1.getHead() == null){
            dummy.setNext(list2.getHead());
        }
        else if (list2.getHead() == null){
            dummy.setNext(list1.getHead());
        }
        else {
            if(a == null){
                tail.setNext(b);
            }
            else{
                tail.setNext(a);
            }
        }

        return dummy.getNext();

    }

    //adding two non-negative numbers, each represented using a singly linked list
    public Node add(SinglyLinkedList num1, SinglyLinkedList num2) {

        

        
    }
    

}