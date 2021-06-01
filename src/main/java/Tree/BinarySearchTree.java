package Tree;

import java.util.*;

public class BinarySearchTree {
    private Node root ;
    public List<Integer> postOrder() {
        Node p = root;
        List<Integer> result = new ArrayList<>();
        postOrderI(p, result);
        return result;

    }
    private void postOrderI(Node node, List<Integer> result) {
        if (node.left != null) {
            postOrderI(node.left, result);
        }
        if (node.right != null) {
            postOrderI(node.right, result);
        }
        result.add(node.value);
    }



    public List<Integer> preOrder() {
        Node p = root;
        List<Integer> result = new ArrayList<>();
        preOrderI(p, result);
        return result;
    }


    private void preOrderI(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.value);

        if (node.left != null) {
            preOrderI(node.left, result);
        }

        if (node.right != null) {
            preOrderI(node.right, result);
        }
    }



    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderI(root, result);
        return result;
    }


    private void inOrderI(Node node, List<Integer> result) {
        if (node == null) return;

        if (node.left != null) {
            inOrderI(node.left, result);
        }
        result.add(node.value);
        if (node.right != null) {
            inOrderI(node.right, result);
        }


    }




    public Node find(int value) {
        Node p = root;

        if (p == null) return null;


        if (value == p.value) {
            return p;
        } else if (value <= p.value) {
            return find(p.left, value);
        } else {
            return find(p.right, value);
        }
    }

    private Node find(Node node, int value) {
        if (node == null) return null;
        if (node.value == value) return node;

        if (value <= node.value) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value, null, null);
            return;
        }
        insert(root, value);
    }
    private void insert(Node fatherNode, int value) {
        if (value <= fatherNode.value) {
            if (fatherNode.left == null) {
                fatherNode.left = new Node(value, null, null);
            } else {
                insert(fatherNode.left, value);
            }
        } else {
            if (fatherNode.right == null) {
                fatherNode.right = new Node(value, null, null);
            } else {
                insert(fatherNode.right, value);
            }
        }
    }

    static class Utils {
        public static String bfs(Node root) {
            StringBuilder sb = new StringBuilder();
            Queue<Node> queue = new LinkedList();
            queue.offer(root);
            while (! queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                sb.append(node.value+"、");
            }
            return sb.toString();
        }
        // 搜索,非遍历
        public static String dfs(Node root) {
            StringBuilder sb = new StringBuilder();
            LinkedList<Node> stack = new LinkedList<>();
            stack.push(root);
            while (! stack.isEmpty()) {
                Node node = stack.pop();
                sb.append(node.value+"、");
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return sb.toString();
        }

    }


    class Node {
        int value;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.value = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(9);
        tree.insert(2);
        tree.insert(3);
        tree.insert(17);
        System.out.println("bfs: " + BinarySearchTree.Utils.bfs(tree.root));
//        System.out.println("dfs: " + BinarySearchTree.Utils.dfs(tree.root));


    }



}
