package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4                -> 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수
 * aba
 * abab
 * abcabc
 * a
 *
 * 출력 :
 * 1
 *
 * 문제 : https://www.acmicpc.net/problem/1316
 */
import java.io.*;

public class 그룹_단어_체커 {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<n; i++) {
            String word = br.readLine();
            if(isGroupWord(word)) {
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean isGroupWord(String word) {
        // 알파벳 a-z
        boolean[] visited = new boolean[26];
        // 이전 문자
        char prev = 0;

        for(char curr : word.toCharArray()) {
            if(prev != curr) {
                if(visited[curr - 'a']) {
                    return false;
                }
                // 방문 처리
                visited[curr - 'a'] = true;
            }
            // 이전 문자 업데이트
            prev = curr;
        }
        return true;
    }
}
