import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>,Double> adjacentVertices;
    public Vertex(V data){
        this.data=data;
        this.adjacentVertices=new HashMap<>();
    }
    public void addAdjacentVertex(Vertex<V> vertex, double weight){
        if (!adjacentVertices.containsKey(vertex)) {
            adjacentVertices.put(vertex, weight);
        }
    }
    public boolean destPresent(Vertex<V> dest){
        return adjacentVertices.containsKey(dest);

    }
    public double getWeight(Vertex<V> vertex){
        return adjacentVertices.get(vertex);
    }
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public V getData() {
        return data;
    }
}
