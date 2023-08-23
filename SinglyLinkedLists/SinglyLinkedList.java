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
        
        this.display();

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

        this.display();

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
            this.display();
        }

    }

    //removing nodes
    public Node removeFirst() {
        
        if(this.head == null){
            System.out.println("Nothing to delete. exitting...");
            this.display();;
            return null;
        }
        else{
            Node tempNode = this.head;
            this.head = this.head.getNext();
            tempNode.setNext(null);
            System.out.println("First node removed successfully.");
            this.display();
            return tempNode;
        }

    }
    public Node removeLast() {
        
        if(this.head == null){
            System.out.println("Nothing to delete. exitting...");
            this.display();
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
            this.display();
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
            this.display();;
            return temp;
        }
        else{
            System.out.println("Position " + position + " out of bounds. Nothing removed.");
            this.display();
            return null;
        }
        
    }
    public void removeNodeElement(int searchKey) {
        Node currentNode = this.head.getNext();
        Node previousNode = this.head;
        int removedCount = 0;

        while(currentNode != null){
            if(this.head.getData() == searchKey){
                this.head = this.head.getNext();
                currentNode = currentNode.getNext();
                previousNode = this.head;
                removedCount++;
            }
            else if(currentNode.getData() == searchKey) {
                currentNode = currentNode.getNext();
                previousNode.setNext(currentNode);
                removedCount++;
            }
            else{
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            
        }

        System.out.println("Removed " + removedCount + " nodes matching the searchkey " + searchKey + ".");
        this.display();

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
}