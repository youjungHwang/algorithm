package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 : 200  -> 합
 *
 * 출력 : 19   -> 자연수 N의 최댓값
 *
 * 문제 : https://www.acmicpc.net/problem/1789
 * - 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 */
import java.io.*;

public class 수들의_합 {
    public static void main(String[] args) throws IOException{
        // 1 ~ n 까지 더하는 공식
        // 1/2 * n * (n+1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Long.parseLong(br.readLine());
        long n = 0;

        // n * (n+1) = sum *2;
        while(n * (n+1) <= sum *2) {
            n++;
        }
        System.out.println(n-1);
    }
}
