package com.algorithm.problemsolving.java.programmers;

/**
 * [고득점 kit] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 네트워크 - dfs
 *
 * input :
 *   n : 3
 *   computers : [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
 *
 * output :
 *   2
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class 네트워크 {
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int count = 0;

        // 방문 배열 초기화, [false][false][false]
        visited = new boolean[n];

        // 모든 컴퓨터에 대해 탐색
        for(int i=0; i<n; i++){
            // [주의] 방문하지 않은 컴퓨터에 대해서만 dfs 호출
            if(!visited[i]){
                dfs(n, computers, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int n, int[][] computers, int i){
        // 현재 컴퓨터 방문 확인
        visited[i] = true;

        // [주의] for문 돌면서 computers[i][j] 연결된 다른 컴퓨터들을 탐색
        for(int j=0; j<n; j++){
            if(computers[i][j] == 1 && i != j && !visited[j]){
                dfs(n, computers, j);
            }
        }
    }

}
