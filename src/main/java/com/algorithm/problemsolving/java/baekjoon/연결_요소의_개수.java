package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6 8                              -> 정점의 개수 N과 간선의 개수 M
 * 1 2                              -> M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 * 5 4
 * 2 4
 * 2 3
 *
 * 출력 :
 * 1
 *
 * 문제 : https://www.acmicpc.net/problem/11724
 */
import java.io.*;
import java.util.*;

public class 연결_요소의_개수 {
    // 그래프 - 링크드리스트
    static List<List<Integer>> graph;
    // 그래프 수
    static int count = 0;
    // 방문 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력으로 그래프를 만들어서 그래프 수를 반환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 링크드리스트 초기화
        // 1. n+1 크기의 리스트 생성
        graph = new ArrayList<>(n+1);
        // 2. 각 노드에 대한 리스트 초기화 (0부터 시작함 주의)
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 배열 초기화
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // dfs
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                countGraph(i);
                count++;
            }
        }
        System.out.print(count);
    }

    private static void countGraph(int node) {
        visited[node] = true;

        for(int linkN : graph.get(node)) {
            if(!visited[linkN]) {
                visited[linkN] = true;
                countGraph(linkN);
            }
        }
    }
}
