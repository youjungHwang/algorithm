package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 4          -> R(행)과 C(열)
 * ####         -> #(벽), .(지나갈 수 있는 공간), J(사용자 초기 위치), F(불이난 위치)
 * #JF#
 * #..#
 * #..#
 *
 * 출력 :
 * 3
 *
 * 문제 : https://www.acmicpc.net/problem/4179
 */
import java.util.*;
import java.io.*;

public class 불 {
    // 4방향
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 미로
    static char[][] map;
    static int r;
    static int c;

    // 큐
    static Queue<int[]> fireQueue = new ArrayDeque<>();
    static Queue<int[]> jihoonQueue = new ArrayDeque<>();

    // 도달하는 시간
    static int[][] fireTime;
    static int[][] jihoonTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mapInfo = br.readLine().split(" ");
        r = Integer.parseInt(mapInfo[0]);
        c = Integer.parseInt(mapInfo[1]);

        // 초기화
        map = new char[r][c];
        fireTime = new int[r][c];
        jihoonTime = new int[r][c];

        for(int row=0; row<r; row++) {
            Arrays.fill(fireTime[row], Integer.MAX_VALUE);
            Arrays.fill(jihoonTime[row], -1);
        }

        // map 생성
        for (int i = 0; i < r; i++) {
            String info = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = info.charAt(j);

                if(map[i][j] == '#') {
                    fireTime[i][j] = -1;
                    jihoonTime[i][j] = -1;
                }

                if(map[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    fireQueue.add(new int[]{i, j});
                }

                if(map[i][j] == 'J') {
                    jihoonTime[i][j] = 0;
                    jihoonQueue.add(new int[]{i, j});
                }
            }
        }

        // 불의 이동
        moveFire();

        // 지훈이의 이동
        moveJihoon();
    }

    // 불의 이동 BFS
    private static void moveFire() {
        // 불은 벽을 제외한 모든 곳으로 퍼질 수 있다
        while(!fireQueue.isEmpty()) {
            // 큐에서 꺼냄
            int[] curr = fireQueue.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 4방향 이동
            for(int i=0; i<4; i++) {
                int nextX = currX + dr[i];
                int nextY = currY + dc[i];

                // 범위 확인
                if(canGo(nextX, nextY) && map[nextX][nextY] != '#' && fireTime[nextX][nextY] == Integer.MAX_VALUE) {
                    fireTime[nextX][nextY] = fireTime[currX][currY] + 1;
                    fireQueue.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    // 지훈이의 이동 BFS
    private static void moveJihoon() {
        // 지훈이는 불이 있는곳으로 이동할 수 없다
        while(!jihoonQueue.isEmpty()) {
            // 큐에서 꺼냄
            int[] curr = jihoonQueue.poll();
            int currX = curr[0];
            int currY = curr[1];

            // [종료조건] 지훈이는 벽을 만나면 탈출 할 수 있다
            // [주의] 지훈이 도착 시간이 불의 시간보다 작아야 한다
            if(currX == 0 || currX == r-1 || currY == 0 || currY == c-1 && jihoonTime[currX][currY] < fireTime[currX][currY]) {
                System.out.println(jihoonTime[currX][currY] + 1);
                return;
            }

            // 4방향 이동
            for(int i=0; i<4; i++) {
                int nextX = currX + dr[i];
                int nextY = currY + dc[i];

                // 범위 확인
                if(canGo(nextX, nextY) && map[nextX][nextY] == '.' && jihoonTime[nextX][nextY] == -1) {
                    // [주의] 불보다 먼저 도달할 수 있는 경우만 이동한다
                    if (jihoonTime[currX][currY] + 1 < fireTime[nextX][nextY]) {
                        jihoonTime[nextX][nextY] = jihoonTime[currX][currY] + 1;
                        jihoonQueue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        // 탈출 실패
        System.out.println("IMPOSSIBLE");
    }

    // 유효 범위
    private static boolean canGo(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}





