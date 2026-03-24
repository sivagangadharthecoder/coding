
import java.util.*;

class SubSetsSumTarget {

    static List<List<Integer>> result = new ArrayList<>();
    static int[] nums;
    static int target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        target = 5;

        subsets();

        for (List<Integer> l : result) {
            System.out.println(l);
        }

        sc.close();
    }

    public static void subsets() {
        backTrack(0, new ArrayList<>(), target);
    }

    private static void backTrack(int index, List<Integer> current, int target) {

        if (index == nums.length) {
            int sum = 0;
            for (int i = 0; i < current.size(); i++) {
                sum += current.get(i);
            }

            if (sum == target) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        current.add(nums[index]);
        backTrack(index + 1, current, target);

        current.remove(current.size() - 1);
        backTrack(index + 1, current, target);
    }
}
