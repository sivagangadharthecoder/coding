
import java.util.ArrayDeque;

class GenerateBinaryNumbers {

    public static void main(String[] args) {
        int n = 5;
        generateBinary(n);
    }

    static void generateBinary(int n) {

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offerLast("1");

        for (int i = 1; i <= n; i++) {
            String cur = queue.pollFirst();
            System.out.print(cur + " ");

            queue.offerLast(cur + "0");
            queue.offerLast(cur + "1");
        }

    }

}
