package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 3 3       -> 방의 크기 N,M
 * 1 1 0     -> 로봇 청소기 시작 점(1,1), 현재 바라보고 있는 방향(0)
 * 1 1 1     -> 방의 상태 : 0(청소 필요한 빈칸), 1(벽)
 * 1 0 1
 * 1 1 1
 *
 * 출력 :
 * 1         -> 청소 가능한 방의 수
 *
 * 문제 :
 * https://www.acmicpc.net/problem/14503
 */
import java.io.*;

public class 로봇_청소기 {
    // 4방향 이동
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};

    // 방
    private static int[][] map;

    // 방 청소 유무
    private static boolean[][] visited;

    // 청소 가능한 방의 수
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomSize = br.readLine();
        String startPoint = br.readLine();

        // 변수 입력 및 선언
        String[] dividedInputRoomSize = roomSize.split(" ");
        int n = Integer.parseInt(dividedInputRoomSize[0]);
        int m = Integer.parseInt(dividedInputRoomSize[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        // 현재 상황
        String[] dividedInputStartPoint = startPoint.split(" ");
        int startX = Integer.parseInt(dividedInputStartPoint[0]);
        int startY = Integer.parseInt(dividedInputStartPoint[1]);
        int startD = Integer.parseInt(dividedInputStartPoint[2]);

        // 현재 방의 상태 map에 넣기
        for(int i=0; i<n; i++){
            String[] value = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(value[j]);
            }
        }

        doCleanTheRoom(startX, startY, startD);
        System.out.println(result);
    }

    private static void doCleanTheRoom(int x, int y, int d) {
        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(map[x][y] == 0 && !visited[x][y]) {
                visited[x][y] = true;
                result++;
            }

            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            // 주변 4칸 청소 상태 확인
            boolean isDirty = false;
            for(int i=0; i<4; i++){
                int nearX = x + dr[i];
                int nearY = y + dc[i];

                if(CanGo(nearX, nearY) && !visited[nearX][nearY]) {
                    // 청소되지 않은 방
                    isDirty = true;
                    break;
                }
            }

            // 반시계 방향으로 90도 회전한다.
            // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다. -> 청소
            if(isDirty) {
                d = (d+3) % 4;
                int nextX = x + dr[d];
                int nextY = y + dc[d];

                if(CanGo(nextX, nextY) && !visited[nextX][nextY]) {
                    // 한 칸 전진한다
                    x = nextX;
                    y = nextY;
                    continue;
                }

            } else {
                // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 청소한다
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                int backDirection = (d+2) % 4;
                int backX = x + dr[backDirection];
                int backY = y + dc[backDirection];

                if(CanGo(backX, backY)) {
                    // 한 칸 후진한다
                    x = backX;
                    y = backY;
                    continue;
                }else {
                    break;
                }
            }
        }
    }

    private static boolean CanGo(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 &&  y < map[0].length && map[x][y] == 0;
    }
}
