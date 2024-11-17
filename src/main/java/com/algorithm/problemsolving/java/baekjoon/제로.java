package com.algorithm.problemsolving.java.baekjoon;
/**
 * 입력 :
 * 4            -> 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 * 3            -> 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다
 * 0
 * 4
 * 0
 *
 * 출력 :         -> 합을 출력
 * 0
 *
 * 문제 : https://www.acmicpc.net/problem/10773
 * - 스택
 */
import java.util.*;
import java.io.*;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                stack.pop();
            }else{
                stack.push(input);
            }
        }

        // 합을 출력
        int count = 0;
        int size = stack.size();
        for(int i=0; i<size; i++) {
            count += stack.pop();
        }
        System.out.print(count);
    }
}
