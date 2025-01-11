package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2439
 */
import java.util.*;
import java.io.*;

public class _2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {

            StringBuilder sb = new StringBuilder();
            // n-i 만큼 공백을 생성한다.
            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            System.out.println(sb);
        }
    }
}
