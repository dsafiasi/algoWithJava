package com.jdbc.AboutLinkedList;

public class SingleLinkedList <T>{
    private Node head;

    public int indexOf(T value) {
        if (head == null) {
            return -1;
        }
        int index = 0;

        Node node = head;
        while (node != null && node.data != value) {
            index += 1;
            node = node.next;
        }

        if (node == null) {
            return -1;
        }
        return index;
    }

    public Node getHead() {
        return head;
    }

    public boolean update(T oldvalue, T newValue) {
        if (head == null) {
            return false;
        }

        Node node = head;
        while (node != null && node.data != oldvalue) {
            node = node.next;
        }

        if (node == null) {
            return false;
        }
        node.data = newValue;
        return true;
    }

    public boolean deleteByNode(Node deleteNode) {
        if (head == null || deleteNode == null) {
            return false;
        }
        Node node = head;
        Node prev = null;
        while (node != null && node != deleteNode) {
            prev = node;
            node = node.next;
        }
        if (node == null) {
            return false;
        }
        prev.next = node.next;
        return true;
    }


    public boolean deleteByValue(T value) {
        if (head == null) {
            return false;
        }
        // 对于仅有一个结点的删除操作需要做特殊处理
        if (head.next == null) {
            head = null;
            return true;
        }

        Node node = head;
        Node prevNode = null;
        while (node != null && node.data != value) {
            prevNode = node;
            node = node.next;
        }
        if (node == null) {
            return false;
        }

        prevNode.next = node.next;
        return true;

    }

    public boolean insertBefore(T oldValue, T newValue) {
        if (head == null) {
            return false;
        }

        Node node = head;
        Node prev = null;
        while (node != null && node.data != oldValue) {
            prev = node;
            node = node.next;
        }
        if (node == null) {
            return false;
        }

        Node newNode = new Node(newValue, node);

        if (head.data == node.data) {
            head = newNode;
        }

        prev.next = newNode;

        return true;
    }

    public boolean insertAfter(T oldValue, T newValue) {
        if (head == null) {
            return false;
        }
        Node node = head;
        while (node != null && node.data != oldValue) {
            node = node.next;
        }
        if (node == null) {
            return false;
        }
        Node newNode = new Node(newValue, node.next);
        node.next = newNode;
        return true;
    }

    public boolean insert(Node<T> newNode) {
        Node node = head;

        if (head == null) {
            head = newNode;
            return true;
        }

        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return true;
    }

    public boolean insert(T value) {
        Node newNode = new Node(value, null);
        return insert(newNode);
    }

    public void print() {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);

    }
    // 单链表反转
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    static class Node <T>{
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList();
        /**
         * 验证insert();
         */
        for (int i = 0; i < 10; i++) {
            int num = 5;
            linkedList.insert(num * i);
        }
        SingleLinkedList.Node node = new Node<>(99,null);
        SingleLinkedList.Node node1 = new Node<>(5,null);

        linkedList.insert(node);

        System.out.println(linkedList.indexOf(99));

        System.out.println(linkedList.deleteByNode(node1));

//        System.out.println(linkedList.indexOf(5));


//        linkedList.print();
//        linkedList.insertAfter(0,11);
//        System.out.println(linkedList.indexOf(11));
//        linkedList.insertBefore(11,12);
//        System.out.println(linkedList.indexOf(12));



//        linkedList.reverse();
//        System.out.println("--------------");
//        linkedList.print();

//        /**
//         * 验证delete()和indexOf();
//         */
//        linkedList.delete(45);
//        System.out.println(linkedList.indexOf(45));
//        System.out.println(linkedList.indexOf(0));
//        System.out.println(linkedList.indexOf(10));
//
//        /**
//         * 验证update()和indexOf();
//         */
//
//        linkedList.update(40,44);
//        System.out.println(linkedList.indexOf(44));

    }



}
