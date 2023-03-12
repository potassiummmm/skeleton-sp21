package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int head, tail;
    private static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        head = 0;
        tail = -1;
        capacity = INIT_CAPACITY;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        for (int i = head, j = 0; j < size; i = (i + 1) % capacity, j++) {
            newItems[j] = items[i];
        }
        head = 0;
        tail = size - 1;
        items = newItems;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            resize((int) (capacity * 1.1));
        }
        head = (head - 1 + capacity) % capacity;
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        tail = (tail + 1) % capacity;
        items[tail] = item;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = head; i != tail; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removed = items[head];
        head = (head + 1) % capacity;
        size--;
        return removed;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removed = items[(tail + capacity) % capacity];
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return removed;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(head + index) % capacity];
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                T item = get(pos);
                pos++;
                return item;
            }
        };
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> oa = (Deque<T>) o;
        if (oa.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!(oa.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}
