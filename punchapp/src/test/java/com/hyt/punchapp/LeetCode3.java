package com.hyt.punchapp;

import org.junit.Test;

import java.util.LinkedList;

public class LeetCode3 {


    // 反转 2  -  4 的 位置
    //  1   2  3  4  5  6
    //  1   2  5  4  3  6
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //TODO 此时 (pre = 2  next = 3)

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //TODO 此时  (rightNode = 5  next = 6)

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        //TODO 此时 ( leftNode = 3  next = 4)  (curr = 6 next = null)

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;
        //TODO 此时 (pre = 2  next = null)
        //TODO 此时 (rightNode = 5  next = null)

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);
        //TODO 反转后   1  2   (3 next = null)  4  (5 next = null)  6
        //TODO 反转后    ( leftNode = 3  next = null)

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        //TODO  pre 2  next = 5
        leftNode.next = curr;
        //TODO  leftNode 3  next = 6
        return dummyNode.next;
    }

    //    3  4  5
    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // (cur = 4 next = 5)  (pre = 3 next = null)
        // (cur = 5 next = null)  (pre = 4 next = (pre = 3 next = null))

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
        superior.next.next = cur;                                  //cur 6 next  6
        superior.next = prev;                                      //5    next  4
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
