
import java.util.*;

class BFSandDFS {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {

        int n = 4;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 3);

        System.out.print(graph);

        boolean[] visited = new boolean[n];

        System.err.print("\ndfs: ");
        dfs(n, visited);

    }

    static void addEdge(int node, int neighbour) {

        graph.get(node).add(neighbour);
        graph.get(neighbour).add(node); // if this line is commented, it becomes directed 

    }

    static void dfs(int curNode, boolean[] visited) {

        visited[curNode] = true;
        System.out.print(curNode + " ");

        for (int neighbour : graph.get(curNode)) {
            if (!visited[neighbour]) dfs(neighbour, visited);
        }

    }

}
