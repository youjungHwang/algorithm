package com.algorithm.problemsolving.java.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 뿌요뿌요 - dfs
 *
 * input:
 * 3
 * 1 1 1
 * 2 1 2
 * 1 1 1
 *
 * output:
 * 1 7
 *
 * 문제: https://www.codetree.ai/missions/2/problems/puyo-puyo/description
 */
public class PuyoPuyo {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 하나의 dfs가 끝나고 기준인 4개가 넘어야 인정 (뿌요 그룹의 수)
        int blockCount = 0;
        // 가장 큰 뿌요 그룹의 크기
        int maxBlockSize = 0;

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int limit = dfs(i, j, map);
                    if (limit >= 4) {
                        blockCount += 1;
                        maxBlockSize = Math.max(limit, maxBlockSize);
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(blockCount + " " + maxBlockSize);
        bw.flush();
    }

    // dfs
    public static int dfs(int x, int y, int[][] map) {
        // 방문 표시
        visited[x][y] = true;
        int count = 1;

        // map 경계 안에서 4방향 이동
        for (int i = 0; i < 4; i++) {
            int newX = x + dr[i];
            int newY = y + dc[i];

            if (newX >= 0 && newX < map.length && newY >= 0 && newY < map.length && !visited[newX][newY]) {
                // 뿌요가 같은 것만 dfs 호출
                if (map[x][y] == map[newX][newY]) {
                    count += dfs(newX, newY, map);
                }
            }
        }
        return count;
    }
}
