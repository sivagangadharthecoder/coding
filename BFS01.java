
import java.util.*;

public class BFS01 {

    static class Pair {

        int nd, wt;

        Pair(int nd, int wt) {
            this.nd = nd;
            this.wt = wt;
        }
    }

    static List<List<Pair>> graph = new ArrayList<>();

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0, 1, 0},
            {0, 2, 1},
            {1, 2, 1},
            {1, 3, 0},
            {2, 4, 1},
            {3, 4, 0}
        };

        makeGraph(n, edges);
        printGraph(n);

        bfsShortestPath(0, n);
    }

    static void bfsShortestPath(int src, int n) {

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(src);

        while (!dq.isEmpty()) {

            int u = dq.pollFirst();

            for (Pair p : graph.get(u)) {

                int v = p.nd;
                int w = p.wt;

                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;

                    if (w == 0) {
                        dq.offerFirst(v); 
                    }else if (w == 1) {
                        dq.offerLast(v);
                    }
                }

            }

        }

        System.out.println("shortest distances from " + src + " to:");

        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + distance[i]);
        }

    }

    static void makeGraph(int n, int[][] edges) {

        graph.clear();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Pair(v, w));
        }

    }

    static void printGraph(int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");

            for (Pair pair : graph.get(i)) {
                System.out.print("[ " + pair.nd + "," + pair.wt + " ]");
            }

            System.out.println();
        }

    }

}
