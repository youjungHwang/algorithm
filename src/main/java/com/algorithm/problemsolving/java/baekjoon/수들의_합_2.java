package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 10 5                     ->  N, M
 * 1 2 3 4 2 5 3 1 1 2      -> N개의 수로 된 수열
 *
 * 출력 : 수열의 i번째 수부터 j번째 수까지의 합이 M이 되는 경우의 수
 * 3
 *
 * 문제 : https://www.acmicpc.net/problem/2003
 * - 투 포인터
 */
import java.io.*;

public class 수들의_합_2 {
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[n];
        String[] data = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        twoPointer(n, m);
        System.out.print(result);
    }

    private static void twoPointer(int n, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < n) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if(sum == target) {
                result++;
            }

            right++;
        }
    }
}
