
import java.util.*;

class Edge {

    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class Kruskal {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        parent[pu] = pv;
    }

    static void kruskalAlgo(int n, List<Edge> edges) {

        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;

        System.out.println("MST Edges:");

        for (Edge e : edges) {

            int u = e.u;
            int v = e.v;

            if (find(u) != find(v)) {
                union(u, v);
                mstWeight += e.weight;
                System.out.println(u + " - " + v + " : " + e.weight);
            }
        }

        System.out.println("Total MST Weight: " + mstWeight);
    }

    public static void main(String[] args) {

        int n = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        kruskalAlgo(n, edges);
    }
}
