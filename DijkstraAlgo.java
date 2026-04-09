
import java.util.*;

class Pair {

    int nd, wt;

    Pair(int nd, int wt) {
        this.nd = nd;
        this.wt = wt;
    }

}

public class DijkstraAlgo {

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

        createGraph(n, edges);
        printGraph(n);

        findDijkstra(0, n);

    }

    static void findDijkstra(int src, int n) {

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        minHeap.offer(new Pair(src, 0));

        while (!minHeap.isEmpty()) {

            Pair pair = minHeap.poll();
            int u = pair.nd;

            for (Pair edge : graph.get(u)) {
                int v = edge.nd;
                int w = edge.wt;

                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                    minHeap.offer(new Pair(v, distance[v]));
                }
            }
        }

        System.out.println("minimum dist from " + src + " to: ");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + distance[i]);
        }

    }

    static void createGraph(int n, int[][] edges) {

        graph.clear();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
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
