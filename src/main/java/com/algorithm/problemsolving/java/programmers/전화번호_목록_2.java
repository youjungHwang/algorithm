package com.algorithm.problemsolving.java.programmers;

import java.util.*;
/**
 * [고득점 kit] 코딩테스트 연습 > 해시 > 전화번호 목록 -> 정렬로 풀이
 *
 * input : ["119", "97674223", "1195524421"]
 * output : false
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호_목록_2 { // 시간복잡도 : O(nlogn + n * m )
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // phone_book 정렬
        // O(nlogn)
        Arrays.sort(phone_book);

        // for문을 돌면서 직후 요소가 직전 접두어로 시작하는지 확인
        // O(n * m) (n: 배열의 길이, m: 전화번호 길이)
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                // 하나 찾으면 종료
                break;
            }
        }
        return answer;
    }

}
