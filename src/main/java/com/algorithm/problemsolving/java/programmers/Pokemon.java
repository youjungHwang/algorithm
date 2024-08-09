package com.algorithm.problemsolving.java.programmers;

import java.util.*;

/**
 * [고득점 kit] 코딩테스트 연습 > 해시 > 폰켓몬
 *
 * input: [3,1,2,3] -> 2마리 고를 수 있음
 * output : 중복 제거 [3,1,2] => 2종류 가져갈 수 있음
 *
 * input: [3,3,3,2,2,4] -> 3마리 고를 수 있음
 * output: 중복 제거 [3,2,4] => 3종류 가져갈 수 있음
 *
 * input : [3,3,3,2,2,2] -> 3마리 고를 수 있음
 * output: 중복 제거 [3,2] -> 2종류 가져갈 수 있음
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
 */
public class Pokemon {
    public int solution(int[] nums) {
        // 몇 마리 고를 수 있는지 : pick
        int pick = nums.length / 2;

        // 중복 제거 : distinctNums, 시간복잡도 O(n)
        Set<Integer> distinctNums = new HashSet<>();
        for (int num : nums) {
            distinctNums.add(num);
        }

        if(pick < distinctNums.size() || pick == distinctNums.size()){
            return pick;
        }else {
            return distinctNums.size();
        }
    }
}
