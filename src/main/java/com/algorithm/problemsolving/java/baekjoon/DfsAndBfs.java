package com.algorithm.problemsolving.java.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1260. DFS와 BFS
 *
 * input :
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 *
 * input 설명 :
 * 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V
 * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
 *
 * output :
 * 1 2 4 3
 * 1 2 3 4
 *
 * 문제: https://www.acmicpc.net/problem/1260
 */
public class DfsAndBfs {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Map<Integer, Boolean> visited = new HashMap<>();
    private static List<Integer> dfsResult = new ArrayList<>();
    private static List<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int v = Integer.parseInt(data[2]);

        // 각 노드에 대해 리스트 초기화
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            String[] edges = br.readLine().split(" ");
            int u1 = Integer.parseInt(edges[0]);
            int u2 = Integer.parseInt(edges[1]);

            graph.get(u1).add(u2);
            graph.get(u2).add(u1);
        }

        // 노드 번호 순으로 오름차순 정렬
        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }

        dfs(v);
        // [중요] visited 초기화
        visited.clear();
        bfs(v);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int dfsData : dfsResult) {
            bw.write(dfsData + " ");
        }
        bw.newLine();
        for (int bfsData : bfsResult) {
            bw.write(bfsData + " ");
        }
        bw.flush();
    }

    public static void dfs(int v) {
        visited.put(v, true);
        dfsResult.add(v);
        for (int nextVertex : graph.get(v)) {
            if (!visited.containsKey(nextVertex)) {
                dfs(nextVertex);
            }
        }
    }

    public static void bfs(int v) {
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited.put(v, true);
        bfsResult.add(v);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int nextVertex : graph.get(currentVertex)) {
                if (!visited.containsKey(nextVertex)) {
                    queue.offer(nextVertex);
                    visited.put(nextVertex, true);
                    bfsResult.add(nextVertex);
                }
            }
        }
    }
}
