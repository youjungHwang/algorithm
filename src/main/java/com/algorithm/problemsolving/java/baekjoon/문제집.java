package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 2          -> 문제의 수 N(1 ≤ N ≤ 32,000)과 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 M(1 ≤ M ≤ 100,000)
 * 4 2          -> 순서쌍 (A,B) A번 문제는 B번 문제보다 먼저 푸는 것이 좋다
 * 3 1
 *
 * 출력 :
 * 3 1 4 2
 *
 * 문제 : https://www.acmicpc.net/problem/1766
 * - 위상정렬
 */

import java.util.*;
import java.io.*;

public class 문제집 {
    // 인접리스트
    private static ArrayList<Integer>[] edges;
    // 진입 차수 관리 배열
    private static int[] indegree;
    // 가능하면 쉬운 문제부터 풀어야 하므로, 큐가 아닌 우선순위 큐
    private static Queue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 인접리스트, 진입 차수 배열 초기화
        edges = new ArrayList[n+1];
        indegree = new int[n+1];

        for(int i=1; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            String[] data = br.readLine().split(" ");
            int first = Integer.parseInt(data[0]);
            int second = Integer.parseInt(data[1]);

            edges[first].add(second);
            indegree[second]++;
        }

        // 큐에 원소 추가
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        topologicalSort();
    }

    // 위상 정렬
    private static void topologicalSort() {
        // 큐에 원소가 다 없을 때까지 반복
        while(!q.isEmpty()) {
            // 큐에 원소를 하나 꺼냄
            int x = q.poll();

            // x값을 출력, 뽑히는 순서가 곧 위상정렬 순서가 됨
            System.out.print(x + " ");

            // x에서 갈 수 있는 모든 곳을 탐색
            for (int i = 0; i < edges[x].size(); i++) {
                int y = edges[x].get(i);

                indegree[y]--;

                if (indegree[y] == 0) {
                    q.add(y);
                }
            }
        }
    }
}

