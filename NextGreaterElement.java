
import java.util.Stack;

class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = {10, -20, 20, 10, 30};

        int[] result = findNextGreater(arr);

        for (int x : result) {
            System.out.print(x + " ");
        }

    }

    static int[] findNextGreater(int[] arr) {

        int n = arr.length;
        Stack<Integer> ms = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            if (ms.isEmpty()) {
                res[i] = -1;
            }

            while (!ms.isEmpty() && ms.peek() <= arr[i]) {
                ms.pop();
            }

            if (!ms.isEmpty()) {
                res[i] = ms.peek();
            }

            ms.push(arr[i]);
        }

        return res;
    }

}
