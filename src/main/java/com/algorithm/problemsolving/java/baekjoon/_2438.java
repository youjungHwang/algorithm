package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2438
 */
import java.util.*;
import java.io.*;

public class _2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            // 별을 i개 출력한다
            printStar(i);
        }
    }

    // nums 개수만큼 별을 출력하는 메서드
    // n = 3 -> ***
    private static void printStar(int nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=nums; i++) {
            sb.append("*");
        }
        System.out.println(sb);
    }
}
