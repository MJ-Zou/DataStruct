import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tree {

    /**
     * 定义二叉树的结点
     */
    static public class Node {
        String data;//结点值
        Node leftChild;//左子树结点
        Node rightChild;//右子树结点

        Node(String data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    //****************************遍历********************************//

    /**
     * 前序遍历
     */
    private static void preOrder(Node node) {
        System.out.print(node.data);
        if (node.leftChild != null) {
            preOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    private static void infixOrder(Node node) {
        if (node.leftChild != null) {
            infixOrder(node.leftChild);
        }
        System.out.print(node.data);
        if (node.rightChild != null) {
            infixOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    private static void postOrder(Node node) {
        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }
        System.out.print(node.data);
    }

    //*******************************生成*****************************//

    /**
     * 根据扩展二叉树的前序遍历生成二叉树
     */
    private static Node createTreeByPre(LinkedList<String> list) throws IOException {
        Node node = new Node(null, null, null);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入结点：");
//        String data = scanner.nextLine();
        String data = list.getFirst();
        list.removeFirst();
        if (data.equals("*")) {
            node = null;
            // createTreeByPre();
        } else {
            node.data = data;
            node.leftChild = createTreeByPre(list);
            node.rightChild = createTreeByPre(list);
            return node;
        }
        return node;

    }

    /**
     * 根据前序、中序遍历生成二叉树
     */
    private static Node createTreeByPreAndIn(List<String> pre, List<String> in) {
        Node node = new Node(null, null, null);
        if (pre.isEmpty() || in.isEmpty()) {
            return null;
        }
        node.data = pre.get(0);
        int i = in.indexOf(node.data);
        pre.remove(0);
        if (i == -1) {
            node.leftChild = null;
        } else {
            node.leftChild = createTreeByPreAndIn(pre, in.subList(0, i));
        }
        node.rightChild = createTreeByPreAndIn(pre, in.subList(i + 1, in.size()));
        return node;
    }

    /**
     * 根据后序、中序遍历生成二叉树
     */
    private static Node createTreeByPostAndIn(List<String> post, List<String> in) {
        Node node = new Node(null, null, null);
        if (post.isEmpty() || in.isEmpty()) {
            return null;
        }
        node.data = post.get(post.size() - 1);
        int i = in.indexOf(node.data);
        post.remove(post.size() - 1);
        node.rightChild = createTreeByPostAndIn(post, in.subList(i + 1, in.size()));
        if (i == -1) {
            node.leftChild = null;
        } else {
            node.leftChild = createTreeByPostAndIn(post, in.subList(0, i));
        }
        return node;
    }


    //*******************************工具*****************************//

    /**
     * 字符串转list
     */
    static LinkedList<String> createList(String str) {
        LinkedList<String> a = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            a.add(String.valueOf(c));
        }
        return a;
    }

    static LinkedList<String> list = new LinkedList<>();
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();

    //************************************************************//

    public static void main(String[] args) throws IOException {
        //*********手动创建一棵树********
        Node n1 = new Node("G", null, null);
        Node n2 = new Node("H", null, null);
        Node n3 = new Node("D", n1, n2);
        Node n4 = new Node("B", n3, null);
        Node n5 = new Node("I", null, null);
        Node n6 = new Node("E", null, n5);
        Node n7 = new Node("F", null, null);
        Node n8 = new Node("C", n6, n7);
        Node n9 = new Node("A", n4, n8);

        //************遍历函数************
        System.out.println("中序遍历");
        infixOrder(n9);

        System.out.println("\n前序遍历");
        preOrder(n9);

        System.out.println("\n后序遍历");
        postOrder(n9);

        //*************建立函数************
        System.out.println("\n\n扩展二叉树前序遍历生成二叉树");
        list = createList("ab*d**c**");
        Node tree = createTreeByPre(list);
        preOrder(tree);
        System.out.println();
        infixOrder(tree);
        System.out.println();
        postOrder(tree);

        System.out.println("\n\n根据扩前序、中序遍历生成二叉树");
        list1 = createList("1234567");
        list2 = createList("3241657");
        tree = createTreeByPreAndIn(list1, list2);
        preOrder(tree);
        System.out.println();
        infixOrder(tree);
        System.out.println();
        postOrder(tree);

        System.out.println("\n\n根据后序、中序遍历生成二叉树");
        list1 = createList("cbefda");
        list2 = createList("cbaedf");
        tree = createTreeByPostAndIn(list1, list2);
        preOrder(tree);
        System.out.println();
        infixOrder(tree);
        System.out.println();
        postOrder(tree);

        int[]a=new int[10];




    }
}
