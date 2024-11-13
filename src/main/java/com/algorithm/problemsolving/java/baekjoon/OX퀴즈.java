package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 5                            -> 테스트 케이스의 개수
 * OOXXOXXOOO
 * OOXXOOXXOO
 * OXOXOXOXOXOXOX
 * OOOOOOOOOO
 * OOOOXOOOOXOOOOX
 *
 * 출력 :
 * 10
 * 9
 * 7
 * 55
 * 30
 *
 * 문제 : https://www.acmicpc.net/problem/8958
 */
import java.io.*;

public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String testCase = br.readLine();
            checkRecord(testCase);
            System.out.println();
        }
    }

    private static void checkRecord(String testCase) {
        int temp = 0;
        int result = 0;

        for(int i=0; i<testCase.length(); i++) {
            char charTestCase = testCase.charAt(i);

            if(charTestCase == 'O') {
                temp += 1;
                result += temp;

            }else if(charTestCase == 'X') {
                // 초기화
                temp = 0;
            }
        }
        System.out.print(result);
    }
}
