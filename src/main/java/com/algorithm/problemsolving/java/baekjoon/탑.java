package com.algorithm.problemsolving.java.baekjoon;

/**
 *  입력 :
 * 5                -> 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하
 * 6 9 5 7 4        -> N개의 탑들의 높이
 *
 *  출력 :           -> 각각의 탑들에서 왼쪽으로 발사한 레이저 신호를 수신한 첫 탑의 인덱스 (없으면 0, 인덱스 1부터 시작)
 *  0 0 2 2 4
 *
 *  문제 : https://www.acmicpc.net/problem/2493
 *  - 스택 O(n)
 */
import java.util.*;
import java.io.*;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 탑의 높이
        int[] height = new int[n];

        String[] data = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            height[i] = Integer.parseInt(data[i]);
        }

        // 결과 담을 배열
        int[] result = new int[n];

        // stack : [탑의 인덱스, 탑의 높이]
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            int currHeight = height[i];

            // 이전 탑의 높이가 현재 탑의 높이 보다 작다면, 제거
            while(!stack.isEmpty() && stack.peek()[1] < currHeight ) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            }else {
                result[i] = stack.peek()[0];
            }

            stack.push(new int[]{i+1, currHeight});
        }

        for(int output : result) {
            System.out.print(output + " ");
        }
    }
}
