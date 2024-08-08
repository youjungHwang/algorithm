package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 14503. 로봇 청소기 - bfs
 *
 * input:
 * 3 3                 // 방의 크기 N과 M (3 <= N,M <= 50)
 * 1 1 0               // 로봇 청소기 현재 좌표 및 방향
 * 1 1 1               // N개의 줄에는 방의 상태 (1은 벽, 0은 청소가 되어있지 않은 방)
 * 1 0 1
 * 1 1 1
 *
 * output:
 * 1
 *
 * 문제: https://www.acmicpc.net/problem/14503
 */

/*
*
1. 4방향으로 이동, 0: 청소 안되어있는 방, 1: 벽 -> 0을 청소
2. 4방향 중 청소 안되어있는 방이 있다면
  2-1. 반시계 90도로 회전하여 그 방향으로 이동해 청소
3. 4방향 다 청소가 다 되어있다면
  3-1. 후진 1칸하고 청소할 곳이 있나 다시 확인
  3-2. 뒤가 벽이라 후진할 수 없으면 종료
*  */
public class RobotVacuum {
    private static boolean[][] visited;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int n,m;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] room = br.readLine().split(" ");
        n = Integer.parseInt(room[0]);
        m = Integer.parseInt(room[1]);
        String[] robot = br.readLine().split(" ");

        // 방 map
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                int state = Integer.parseInt(row[j]);
                map[i][j] = state;
            }
        }

        // 출력
        System.out.print(bfs(map, robot));
    }

    public static int bfs(int[][] map, String[] robot){
        // 청소한 방 수
        int cleanRoom = 1;
        // 큐 선언
        Queue<int[]> queue = new ArrayDeque<>();
        // 큐에 로봇의 현재 위치를 추가
        int rX = Integer.parseInt(robot[0]);
        int rY = Integer.parseInt(robot[1]);
        int rD = Integer.parseInt(robot[2]);
        queue.add(new int[]{rX,rY,rD});

        // 방문 배열 초기화 및 확인
        visited = new boolean[n][m];
        visited[rX][rY] = true;

        while(!queue.isEmpty()){
            // 큐에서 하나 위치를 뽑음
            int[] curr = queue.poll();
            int cX = curr[0];
            int cY = curr[1];
            int cD = curr[2];
            // 처음에는 모두 청소가 안되어있다고 가정
            boolean isClean = false;

            // 4방향을 탐색하는데, 문제에서 반시계 방향으로 회전하라고 함
            for(int i=0; i<4; i++){
                // 반시계 방향으로 회전
                int newD = (cD + 3) % 4;
                int nX = cX + dr[newD];
                int nY = cY + dc[newD];

                // 범위 내에 있고 청소되지 않은 공간이면
                if(nX >= 0 && nX < n && nY >= 0 && nY < m && !visited[nX][nY] && map[nX][nY] == 0){
                    queue.add(new int[]{nX, nY, newD});
                    visited[nX][nY] = true;
                    cleanRoom ++;
                    // 청소되지 않은 공간을 찾고 청소했으므로
                    isClean = true;
                    break;
                }
                // [주의] 다음 방향으로 갱신
                cD = newD;
            }

            // 4방향 모두 청소가 완료되었거나 벽인 경우
            // isClean의 기본값이 false이므로 이건 true
            if(!isClean){
                // [주의] 후진은 한번만 이므로 for문 없음
                // 후진 방향으로 이동
                int backD = (cD + 2) % 4;
                int bX = cX + dr[backD];
                int bY = cY + dc[backD];

                // 후진 가능하면(벽이 아니면) 후진하고 벽이면 멈춤
                if(bX >= 0 && bX < n && bY >= 0 && bY < m&& map[bX][bY] != 1){
                    // [주의] 후진 시에는 현재 방향을 유지하면서 후진 위치를 설정
                    queue.add(new int[]{bX, bY, cD});
                }else{
                    break;
                }
            }
        }
        return cleanRoom;
    }
}
