package com.algorithm.problemsolving.java.leetcode;

/**
 * 704. Binary Search(이진 탐색) - 반복문 사용
 *
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 문제: https://leetcode.com/problems/binary-search/description/
 * 풀이: https://lealea.tistory.com/349
 */
public class BinarySearchLoop {
    public int search(int[] nums, int target) {
        // leftIndex와 rightIndex 인덱스를 각각 0과 nums.length - 1로 설정
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        // leftIndex가 rightIndex보다 작거나 같을 때까지 while문을 돈다
        while(leftIndex <= rightIndex){
            // 중간 인덱스를 계산
            int midIndex = (leftIndex + rightIndex) / 2;

            // target이 중간 값과 같다면 해당 인덱스를 반환
            if(nums[midIndex] == target) {
                return midIndex;
                // target이 중간 값보다 작다면 rightIndex를 중간 인덱스보다 하나 작은 값으로 설정
            } else if(nums[midIndex] > target){
                rightIndex = midIndex - 1;
                // target이 중간 값보다 크다면 leftIndex를 중간 인덱스보다 하나 큰 값으로 설정
            } else {
                leftIndex = midIndex + 1;
            }
        }
        // target을 찾지 못한 경우 -1을 반환
        return -1;
    }
}
