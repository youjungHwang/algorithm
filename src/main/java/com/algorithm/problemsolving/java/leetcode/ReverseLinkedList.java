package com.algorithm.problemsolving.java.leetcode;

/**
 * 206. Reverse Linked List
 *
 * 문제: https://leetcode.com/problems/reverse-linked-list/description/
 * 해설: https://lealea.tistory.com/319
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        // 리스트의 끝까지 반복
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;  // 현재 노드의 다음을 이전 노드로 설정 (역방향)
            prev = current;  // 이전 노드를 현재 노드로 이동
            current = next;  // 현재 노드를 다음 노드로 이동
        }

        // 마지막엔 prev가 새로운 헤드가 됨
        return prev;
    }
}
