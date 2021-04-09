package Tree;

import java.util.ArrayList;
import java.util.List;

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
        BinarySearchTree b = new BinarySearchTree();
        b.insert(10);
        b.insert(11);
        b.insert(12);
        b.insert(9);
        b.insert(2);
        b.insert(3);
        b.insert(17);
//        List inorderResult = b.inOrder();
//        System.out.println(b.preOrder());
        System.out.println(b.postOrder());

//        for (i : inorderResult) {
//            System.out.println();
//        }
//        System.out.println(inorderResult);
//        Node node_10 = b.find(10);
//        System.out.println(node_10.value);
//        System.out.println(b.find(11).value);

//        System.out.println(b.find(10).value);


    }



}
