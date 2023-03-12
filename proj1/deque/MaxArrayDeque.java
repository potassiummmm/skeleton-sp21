package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for (T i : this) {
            if (comparator.compare(i, maxItem) > 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for (T i : this) {
            if (c.compare(i, maxItem) > 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }

    public static void main(String[] args) {
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        maxArrayDeque.addFirst(0);
        maxArrayDeque.addFirst(1);
        maxArrayDeque.addFirst(2);
        maxArrayDeque.addFirst(3);
        maxArrayDeque.addFirst(4);
        maxArrayDeque.addFirst(5);
        maxArrayDeque.addFirst(6);
        maxArrayDeque.addFirst(7);
        maxArrayDeque.addFirst(8);
        maxArrayDeque.addFirst(9);
        int a = maxArrayDeque.removeLast();
        int b;
    }
}
