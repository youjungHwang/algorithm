package com.algorithm.problemsolving.java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 18312번 시각 (브론즈 2)
 *
 * 문제: https://www.acmicpc.net/problem/18312
 * 0시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 모든 시각을 세는 프로그램을 작성
 *
 * 입력 예시:
 * 첫 번째 줄에 N이 주어짐: 5 (0≤N≤23)
 * 두 번째 줄에 K가 공백으로 구분되어 주어짐: 3 (0≤K≤9)
 *
 * 출력 예시:
 * 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 시각들의 수를 출력: 11475
 */
public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr= new int[2];
        // N과 K를 파싱하여 배열에 저장
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = search(arr[0], arr[1]);
        System.out.println(count);
    }

    /**
     * 00:00:00부터 t:59:59까지 모든 시각 중에서 숫자 s가 포함된 시각의 수를 세는 메서드
     * @param t 검사할 최대 시간 (0시부터 23시까지 가능)
     * @param s 찾고자 하는 숫자 (0부터 9까지)
     * @return 숫자 s가 하나라도 포함된 시각의 총 수
     */
    static int search(int t, int s){
        int count = 0;
        // 모든 시, 분, 초에 대해 반복
        for(int i=0; i<=t; i++){
            for(int j=0; j<=59; j++){
                for(int k=0; k<=59; k++){
                    // 시, 분, 초를 각각 십의 자리와 일의 자리로 분리
                    int a = i / 10;
                    int b = i % 10;
                    int c = j / 10;
                    int d = j % 10;
                    int e = k / 10;
                    int f = k % 10;
                    // 시, 분, 초를 각각 십의 자리와 일의 자리로 분리한 숫자가 s와 일치하는지 확인
                    if(a == s || b == s || c == s || d == s || e == s || f == s){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
