package deque;

public class ArrayDeque<T> implements Deque<T> {
    protected T[] items;
    protected int size;
    protected int capacity;
    protected int head, tail;
    static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        head = 0;
        tail = -1;
        capacity = INIT_CAPACITY;
    }

    public void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        head = 0;
        tail = size - 1;
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = head; i != tail ; i = (i + 1) % capacity) {
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
}
