import java.util.*;

public class WeightedGraph<V> {
private boolean undirected;
private Map<V,Vertex<V>> vertices;
public WeightedGraph(boolean undirected){
    this.undirected=undirected;
    this.vertices=new HashMap<>();
}
public WeightedGraph(){
    this(true);
}

 public void addVertex(V data){
    if(!hasVertex(data)){
        vertices.put(data,new Vertex<>(data));
    }
}
    public Vertex<V> getVertex(V data){
        return vertices.get(data);
    }
public void addEdge(V source,V dest,double weight){
    if(!hasVertex(source)){
        addVertex(source);
    }
    if(!hasVertex(dest)){
        addVertex(dest);
    }
    if(hasEdge(source,dest)||source.equals(dest)){
        return;
    }
    vertices.get(source).addAdjacentVertex(vertices.get(dest),weight);
    if(undirected){
        vertices.get(dest).addAdjacentVertex(vertices.get(source),weight);
    }

}
    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : vertices.keySet()) {
            count += vertices.get(v).getAdjacentVertices().size();
        }

        if (undirected)
            count /= 2;

        return count;
    }
public boolean hasVertex(V data){
    return vertices.containsKey(data);
}
public boolean hasEdge(V source,V dest){
    if(!hasVertex(source)||! hasVertex(dest)) return false;
    return vertices.get(source).getAdjacentVertices().containsKey(dest);
}

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) {
            return new HashSet<>();
        }

        List<V> adjacencyList = new ArrayList<>();
        for (Vertex<V> adjacentVertex : vertices.get(v).getAdjacentVertices().keySet()) {
            adjacencyList.add(adjacentVertex.getData());
        }
        return adjacencyList;
    }

    public Iterable<V> getEdges(V v) {
        if (!hasVertex(v)) {
            return new ArrayList<>();
        }

        List<V> edges = new ArrayList<>();
        for (Vertex<V> adjacentVertex : vertices.get(v).getAdjacentVertices().keySet()) {
            edges.add(adjacentVertex.getData());
        }
        return edges;

    }


    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
