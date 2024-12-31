package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2164
 * - 큐
 */
import java.util.*;
import java.io.*;

public class _2164 {
    // 큐
    private static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 초기 세팅
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        // 큐의 크기가 1보다 클 때까지 실행
        while(q.size() > 1) {
            // 1. 큐에 첫 원소 삭제
            q.pop();

            // 2. 그 다음 원소 맨 뒤로 보내기
            q.add(q.pop());
        }
        System.out.print(q.pop());
    }
}
