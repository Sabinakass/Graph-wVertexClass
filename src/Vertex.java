import java.util.HashMap;
import java.util.Map;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>,Double> adjacentVertices;

     public Vertex(V data){
     this.data=data;
     adjacentVertices=new HashMap<>();
     }

    public V getData() {
        return data;
    }

    public void addAdjacentVertices(Vertex<V> dest, Double weight){
         if(!adjacentVertices.containsKey(dest)){
             adjacentVertices.put(dest,weight);
             dest.addAdjacentVertices(this,weight);
         }

    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
