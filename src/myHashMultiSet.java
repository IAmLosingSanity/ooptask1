import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class myHashMultiSet<E> implements Iterable<E> {
    private final Map<E, Integer> map;

    public myHashMultiSet() {
        map = new HashMap<>();
    }

    @Override
    public Iterator<E> iterator() {
        return new MultiSetIterator();
    }

    public boolean remove(Object o) {
        Integer count = map.get(o);
        if (count != null) {
            if (count > 1) {
                map.put((E) o, count - 1);
            } else {
                map.remove(o);
            }
            return true;
        }
        return false;
    }

    public void add(E e) {
        Integer count = map.get(e);
        if (count != null) {
            map.put(e, count + 1);
        } else {
            map.put(e, 1);
        }
    }

    private class MultiSetIterator implements Iterator<E> {
        private final Iterator<Map.Entry<E, Integer>> entryIterator;
        private E currentKey;
        private int count;

        public MultiSetIterator() {
            entryIterator = map.entrySet().iterator();
            currentKey = null;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count > 0 || entryIterator.hasNext();
        }

        @Override
        public E next() {
            if (count == 0) {
                Map.Entry<E, Integer> entry = entryIterator.next();
                currentKey = entry.getKey();
                count = entry.getValue();
            }
            count--;
            return currentKey;
        }

        @Override
        public void remove() {
            if (currentKey != null) {
                if (count > 0) {
                    map.put(currentKey, count);
                } else {
                    entryIterator.remove();
                }
                currentKey = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}