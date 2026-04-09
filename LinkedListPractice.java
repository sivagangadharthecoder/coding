
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

    static Node deleteByPos(Node head, int pos) {

        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        }

        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {

            if (temp.next == null) {
                System.out.println("invalid position!");
                return head;
            }

            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

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
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.err.println("NULL");
    }

    static int findLen(Node head) {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            return 1;
        }

        int len = 0;

        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    static int findMiddlePos(Node head) {
        return findLen(head) / 2;
    }

    static Node deleteFromBehind(Node head, int k) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        int len = findLen(head);

        if (k < 0 || k > len) {
            System.out.println("invalid position!");
            return head;
        }

        if (len - k == 0) {
            return head.next;
        }

        Node temp = head;

        int pos = len - k;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
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

        head = deleteByValue(head, 100);
        printList(head);

        System.out.println("middle position is : " + findMiddlePos(head));
        head = deleteByPos(head, 1);
        printList(head);

        System.out.println("middle position is : " + findMiddlePos(head));
        System.out.println("no.of nodes are : " + findMiddlePos(head) * 2);

        head = deleteFromBehind(head, 2);
        printList(head);

    }

}
