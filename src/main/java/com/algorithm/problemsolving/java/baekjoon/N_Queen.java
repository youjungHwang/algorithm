package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 8                    -> 퀸의 수(N)
 *
 * 출력 :
 * 92                   -> 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
 *
 * 문제 : https://www.acmicpc.net/problem/9663
 * - 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * - 한 행, 열, 대각선에는 하나의 퀸만 존재해야 한다
 */
import java.io.*;

public class N_Queen {
    // 대각선 방향
    static int[] dr = {-1,-1,1,1};
    static int[] dc = {-1,1,1,-1};

    // 체스판
    static int[][] map;

    // 퀸 놓는 경우의 수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화
        map = new int[N][N];

        nQueen(0, N);
        System.out.print(count);
    }

    private static void nQueen(int depth, int N) {
        // 종료 조건
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(isSafe(depth, i)) {
                placeQueen(depth, i);
                nQueen(depth+1, N);
                removeQueen(depth, i);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        // 특정 열에 이미 다른 퀸이 놓여 있는지 확인
        for(int i=0; i<row; i++) {
            if(map[i][col] == 1) {
                return false;
            }
        }

        // 대각선 확인
        for(int d=0; d<4; d++) {
            // 현재 위치
            int nx = row;
            int ny = col;

            while (isRange(nx, ny)) {
                if(map[nx][ny] == 1) {
                    return false;
                }
                nx += dr[d];
                ny += dc[d];
            }
        }

        return true;
    }

    private static void placeQueen(int row, int col) {
        // 퀸을 위치시킴 (1)
        map[row][col] = 1;
    }

    private static void removeQueen(int row, int col) {
        // 퀸을 해당 위치에서 제거 (0)
        map[row][col] = 0;
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length;
    }
}
