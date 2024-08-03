package com.algorithm.problemsolving.java.baekjoon;

import java.util.*;
import java.io.*;

/**
 * 7569. 토마토 - bfs
 *
 * input :
 * 5 3 2       -> 가로(m), 세로(n), 높이(h)
 * 0 0 0 0 0   -> 1(익음), 0(안 익음), -1(토마토가 없음)
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 1 0 0
 * 0 0 0 0 0
 *
 * output: 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수 (안 익으면 -1)
 * 4
 *
 * 문제: https://www.acmicpc.net/problem/7569
 */
public class Tomato {
    // 3차원 방향 배열 (4방향 + 상 + 하)
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]); // 가로
        int n = Integer.parseInt(size[1]); // 세로
        int h = Integer.parseInt(size[2]); // 높이

        // 어디에 저장할까? 3차원 배열
        int[][][] map = new int[h][n][m];
        // map과 같은 형태의 visited 생성하여 방문 확인
        boolean[][][] visited = new boolean[h][n][m];

        // 입력 받아서 map에 저장
        // 각 층 (h)에 대해, 각 행 (n)의 데이터를 읽고, 이를 각 열 (m)에 저장
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                String[] row = br.readLine().split(" ");
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(row[k]);
                }
            }
        }

        System.out.println(bfs(map,visited, h, n, m));
    }

    // bfs
    public static int bfs(int[][][] map, boolean[][][] visited, int h, int n, int m){
        // 큐 생성, 큐에 무엇을 저장할까 : h,n,m,일수
        Queue<int[]> q = new ArrayDeque<>();

        // 어떤 걸 큐에 넣고 방문 확인을 할까? 전체를 돌면서 초기 상태에서 이미 익은 토마토를 넣는다
        // -> BFS 탐색의 시작을 준비
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 1){
                        q.add(new int[]{i,j,k,0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int minDays = 0;

        // bfs 탐색
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int ch = curr[0]; // 현재 높이
            int cn = curr[1]; // 현재 세로
            int cm = curr[2]; // 현재 가로
            int day = curr[3];
            minDays =  Math.max(minDays, day);

            // 경계안에서 6방향으로 움직이면서 확인
            for(int i=0; i<6; i++){
                int nh = ch + dz[i];
                int nn = cn + dy[i];
                int nm = cm + dx[i];

                if(nh >= 0 && nh < map.length && nn >= 0 && nn < map[0].length && nm >= 0 && nm < map[0][0].length){
                    if(!visited[nh][nn][nm] && map[nh][nn][nm] == 0){
                        // 익지 않은 토마토를 큐에 추가하고 그 상태를 익은 상태로 갱신
                        // -> BFS 탐색 중에 상태를 갱신하는 과정
                        q.add(new int[]{nh,nn,nm,day + 1});
                        visited[nh][nn][nm] = true;
                        map[nh][nn][nm] = 1;
                    }
                }
            }
        }

        // 그럼에도 전체 돌면서 익지 않은 토마토가 있다면 -1 반환
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }

        return minDays;
    }
}
