import java.util.ArrayList;
import java.util.List;

public class ListNode {

    //输出链表
    static void printNode(Node head) {
        if (head.next == null) {
            System.out.println(head.next);
            return;
        }

        Node node = head.next;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }


    //1.1反转链表1
    static void reverseNode1(Node head) {

        Node pre = null;
        Node cur = null;
        Node next = null;

        pre = head.next;
        //空链表情况
        if (pre == null) {
            return;
        }
        cur = pre.next;
        //链表只有一个元素的情况
        if (cur == null) {
            return;
        }
        pre.next = null;

        while (cur.next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        cur.next = pre;
        head.next = cur;
    }

    //1.1反转链表2
    static void reverseNode2(Node head) {
        if (head.next == null) {
            return;
        }

        Node cur = null;
        Node next = null;

        cur = head.next.next;
        head.next.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
    }

    //1.2去除重复节点(双循环)
    static void removeDup(Node head) {
        if (head.next == null) {
            return;
        }

        Node node1 = null;
        Node node2 = null;
        node1 = head.next;
        node2 = node1;

        if (node2.next == null) {
            return;
        }

        while (node1.next != null) {
            int a = node1.val;
            node2 = node1;
            while (node2.next != null) {
                int b = node2.next.val;
                if (a == b) {
                    node2.next = node2.next.next;
                } else {
                    node2 = node2.next;
                }
            }
            node1 = node1.next;
        }
    }

    //1.3链表求和
    static Node add(Node h1, Node h2) {
        Node head = new Node();
        Node pre = head;
        Node cur1 = h1.next;
        Node cur2 = h2.next;
        int in = 0;
        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + in;
            in=val/10;
            val=val%10;

            cur1 = cur1.next;
            cur2 = cur2.next;

            Node node = new Node();
            node.val = val;
            pre.next = node;
            pre = node;
        }


        while (cur2 != null) {
            int val = cur2.val+in;
            in=val/10;
            val=val%10;
            cur2 = cur2.next;

            Node node = new Node();
            node.val = val;
            pre.next = node;
            pre = node;
        }

        while (cur1 != null) {
            int val = cur1.val+in;
            in=val/10;
            val=val%10;
            cur1 = cur1.next;

            Node node = new Node();
            node.val = val;
            pre.next = node;
            pre = node;
        }


        //最后是否有进位
        if (in == 1) {
            Node node = new Node();
            node.val = 1;
            pre.next = node;
        }

        return head;
    }

    //1.4链表重新排序

    //数组转链表
    static Node createNode(String str) {
        Node head = new Node();
        Node pre = head;
        char[] chars = str.toCharArray();
        for (Character c : chars) {
            Node node = new Node();
            node.val = Integer.parseInt(c.toString());
            pre.next = node;
            pre = node;
        }
        return head;
    }


    public static void main(String[] args) {
//        //构造链表
//        Node head = new Node();
//        Node pre = null;
//        pre = head;
//        for (int i = 1; i < 8; i++) {
//            Node node = new Node();
//            node.val = i;
//            pre.next = node;
//            pre = node;
//        }

        Node head;
        //构造链表
        head = createNode("11235456");
        System.out.print("原始");
        printNode(head);

        System.out.print("反转");
        reverseNode1(head);
        printNode(head);

        System.out.print("反转");
        reverseNode2(head);
        printNode(head);

        System.out.print("去重复");
        removeDup(head);
        printNode(head);

        System.out.print("相加");
        Node h1 = createNode("345679");
        Node h2 = createNode("98265");
        head = add(h1, h2);
        printNode(head);


    }
}


//链表节点
class Node {
    int val = -1;
    Node next = null;
}
