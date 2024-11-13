package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 5                            -> 가지고 있는 숫자 카드의 개수 N
 * 6 3 2 10 -10                 -> 숫자 카드에 적혀있는 정수
 * 8
 * 10 9 -5 2 3 4 5 -10          -> 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수
 *
 * 출력 :                        -> 가지고 있으면 1을, 아니면 0
 * 1 0 0 1 1 0 0 1
 *
 * 문제 : https://www.acmicpc.net/problem/10815
 * - 첫 번째 방법 : 이중 for문 -> O(n^2) -> 시간 초과
 * - 두 번쩨 방법 : 이분 탐색 -> O(nlogn)
 */
import java.io.*;
import java.util.*;

public class 숫자_카드 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이미 가지고 있는 카드 정보
        int n  = Integer.parseInt(br.readLine());
        int[] cardArr = new int[n];

        String[] inputN = br.readLine().split(" ");
        for(int i=0; i<cardArr.length; i++) {
            cardArr[i] = Integer.parseInt(inputN[i]);
        }

        // 가지고 있는지 확인 할 카드 정보
        int m = Integer.parseInt(br.readLine());;
        int[] checkArr = new int[m];

        String[] inputM = br.readLine().split(" ");
        for(int i=0; i<checkArr.length; i++) {
            checkArr[i] = Integer.parseInt(inputM[i]);
        }

        // 정렬
        Arrays.sort(cardArr);

        // 이분 탐색
        for(int i=0; i<checkArr.length; i++) {
            binarySearchInCards(cardArr, checkArr[i]);
        }

    }

    private static void binarySearchInCards(int[] arr, int checkCard) {
        int left = 0;
        int right = arr.length - 1;
        boolean isFound = false;

        while(left <= right) {
            int m = (left + right) / 2;

            if(arr[m] == checkCard) {
                isFound = true;
                break;
            }

            if(arr[m] > checkCard) {
                right = m -1;
            }else if(arr[m] < checkCard) {
                left = m + 1;
            }
        }

        if(isFound) {
            System.out.print(1 + " ");
        }else {
            System.out.print(0 + " ");
        }

    }
}
