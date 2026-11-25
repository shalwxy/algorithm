package inflearn_java_intro.sec08_recursive_tree_graph.p05_binary_tree_traversal;

public class Main {
    public static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrder(root);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ", root.val);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.printf("%d ", root.val);
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.printf("%d ", root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    }
}