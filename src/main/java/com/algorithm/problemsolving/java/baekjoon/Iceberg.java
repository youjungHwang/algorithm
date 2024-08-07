package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 2573. 빙산 - bfs
 *
 * input:
 * 5 7
 * 0 0 0 0 0 0 0
 * 0 2 4 5 3 0 0
 * 0 3 0 2 5 2 0
 * 0 7 6 2 4 0 0
 * 0 0 0 0 0 0 0
 *
 * output:
 * 2
 *
 * 문제: https://www.acmicpc.net/problem/2573
 */
public class Iceberg {
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        // 입력 담을 map
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int year = 0;
        while(true){
            int count = icebergCount(map);
            if(count == 0){
                System.out.println(0);
                break;
            }else if(count > 1){
                System.out.println(year);
                break;
            }

            // 매년 빙산 높이 재조정
            meltHeight(map);
            year++;
        }
    }

    // 빙산 덩어리 개수 세는 함수
    public static int icebergCount(int[][] map){
        // 빙산 덩어리 수
        int count = 0;
        // 방문 확인, 매번 초기화 해야함
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    // 연결된 빙산 덩어리를 모두 방문 처리하고, 덩어리 개수를 증가시킴
                    bfs(i,j,map);
                    count ++;
                }
            }
        }
        return count;
    }

    // bfs : 빙산 영역 탐색
    public static void bfs(int x, int y, int[][] map){
        // 큐 선언
        Queue<int[]> q = new ArrayDeque<>();
        // 큐 넣기
        q.add(new int[]{x,y});
        // 방문 확인
        visited[x][y] = true;

        while (!q.isEmpty()){
            // 큐에서 하나 poll
            int[] current = q.poll();
            int currX = current[0];
            int currY = current[1];

            // 4방향으로 연결된 칸을 큐에 넣고 방문처리
            for(int i=0; i<4; i++){
                int nX = currX + dr[i];
                int nY = currY + dc[i];

                // 범위 확인
                if(nX >= 0 && nX < n && nY >=0 && nY < m & !visited[nX][nY] && map[nX][nY] != 0){
                    q.add(new int[]{nX,nY});
                    visited[nX][nY] = true;
                }
            }
        }
    }

    // 매년 빙산 높이 조정 함수
    public static void meltHeight(int[][] map){
        // [주의] 새로운 맵 초기화
        int[][] newMap = new int[n][m];

        // 현재 칸 -> 4방향 이동 ->  0인 곳이 있으면 카운트
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // 현재 칸은 빙산
                if(map[i][j] != 0){
                    // [주의] seaCount를 매번 초기화, 누적x
                    int seaCount = 0;
                    // 4방향을 확인하면서
                    for(int k=0; k<4; k++){
                        int nX = i + dr[k];
                        int nY = j + dc[k];

                        if(nX >= 0 && nX < n && nY >=0 && nY < m && map[nX][nY] == 0) {
                            seaCount ++;
                        }
                    }
                    // 현재 칸의 높이를 줄임
                    newMap[i][j] = map[i][j] - seaCount;
                    if(newMap[i][j] < 0) {
                        // 높이가 음수가 되면 0으로 설정
                        newMap[i][j] = 0;
                    }
                }
            }
        }

        // [주의] 원래 맵을 새로운 맵으로 업데이트
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }
}
