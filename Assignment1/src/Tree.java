import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    String data;
    Node left, right;

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(String data) {
        this.data = data;
        left = right = null;
    }
}

public class Tree {

    Node root;
    Scanner sc;

    Tree() {
        root = null;
        sc = new Scanner(System.in);
    }

    public void createTree() {

        Queue<Node> queue = new LinkedList<>();
        String data;
        System.out.println("Enter the name of city: ");
        data = sc.next();

        root = new Node(data);
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println("Enter left direction connected city of " + curr.data + " else -1 for no connected city:  ");
            String left = sc.next();
            if (!left.equals("-1")) {
                Node leftChild = new Node(left);
                curr.left = leftChild;
                queue.offer(leftChild);
            }
            System.out.println("Enter right direction connected city of " + curr.data + " else -1 for no connected city:  ");
            String right = sc.next();
            if (!right.equals("-1")) {
                Node rightChild = new Node(right);
                curr.right = rightChild;
                queue.offer(rightChild);
            }
        }
    }

    private void preOrderUtil(Node root, int level) {
        if (root != null) {
            System.out.println(root.data + " is at Level " + level);
            preOrderUtil(root.left, level + 1);
            preOrderUtil(root.right, level + 1);
        }
    }

    public void preOrder() {
        System.out.println("Preorder Traversal with Levels:");
        preOrderUtil(root, 0);
    }

    private void postOrderUtil(Node root, int level) {
        if (root != null) {
            postOrderUtil(root.left, level + 1);
            postOrderUtil(root.right, level + 1);
            System.out.println(root.data + " is at Level " + level);
        }
    }

    public void postOrder() {
        System.out.println("Postorder Traversal with Levels:");
        postOrderUtil(root, 0);
    }

    private void inOrderUtil(Node root, int level) {
        if (root != null) {
            inOrderUtil(root.left, level + 1);
            System.out.println(root.data + " is at Level " + level);
            inOrderUtil(root.right, level + 1);
        }
    }

    public void inOrder() {
        System.out.println("Inorder Traversal with Levels:");
        inOrderUtil(root, 0);
    }

    public void dfs() {
        System.out.println("DFS Traversals: 1. Inorder 2. Preorder 3. Postorder");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                inOrder();
                break;
            case 2:
                preOrder();
                break;
            case 3:
                postOrder();
                break;
            default:
                System.out.println("Select from above options....");
        }
    }

    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>(); // Queue to store levels
        queue.offer(root);
        levels.offer(0); // Root level is 0
        System.out.println("BFS Traversal with Levels:");
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int level = levels.poll();
            System.out.println(curr.data + " is at Level " + level);
            if (curr.left != null) {
                queue.offer(curr.left);
                levels.offer(level + 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                levels.offer(level + 1);
            }
        }
    }
}
