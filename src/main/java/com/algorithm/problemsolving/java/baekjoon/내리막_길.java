package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 5                                  -> 지도의 세로의 크기 M과 가로의 크기 N (각각 500이하의 자연수)
 * 50 45 37 32 30                       -> 각 지점의 높이 (10000이하의 자연수)
 * 35 50 40 20 25
 * 30 30 25 17 28
 * 27 24 22 15 10
 *
 * 출력 : 항상 내리막길로만 이동하는 경로의 개수 (음이 아닌 정수)
 * 3
 *
 * 문제 : https://www.acmicpc.net/problem/1520
 */
import java.io.*;

public class 내리막_길 {
    // 4방향
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    // 지도
    static int[][] map;
    static int m;
    static int n;

    // dp
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        m = Integer.parseInt(size[0]);
        n = Integer.parseInt(size[1]);

        // 초기화
        map = new int[m][n];
        dp = new int[m][n];

        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                dp[i][j] = -1;
            }
        }

        // 시작 좌표
        System.out.print(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if(x == (m-1) && y == (n-1)) {
            return 1;
        }

        // 이미 계산된 경로 수가 있다면 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 경로 수를 누적하기 위해 초기화
        dp[x][y] = 0;

        // 4방향 확인
        for(int i=0; i<4; i++) {
            int nX = x + dr[i];
            int nY = y + dc[i];

            if(isRange(nX, nY) && map[x][y] > map[nX][nY]) {
                // 현재 위치에서 가능한 모든 내리막 경로의 개수를 누적
                dp[x][y] += dfs(nX, nY);
            }
        }
        return dp[x][y];
    }

    // 범위 확인
    private static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
