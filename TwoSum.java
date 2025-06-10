import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[] { i, map.get(nums[i]) };
            }
            map.put(diff, i);
        }
        return new int[] {};
    }
}
