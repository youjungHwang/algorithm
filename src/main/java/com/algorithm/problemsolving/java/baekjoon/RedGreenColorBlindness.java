package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;

/**
 * 10026. 적록색약 - dfs
 *
 * 문제: https://www.acmicpc.net/problem/10026
 */
public class RedGreenColorBlindness {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];

        for(int i =0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                matrix[i][j] = line.charAt(j);
            }
        }

        int normalCount = 0;
        int colorBlindCount = 0;

        // 정상인의 경우 dfs
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j, matrix, matrix[i][j]);
                    // [핵심] 같은 문자 dfs가 끝나면 count +1
                    normalCount++;
                }
            }
        }

        // 적록색맹의 경우 dfs
        // visited 배열 초기화
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 'R'){
                    matrix[i][j] = 'G';
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j, matrix, matrix[i][j]);
                    // [핵심] 같은 문자 dfs가 끝나면 count +1
                    colorBlindCount++;
                }
            }
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(normalCount + " " + colorBlindCount);
        bw.flush();
    }

    // dfs
    public static void dfs(int x, int y, char[][] matrix, char currentColor){
        visited[x][y] = true;

        // 경계 안쪽으로 4방향 돌면서 확인
        for(int i=0; i<4; i++){
            int newX = x + dr[i];
            int newY = y + dc[i];

            if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix.length && !visited[newX][newY]){
                if(matrix[newX][newY] == currentColor){
                    dfs(newX, newY, matrix, matrix[newX][newY]);
                }
            }
        }
    }
}
