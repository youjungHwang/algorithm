package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2309
 */
import java.util.*;
import java.io.*;

public class _2309 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        arr = new int[9];
        for(int i=0; i<9; i++) {
            int height = Integer.parseInt(br.readLine());
            arr[i] = height;
            sum += arr[i];
        }
        Arrays.sort(arr);

        subtraction(sum);
    }

    private static void subtraction(int sum) {
        int target = 100;
        int[] path = new int[2];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(sum - arr[i] - arr[j] == target) {
                    path[0] = arr[i];
                    path[1] = arr[j];
                    break;
                }
            }
        }

        for(int real : arr) {
            if(real != path[0] && real != path[1]) {
                System.out.println(real);
            }
        }
    }
}
