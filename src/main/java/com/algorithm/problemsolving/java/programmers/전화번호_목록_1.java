package com.algorithm.problemsolving.java.programmers;

import java.util.*;
/**
 * [고득점 kit] 코딩테스트 연습 > 해시 > 전화번호 목록 -> HashMap으로 풀이
 *
 * input : ["119", "97674223", "1195524421"]
 * output : false
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호_목록_1 { // 시간복잡도 : O(m^2)
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 해시맵 선언 및 초기화
        // 키(전화번호) : 값(1)
        Map<String, Integer> phoneMap = new HashMap<>();
        // O(n)
        for(String number : phone_book) {
            phoneMap.put(number, 1);
        }

        // phone_book의 각 전화번호가 다른 번호의 접두어인지 확인
        // O(n)
        for(String number : phone_book) {
            // 최대 O(m) (m은 전화번호의 길이)
            for(int i=0; i<number.length(); i++){
                if(phoneMap.containsKey(number.substring(0,i))){
                    answer = false;
                }
            }
        }
        return answer;
    }
}
