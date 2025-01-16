package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10026
 * - BFS
 * - charAt() : String으로 저장된 문자열 중 한 글자를 선택해 char타입으로 변환해줌
 * - map, visited 초기화 주의
 */
import java.io.*;
import java.util.*;

public class _10026 {
    // 4방향
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};

    // 2차원 배열
    private static char[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // [주의] map 초기화
        map = new char[n][n];

        for(int i=0; i<n; i++) {
            String info = br.readLine();

            for(int j=0; j<n; j++) {
                map[i][j] = info.charAt(j);
            }
        }

        // 적록색약이 아닌 경우
        int countForNormal = countColorForNormal(0,0);
        System.out.print(countForNormal + " ");

        // 적록색약인 경우
        int countForNotNormal = countColorForNotNormal(0,0);
        System.out.print(countForNotNormal);
    }

    // 적록색약이 아닌 경우
    private static int countColorForNormal(int x, int y) {
        // 방문 배열 초기화
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        // 전체 맵 돌기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, visited, map[i][j]);
                    count++;
                }
            }
        }
        return count;
    }

    // 적록색약인 경우
    private static int countColorForNotNormal(int x, int y) {
        // G를 전부 R로 바꾸기
        for(int i =0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        // 방문 배열 초기화
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        // 전체 맵 돌기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, visited, map[i][j]);
                    count++;
                }
            }
        }
        return count;
    }

    // bfs
    private static void bfs(int x, int y, boolean[][] visited, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        visited[x][y] = true;

        while(!q.isEmpty()) {
            // 큐에서 원소 뽑기
            int[] curr = q.poll();
            int cX = curr[0];
            int cY = curr[1];

            // 4방향
            for(int i=0; i<4; i++) {
                int nX = cX + dr[i];
                int nY = cY + dc[i];

                // 범위 안에 있는지, 방문 안한 부분인지, 이전과 같은 색인지
                if(canGo(nX, nY) && !visited[nX][nY]) {
                    if(map[nX][nY] == color) {
                        visited[nX][nY] = true;
                        q.add(new int[]{nX, nY});
                    }
                }
            }
        }
    }

    // 범위 안에 있는지
    private static boolean canGo(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
