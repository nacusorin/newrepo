package TemaLibrarieApp;

import java.util.HashSet;
import java.util.Set;

public class GenericClass <T extends Carti> {

    private final Set<T> set;
    public GenericClass() {
        this.set = new HashSet<>();
    }
    public Set<T> getSet() {
        return set;
    }
    public void add(T obj) {
        set.add(obj);
    }
    public int size() {
        return set.size();
    }
}

