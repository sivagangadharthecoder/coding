
import java.util.*;

class Pair {

    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

}

public class PrimsAlgo {

    static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    static int n = 5;

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1, 12);
        addEdge(0, 2, 7);
        addEdge(1, 3, 4);
        addEdge(2, 4, 3);
        addEdge(3, 4, 13);

        printGraph();

        prims();

    }

    static void prims() {

        boolean[] visited = new boolean[n];

        Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Pair(0, 0));

        int mstweight = 0;

        while (!minHeap.isEmpty()) {

            Pair curr = minHeap.poll();
            int nd = curr.node;
            int wt = curr.weight;

            if (visited[nd]) {
                continue;
            }

            visited[nd] = true;
            mstweight += wt;

            for (Pair neighbour : graph.get(nd)) {
                if (!visited[neighbour.node]) {
                    minHeap.offer(new Pair(neighbour.node, neighbour.weight));
                }
            }
        }

        System.out.println("prims mstweight: " + mstweight);
    }

    static void addEdge(int node, int neighbour, int weight) {

        graph.get(node).add(new Pair(neighbour, weight));
        graph.get(neighbour).add(new Pair(node, weight));

    }

    static void printGraph() {

        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");

            for (Pair p : graph.get(i)) {
                System.out.print(" (" + p.node + "," + p.weight + ") ");
            }

            System.out.println();
        }
    }

}
