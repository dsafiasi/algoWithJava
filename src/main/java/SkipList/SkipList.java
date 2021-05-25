package SkipList;

public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表


    public void insert(int value) {
        

    }
    class Node {
        private int data;
        private Node[] forwards = new Node[MAX_LEVEL];
    }



}
