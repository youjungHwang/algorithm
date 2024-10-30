package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6
 * 10 20 10 30 20 50
 *
 * 출력 :
 * 4
 *
 * 문제 : https://www.acmicpc.net/problem/11053
 * - dp
 */
import java.util.*;
import java.io.*;

public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] parts = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // dp 선언 및 초기화
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // [주의] 자신 보다 작은 것들과 비교한다
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // int 배열 -> Integer 배열로 변환
        Integer[] dpInteger = Arrays.stream(dp).boxed().toArray(Integer[]::new);
        Arrays.sort(dpInteger, Collections.reverseOrder());
        System.out.println(dpInteger[0]);
    }
}
