package Tree;

public class RBTree {
    private final int R = 0;
    private final int B = 1;

    private final Node nil = new Node(-1);
    private Node root = nil;


    private class Node {

        int key = -1, color = B;
        Node left = nil, right = nil, p = nil;

        Node(int key) {
            this.key = key;
        }
    }

    void rotateLef(Node node) {
        if (node.p != nil) {
            if (node == node.p.left) {
                node.p.left = node.right;
            } else {
                node.p.right = node.right;
            }
            node.right.p = node.p;
            node.p = node.right;
            if (node.right.left != nil) {
                node.right.left.p = node;
            }
            node.right = node.right.left;// 注意，此处的node.right变了，因此不能在使用node.right
            node.p.left = node;
        } else {
            node.right.p = nil;
            root = node.right;
            node.p = node.right;

            if (node.right.left != nil) {
                node.right.left.p = node;
            }
            node.right = node.right.left;// 注意，此处的node.right变了，因此不能在使用node.right
            node.p.left = node;

        }


    }

}
