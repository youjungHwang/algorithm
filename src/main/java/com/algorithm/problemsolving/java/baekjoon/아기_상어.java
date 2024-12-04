package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4                -> 공간의 크기 N(2 ≤ N ≤ 20)
 * 4 3 2 1          ->  공간의 상태 (0: 빈 칸 || 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기 || 9: 아기 상어의 위치)
 * 0 0 0 0
 * 0 0 9 0
 * 1 2 3 4
 *
 * 출력 : 아기상어가 물고기를 잡아먹을 수 있는 시간
 * 14
 *
 * 문제 : https://www.acmicpc.net/problem/ => BFS
 * - 가장 처음 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
 * - 아기 상어 이동 조건 : 상어 크기 >= 물고기 크기
 * - 아기 상어는 자신보다 작은 물고기만 먹을 수 있다
 * - 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다
 *
 * - 먹을 수 있는 물고기가 1마리보다 많다면, (순서 존재)
 *  - 1. 거리가 가장 가까운 물고기
 *  - 2. 가장 위에 있는 물고기
 *  - 3. 가장 왼쪽에 있는 물고기를 먹는다.
 */
import java.util.*;
import java.io.*;

public class 아기_상어 {
    // 4방향
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    // map의 크기
    private static int n;

    // map
    private static int[][] map;
    
    // 방문 확인
    private static boolean[][] visited;
    
    // 상어 초기 위치
    private static int[] startShark = new int[2];

    // 상어 초기 크기
    private static int sharkSize = 2;

    // 먹은 물고기 수
    private static int eatFish = 0;

    // 최종 시간
    private static int totalMinTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        // 초기화
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                
                if(map[i][j] == 9) {
                    startShark[0] = i;
                    startShark[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            // 가장 가까운 물고기 탐색
            int[] nearFish = bfs(startShark[0], startShark[1]);

            // 더이상 먹을 물고기가 없으면 종료
            if(nearFish == null) {
                break;
            }

            // 물고기 위치까지 상어 이동
            startShark[0] = nearFish[0];
            startShark[1] = nearFish[1];
            totalMinTime += nearFish[2];
            eatFish++;
            map[startShark[0]][startShark[1]] = 0;

            // 상어 크기 업데이트
            if(eatFish == sharkSize) {
                sharkSize ++;
                eatFish = 0;
            }
        }
        System.out.println(totalMinTime);
    }

    // bfs
    private static int[] bfs(int sharkX, int sharkY) {
        // 상어를 넣는 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sharkX, sharkY});

        // 이동 거리
        int[][] distance = new int[n][n];

        // 초기화, 방문 확인
        visited = new boolean[n][n];
        visited[sharkX][sharkY] = true;

        // 물고기를 정렬할 때 사용할 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[2] != b[2]) return a[2] - b[2]; // distance값 기준으로 오름차순 정렬
            if(a[0] != b[0]) return a[0] - b[0]; // x값 기준으로 오름차순 정렬
            return a[1] - b[1]; // y값을 기준으로 오름차순 정렬
        });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 이동
            for(int i=0; i<4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                // 상어가 이동할 수 있는지
                if(canGo(nextX, nextY) && !visited[nextX][nextY]) {
                    if(map[nextX][nextY] <= sharkSize) {
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[currX][currY] + 1;
                        q.add(new int[] {nextX, nextY});
                    }

                    // 먹을 수 있는 물고기면 리스트에 추가
                    if(map[nextX][nextY] > 0 && map[nextX][nextY] < sharkSize) {
                        pq.add(new int[] {nextX, nextY, distance[nextX][nextY]});
                    }
                }
            }
        }

        // 먹을 물고기가 없으면 null 반환
        if(pq.isEmpty()) {
            return null;
        }else {
            return pq.poll();
        }
    }

    // 유효한 위치인지 확인
    private static boolean canGo(int x, int y) {
        return x >= 0 && x < n && y >= 0 &&  y< n;
    }
}
