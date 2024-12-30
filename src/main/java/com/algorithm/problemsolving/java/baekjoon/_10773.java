package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10773
 */
import java.util.*;
import java.io.*;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        // 스택
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                stack.push(num);
            }else {
                stack.pop();
            }
        }

        // stack에 있는 원소 전부 더하기
        for(int num : stack) {
            result += num;
        }

        System.out.print(result);
    }
}
