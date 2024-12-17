package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 1                -> 테스트 케이스의 개수 T
 * 5 3 6            -> 배추밭의 가로길이 M(1 ≤ M ≤ 50)  | 세로길이 N(1 ≤ N ≤ 50) | 배추가 심어져 있는 위치의 개수 K
 * 0 2              -> 배추의 위치
 * 1 2
 * 2 2
 * 3 2
 * 4 2
 * 4 0
 *
 * 출력 : 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수
 * 2
 *
 * 문제 : https://www.acmicpc.net/problem/1012
 * - BFS
 */
import java.util.*;
import java.io.*;

public class 유기농_배추 {
    // 4방향
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};

    // 배추밭 map
    private static int[][] map;
    private static int m;
    private static int n;

    // 방문 확인
    private static boolean[][] visited;

    // 최소 지렁이 개수
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] info = br.readLine().split(" ");
            m = Integer.parseInt(info[0]);
            n = Integer.parseInt(info[1]);
            int kk = Integer.parseInt(info[2]);

            // 초기화
            map = new int[m][n];
            visited = new boolean[m][n];
            count = 0;

            // 지렁이 있는 부분은 1로 변경
            for(int j=0; j<kk; j++) {
                String[] infoMap = br.readLine().split(" ");
                int x = Integer.parseInt(infoMap[0]);
                int y = Integer.parseInt(infoMap[1]);

                map[x][y] = 1;
            }

            // [주의] 최소한의 지렁이 찾기 메서드 호출(전체 탐색)
            for(int row=0; row<m; row++) {
                for(int col=0; col<n; col++) {
                    if(map[row][col] == 1 && !visited[row][col]) {
                        bfs(row,col);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int startX, int startY) {
        // 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});

        // 방문 확인
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            // 큐에서 원소를 뽑음
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 4방향 이동해서 확인
            for(int i=0; i<4; i++) {
                int nextX = currX + dr[i];
                int nextY = currY + dc[i];

                // 범위 확인, 방문 확인
                if(canGo(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    // 방문 확인
                    visited[nextX][nextY] = true;
                    // 큐에 넣기
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    // 적절한 범위인지 확인
    private static boolean canGo(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
