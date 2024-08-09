package com.algorithm.problemsolving.java.programmers;

/**
 * [고득점 kit] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
 * 완전탐색, dfs 활용
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int currentSum, int step){
        // 반환할 값
        int count = 0;

        // base code : 만약 현재 단계와 numbers 배열의 길이가 같다면 숫자를 모두 확인한 것 +
        // 현재까지 계산한 값과 target이 같다면 count + 1, 다르면 기존 count 반환
        if(step == numbers.length){
            if(currentSum == target){
                count++;
                return count;
            }else{
                return count;
            }
        }

        // numbers 배열의 원소를 더하거나 빼는 두 가지 경우를 모두 dfs탐색, 다음 단계로 넘어감 step +1
        return dfs(numbers, target, currentSum + numbers[step], step + 1) +
        dfs(numbers, target, currentSum - numbers[step], step + 1);
    }
}
