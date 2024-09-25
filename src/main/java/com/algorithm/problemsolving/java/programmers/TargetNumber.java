package com.algorithm.problemsolving.java.programmers;

/**
 * [고득점 kit, 복습] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버 - dfs
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, target, 0);
    }

    // dfs
    private static int dfs(int depth, int[] numbers, int target, int sum) {
        int count = 0;

        // base code
        if(depth == numbers.length) {
            if(target == sum) {
                count ++;
            }
            return count;
        }

        count += dfs(depth+1, numbers, target, sum + numbers[depth]);
        count += dfs(depth+1, numbers, target, sum - numbers[depth]);
        return count;
    }
}
