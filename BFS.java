import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V>{

    public BFS(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        V startVertex = current;
        if (startVertex == null) {
            return;
        }

        marked.add(startVertex);
        Queue<V> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (V vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
