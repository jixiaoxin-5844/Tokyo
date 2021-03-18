package com.hyt.punchapp;

import org.junit.Test;

import java.util.LinkedList;

public class LeetCode3 {

    @Test
    public void add() {
        LinkedList linkedList = new LinkedList<String>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");



        //打印此时的链表
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("当前节点" + i + ":" + linkedList.get(i));
        }

        //开始反转
        System.out.println("开始反转 left:" + 2 + ",right:" + 4);
        // 反转为12543

        String nn;
        for (int i = 0; i < 4 - 2; i++) {

        }

        //打印此时的链表
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("第一次打印,当前节点" + i + ":" + linkedList.get(i));
        }

    }


    public ListNode a(ListNode listNode, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = listNode;
        ListNode superior = dummyHead;

        // 1. 遍历至m的前一个节点
        for (int i = 1; i < left; i++) {
            superior = superior.next;
        }


        ListNode prev = null;
        //此时 superior = left 的前一个结点
        // superior.next就是要开始遍历的节点
        ListNode cur = superior.next;

        // 2. 180°旋转爆炸   1 2 3 4 5 6
        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;

            //开始循环        第一次循环结束后的值     第二次      第三次
            //cur = 3                   4              5          6
            //cur.next = 4              5              6          null
            //prev = null;              3              4          5
            //prev.next = null          null           4          4

        }

        // 3. 修改m和n-m位置处的节点的指向
        superior.next.next = cur;
        superior.next = prev;
        return dummyHead.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
