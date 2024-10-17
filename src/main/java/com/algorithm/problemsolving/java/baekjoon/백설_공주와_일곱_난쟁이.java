package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 7
 * 8
 * 10
 * 13
 * 15
 * 19
 * 20
 * 23
 * 25
 *
 * 출력 :
 * 7
 * 8
 * 10
 * 13
 * 19
 * 20
 * 23
 *
 * 문제 :
 * https://www.acmicpc.net/problem/3040
 */
import java.io.*;
import java.util.*;

public class 백설_공주와_일곱_난쟁이 {
    private static int TARGET_NUMBER = 100;
    private static int INPUT_NUMBER = 9;
    private static int SELECT_NUMBER = 7;

    private static int[] box;
    private static List<Integer> selectedBox = new ArrayList<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        box = new int[INPUT_NUMBER];
        for(int i=0; i<INPUT_NUMBER; i++) {
            box[i] = Integer.parseInt(br.readLine());
        }

        checkTargetNumber(0,0, 0);
    }

    private static void checkTargetNumber(int start, int sum, int count) {
        // 종료 조건
        if(sum == TARGET_NUMBER && count == SELECT_NUMBER) {
            for(int num : selectedBox) {
                System.out.println(num);
            }
        }

        for(int i=start; i<INPUT_NUMBER; i++){
            selectedBox.add(box[i]);
            checkTargetNumber(i+1, sum + box[i], count + 1);
            selectedBox.remove(selectedBox.size() - 1);
        }
    }
}
