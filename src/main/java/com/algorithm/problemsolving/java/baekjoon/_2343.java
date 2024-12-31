package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2343
 * - 이분 탐색
 * - 탐색할 범위를 찾는 것이 관건
 */
import java.util.*;
import java.io.*;

public class _2343 {
    private static int n;
    private static int m;

    public static void main(String[] ags) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        // 강의의 수
        n = Integer.parseInt(info[0]);
        // 블루레이의 수
        m = Integer.parseInt(info[1]);

        // 배열
        int[] arr = new int[n];
        int sum = 0;
        String[] musicLength = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(musicLength[i]);
            sum += arr[i];
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        binarySearchForRecord(arr, max, sum);
    }

    private static void binarySearchForRecord(int[] arr, int max, int totalLength) {
        // 탐색 할 범위 [강의 중 제일 긴 시간, 강의 총합]
        int left = max;
        int right = totalLength;

        // 출력할 최종 블루레이 최소 크기
        int result = 0;

        while(left <= right) {
            // 블루레이 크기
            int mid = (left + right) / 2;

            // 현재 블루레이에 담긴 강의 길이의 총합
            int sum = 0;

            // 블루레이 개수
            int count = 1;

            // 강의 길이의 합이 블루레이 크기 초과시, 블루레이 개수 증가, 총합 초기화(현재 강의만 담음)
            for(int i=0; i<n; i++) {
                if(sum + arr[i] > mid) {
                    sum = arr[i];
                    count++;
                }else {
                    sum += arr[i];
                }
            }

            if(count <= m) {
                result = mid;
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        System.out.print(result);
    }
}
