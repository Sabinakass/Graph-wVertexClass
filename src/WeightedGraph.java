import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> vertices;
    private final boolean undirected;

    public WeightedGraph(){
        this.vertices=new HashMap<>();
        this.undirected=true;
    }

    public WeightedGraph(boolean undirected) {
        this.vertices=new HashMap<>();
        this.undirected = undirected;
    }
    public void addVertex(V vertex){
        if(!hasVertex(vertex)){
           vertices.put(new Vertex<>(vertex),new ArrayList<>());
        }
    }
    public void addEdge(V source,V dest,Double weight) {
        Vertex<V> s = getVertex(source);
        Vertex<V> d = getVertex(dest);

        if (s == null) {
            s = new Vertex<>(source);
            vertices.put(s, new ArrayList<>());
        }

        if (d == null) {
            d = new Vertex<>(dest);
            vertices.put(d, new ArrayList<>());
        }

        if (hasEdge(source, dest) || source.equals(dest)) {
            return;
        }

        vertices.get(s).add(d);
        s.addAdjacentVertices(d, weight);

        if (!undirected) {
            return;
        }

        vertices.get(d).add(s);
        d.addAdjacentVertices(s, weight);

    }

    public Vertex<V> getVertex(V v) {
        for (Vertex<V> vertex : vertices.keySet()) {
            if (vertex.getData().equals(v)) {
                return vertex;
            }
        }
        return null;
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : vertices.keySet()) {
            count += vertices.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(V v){
        for (Vertex<V> vertex : vertices.keySet()) {
            if (vertex.getData().equals(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEdge(V s,V d ){
        if (!hasVertex(s) || !hasVertex(d)) {
            return false;
        }

        Vertex<V> sour = getVertex(s);
        Vertex<V> dest = getVertex(d);

        return vertices.get(sour).contains(dest);
    }


    public Iterable<Vertex<V>> adjacencyList(Vertex<V> v) {
        if (!hasVertex(v.getData())) {
            return new HashSet<>();
        }

        List<Vertex<V>> adjacencyList = new ArrayList<>(v.getAdjacentVertices().keySet());
        return adjacencyList;
    }

    public Iterable<Vertex<V>> getEdges(Vertex<V> v) {
        if (!hasVertex(v.getData())) {
            return new ArrayList<>();
        }

        List<Vertex<V>> edges = vertices.get(v);
        return edges != null ? edges : new ArrayList<>();

    }

    public Map<Vertex<V>, List<Vertex<V>>> getVertices() {
        return vertices;
    }
}
