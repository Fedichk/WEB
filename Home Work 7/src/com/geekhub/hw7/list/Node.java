package com.geekhub.hw7.list;

class Node<T> {

    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}