package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6                -> 동기의 수 n (2 ≤ n ≤ 500)
 * 5                -> 리스트의 길이 m (1 ≤ m ≤ 10000)
 * 1 2              -> 친구 관계 ai bi
 * 1 3
 * 3 4
 * 2 3
 * 4 5
 *
 * 출력 : 자신의 친구와 친구의 친구를 초대, 초대하는 동기의 수 출력
 * 3
 *
 * 문제 : https://www.acmicpc.net/problem/5567
 * - 그래프 (인접 리스트)
 * - BFS + 큐
 */
import java.util.*;
import java.io.*;

public class 결혼식 {
    // 친구 관계 그래프 (인접 리스트로 구성)
    static List<List<Integer>> graph;
    // 방문 확인 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>(n+1);
        // 각 인덱스에 대해 ArrayList 추가
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접리스트 양방향
        for(int i=0; i<m; i++) {
            String[] data = br.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 방문 배열 초기화
        visited = new boolean[n+1];

        int result = canGo(1);
        System.out.print(result);
    }

    private static int canGo(int start) {
        // 큐
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        // 방문 확인
        visited[start] = true;

        // 깊이 (나 :0, 친구: 1, 친구의 친구 :2 까지만 결혼식 참석 가능)
        int depth = 0;
        int count = 0;

        while(!q.isEmpty()) {
            // depth가 2 이상이면 종료
            if (depth == 2) break;

            // 현재 큐에 있는 노드 개수
            int size = q.size();
            // 해당 레벨의 모든 노드를 탐색
            for(int i=0; i<size; i++) {
                int curr = q.poll();

                for(int next : graph.get(curr)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        count++;
                        q.add(next);
                    }
                }
            }
            // 한 레벨이 끝나면 증가
            depth++;
        }
        return count;
    }
}
