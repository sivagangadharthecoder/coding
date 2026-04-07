
import java.util.Queue;
import java.util.LinkedList;

class Node {

    int data;
    Node left, right;

    Node(int data) {

        this.data = data;
        left = right = null;

    }

}

public class TreeInsertionTraversals {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        System.out.println("binary tree created!");

        System.out.print("preOrder: ");
        preOrder(root);

        System.out.print("\ninOrder: ");
        inOrder(root);

        System.out.print("\npostOrder: ");
        postOrder(root);

        System.out.print("\nlevelOrder: ");
        levelOrder(root);

    }

    static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);

    }

    static void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                q.offer(current.left);
            }
            if (current.right != null) {
                q.offer(current.right);
            }

        }

    }

}
