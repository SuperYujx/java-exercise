package com.example.javaexercise.java_demo.demo03_collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println();
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = list.stream().mapToInt(Integer::valueOf).toArray();

        list.toArray();
        return result;
    }
}

