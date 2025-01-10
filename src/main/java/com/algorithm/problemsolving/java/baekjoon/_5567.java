package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/5567
 * - 그래프(BFS)
 * - 친구와 친구의 친구까지만 count
 */
import java.util.*;
import java.io.*;

public class _5567 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // [주의] 그래프 초기화
        graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            String[] info = br.readLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 방문 배열 초기화
        visited = new boolean[n+1];
        visited[1] = true;

        int count = bfs(1, 0);

        System.out.print(count);
    }

    // 친구 찾기(depth 2까지)
    private static int bfs(int node, int depth) {
        // 큐
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);

        while(!q.isEmpty()) {
            // depth가 2면 종료
            if(depth == 2) {
                break;
            }

            // 현재 큐에 있는 노드 개수
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                // 큐에서 뽑고
                int curr = q.poll();
                for(int next : graph.get(curr)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        count++;
                        q.add(next);
                    }
                }
            }
            depth++;
        }
        return count;
    }
}
