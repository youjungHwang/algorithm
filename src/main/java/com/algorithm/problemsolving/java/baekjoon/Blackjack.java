package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2798번 블랙잭 (브론즈 2)
 *
 * 문제: https://www.acmicpc.net/problem/2798
 *
 * 입력 예시:
 * 첫 번째 줄에 N(카드 수)과 M(목표 수)이 주어짐: 5 21
 * 두 번째 줄에 N개의 카드에 적힌 수가 공백으로 구분되어 주어짐: 5 6 7 8 9
 *
 * 출력 예시:
 * M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력: 21
 */
public class Blackjack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 예: 5
        int M = Integer.parseInt(st.nextToken()); // 예: 21

        // 카드 값을 저장할 배열 초기화
        int[] arr = new int[N];

        // 두 번째 줄의 카드 값들을 읽어 배열에 저장
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }

    // 완전 탐색
    static int search(int[] arr, int N, int M){
        int result = 0;

        // 세 개의 카드를 선택하므로 첫 번째 카드는 N-2범위를 탐색해서 선택
        for(int i=0; i<N-2; i++){
            // 첫 번째 카드가 M보다 크면 무시
            if(arr[i] > M) continue;

            // 두 번째 카드는 i+1 ~ N-1범위를 탐색해서 선택
            for(int j=i+1; j<N-1; j++){
                // 첫 두 카드의 합이 M보다 크면 무시
                if(arr[i] + arr[j] > M) continue;

                for(int k=j+1; k<N; k++){
                    int temp = arr[i] + arr[j] + arr[k];

                    if(temp == M){
                        return temp;
                    }

                    // 현재까지의 최대 합보다 크고 M보다 작은 경우 업데이트
                    if(temp <= M && result < temp){
                        result = temp;
                    }
                }
            }

        }
        return result;
    }
}


