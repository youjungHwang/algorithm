package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * ACAYKP
 * CAPCAK
 *
 * 출력 :
 * 4
 *
 * 문제 : https://www.acmicpc.net/problem/9251
 */
import java.util.*;
import java.io.*;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int firstSize = first.length();
        int secondSize = second.length();

        // dp 선언 및 초기화
        int[][] dp = new int[firstSize + 1][secondSize + 1];

        for(int i=0; i<firstSize; i++) {
            Arrays.fill(dp[i],0);
        }

        for(int i=1; i<=firstSize; i++) {
            for(int j=1; j<=secondSize; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[firstSize][secondSize]);
    }
}
