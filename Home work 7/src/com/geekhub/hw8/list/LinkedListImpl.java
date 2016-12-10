package com.geekhub.hw8.list;

import java.util.Iterator;

public class LinkedListImpl<E> implements LinkedList<E> {

    private int size = 0;

    private Node<E> tail;
    private Node<E> head;

    @Override
    public void add(E element) {
        Node<E> list = new Node<E>(element, null);
        if (isEmpty()) {
            head = list;
            tail = list;
        } else {
            tail.next = list;
            tail = list;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (isEmpty() || index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp == null) throw new IndexOutOfBoundsException();
        return temp.value;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.value.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    @Override
    public boolean delete(E element) {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        if (head.value == element) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.next.value == element) {
                if (tail == temp.next) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public E delete(int index) {
        if (isEmpty() || index < 0 || index > size) throw new IndexOutOfBoundsException();
        E temp = (get(index));
        delete(get(index));
        return temp;
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
        int oldSize = size;
        head = null;
        tail = null;
        size = 0;
        return oldSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl<>(head);
    }
}