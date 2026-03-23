
class LinkedListDemo {

    // Node Structure
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at Beginning
    static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    // Insert at End
    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Insert at Position 
    static Node insertAtPosition(Node head, int data, int pos) {
        if (pos == 0) {
            return insertAtBeginning(head, data);
        }

        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return head;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }
        

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Delete at Beginning
    static Node deleteAtBeginning(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    // Delete at End
    static Node deleteAtEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    // Delete by Value
    static Node deleteByValue(Node head, int key) {
        if (head == null) {
            return null;
        }

        if (head.data == key) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

    // Print List
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Get Element at Position
    static int getAtPosition(Node head, int pos) {
        Node temp = head;

        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds");
                return -1;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return -1;
        }

        return temp.data;
    }

    // Search Element
    static boolean search(Node head, int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        Node head = null;

        // Adding
        head = insertAtBeginning(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtPosition(head, 25, 2);

        System.out.print("After insertion: ");
        printList(head);

        // Deleting
        head = deleteAtBeginning(head);

        System.out.print("After delete beginning: ");
        printList(head);

        head = deleteByValue(head, 25);

        System.out.print("After delete 25: ");
        printList(head);

        head = deleteAtEnd(head);
        System.out.print("After delete end: ");
        printList(head);

        // Accessing
        System.out.println("Element at position 1: " + getAtPosition(head, 1));
        System.out.println("Search 30: " + search(head, 30));
    }
}
