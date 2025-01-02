package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/11399
 */
import java.util.*;
import java.io.*;

public class _11399 {
    private static int[] arr;
    private static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 초기화
        arr = new int[n];
        String[] info = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }
        Arrays.sort(arr);

        for(int i=1; i<=n; i++) {
            greedySum(i); 
        }
        System.out.print(result);
    }

    private static void greedySum(int num) {
        int sum = 0;

        for(int i=0; i<num; i++) {
            sum += arr[i]; 
        }
        result += sum; 
    }
}
