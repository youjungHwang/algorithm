package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 5
 * 0 4
 * 1 2
 * 1 -1
 * 2 2
 * 3 3
 *
 * 출력 :
 * 1 -1
 * 1 2
 * 2 2
 * 3 3
 * 0 4
 *
 * 문제 : https://www.acmicpc.net/problem/11651
 * - 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력
 */
import java.util.*;
import java.io.*;

public class 좌표_정렬하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n][2];

        for(int i=0; i<n; i++) {
            String pair = br.readLine();
            String[] dividedPair = pair.split(" ");

            arr[i][0] = Integer.parseInt(dividedPair[0]);
            arr[i][1] = Integer.parseInt(dividedPair[1]);
        }

        // y좌표를 기준으로 오름차순 정렬
        // 만약, y좌표가 같다면 x좌표를 기준으로 오름차순 정렬
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1])
                .thenComparing(a -> a[0]));

        for(int[] num : arr) {
            System.out.println(num[0] + " " + num[1]);
        }
    }
}
