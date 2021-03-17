package com.hyt.punchapp;

import java.util.LinkedList;

public class LeetCode2 {


    public void a(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("cs");
        linkedList.addLast("aa");
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

