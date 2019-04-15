package DataStruct;

import java.util.*;

public class Tree {
    //二叉树的结点
    static public class Node {
        String data;//结点值
        Node left;//左子树结点
        Node right;//右子树结点

        Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    //前序遍历
    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    private static void infixOrder(Node node) {
        if (node == null) {
            return;
        }
        infixOrder(node.left);
        System.out.print(node.data);
        infixOrder(node.right);

    }

    //后序遍历
    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    //根据扩展二叉树的前序遍历生成二叉树(键盘输入)
    private static Node createTreeByPre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入结点：");
        String data = scanner.nextLine();
        if (data.equals("*")) {
            return null;
        }
        Node node = new Node(null, null, null);
        node.data = data;
        node.left = createTreeByPre();
        node.right = createTreeByPre();
        return node;
    }

    //根据扩展二叉树的前序遍历生成二叉树(传入数组)
    private static Node createTreeByPre(String[] pre) {
        String data = pre[0];
        System.arraycopy(pre, 1, pre, 0, pre.length - 1);
        if (data.equals("*")) {
            return null;
        }
        Node node = new Node(null, null, null);
        node.data = data;
        node.left = createTreeByPre(pre);
        node.right = createTreeByPre(pre);
        return node;
    }

    //根据前序、中序遍历生成二叉树
    private static Node createTreeByPreAndIn(String[] pre, int preStart, int preStop, String[] in, int inStart, int inStop) {
        if (preStart > preStop || inStart > inStop) {
            return null;
        }
        Node node = new Node(null, null, null);
        node.data = pre[preStart];
        for (int i = inStart; i <= inStop; i++) {
            if (in[i].equals(pre[preStart])) {
                node.left = createTreeByPreAndIn(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                node.right = createTreeByPreAndIn(pre, preStart + i - inStart + 1, preStop, in, i + 1, inStop);
                break;
            }
        }
        return node;
    }

    //根据后序、中序遍历生成二叉树
    private static Node createTreeByPostAndIn(String[] post, int postStart, int postStop, String[] in, int inStart, int inStop) {
        if (postStart > postStop || inStart > inStop) {
            return null;
        }
        Node node = new Node(null, null, null);
        node.data = post[postStop];
        for (int i = inStart; i <= inStop; i++) {
            if (in[i].equals(post[postStop])) {
                node.left = createTreeByPostAndIn(post, postStart, postStart + i - inStart - 1, in, inStart, i - 1);
                node.right = createTreeByPostAndIn(post, postStart + i - inStart, postStop - 1, in, i + 1, inStop);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Node n1 = new Node("G", null, null);
        Node n2 = new Node("H", null, null);
        Node n3 = new Node("D", n1, n2);
        Node n4 = new Node("B", n3, null);
        Node n5 = new Node("I", null, null);
        Node n6 = new Node("E", null, n5);
        Node n7 = new Node("F", null, null);
        Node n8 = new Node("C", n6, n7);
        Node n9 = new Node("A", n4, n8);
        System.out.println("中序遍历");
        infixOrder(n9);
        System.out.println("\n前序遍历");
        preOrder(n9);
        System.out.println("\n后序遍历");
        postOrder(n9);

        System.out.println("\n\n扩展二叉树前序遍历生成二叉树");
        String[] arr = {"a", "b", "*", "d", "*", "*", "c", "*", "*"};
        Node tree = createTreeByPre(arr);
        preOrder(tree);
        System.out.println("\n扩展二叉树前序遍历生成二叉树");
        tree = createTreeByPre();
        preOrder(tree);

        String[] pre = {"1", "2", "3", "4", "5", "6", "7"};
        String[] in = {"3", "2", "4", "1", "6", "5", "7"};
        String[] post = {"3", "4", "2", "6", "7", "5", "1"};
        System.out.println("\n\n根据前序、中序遍历生成二叉树");
        tree = createTreeByPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
        postOrder(tree);
        System.out.println("\n根据后序、中序遍历生成二叉树");
        tree = createTreeByPostAndIn(post, 0, post.length - 1, in, 0, in.length - 1);
        preOrder(tree);


    }
}
