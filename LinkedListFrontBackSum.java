import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListFrontBackSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, new ListNode(7))))));

        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null)
                System.out.print(cur.val);
            else
                System.out.print(cur.val + " -> ");
            cur = cur.next;
        }

        System.out.println();
        cur = head;
        modifyList(head);
        while (head != null) {
            if (head.next == null)
                System.out.print(head.val);
            else
                System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    private static ListNode modifyList(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < count / 2; i++) {
            temp.val = list.get(i) + list.get(count - 1 - i);
            temp = temp.next;
        }

        return head;
    }
}