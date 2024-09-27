package com.algorithm.problemsolving.java.programmers;

import java.util.*;
/**
 * [고득점 kit] 코딩테스트 연습 > 해시 > 완주하지 못한 선수
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // participant -> {이름 : 출현 횟수}
        Map<String, Integer> hashMap = new HashMap<>();
        for(String person : participant) {
            hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
        }

        for(int i=0; i<completion.length; i++) {
            if(hashMap.containsKey(completion[i])) {
                int value = hashMap.get(completion[i]);
                value -= 1;
                hashMap.put(completion[i], value);
            }
        }

        // value가 0이 아닌 사람을 반환
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
