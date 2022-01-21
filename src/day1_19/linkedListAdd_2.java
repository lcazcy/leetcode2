package day1_19;

import common.ListNode;
import common.mySort;
import org.junit.Test;

/**
 * 两数相加：
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class linkedListAdd_2 {

    @Test
    public void test(){
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(3,node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode l1 = new ListNode(5, node1);
        mySort.showLinkedList(l1);

        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5,node4);
        ListNode l2 = new ListNode(4, node5);
        mySort.showLinkedList(l2);

        ListNode head = addTwoNumbers(l1, l2);

        System.out.println("-----------------");
        mySort.showLinkedList(head);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null;    // 头指针
        ListNode tail = null;    // 尾指针
        int carry = 0; // 进位

        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;   // l1 待加数
            int n2 = l2 != null ? l2.val : 0;   // l2 待加数
            int sum = n1 + n2 + carry;          // 和

            if(head == null){
                tail = new ListNode(sum % 10);
                head = tail; // 对十取余，保证个位数，大于十则进位
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;  // 判断是否需要进位

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){    // carry大于零 说明 需要进位 ，创建新节点
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
