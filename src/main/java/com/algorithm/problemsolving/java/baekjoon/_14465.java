package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/14465
 * - 누적합 배열
 */
import java.util.*;
import java.io.*;

public class _14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        // 횡단보도 수
        int n = Integer.parseInt(info[0]);
        // (원하는) 연속한 신호등 수
        int k = Integer.parseInt(info[1]);
        // 망가진 신호등
        int b = Integer.parseInt(info[2]);

        // 배열
        int[] arr = new int[n];
        // 모든 신호등 0로 초기화
        Arrays.fill(arr, 0);

        for(int i=0; i<b; i++) {
            int brokenSpot = Integer.parseInt(br.readLine());
            // 망가진 신호등은 1
            arr[brokenSpot-1] = 1;
        }

        // 누적합 배열
        int[] psum = new int[n];
        psum[0] = arr[0];
        for(int i=1; i<n; i++) {
            psum[i] = psum[i-1] + arr[i];
        }

        List<Integer> temp_psum = new ArrayList<>();
        for(int i=0; i<n-k+1; i++) {
            if(i == 0) {
                temp_psum.add(psum[i+k-1]);
            }else{
                temp_psum.add(psum[i+k-1] - psum[i-1]);
            }
        }

        Collections.sort(temp_psum);
        System.out.print(temp_psum.get(0));
    }
}
