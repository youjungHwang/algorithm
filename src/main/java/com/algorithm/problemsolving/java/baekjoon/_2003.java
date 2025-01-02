package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2003
 * - 구간 합
 * - 투포인터 알고리즘 활용
 *   - 시작점 고정, 끝점을 +1
 *   - 만약 합이(sum) >= m => 시작점 +1
 *   -> 시간복잡도 O(N)
 */
import java.io.*;
import java.util.*;

public class _2003 {
    private static int[] arr;
    private static int n;
    private static int m;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 초기화
        arr = new int[n];
        String[] info = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        twoPointer();
        System.out.print(count);
    }

    private static void twoPointer() {
        int start = 0;
        int end = 0;
        int sum = arr[0];

        while(true) {
            if(sum == m) {
                count++;
            }

            // 시작점 +1
            if(sum >= m) {
                // sum 갱신
                sum -= arr[start];
                start += 1;
            // 끝점 +1
            }else {
                // 만약 끝 포인터가 마지막 까지 갔다면 break
                if(end == n-1) {
                    break;
                }
                end += 1;
                // sum 갱신
                sum += arr[end];
            }
        }
    }
}
