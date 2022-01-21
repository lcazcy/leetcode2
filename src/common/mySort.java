package common;


import java.util.LinkedList;
import java.util.Queue;

public class mySort {

    // 层次遍历
    public static void levelOrder(TreeNode root){
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            TreeNode current = null;
            queue.offer(root);//将根节点入队
            while (!queue.isEmpty()) {
                current = queue.poll();//出队队头元素并访问
                System.out.printf("%d\t",current.val);
                if (current.left != null)//如果当前节点的左节点不为空入队
                {
                    queue.offer(current.left);
                }
                if (current.right != null)//如果当前节点的右节点不为空，把右节点入队
                {
                    queue.offer(current.right);
                }
            }
        }
    }

    // 先序遍历输出
    public static void preOrder(TreeNode root){
        if(root != null){
            System.out.printf("%4d",root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 中序遍历输出
    public static void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.printf("%4d",root.val);
            inorder(root.right);
        }
    }

    // 后续遍历输出
    public static void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            System.out.printf("%4d",root.val);
            postOrder(root.right);
        }
    }

    // 遍历链表
    public static void showLinkedList(ListNode L){
        ListNode node = L;
        while(node != null) {
            System.out.printf("%d\t", node.val);
            node = node.next;
        }
        System.out.println();
    }

    // 链表反转
    public static ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



}
