package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 23
 *
 * 출력 :
 * 4
 *
 * 문제 : https://www.acmicpc.net/problem/1094
 */
import java.util.*;
import java.io.*;

public class 막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int result = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(64);
        q.add(32);
        q.add(16);
        q.add(8);
        q.add(4);
        q.add(2);
        q.add(1);

        while(!q.isEmpty()) {
            int num = q.remove();

            if(num > x) continue;

            if(num == x) {
                result++;
                break;
            }

            if(num < x) {
                result++;
                x = x - num;
            }
        }
        System.out.print(result);
    }
}
