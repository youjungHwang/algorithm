package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets 부분집합
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 문제: https://leetcode.com/problems/subsets/description/
 * 풀이: https://lealea.tistory.com/347
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, new ArrayList<>(), nums, result);
        return result;
    }

    public List<List<Integer>> backtracking(int start, List<Integer> curr, int[] nums,
                                            List<List<Integer>> result) {
        // base case: 현재 curr 을 결과 리스트 result 에 추가한다. 처음은 []가 추가된다.
        result.add(new ArrayList<>(curr));

        // 원소 처음부터 끝까지 순회하며 add, 백트래킹, remove 를 진행한다
        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);
            // 재귀 호출을 통해 다음 원소를 추가한 부분집합을 만든다
            backtracking(i+1, curr, nums, result);
            // 부분집합에서 마지막 원소를 제거하여 다음 반복에서 다른 부분집합을 만든다
            curr.remove(curr.size()-1);
        }
        return result;
    }
}
