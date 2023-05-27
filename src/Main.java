import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
        String vertexData = "Shymkent";
//        Vertex<String> vertex = graph.getVertex(vertexData);
//
//        Iterable<Vertex<String>> adjacencyList = graph.adjacencyList(vertex);
//        for (Vertex<String> adjacentVertex : adjacencyList) {
//            System.out.println(adjacentVertex.getData());
//
//        }
        for (Vertex<String> vertex : graph.getVertices().keySet()) {
            System.out.println("Edges of vertex " + vertex.getData() + ":");
            for (Vertex<String> adjacentVertex : graph.getEdges(vertex)) {
                System.out.println(vertex.getData() + " -> " + adjacentVertex.getData());
            }
            System.out.println();
        }
        Search<String> bfs=new BFS<>(graph,vertexData);
        outputPath(bfs,"Kyzylorda");
        }

    public static void outputPath(Search<String> search, String key) {
        if (search.hasPathTo(new Vertex<>(key))){
            Iterable<String> path = search.pathTo(key);
            for (String v : path) {
                System.out.print(v + " -> ");
            }
            System.out.println("\b\b ");
        } else {
            System.out.println("No path found from source to destination.");
        }
    }
}