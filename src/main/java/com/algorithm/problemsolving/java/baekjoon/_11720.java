package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/11720
 */
import java.util.*;
import java.io.*;

public class _11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int result = 0;

        // 배열
        int[] arr = new int[count];

        for(int i=0; i<number.length(); i++) {
            if(i != number.length()-1) {
                int num = Integer.parseInt(number.substring(i, i+1));
                arr[i] = num;
            }

            int lastNum = Integer.parseInt(number.substring(number.length()-1));
            arr[number.length()-1] = lastNum;
        }

        // 배열의 원소들의 합
        for(int num : arr) {
            result += num;
        }

        System.out.print(result);
    }
}
