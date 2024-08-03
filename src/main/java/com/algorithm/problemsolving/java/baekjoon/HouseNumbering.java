package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 2667. 단지번호붙이기 - dfs
 *
 * 문제: https://www.acmicpc.net/problem/2667
 */
public class HouseNumbering {
    static List<Integer> houses = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 & !visited[i][j]) {
                    int count = dfs(i, j, map);
                    houses.add(count);
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(houses);

        // 출력
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(houses.size() + "\n");
        for (int i = 0; i < houses.size(); i++) {
            writer.write(houses.get(i) + "\n");
        }
        writer.flush();
    }

    // dfs
    public static int dfs(int x, int y, int[][] map) {
        visited[x][y] = true;
        // 현재 집 포함시킴 (새로운 단지를 탐색 할 때마다 초기화 되어야 하므로 전역변수로 공유하면 안됨)
        int count = 1;

        // 경계 안쪽으로 반복문 4방향 돌면서 확인
        for (int i = 0; i < 4; i++) {
            int newX = x + dr[i];
            int newY = y + dc[i];

            if (newX < map.length && newX >= 0 && newY < map.length && newY >= 0) {
                if (map[newX][newY] == 1 & !visited[newX][newY]) {
                    count += dfs(newX, newY, map);
                }
            }
        }
        return count;
    }
}


