package DataStruct;

import java.io.IOException;
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

    //****************************遍历********************************//
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

    //*******************************生成*****************************//
    //根据扩展二叉树的前序遍历生成二叉树
    private static Node createTreeByPre(LinkedList<String> list) {
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
            node.left = createTreeByPre(list);
            node.right = createTreeByPre(list);
        }
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
                node.left = createTreeByPostAndIn(post, postStart, postStart + i - inStart-1, in, inStart, i - 1);
                node.right = createTreeByPostAndIn(post, postStart + i - inStart , postStop - 1, in, i + 1, inStop);
                break;
            }
        }
        return node;
    }

    //*******************************工具*****************************//

    /**
     * 字符串转list
     */
    private static LinkedList<String> createList(String str) {
        LinkedList<String> a = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            a.add(String.valueOf(c));
        }
        return a;
    }

    private static LinkedList<String> list = new LinkedList<>();
    private static List<String> list1 = new ArrayList<>();
    private static List<String> list2 = new ArrayList<>();

    //************************************************************//

    public static void main(String[] args) {
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
