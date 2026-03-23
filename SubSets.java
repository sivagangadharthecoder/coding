
import java.util.*;

class SubSets {

    static List<List<Integer>> result = new ArrayList<>();
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        subsets();

        for (List<Integer> l : result) {
            System.out.println(l);
        }

        sc.close();
    }

    public static void subsets() {
        backTrack(0, new ArrayList<>());
    }

    private static void backTrack(int index, List<Integer> current) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backTrack(index + 1, current);

        current.remove(current.size() - 1);
        backTrack(index + 1, current);
    }
}
