package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2438
 */
import java.util.*;
import java.io.*;

public class _2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            // 별을 i개 출력한다
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<=i; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}
