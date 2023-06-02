import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
        String vertexData = "Almaty";



        System.out.println("Adjacent vertices");
        for (String vertex : graph.getVertices().keySet()) {
            System.out.println("Edges of vertex " + vertex + ":");
            for (String adjacentVertex : graph.getEdges(vertex)) {
                System.out.println(vertex + " -> " + adjacentVertex);
            }
            System.out.println();
        }

        System.out.println("BFS");
        Search<String> bfs=new BFS<>(graph,vertexData);
        outputPath(bfs,"Kyzylorda");

        System.out.println("Dijkstra");
        Search<String> dijkstra=new DijkstraSearch<>(graph,vertexData);
        outputPath(dijkstra,"Kyzylorda");
     
    }

    public static void outputPath(Search<String> search, String key) {
        if (search.hasPathTo(key)){
            Iterable<String> path = search.pathTo(key);
            Iterator<String> iterator = path.iterator();

            if (iterator.hasNext()) {
                System.out.print(iterator.next());
            }


            while (iterator.hasNext()) {
                System.out.print(" -> " + iterator.next());
            }

            System.out.println();
        } else {
            System.out.println("No path found from source to destination.");
        }
    }
    }
