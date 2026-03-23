
import java.util.*;

class FraudDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> frauds = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String sender = sc.next();
            String receiver = sc.next();
            int amount = sc.nextInt();
            int time = sc.nextInt();

            String key = sender + "-" + receiver + "-" + amount;

            if (map.containsKey(key)) {
                List<Integer> times = map.get(key);

                for (int t : times) {
                    if (Math.abs(t - time) <= 60) {
                        frauds.add(sender + " " + receiver + " " + amount + " " + time);
                        break;
                    }
                }
                times.add(time);

            } else {
                List<Integer> times = new ArrayList<>();
                times.add(time);
                map.put(key, times);
            }
        }

        for (String f : frauds) {
            System.out.println(f);
        }

        sc.close();
    }

}
