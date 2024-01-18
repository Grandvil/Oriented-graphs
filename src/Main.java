import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int v = 7;
        Graph graph = new Graph(v);
        int startUser = 0;

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        virusizeMeme(graph, startUser);
    }

    public static void virusizeMeme(Graph graph, int startUser) {
        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> sent = new ArrayDeque<>();
        visited[startUser] = true;
        sent.add(startUser);

        int lastViewer = 0;
        while (!sent.isEmpty()) {
            lastViewer = sent.remove();
            for (int vv : graph.nexts(lastViewer)) {
                if (!visited[vv]) {
                    visited[vv] = true;
                    sent.add(vv);
                }
            }
        }

        System.out.println("Последним увидит: " + lastViewer);
    }
}