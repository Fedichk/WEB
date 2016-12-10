package com.geekhub.hw8.list;

import java.util.Iterator;

class IteratorImpl<E> implements Iterator<E> {

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

