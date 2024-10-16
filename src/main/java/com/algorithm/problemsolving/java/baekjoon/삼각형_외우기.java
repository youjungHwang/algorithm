package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 60
 * 70
 * 50
 *
 * 출력 :
 * Scalene
 *
 * 문제 : https://www.acmicpc.net/problem/10101
 */
import java.io.*;

public class 삼각형_외우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());

        String result = checkType(first, second, third);
        System.out.print(result);
    }

    private static String checkType(int first, int second, int third) {
        int sum = first + second + third;

        if(first == 60 && second == 60 && third == 60){
            return "Equilateral";
        }

        if(sum == 180) {
            if(isIsosceles(first, second, third)) {
                return "Isosceles";
            }else {
                return "Scalene";
            }
        }
        return "Error";
    }

    private static boolean isIsosceles(int first, int second, int third) {
        return (first == second || first == third || second == third);
    }
}
