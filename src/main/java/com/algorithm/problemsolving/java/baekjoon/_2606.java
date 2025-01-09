package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/2606
 * - 그래프
 * - DFS
 */
import java.util.*;
import java.io.*;
public class _2606 {
    private static List<List<Integer>> graph;
    private static int count;
    // 방문 확인 배열
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int infoNum = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>(n+1);
        // 각 인덱스에 대해 ArrayList 추가
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        // [주의] 방문 배열 초기화
        visited = new boolean[n+1];

        // 연길 리스트 양방향
        for(int i=0; i<infoNum; i++) {
            String[] info = br.readLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        findVirusNodes(1);
        System.out.print(count);
    }

    private static void findVirusNodes(int node) {
        // 방문
        visited[node] = true;

        // 해당 노드와 이어진 노드들 순회하며 방문 처리
        for(int near : graph.get(node)) {
            if(!visited[near]) {
                count++;
                findVirusNodes(near);
            }
        }
    }
}
