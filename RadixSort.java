import java.util.*;

public class RadixSort {

    public static void sorting(int[] arr) {
        int maxElement = Arrays.stream(arr).max().getAsInt();
        for (int i = 1; i < maxElement; i++) {
            radixSort(arr, i);
            System.out.println(Arrays.toString(arr));
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void radixSort(int[] arr, int place) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i : arr) {
            int digit = (i / place) % 10;
            map.computeIfAbsent(digit, k -> new ArrayList<>()).add(i);
        }

        int i = 0;
        for (List<Integer> list : map.values()) {
            for (Integer j : list) {
                arr[i] = j;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 100, 20, 18, 53 };
        sorting(arr);
    }
}

/*
 * for given arr, N = number of numbers
 * 
 * function radixSort(arr, N, place) #pass
 * dict = pairs of each pair is of key: digit, value: arr
 * for e in arr:
 * digit = e / place % 10
 * if the key 'digit' not in dict:
 * dict[digit] = new arr
 * dict[digit].add(e)
 * #copy nums in dict back to arr
 * for groupArr in dictValues:
 * for e in groupArr:
 * arr[I] = 0
 * I++
 * ---------
 * 
 * 
 * function sort(arr, N)
 * max = maximum(arr, N)
 * iterate 1, 10, 100.. < max
 * radixSort(arr, N, place)
 * print(arr, N)
 * 
 */