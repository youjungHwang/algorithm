package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2512
 * - 이분탐색
 */
import java.util.*;
import java.io.*;

public class _2512 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 배열
        int[] arr = new int[n];
        String[] info = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        // 정렬
        Arrays.sort(arr);

        // 총 예산
        int totalAmount = Integer.parseInt(br.readLine());

        binarySearchAboutTotalAmount(arr, totalAmount);
    }

    private static void binarySearchAboutTotalAmount(int[] arr, int target) {
        // 범위 [0, 예산액 중 가장 큰 수]
        int left = 0;
        int right = arr[n-1];
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i=0; i<n; i++) {
                sum += Math.min(mid, arr[i]);
            }

            // 더 큰 상한선이 존재할 가능성이 있으므로 sum == target 만족시, 바로 return하지 않음
            if(sum <= target) {
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.print(result);
    }
}
