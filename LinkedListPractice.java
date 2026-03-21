public class LinkedListPractice {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

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

    static Node insertAtPosition(Node head, int data, int pos) {
        if (pos == 0) {
            return insertAtBeginning(head, data);
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("invalid position!");
                return head;
            }

            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("invalid position!");
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    static Node deleteAtBeginning(Node head) {
        if (head == null) {
            return null;
        }

        head = head.next;
        return head;
    }

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

    static Node deleteByValue(Node head, int val) {
        if (head == null) {
            return null;
        }

        if (head.data == val) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("value not found!");
            return head;
        }

        temp.next = temp.next.next;
        return head;
    }

    static int getAtPosition(Node head, int pos) {
        Node temp = head;

        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                System.out.println("invalid position!");
                return -1;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("invalid position");
            return -1;
        }

        return temp.data;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.err.println("NULL");
    }

    public static void main(String[] args) throws Exception {

        Node head = null;

        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 30);
        printList(head);

        head = insertAtEnd(head, 90);
        head = insertAtEnd(head, 100);
        printList(head);

        head = insertAtPosition(head, -100, 100);
        head = insertAtPosition(head, -200, 2);
        printList(head);

        head = deleteAtBeginning(head);
        printList(head);

        head = deleteAtEnd(head);
        printList(head);

        head = deleteByValue(head, -200);
        head = deleteByValue(head, 1000);
        printList(head);

        System.out.println("value at index 1 is: " + getAtPosition(head, 1));
        System.out.println("value at index 2 is: " + getAtPosition(head, 2));
    }

}