package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 2468. 안전 영역 - dfs
 *
 * input:
 * 5
 * 6 8 2 6 2
 * 3 2 3 4 6
 * 6 7 3 3 2
 * 7 2 5 3 6
 * 8 9 5 2 7
 *
 * output:
 * 5
 *
 * 문제: https://www.acmicpc.net/problem/2468
 */
public class SafeZone {
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static Set<Integer> heightSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // map에 입력값을 담음
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int height = Integer.parseInt(row[j]);
                map[i][j] = height;
                heightSet.add(height);
            }
        }

        // 특정 높이에 따라 dfs 호출
        int maxSafeZone = 0;

        // [주의] 맵의 모든 높이가 같다면 전체가 1개의 안전지역
        if(heightSet.size() == 1){
            maxSafeZone = 1;
        }else{
            for(int currHeight : heightSet){
                int safeZone = 0;
                // 방문 확인 배열 초기화
                visited = new boolean[n][n];

                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        if(!visited[i][j] && map[i][j] > currHeight){
                            dfs(i, j, map, visited, currHeight);
                            safeZone++;
                        }
                    }
                }
                maxSafeZone = Math.max(maxSafeZone, safeZone);
            }
        }

        System.out.println(maxSafeZone);
    }

    // dfs
    public static void dfs(int x, int y, int[][] map, boolean[][] visited, int currHeight ){
        // 방문 확인 체크
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nX = x + dr[i];
            int nY = y + dc[i];

            // 범위내에서 확인
            if(nX >= 0 && nX < map.length && nY >= 0 && nY < map[0].length
                    && !visited[nX][nY] && map[nX][nY] > currHeight){
                visited[nX][nY] = true;
                dfs(nX, nY, map, visited, currHeight);
            }
        }
    }
}
