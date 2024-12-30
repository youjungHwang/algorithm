package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10809
 * - 알파벳은 총 26개
 */
import java.util.*;
import java.io.*;

public class _10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        // 체크 배열 초기화
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<sentence.length(); i++) {
            // 문자열 -> 문자
            char word = sentence.charAt(i);
            int wordNumber = word - 'a';

            if(arr[wordNumber] == -1) {
                arr[wordNumber] = i;
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
