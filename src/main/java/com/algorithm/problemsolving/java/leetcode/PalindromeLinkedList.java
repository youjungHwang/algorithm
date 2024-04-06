package com.algorithm.problemsolving.java.leetcode;

import java.util.*;
/**
 * 234. Palindrome Linked List
 *
 * 문제: https://leetcode.com/problems/palindrome-linked-list/
 * 해설: https://lealea.tistory.com/317
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new ArrayDeque<>();

        ListNode node = head;
        while (node != null) {
            dq.add(node.val);
            node = node.next;
        }

        node = head;

        while (!dq.isEmpty()) {
            if(dq.removeLast() != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
