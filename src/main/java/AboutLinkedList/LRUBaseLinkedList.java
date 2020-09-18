package com.jdbc.AboutLinkedList;

import java.util.Random;

public class LRUBaseLinkedList <T> {
    private int length;
    private final static int DEFAULT_CAPACITY = 5;
    private Node head;// 哨兵
    private int capacity;

    public LRUBaseLinkedList(int capacity) {
        this.length = 0;
        this.capacity = capacity;
    }

    public LRUBaseLinkedList() {
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    private Node findPrevNode(T value) {
        Node node = head;
        if (node == null) return null;

        while (node.next != null) {
            if (node.next.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    private void deleteEndNode() {
        Node node = head;
        if (length <= 0) return;

        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        length--;
    }

    public void add(T value) {
        Node prevNode = findPrevNode(value);

        if (prevNode != null) {
            insertNodeAtBegin(value);
            deleteElemOp(prevNode);
        } else {
            if (length >= capacity) {
                deleteEndNode();
            }
            insertNodeAtBegin(value);
        }

    }


    private void insertNodeAtBegin(T value) {
        Node node = new Node(value, head);
        head = node;
        length++;
    }


    private void deleteElemOp(Node prevNode) {
        Node temp = prevNode.next;
        prevNode.next = temp.next;
        temp = null;
        length--;
    }

    private void printAll() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value + " ,");
            node = node.next;
        }
        System.out.println();
    }

    class Node <T>{
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }


    }


    // 已存在缓存，将结点移动到头部
    // 遍历看是否在缓存
    // 未存在缓存，若缓存未满，则添加至头部；否则，删除尾部，并将其添加至头部。


    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> lruList = new LRUBaseLinkedList<>();
        Random random = new Random();


        for (int i = 0; i< 5; i++) {
            lruList.add(random.nextInt(10));
//            lruList.add(i);
        }

        lruList.printAll();

//        lruList.add(6);
//        System.out.println("期待:" + "6,4,3,2,1");
//        lruList.printAll();

    }
}