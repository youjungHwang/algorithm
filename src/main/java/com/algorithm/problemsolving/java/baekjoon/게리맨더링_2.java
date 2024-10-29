package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/17779
 * - 구현
 */
import java.util.*;
import java.io.*;

public class 게리맨더링_2 {
    // map 크기
    static int n;
    static int[][] map;
    // 전체 인구수
    static int totalSum = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // map 초기화
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] parts = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(parts[j]);
                totalSum += map[i][j];
            }
        }

        // 기준점 (x, y)와 경계의 길이 d1, d2를 정함
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                for(int d1=1; d1<n; d1++) {
                    for(int d2=1; d2<n; d2++) {
                        if(x+d1+d2 >= n) continue;
                        if(y-d1 < 0 || y+d2 >= n) continue;

                        border(x,y,d1,d2);
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static void border(int x, int y, int d1, int d2) {
        int[][] border = new int[n][n];
        int[] people = new int[5];

        // 경계선을 5로 채움
        for(int i=0; i<=d1; i++) {
            border[x+i][y-i] = 5;
            border[x+i+d2][y-i+d2] = 5;
        }
        for(int i=0; i<=d2; i++) {
            border[x+i][y+i] = 5;
            border[x+i+d1][y+i-d1] = 5;
        }

        // 1구역 인구 수 (이동 방향 ->)
        for(int i=0; i<x+d1; i++) {
            for(int j=0; j<=y; j++) {
                // 경계선 만나면 중단
                if (border[i][j] == 5) break;
                people[0] += map[i][j];
            }
        }

        // 2구역 인구 수 (이동 방향 <-)
        for(int i=0; i<=x+d2; i++) {
            for(int j=n-1; j>y; j--) {
                // 경계선 만나면 중단
                if (border[i][j] == 5) break;
                people[1] += map[i][j];
            }
        }

        // 3구역 인구 수 (이동 방향 ->)
        for(int i=x+d1; i<n; i++) {
            for(int j=0; j<y-d1+d2; j++) {
                // 경계선 만나면 중단
                if (border[i][j] == 5) break;
                people[2] += map[i][j];
            }
        }

        //4 구역 인구 수 (이동 방향 <-)
        for(int i=x+d2+1; i<n; i++) {
            for(int j=n-1; j>=y-d1+d2; j--) {
                // 경계선 만나면 중단
                if (border[i][j] == 5) break;
                people[3] += map[i][j];
            }
        }

        // 5 구역 인구수
        people[4] = totalSum;

        for(int i=0; i<4; i++) {
            people[4] -= people[i];
        }

        Arrays.sort(people);
        min = Math.min(min, people[4] - people[0]);
    }
}
