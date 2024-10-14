package com.algorithm.problemsolving.java.baekjoon;

/**
 * 10816. 숫자 카드 2
 *
 * 입력 :
 * 10                             -> N개
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8                              -> M개
 * 10 9 -5 2 3 4 5 -10
 *
 * 출력 :
 * 3 0 0 1 2 0 0 2
 *
 * 문제 :
 * https://www.acmicpc.net/problem/10816
 */
import java.io.*;
import java.util.*;

public class 숫자_카드_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputN = new int[N];

        // 공백을 기준으로 String 배열로 받아 처리
        String[] inputNStrings = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            inputN[i] = Integer.parseInt(inputNStrings[i]);
        }

        Map<Integer, Integer> inputMap = new HashMap<>();
        for(int num : inputN){
            inputMap.put(num, inputMap.getOrDefault(num, 0) +1 );
        }

        int M = Integer.parseInt(br.readLine());
        int[] inputM = new int[M];
        String[] inputMStrings = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            inputM[i] = Integer.parseInt(inputMStrings[i]);
        }

        for(int i=0; i<M; i++){
            System.out.print(inputMap.getOrDefault(inputM[i],0) + " ");
        }
    }
}
