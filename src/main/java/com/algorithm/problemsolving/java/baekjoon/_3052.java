package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/3052
 * - Set 사용
 */
import java.io.*;
import java.util.*;

public class _3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 중복을 제거하여 담기위해 set사용
        Set<Integer> arr = new HashSet<>();

        for(int i=0; i<10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num % 42);
        }

        System.out.print(arr.size());
    }
}
