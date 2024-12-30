package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/5597
 * - 배열
 */
import java.util.*;
import java.io.*;

public class _5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열
        int[] arr = new int[31];
        Arrays.fill(arr,0);

        for(int i=0; i<28; i++) {
            int info = Integer.parseInt(br.readLine());
            arr[info] = 1;
        }

        for(int i=1; i<=30; i++) {
            if(arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
