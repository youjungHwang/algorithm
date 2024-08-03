package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 2606번 바이러스 - dfs
 *
 * input:
 * 7 컴퓨터의 수
 * 6 연결되어 있는 컴퓨터 쌍의 수
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 *
 * output: 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
 * 4
 *
 * 문제: https://www.acmicpc.net/problem/2606
 */
public class Virus {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // [주의] 각 노드에 대해 리스트 초기화 (컴퓨터 수 기준)
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 입력
        for(int i=0; i<m; i++){
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // visited 초기화 (1부터 n까지 사용)
        visited = new boolean[n+1];

        // 1번 컴퓨터를 확인하므로 1을 넘김
        int result = dfs(start) -1;
        System.out.println(result);
    }

    // dfs
    public static int dfs(int start){
        visited[start] = true;
        int result = 1;

        // 인접하는 노드, 방문 하지 않았다면 dfs
        for(int nv : graph.get(start)){
            if(!visited[nv]){
                result += dfs(nv);
            }
        }
        return result;
    }
}
