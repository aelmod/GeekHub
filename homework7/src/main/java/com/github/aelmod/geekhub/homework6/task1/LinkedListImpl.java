package com.github.aelmod.geekhub.homework6.task1;

import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class LinkedListImpl<E> implements LinkedList<E> {

    private int size = 0;

    private Node<E> tail;
    private Node<E> head;

    @Override
    public void add(E element) {
        size++;
        tail = new Node<>(element, null);
        if (head == null) {
            head = tail;
            return;
        }
        Node<E> last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = tail;
    }

    @Override
    public E get(int index) {
        if (head == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean contains(E element) {
        for (E e : this)
            if (e.equals(element)) return true;
        return false;
    }

    @Override
    public boolean delete(E element) {

        if (nonNull(head) && Objects.equals(head.value, element)) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> prev = null;
        for (Node<E> current = head; nonNull(current); current = current.next) {
            if (Objects.equals(element, current.value)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
        }

        return false;
    }

    @Override
    public E delete(int index) {
        if (head == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        Node<E> prev = null;
        if (index == 0) {
            prev = head;
            head = head.next;
            return prev.value;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        return current.value;
    }

    public void print() {
        for (Node<E> current = this.head; current != null; current = current.next) {
            System.out.println(current.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int clean() {
        int prevSize = size();
        size = 0;
        head = null;
        tail = null;
        return prevSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl<>(head);
    }

    private static class IteratorImpl<E> implements Iterator<E> {

        private Node<E> node;

        public IteratorImpl(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E value = node.value;
            node = node.next;
            return value;
        }
    }
}