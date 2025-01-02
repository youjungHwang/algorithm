package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2847
 * - 그리디 알고리즘
 * - 마지막 레벨을 기준으로 앞으로 가면서 - 연산
 */
import java.util.*;
import java.io.*;

public class _2847 {
    // 배열
    private static int[] carArr;

    // (누적) 감소한 점수
    private static int point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 초기화
        carArr = new int[n];

        for(int i=0; i<n; i++) {
            int info = Integer.parseInt(br.readLine());
            carArr[i] = info;
        }

        calculLevel(n-1);
        System.out.print(point);
    }

    private static void calculLevel(int level) {
        // 기준
        int record = carArr[level];

        for(int i=level-1; i>=0; i--) {
            if(record < carArr[i]) {
                point += (carArr[i] - record) + 1;
                record = record-1;
            }else if(record == carArr[i]){
                point ++;
                record = record-1;
            } else {
                record = carArr[i];
            }
        }
    }
}
