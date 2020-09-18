package com.jdbc.AboutLinkedList;

public class LoopLinkedList <T> extends SingleLinkedList<T>{

    @Override
    public boolean insert(T value) {
        Node newNode = new Node<>(value, getHead());

        return super.insert(newNode);
    }



}
