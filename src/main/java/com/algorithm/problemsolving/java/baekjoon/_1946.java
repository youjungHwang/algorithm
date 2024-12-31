package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/1946
 * - 이차원 배열 정렬
 */
import java.util.*;
import java.io.*;

public class _1946 {
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());

            // 배열 초기화
            int[][] arr = new int[n][2];

            for(int j=0; j<n; j++) {
                String[] info = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(info[0]);
                arr[j][1] = Integer.parseInt(info[1]);
            }

            // 첫 번째 원소 기준으로 오름차순, 같으면 두 번째 원소 기준으로 오름차순 정렬
            Arrays.sort(arr, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            });

            // 최대 신입사원 찾기
            pickEmployee(arr);
        }
    }

    public static void pickEmployee(int[][] arr) {
        // 최대 신입사원 수
        int result = 1;

        // 2차면접 랭킹
        int topRanking = arr[0][1];

        for(int i=1; i<n; i++) {
            if(topRanking > arr[i][1]) {
                // 하위호환이 아니므로 신입사원 선발
                result++;
                // 랭킹 갱신
                topRanking = arr[i][1];
            }else {
                continue;
            }
        }
        System.out.println(result);
    }
}
