package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10819
 * - 완전 탐색(순열)
 */
import java.util.*;
import java.io.*;

public class _10819 {
    private static int[] arr;
    private static int[] temp;
    private static int n;
    private static int Maxsum;

    // 방문 확인(방문 확인 -> 백트래킹 -> 방문 해제)
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 초기화
        arr = new int[n];
        visited = new boolean[n];
        temp = new int[n];

        String[] info = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        backtracking(0);
        System.out.print(Maxsum);
    }

    private static void backtracking(int depth) {
        // 순열 가능성 전부 확인 했으면, 계산 후 출력
        if(depth == n) {
            int sum = 0;
            for(int i=0; i<n-1; i++) {
                // 임시 저장한 순열로 계산해봄
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            Maxsum = Math.max(Maxsum, sum);
            return;
        }

        // 순열 만들기
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // 현재 생성중인 순열을 임시 저장
                temp[depth] = arr[i];
                backtracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
