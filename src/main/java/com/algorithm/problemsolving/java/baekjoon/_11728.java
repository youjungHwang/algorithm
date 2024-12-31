package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/11728
 * - 정렬 : O(nlogn)
 * - 1. 두 배열을 합친 후 정렬 시, 시간초과 -> 출력 최적화로 통과
 * - 2. 두 배열 -> 역순으로 스택에 넣고 peek(), pop() 비교 시, 시간초과
 * - 3. 앞에 원소끼리 비교(병합 정렬 컨셉)
 */
import java.util.*;
import java.io.*;

public class _11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        // A 배열
        int na = Integer.parseInt(info[0]);
        int[] arrA = new int[na];

        // O(N)
        String[] infoA = br.readLine().split(" ");
        for(int i=0; i<na; i++) {
            arrA[i] = Integer.parseInt(infoA[i]);
        }

        // B 배열
        int nb = Integer.parseInt(info[1]);
        int[] arrB = new int[nb];

        // O(M)
        String[] infoB = br.readLine().split(" ");
        for(int i=0; i<nb; i++) {
            arrB[i] = Integer.parseInt(infoB[i]);
        }

        // 배열 합치기
        // O(N)
        List<Integer> list = new ArrayList<>();
        for(int numA : arrA) {
            list.add(numA);
        }

        // O(M)
        for(int numB : arrB) {
            list.add(numB);
        }

        // 정렬
        // K = N + M
        // O(KlogK)
        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        for(int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
