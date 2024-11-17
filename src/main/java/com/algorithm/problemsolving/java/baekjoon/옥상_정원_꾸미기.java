package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6            -> 빌딩의 개수 N이 입력된다.(1 ≤ N ≤ 80,000)
 * 10           -> 각 빌딩의 높이
 * 3
 * 7
 * 4
 * 12
 * 2
 *
 * 출력 : 관리인이 볼 수 있는 빌당 수의 합 (오른쪽으로만 볼 수 있다. 자신의 빌딩보다 높거나 같은 빌딩이 있으면 그 다음에 있는 모든 빌딩의 옥상은 보지 못한다)
 * 5
 *
 * 문제 : https://www.acmicpc.net/problem/6198
 * - 스택
 * - 본인 빌딩'을' 볼 수 있는 관리인의 수
 */
import java.util.*;
import java.io.*;

public class 옥상_정원_꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 빌딩의 높이
        int[] height = new int[n];
        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());
            height[i] = input;
        }

        // [주의] 약 32억으로 int 범위를 넘어가기 때문에 long으로 선언 (80,000 + 79,999 + 79,998 + ... +1)
        long result = 0;

        // 스택
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            // 현재 빌딩의 높이
            int currHeight = height[i];

            // [주의] 내 빌딩 높이보다 낮은 빌딩은 나를 볼 수 없으므로, 모두 pop
            while (!stack.isEmpty() && stack.peek() <= currHeight) {
                stack.pop();
            }

            result += stack.size();

            stack.push(currHeight);
        }
        System.out.print(result);
    }
}
