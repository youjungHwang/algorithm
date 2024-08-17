package com.algorithm.problemsolving.java.programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [문자열] 코딩테스트 연습 > 연습문제 > 자연수 뒤집어 배열로 만들기
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        // 인덱싱을 쉽게 하기 위해 문자열로 변환
        String str = String.valueOf(n);

        int[] answer = new int[str.length()];
        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i=0; i<str.length(); i++){
            arrList.add(Integer.parseInt(str.substring(i, i+1)));
        }

        // 뒤집기
        Collections.reverse(arrList);

        // ArrayList -> int[] 배열로 변환
        for(int i=0; i<str.length(); i++){
            // 배열은 인덱스로 넣음
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}
