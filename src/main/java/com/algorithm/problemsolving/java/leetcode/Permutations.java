package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations 순열
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 문제: https://leetcode.com/problems/permutations/description/
 * 풀이: https://lealea.tistory.com/347
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtracking(new ArrayList<>(), nums, resultList);
        return resultList;
    }

    public List<List<Integer>> backtracking(List<Integer> curr, int[] nums,
                                            List<List<Integer>> resultList) {
        // base case: curr의 길이가 nums의 길이와 같다면 resultList에 현재 순열을 추가한다
        if (curr.size() == nums.length) {
            resultList.add(new ArrayList<>(curr));
        }

        // 백트래킹 처음 원소부터 마지막 원소까지 순회하며 add, 백트래킹, remove 진행한다
        for (int num : nums) {
            // 현재 접근한 원소가 curr에 없다면 해당 원소를 add 한다
            if (!curr.contains(num)) {
                curr.add(num);
                backtracking(curr, nums, resultList);
                // curr에 가장 최근에 접근한 원소를 제거한다
                curr.remove(curr.size() - 1);
            }
        }
        return resultList;
    }
}
