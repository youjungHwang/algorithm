package com.algorithm.problemsolving.java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2178. 미로 탐색 - bfs
 *
 * input:
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 *
 * output:
 * 15
 *
 * 문제: https://www.acmicpc.net/problem/2178
 */
public class MazeTraversal {
    // 4방향
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        // 입력을 저장할 미로 맵
        int[][] maze = new int[n][m];
        // [주의] 초기화 진행
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                // 문자를 정수로 변환
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // 시작위치는 (0,0)
        count = bfs(0, 0, n, m, maze);

        // 출력 : 이동한 노드의 총 개수
        System.out.println(count);
    }

    // bfs
    public static int bfs(int startX, int startY, int n, int m, int[][] maze) {
        // queue 생성
        Queue<int[]> queue = new ArrayDeque<>();
        // 큐에 위치를 추가할 때, 현재까지의 이동 거리를 함께 저장
        queue.add(new int[]{startX, startY, 1});
        // 해당 노드를 이전에 방문했는지 확인
        visited[startX][startY] = true;

        // 큐가 빌 때까지 loop
        while (!queue.isEmpty()) {
            // 큐에서 원소 하나 poll
            int[] cn = queue.poll(); 
            int cnX = cn[0];
            int cnY = cn[1];
            int steps = cn[2];

            // 막힌 길이면 건너뛰기
            if (maze[cnX][cnY] == 0) {
                continue;
            }

            // 목적지 도착시 return
            if (cnX == n-1 && cnY == m-1) {
                return steps;
            }

            // maze 경계안에서 4방향 확인
            for (int k = 0; k < 4; k++) {
                int newX = cnX + dr[k];
                int newY = cnY + dc[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && maze[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY, steps +1});
                    visited[newX][newY] = true;
                }
            }
        }
        // 무조건 답이 있지만 형식상 추가
        return -1;
    }
}
