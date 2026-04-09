
public class StackImpl {

    public static void main(String[] args) {

        Stack stack = new Stack(3);

        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.pop());

        stack.print();
        stack.peek();

    }

}

class Stack {

    int top, size;
    int[] stack;

    Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == size - 1) {
            System.out.println("stack overflow");
            return;
        }
        stack[++top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("stack underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek() {
        if (top == -1) {
            return -1;
        }
        return stack[top];
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void print() {
        if (top == -1) {
            System.out.println("stack is empty");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

}
