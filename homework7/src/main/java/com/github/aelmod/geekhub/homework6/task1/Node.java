package com.github.aelmod.geekhub.homework6.task1;

/**
 * Created by aelmod-notebook on 01.12.2016.
 */
class Node<T> {

    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
