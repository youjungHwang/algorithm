package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 1 1
 * 5 5
 * 7 3
 *
 * 출력 : P1, P2, P3를 순서대로 이은 선분이 반시계 방향을 나타내면 1, 시계 방향이면 -1, 일직선이면 0을 출력
 * -1
 *
 * 문제 : https://www.acmicpc.net/problem/11758
 * - 모든 좌표는 정수이다. P1, P2, P3의 좌표는 서로 다르다.
 */
import java.io.*;

public class CCW {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int x1 = Integer.parseInt(input1[0]);
        int y1 = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int x2 = Integer.parseInt(input2[0]);
        int y2 = Integer.parseInt(input2[1]);

        String[] input3 = br.readLine().split(" ");
        int x3 = Integer.parseInt(input3[0]);
        int y3 = Integer.parseInt(input3[1]);

        ccw(x1,y1,x2,y2,x3,y3);
        System.out.print(result);
    }

    // 신발끈 공식 사용
    private static void ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int leftSum = (x1 * y2) + (x2 * y3) + (x3 * y1);
        int rightSum = (x2 * y1) + (x3 * y2) + (x1 * y3);
        int total = leftSum - rightSum;

        if(total > 0) {
            result = 1;
        }else if(total < 0) {
            result = -1;
        }else {
            result = 0;
        }
    }
}
