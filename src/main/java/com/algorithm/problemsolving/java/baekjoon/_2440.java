package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2440
 */
import java.util.*;
import java.io.*;

public class _2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=n-i; j>=1; j--) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}

