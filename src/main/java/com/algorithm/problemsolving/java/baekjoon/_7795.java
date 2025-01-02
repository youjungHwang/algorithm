package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/7795
 */
import java.io.*;
import java.util.*;

public class _7795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] info = br.readLine().split(" ");

            // a 배열 -> 정렬
            int[] a = new int[Integer.parseInt(info[0])];
            String[] infoA = br.readLine().split(" ");
            for(int j=0; j<Integer.parseInt(info[0]); j++) {
                a[j] = Integer.parseInt(infoA[j]);
            }
            Arrays.sort(a);

            // b 배열 -> 정렬
            int[] b = new int[Integer.parseInt(info[1])];
            String[] infoB = br.readLine().split(" ");
            for(int j=0; j<Integer.parseInt(info[1]); j++) {
                b[j] = Integer.parseInt(infoB[j]);
            }
            Arrays.sort(b);

            int result = findPair(a,b);
            System.out.println(result);
        }
    }

    private static int findPair(int[] a, int[] b) {
        int result = 0;

        int sizeA = a.length;
        int sizeB = b.length;

        for(int i=0; i<sizeA; i++) {
            for(int j=0; j<sizeB; j++) {
                if(a[i] > b[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
