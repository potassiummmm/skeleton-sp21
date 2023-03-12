package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public LinkedListDeque() {
        size = 0;
    }

    private class Node<T> {
        T value;
        Node<T> pre, next;

        Node(T item) {
            value = item;
        }

        public T getRecursive(int index) {
            if (index == 0) {
                return value;
            }
            return next.getRecursive(index - 1);
        }
    }

    private Node<T> head, tail;
    private int size;

    public void addFirst(T item) {
        if (head == null) {
            head = new Node<T>(item);
            head.next = head;
            head.pre = head;
            tail = head;
        } else {
            Node<T> newHead = new Node<T>(item);
            tail.next = newHead;
            newHead.next = head;
            newHead.pre = tail;
            head.pre = newHead;
            head = newHead;
        }
        size++;
    }

    public void addLast(T item) {
        if (head == null) {
            head = new Node<T>(item);
            head.next = head;
            head.pre = head;
            tail = head;
        } else {
            Node<T> newTail = new Node<T>(item);
            tail.next = newTail;
            newTail.next = head;
            newTail.pre = tail;
            head.pre = newTail;
            tail = newTail;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> cur = head;
        while (true) {
            System.out.print(cur.value);
            cur = cur.next;
            if (cur == head) {
                break;
            }
            System.out.print(' ');
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removed = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> newHead = head.next;
            newHead.pre = tail;
            tail.next = newHead;
            head.pre = null;
            head.next = null;
            head = newHead;
        }
        size--;
        return removed;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removed = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> newTail = tail.pre;
            newTail.next = head;
            head.pre = newTail;
            tail.pre = null;
            tail.next = null;
            tail = newTail;
        }
        size--;
        return removed;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node<T> curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.value;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return head.getRecursive(index);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node != tail;
            }

            @Override
            public T next() {
                T val = node.value;
                node = node.next;
                return val;
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
        Deque<T> ol = (Deque<T>) o;
        if (ol.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!(ol.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}
