package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 2
 *
 * 출력 :         -> 사전 순, 중복x
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 4
 * 3 1
 * 3 2
 * 3 4
 * 4 1
 * 4 2
 * 4 3
 *
 * 문제 : https://www.acmicpc.net/problem/15649
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
import java.io.*;

public class N과_M_1 {
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lineArr = line.split(" ");

        int n = Integer.parseInt(lineArr[0]);
        int m = Integer.parseInt(lineArr[1]);

        // 각 원소 방문처리
        visited = new boolean[n];
        arr = new int[m];
        dfs(n,m,0);
    }

    private static void dfs(int n, int m, int depth) {
        // 종료 조건
        if(depth == m) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // dfs
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visited[i] = false;
            }
        }
    }
}
