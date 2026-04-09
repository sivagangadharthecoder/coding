
public class QueueImpl {

    public static void main(String[] args) {

        QueueArr q = new QueueArr(5);

        q.offer(10);
        q.offer(20);
        q.offer(30);

        q.printQueue();

        q.poll();
        q.printQueue();

        System.out.println("Peek: " + q.peek());
        System.out.println("Size: " + q.size());
    }
}

class QueueArr {

    int front, rear, size;
    int[] arr;

    QueueArr(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void offer(int x) {
        if (size == arr.length) {
            System.out.println("Queue Full");
            return;
        }

        rear++;
        arr[rear] = x;
        size++;
    }

    int poll() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        int val = arr[front];
        front++;
        size--;
        return val;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
