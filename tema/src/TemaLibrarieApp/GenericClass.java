package TemaLibrarieApp;

/**
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

import java.util.HashSet;
import java.util.Set;

public class GenericClass <T extends Carti> {

    private final Set<T> set;

    /**
     * Constructs a new generic class instance and assignees to it a new {@link HashSet} collection of type T elements.
     */
    public GenericClass() {
        this.set = new HashSet<>();
    }
    public Set<T> getSet() {
        return set;
    }
    /**
     * Adds objects of type T to the set.
     * @param obj the object of type T that will be added.
     */
    public void add(T obj) {
        set.add(obj);
    }
    public int size() {
        return set.size();
    }
}

