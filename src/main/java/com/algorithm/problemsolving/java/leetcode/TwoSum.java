package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;

/**
 * 1. Two Sum
 *
 * 문제: https://leetcode.com/problems/two-sum/description/
 * 풀이: https://lealea.tistory.com/345
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return backtracking(nums, target, 0, new ArrayList<Integer>());
    }

    public int[] backtracking(int[] nums, int target, int start, ArrayList<Integer> ans) {
        // base case: ans에 원소가 2개가 들어가 있다면,
        if (ans.size() == 2) {
            // 두 원소의 합이 target이면 ans를 반환하고, 그렇지 않으면 null을 반환한다
            if (nums[ans.get(0)] + nums[ans.get(1)] == target) {
                return new int[]{ans.get(0), ans.get(1)};
            }
            return null;
        }

        // 인덱스 0부터 끝까지 순회한다
        for (int i = start; i < nums.length; i++) {
            // ans에 인덱스 i를 추가한다.
            ans.add(i);
            // 재귀 함수를 호출한다.
            int[] result = backtracking(nums, target, i + 1, ans);
            // 반환값이 존재하면 그 반환값을 반환한다.
            if (result != null) {
                return result;
            }
            // 반환값이 false이면 ans에서 해당 인덱스를 제거한다.
            ans.remove(ans.size() - 1);
        }
        return null;
    }
}

