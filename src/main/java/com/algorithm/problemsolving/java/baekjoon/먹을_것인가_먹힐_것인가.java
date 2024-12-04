package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 2                        -> 테스트 케이스의 개수 T
 * 5 3                      -> A의 수 N과 B의 수 M
 * 8 1 7 3 1                -> A의 크기
 * 3 6 1                    -> B의 크기
 * 3 4
 * 2 13 7
 * 103 11 290 215
 *
 * 출력 :
 * 7
 * 1
 *
 * 문제 : https://www.acmicpc.net/problem/7795
 */
import java.util.*;
import java.io.*;

public class 먹을_것인가_먹힐_것인가 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
           int count =  initialize();
           System.out.println(count);
        }
    }

    // 테스트 초기 설정
    private static int initialize() throws IOException {
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int[] arrA = new int[a];
        int[] arrB = new int[b];

        String[] inputA = br.readLine().split(" ");
        for(int i=0; i<a; i++) {
            arrA[i] = Integer.parseInt(inputA[i]);
        }

        String[] inputB = br.readLine().split(" ");
        for(int i=0; i<b; i++) {
            arrB[i] = Integer.parseInt(inputB[i]);
        }

        // 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int count = findPair(arrA, arrB);
        return count;
    }

    // a가 b보다 큰 쌍의 개수를 구하는 메서드
    private static int findPair(int[] arrA, int[] arrB) {
        int count = 0;

        for(int i=0; i<arrA.length; i++) {
            for(int j=0; j<arrB.length; j++) {
                if(arrA[i] > arrB[j]) count++;
            }
        }
        return count;
    }
}
