import java.util.*;

public class Search<V> {

    protected int count;
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v))
            return new ArrayList<>();
        LinkedList<V> ls = new LinkedList<>();
        V current = v;
        while (!current.equals(source)) {
            ls.push(current);
            current = edgeTo.get(current);
        }
        ls.push(source);
        return ls;
    }

    public int getCount() {
        return count;
    }
}
