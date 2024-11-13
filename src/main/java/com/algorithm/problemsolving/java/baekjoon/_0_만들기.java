package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 2                    -> 테스트 케이스의 개수가 주어진다(<10)
 * 3                    -> 각 테스트 케이스엔 자연수 N이 주어진다(3 <= N <= 9)
 * 7
 *
 * 출력 : ASCII 순서에 따라 결과가 0이 되는 모든 수식을 출력
 * 1+2-3
 *
 * 1+2-3+4-5-6+7
 * 1+2-3-4+5+6-7
 * 1-2 3+4+5+6+7
 * 1-2 3-4 5+6 7
 * 1-2+3+4-5+6-7
 * 1-2-3-4-5+6+7
 *
 * 문제 : https://www.acmicpc.net/problem/7490
 * - dfs
 */
import java.io.*;

public class _0_만들기 {
    // 자연수 1 ~ n까지의 오름차순 수열
    static int[] arr;
    // 각 테스트 케이스의 n
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());

            // 배열 초기화
            arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = j+1;
            }

            comb(1, 1, "1");
            System.out.println();
        }
    }

    // dfs - 3가지 경우의 수
    private static void comb(int currNum, int len, String format) {
        if(len == n) {
            if(calculate(format) == 0) {
                System.out.println(format);
            }
            return;
        }

        comb(currNum+1, len+1, format + ' ' + (currNum+1));
        comb(currNum+1, len+1, format + '+' + (currNum+1));
        comb(currNum+1, len+1, format + '-' + (currNum+1));
    }

    // 만들어진 수식이 0이 되는지 확인
    private static int calculate(String format) {
        // "1-2 3+4+5+6+7"
        // 공백이 있으면 붙인다. "1-23+4+5+6+7"
        StringBuilder sb = new StringBuilder();
        String[] parts = format.split(" ");

        for(String part : parts) {
            sb.append(part);
        }

        // "1-23+4+5+6+7"
        String newFormat = sb.toString();

        // 결과를 저장
        int result = 0;
        // 현재 숫자
        int currNumber = 0;
        // 최근 연산자
        char lastOperator = '+';

        for(int i=0; i<newFormat.length(); i++) {
            char curr = newFormat.charAt(i);

            // curr가 숫자인가 '1'
            if(Character.isDigit(curr)) {
                // '1' -> 1로 변환
                // 공백을 붙여서 처리하므로, 누적으로 처리하기 위해 currNumber * 10 사용
                currNumber = currNumber * 10 + (curr - '0'); //
            }

            // curr가 연산자인 경우
            if (curr == '+' || curr == '-') {
                if (lastOperator == '+') {
                    result += currNumber;
                } else if (lastOperator == '-') {
                    result -= currNumber;
                }
                // 현재 연산자를 lastOperator에 저장
                lastOperator = curr;
                // currNumber를 0으로 초기화
                currNumber = 0;
            }
        }

        // 마지막 숫자 처리
        if(lastOperator == '+') {
            result += currNumber;
        } else if (lastOperator == '-') {
            result -= currNumber;
        }

        return result;
    }
}
