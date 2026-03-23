
import java.util.*;

class SubSequences {

    static List<String> result = new ArrayList<>();
    static String s;

    public static void main(String[] args) {

        s = "abcd";
        backTrack(0, "");

        for (String str : result) {
            System.out.println(str);
        }

    }

    private static void backTrack(int index, String current) {

        if (index == s.length()) {
            result.add(current);
            return;
        }

        backTrack(index + 1, current + s.charAt(index));
        backTrack(index + 1, current);
    }

}
