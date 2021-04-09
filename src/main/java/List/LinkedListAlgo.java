package List;


/**
 * 1. 单链表反转
 * 2. 有序链表的合并
 * 3. 链表中环的检测
 * 4. 求取中间结点
 * 5. 删除倒数第k个结点
 */
public class LinkedListAlgo <T>{
    class Node <T>{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    boolean checkCircle(Node node) {
        if (node == null) return false;
        Node fast = node.next;
        Node slow = node;

        // 返回环的长度和stepCounts

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }


    Node deleteLastKth(Node node, int  k) {
        if (node == null) return null;
        int i = 1;
        Node fast = node;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) return node;

        Node slow = node;// slow就是要被删除的结点
        Node prev= null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == null) {// 正数第k个为末尾，也就是说删除开头
            node = node.next;
        }
        prev.next = prev.next.next;
        return node;
    }



//    public Node reverse(Node node) {
//        if (node == null) return null;
//
//        Node prev = null;
//        Node curr = node;
//
//        while (curr != null) {
//            Node next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//
//    }


    /**
     * class Node <T>{
     *     T value;
     *     Node next;
     * }
     */
//
//    public Node mergeTwoLists(Node node1, Node node2) {
//        Node solider = new Node(0); // 利用哨兵简化
//        Node p = solider;
//        while (node1 != null && node2 != null) {
//            if (node1.value <= node2.value) {
//                p.next = node1;
//                node1 = node1.next;
//            } else {
//                p.next = node2;
//                node2 = node2.next;
//            }
//            p = p.next; // focus
//        }
//        if (node1 != null) {p.next = node1;}
//        if (node2 != null) {p.next = node2;}
//        return solider.next;
//    }





//    public Node getMiddleNode(Node node) {
//        if (node == null) return null;
//        Node fast = node;
//        Node slow = node;
//
//        while (fast != null && fast.next != null) {// 奇数个或偶数个
//            // fast = 2 * slow
//            fast = fast.next.next; // 两格两格走
//            slow = slow.next;
//        }
//
//        return slow;
//    }




    Node reverse(Node node) {
        if (node == null || node.next == null) return null;
        Node prev = null;
        Node curr = node;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }





    // 第二遍
    Node getMiddleNode(Node node) {
        if (node == null) return null;

        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) { // fast.next 避免空指针指向
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    /**
     * 合并两有序链表：第二遍
     * @param node1
     * @param node2
     * @return
     */
    Node mergeTwoSortedLists(Node node1, Node node2) {
        Node solider = new Node(0);
        Node p = solider;

        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }

        if (node1 != null) p.next = node1;
        if (node2 != null) p.next = node2;

        return solider.next;
    }

    /**
     * 删除倒数第 k 个结点
     * @param node
     * @param k
     * @return
     */
//    public Node deleteLastKth(Node node, int k) {
//        Node fast = node;
//        int i = 1;
//
//        while (fast != null || i<k) {
//            fast = fast.next;
//            ++i;
//        }
//
//        if (fast == null) return node;
//
//        Node slow = node;
//        Node prev = null;
//
//        // fast 与 slow 距离 k-1
//        // 当fast为最后一个非null结点时，即，倒1个结点，此时slow就是倒数第k个结点
//        // 此时，通过prev.next == prev.next.next将slow删除
//        while (fast.next != null) {
//            fast = fast.next;
//            prev = slow;
//            slow = slow.next;
//        }
//
//        // 从正数，第k个为fast正好为尾结点，则删除头结点。
//        if (prev == null) {
//            node = node.next;
//        } else {
//            prev.next = prev.next.next;
//        }
//        return node;
//    }
}
