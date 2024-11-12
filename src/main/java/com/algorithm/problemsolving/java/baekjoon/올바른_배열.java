package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6                              -> 배열의 크기 N이 주어진다. N은 50보다 작거나 같은 자연수
 * 5                              -> 원소는 1,000,000,000보다 작거나 같은 음이 아닌 정수이다. 배열에 중복되는 수는 없다.
 * 7
 * 9
 * 8492
 * 8493
 * 192398
 *
 * 출력 : 배열 속에 있는 원소 중 5개가 연속되도록 하기 위해 추가 되어야 할 원소의 최소 개수
 * 2
 *
 * 문제 : https://www.acmicpc.net/problem/1337
 * - 투 포인터 알고리즘
 */
import java.util.*;
import java.io.*;

public class 올바른_배열 {
    // 추가 되어야 할 원소의 최소 개수는 최대가 4이다
    static int count = 4;
    // 원소를 담을 배열
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            int start = i;
            int end = arr.length - 1;

            while(start < end) {
                if(arr[end] - arr[start] > 4) {
                    end -= 1;
                }else {
                    int temp = 4 - (end - start);
                    count = Math.min(count, temp);
                    break;
                }
            }
        }
        System.out.print(count);
    }
}
