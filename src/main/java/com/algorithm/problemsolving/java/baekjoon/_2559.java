package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2559
 * - 누적합 배열
 * - 연속 k일 온도 합의 최댓값 구하기
 */
import java.util.*;
import java.io.*;

public class _2559 {
    // 온도를 담을 배열
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        // 초기화
        arr = new int[n];

        String[] temperature = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(temperature[i]);
        }

        // 누적합 배열
        int[] psum = new int[n];
        psum[0] = arr[0];
        for(int i=1; i<n; i++) {
            psum[i] = psum[i-1] + arr[i];
        }

        // 연속된 k일의 온도의 합
        List<Integer> temp_psum = new ArrayList<>();
        for(int i=0; i<n-k+1; i++) {
            if(i == 0) {
                temp_psum.add(psum[i+k-1]);
            }else{
                temp_psum.add(psum[i+k-1] - psum[i-1]);
            }
        }

        // 오름차순 정렬
        Collections.sort(temp_psum, Collections.reverseOrder());
        System.out.print(temp_psum.get(0));
    }
}
