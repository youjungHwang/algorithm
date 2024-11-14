package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 5 5                      -> 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)
 * 1 3                      -> 친구 관계는 A와 B
 * 1 4
 * 4 5
 * 4 3
 * 3 2
 *
 * 출력 : 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력
 * 3
 *
 * 문제 : https://www.acmicpc.net/problem/1389
 */
import java.util.*;
import java.io.*;

public class 케빈_베이컨의_6단계_법칙 {
    // 인접 리스트
    static List<List<Integer>> graph;
    // 방문 배열
    static boolean[] visited;
    // 케빈 베이컨의 수를 저장할 배열
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        // 초기화
        visited = new boolean[n+1];
        result = new int[n+1];

        graph = new ArrayList<>(n + 1);
        // 각 인덱스에 대해 ArrayList를 추가
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트 (양방향)
        for(int i=0; i<m; i++) {
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=n; i++) {
            // bfs 호출 전 visited 배열 초기화
            Arrays.fill(visited, false);
            result[i] = searchAll(i, n);
        }

        // 케빈 베이컨의 수가 가장 작은 사람 찾기
        int minIndex = 1;
        for(int i=2; i<=n; i++) {
            if(result[i] < result[minIndex]) {
                minIndex = i;
            }
        }
        System.out.print(minIndex);
    }

    // bfs
    private static int searchAll(int start, int n) {
        // 큐
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        // 방문 확인
        visited[start] = true;
        // 각각의 거리 저장, 초기화
        int[] dist = new int[n+1];

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }

        // 케빈 베이컨 수 계산
        int totalDist = 0;
        for(int i=1; i<=n; i++) {
            totalDist += dist[i];
        }
        return totalDist;
    }
}
