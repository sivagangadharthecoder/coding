
import java.util.*;

class MaxPersons {

    public static void main(String[] args) {

        int[] weights = {80, 40, 60, 10, 30, 20};
        int maxCapacity = 100;

        int result = findMaxPersons(weights, maxCapacity);
        System.out.print("no of persons: " + result);

    }

    private static int findMaxPersons(int[] weights, int maxCapacity) {

        Arrays.sort(weights);

        int count = 0, sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (sum > maxCapacity) {
                break;
            } else {
                count++;
            }
        }

        return count;
    }
}
