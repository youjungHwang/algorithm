package com.algorithm.problemsolving.java.programmers;

/**
 * [문자열] 코딩테스트 연습 > 연습문제 > 자연수 뒤집어 배열로 만들기
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        // substring으로 문자열 조작을 위해 long -> String
        String str = String.valueOf(n);

        // "12345" -> [1,2,3,4,5]
        int[] arr = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 배열을 하나 더 만들어서 거꾸로 삽입
        int[] answer = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            answer[i] =  arr[str.length() - 1 - i];
        }
        return answer;
    }
}
