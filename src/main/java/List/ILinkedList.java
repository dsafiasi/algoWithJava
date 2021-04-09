package List;

public class ILinkedList<T> {

    private int count;
    private Node<T> head;
    private Node<T> tail;


    // 增删改查


    // 默认添加至尾部
    public void add(T value) {
        Node<T> node = new Node<>(value,null, null);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value,null, head);
        head = node;
        if (tail == null) {
            tail = node;
        }
        count++;
    }

//    public void add

    // 默认删除末尾
    public boolean remove() {
        if (count <= 0) return false;

        return removeByIndex(count-1);
    }

    public boolean removeByNode(Node<T> node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            if (node.prev == null && node.next == null) {
                head = null;
                tail = null;
            } else {
                if (node.prev == null) {
                    node.next.prev = null;
                    head = node.next;
                }
                if (node.next == null) {
                    node.prev.next = null;
                    tail = node.prev;
                }
            }
        }
        count--;
        return true;

    }

    public boolean removeByIndex(int index) {
        Node<T> node = getNodeByIndex(index);
        return removeByNode(node);
    }
    public boolean removeByValue(T value) {
        Node<T> node = getNodeByValue(value);
        return removeByNode(node);
    }


//    public int indexOf(T value) {
//        int index = 0;
//        Node node = head;
//        while (node != null) {
//            if (value.equals(node.value)) break;
//            node = node.next;
//        }
//        return node;
//
//    }


    public Node<T> getNodeByIndex(int index) {
        checkIndex(index);
        Node<T> node ;

        if (index <= count/2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = count-1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;

    }

    public Node<T> getNodeByValue(T value) {
        Node node = head;
        while (node != null) {
            if (value.equals(node.value)) break;
            node = node.next;
        }
        return node;
    }



    class Node <T> {
        Node<T> prev;
        Node<T> next;
        T value;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = data;
        }
    }



    private void printAll() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            sb.append(node.value+",");
            node = node.next;
        }
//        sb.deleteCharAt(sb.length()-1);
//        sb.delete(sb.length()-1);
//        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb);
    }






    private void checkIndexForAdd(int index) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException("");
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException("");
    }




}
