package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6 4                  -> 상자의 크기를 나타내는 두 정수 M(가로),N(세로) 2 ≤ M,N ≤ 1,000
 * 0 0 0 0 0 0          -> 1(익은 토마토), 0(익지 않은 토마토), -1(토마토가 들어있지 않은 칸)
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 *
 * 출력 : 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수
 * 단, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을, 토마토가 모두 익지는 못하는 상황이면 -1 출력
 *
 * 문제 : https://www.acmicpc.net/problem/7576
 * - BFS + 큐
 */
import java.util.*;
import java.io.*;

public class 토마토 {
    // 4방향
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 상자
    static int[][] map;
    static int n;
    static int m;

    // 방문 배열
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        // 초기화
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String[] data = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        // 저장될 때부터 모든 토마토가 1이면 -> 0을 출력
        boolean isAllGood = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    isAllGood = false;
                    break;
                }
            }
            if (!isAllGood) break;
        }

        if (isAllGood) {
            System.out.println(0);
            return;
        }

        int minDay = checkMinDays();

        // 모든 토마토가 익지 못하는 경우
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(minDay);
    }

    // bfs
    private static int checkMinDays() {
        // 큐
        Queue<int[]> q = new ArrayDeque<>();

        // 초기 익은 토마토를 큐에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // 초기값 -1 (첫날은 0으로 시작)
        int days = -1;

        while(!q.isEmpty()) {
            // [주의] 같은 레벨의 모든 노드를 처리한 후 days를 증가
            int size = q.size();

            for(int s=0; s<size; s++) {
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];

                // 4방향 이동
                for(int i=0; i<4; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
            days++;
        }
        return days;
    }

    // 범위 확인
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
