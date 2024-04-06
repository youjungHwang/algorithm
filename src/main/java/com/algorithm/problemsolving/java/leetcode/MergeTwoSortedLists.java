package com.algorithm.problemsolving.java.leetcode;

/**
 * 21. Merge Two Sorted Lists
 *
 * 문제: https://leetcode.com/problems/merge-two-sorted-lists/
 * 해설: https://lealea.tistory.com/318
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {
    public ListNode  mergeTwoLists(ListNode list1, ListNode list2) {
        // 더미 노드 생성
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // list1 또는 list2 중 하나가 먼저 끝났을 경우, 나머지 리스트 연결
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // 더미 노드의 다음 노드를 반환
        return dummy.next;
    }
}


