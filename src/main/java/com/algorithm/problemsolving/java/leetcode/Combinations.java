package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations 조합
 *
 * Example:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * 문제: https://leetcode.com/problems/combinations/description/
 * 풀이: https://lealea.tistory.com/347
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, new ArrayList<>(), n, k, result);
        return result;
    }

    public List<List<Integer>> backtracking(int start, List<Integer> curr, int n, int k,
                                            List<List<Integer>> result){
        // base case: curr의 길이가 k와 같으면 현재 조합을 결과 리스트 result 에 추가한다
        if(curr.size() == k) {
            // 현재 조합의 복사본을 추가한다
            result.add(new ArrayList<>(curr));
        }

        // 1부터 n까지 순회하면서 curr에 숫자를 추가하고, 백트래킹을 통해 조합 생성, 삭제를 진행한다.
        for(int i=start; i<=n; i++){
            curr.add(i);
            // [start를 사용하는 이유] 다음 백트래킹을 호출 한다 (i+1을 넘겨줌으로써 중복 방지)
            backtracking(i+1, curr, n, k, result);
            // curr에 가장 최근에 접근한 원소를 제거한다
            curr.remove(curr.size()-1);
        }
        return result;
    }
}
