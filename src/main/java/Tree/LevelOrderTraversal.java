package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void levelOrderTraversal(Node root) {
        Deque<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (queue.size() != 0) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(16);
//        root.left.left = new Node(17);
//        root.left.right = new Node(18);
//        root.right.left = new Node(19);
//        root.right.right = new Node(20);
        levelOrderTraversal(root);

    }



}
