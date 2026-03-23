
import java.util.Scanner;

public class MaxNumberPossible {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int max = num;
        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);

            int digit = s.charAt(i) - '0';
            sb.setCharAt(i, (char) (arr[digit] + '0'));

            int newNum = Integer.parseInt(sb.toString());
            max = Math.max(max, newNum);
        }

        System.out.println("max: " + max);

        sc.close();
    }

}
