package com.algorithm.problemsolving.java.programmers;

import java.util.*;
/**
 * [고득점 kit] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 게임 맵 최단거리 - bfs
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임_맵_최단거리 {
    // 4방향 이동
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};
    private static boolean[][] visited;


    public int solution(int[][] maps) { // 길(1), 벽(0)
        // 맵의 크기
        int n = maps.length;
        int m = maps[0].length;

        // 방문 확인 배열 초기화
        visited = new boolean[n][m];

        // 상대팀이 주위에 벽(0)이 있다면 return -1
        // 주위 : 북(-1,0), 북서(-1,-1), 서(0,-1)
        // [주의] 인덱스는 0부터 시작해 상대팀 위치가 maps[n-1][m-1]
        // [주의] 맵 크기가 2x2 이상인 경우에만 체크
        if(n>1 && m>1){
            if(maps[n-2][m-1] == 0 && maps[n-2][m-2] == 0 && maps[n-1][m-2] == 0) {
                return -1;
            }
        }

        // 최단거리 구할 bfs 호출
        return bfs(n, m, maps);
    }

    public static int bfs(int n, int m, int[][] maps){
        // 큐 생성
        Queue<int[]> q = new ArrayDeque<>();
        // 큐 초기화 (현재 위치와 거리) {row, col, distance}
        q.add(new int[]{0,0,1});
        // 방문 확인
        visited[0][0] = true;

        // 큐가 빌 때까지 탐색
        while(!q.isEmpty()){
            // 큐에서 하나 빼고
            int[] current = q.poll();
            int cX = current[0];
            int cY = current[1];
            int cD = current[2];

            // [주의] 도착했을 때 현재까지 누적거리 return
            if(cX == n-1 && cY == m-1){
                // [주의] distance가 아닌 cD를 반환
                return cD;
            }

            // 4방향으로 돌면서
            for(int i=0; i<4; i++){
                int nX = cX + dr[i];
                int nY = cY + dc[i];

                // 경계 안에서, 길(1)곳만 이동가능
                if(nX >= 0 && nX < n && nY >= 0 && nY < m && maps[nX][nY] == 1 && !visited[nX][nY]){
                    q.add(new int[]{nX,nY,cD+1});
                    visited[nX][nY] = true;
                    // [주의] 불필요한 bfs 호출 제거
                }
            }
        }
        // 도착점에 갈 수없는 경우 -1 반환
        return -1;
    }
}
