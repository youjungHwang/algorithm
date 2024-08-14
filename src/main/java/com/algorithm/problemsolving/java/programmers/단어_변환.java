package com.algorithm.problemsolving.java.programmers;

import java.util.*;

/**
 * [고득점 kit] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 단어 변환 - bfs
 * input :
 *   begin : "hit"
 *   target : "cog"
 *   words : ["hot", "dot", "dog", "lot", "log", "cog"]
 *
 * output : 4
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class 단어_변환 {
    private static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        // target이 words 배열에 없으면 바로 0을 반환
        boolean flag = false;
        for(String word : words){
            if(target.equals(word)){
                flag = true;
                break;
            }
        }

        if(!flag) {
            return 0;
        }

        return bfs(begin, target, words);
    }

    public static int bfs(String begin, String target, String[] words) {
        // 큐 생성
        Queue<String> q = new ArrayDeque<>();
        // 시작 단어를 큐에 추가
        q.add(begin);
        // 방문 확인 배열 초기화
        visited = new boolean[words.length];
        // 최소 단계 변수 초기화
        int steps = 0;

        // 큐가 빌때까지 확인
        while(!q.isEmpty()) {
            // 큐에서 하나의 단어를 꺼냄
            String curr = q.poll();

            // 현재 단어가 target과 같으면 steps 반환
            if(curr.equals(target)){
                return steps;
            }

            for(int i = 0; i < words.length; i++){
                // 방문하지 않았고, curr 단어와 하나의 글자만 다른 경우
                if(!visited[i] && checkWords(curr, words[i])){
                    visited[i] = true;
                    q.add(words[i]);
                }
            }
            // [주의] 큐에서 꺼낸 단어와 words 배열의 모든 단어와 비교한 후, steps 증가
            steps += 1;
        }
        
        return 0;
    }

    // 두 단어가 정확히 한 글자만 다른지 확인하는 메서드
    public static boolean checkWords(String curr, String word) {
        int diffCount = 0;

        // 두 단어의 길이는 항상 같음
        int wordLength = curr.length();
        for(int i=0; i<wordLength; i++) {
            if(curr.charAt(i) != word.charAt(i)) {
                diffCount += 1;
            }

            if(diffCount > 1){
                return false;
            }
        }
        // 다른 글자가 정확히 1개일 때만 true 반환
        return diffCount == 1;
    }

}
