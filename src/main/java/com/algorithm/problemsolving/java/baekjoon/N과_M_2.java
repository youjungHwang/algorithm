package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 2
 *
 * 출력 :
 * 1 2
 * 1 3
 * 1 4
 *
 * 2 3
 * 2 4
 *
 * 3 4
 *
 * 문제 : https://www.acmicpc.net/problem/15650
 */
import java.io.*;

public class N과_M_2 {
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lineArr = line.split(" ");

        int n = Integer.parseInt(lineArr[0]);
        int m = Integer.parseInt(lineArr[1]);

        visited = new boolean[n];
        arr = new int[m];
        dfs(n,m,0,1);
    }

    private static void dfs(int n, int m, int depth, int start) {
        // 종료 조건
        if(depth == m) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return; // 1. 호출한 곳으로 돌아감
        }

        // dfs
        // 자신의 전 원소는 다시 방문하지 않음
        for(int i=start; i<=n; i++){
            visited[i-1] = true;
            arr[depth] = i;
            dfs(n,m,depth+1, i+1); // 2. 여기서 호출했음
            visited[i-1] = false; // 3. 이전 깊이에서 다른 숫자를 선택하기 위해 방문 취소 처리
        }
    }

}
