package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력:
 * 6 5                  -> 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)
 * 1 1 0 1 1            -> 1로 연결된 것이 그림
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 0 1 1 1
 * 0 0 1 1 1
 * 0 0 1 1 1
 *
 * 출력 :
 * 4                    -> 그림의 개수
 * 9                    -> 그 중 가장 넓은 그림의 넓이 (그림이 없으면 0)
 *
 * 문제 : https://www.acmicpc.net/problem/1926
 * - BFS + 큐
 */
import java.util.*;
import java.io.*;

public class 그림 {
    // 4방향으로 이어진 게 하나의 그림
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 방문 확인
    static boolean[][] visited;

    // map
    static int[][] map;
    static int n;
    static int m;

    // 그림의 개수
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        m = Integer.parseInt(data[1]);

        // map 초기화
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 방문 배열 초기화
        visited = new boolean[n][m];

        int maxSize = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count ++;
                    int tempSize = findPictures(i,j);
                    maxSize = Math.max(maxSize, tempSize);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int findPictures(int x, int y) {
        // 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        // 방문 확인
        visited[x][y] = true;

        // 현재 그림의 크기
        int size = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 4방향
            for(int i=0; i<4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                    size++;
                }
            }
        }
        return size;
    }

    // 범위 확인
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >=0 && y < m;
    }
}
