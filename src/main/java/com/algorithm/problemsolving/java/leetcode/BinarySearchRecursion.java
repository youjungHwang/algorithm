package com.algorithm.problemsolving.java.leetcode;

/**
 * 704. Binary Search(이진 탐색) - 재귀 사용
 *
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 문제: https://leetcode.com/problems/binary-search/description/
 * 풀이: https://lealea.tistory.com/349
 */
public class BinarySearchRecursion {
    public int search(int[] nums, int target) {
        // leftIndex와 rightIndex 인덱스를 각각 0과 nums.length - 1로 설정
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        // 백트래킹 호출
        int result = backtracking(nums, target, leftIndex, rightIndex);
        return result;
    }

    public int backtracking(int[] nums, int target, int leftIndex, int rightIndex) {
        // 중간 인덱스 계산
        int midIndex = (leftIndex + rightIndex) / 2;

        // base case : leftIndex가 rightIndex보다 크면 -1 반환
        if (leftIndex > rightIndex) return -1;

        // target이 중간 값과 같으면 해당 인덱스 반환
        if (nums[midIndex] == target) {
            return midIndex;
        }
        // target이 중간 값보다 작으면 왼쪽 부분 탐색
        else if (nums[midIndex] > target) {
            return backtracking(nums, target, leftIndex, midIndex - 1);
        }
        // target이 중간 값보다 크면 오른쪽 부분 탐색
        else {
            return backtracking(nums, target, midIndex + 1, rightIndex);
        }
    }
}
