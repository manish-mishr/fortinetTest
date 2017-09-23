class LinkedList {
 
    static Node head = null;
 

// My resolution:   I am using iterative approach. I am using simple approach in which I make next of a node refer to the previous node and refer earlier next node as head and current node whose next refers to the previous
    // node as newhead. Keep repeating this process untill head is not null.
    
// Time complexity:  theta(n). As to reverse the list, I am visiting  all the n nodes just once. so, It's time complexity is O(n).
// Space complexity:  O(1). I am using constant space to reverse the list as I am not using any auxiliary space for reversal of list.


    /* Function to reverse the linked list */
    public  Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            }
        return newHead;
    }
 
    
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.head = new Node(85);
        // list.head.next = new Node(15);
        // list.head.next.next = new Node(4);
        // list.head.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}


class Node{
    
    private int value;
    Node next;

    Node(int v){
        value = v;
        next = null;
        }

    int getValue(){
        return value;
    }
}

