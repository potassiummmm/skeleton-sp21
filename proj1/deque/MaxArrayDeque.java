package deque;

import net.sf.saxon.functions.Compare;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxElem = get(0);
        for (int i = head + 1; i != tail ; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
            if (comparator.compare(maxElem, items[i]) < 0) {
                maxElem = items[i];
            }
        }
        return maxElem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxElem = get(0);
        for (int i = head + 1; i != tail ; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
            if (c.compare(maxElem, items[i]) < 0) {
                maxElem = items[i];
            }
        }
        return maxElem;
    }
}
