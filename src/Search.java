import java.util.*;

public class Search<V> {
    protected int count;
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(V source) {
        this.source = new Vertex<>(source);
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

public Iterable<V> pathTo(V v) {
    if (!hasPathTo(new Vertex<>(v)))
        return new ArrayList<>();
    LinkedList<V> ls = new LinkedList<>();
    Vertex<V> current = new Vertex<>(v);
    while (!current.getData().equals(source.getData())) {
        ls.push(current.getData());
        current = edgeTo.get(current);
    }
    ls.push(source.getData());
    return ls;
}

    public int getCount() {
        return count;
    }
}