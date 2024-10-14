package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * ()(((()())(())()))(())
 *
 * 출력 : 잘려진 조각의 총 개수
 * 17
 *
 * 문제 :
 * https://www.acmicpc.net/problem/10799
 */
import java.io.*;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 0;
        int stick = 0;

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(') {
                // 막대기 시작
                stick++;
            } else {
                if (input.charAt(i - 1) == '(') {
                    // 레이저인 경우
                    stick--;
                    result += stick;

                } else {
                    // 막대기 끝
                    stick--;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
