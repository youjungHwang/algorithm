package com.algorithm.problemsolving.java.baekjoon;

import java.util.*;
import java.io.*;

/**
 * 2644. 촌수계산 - bfs
 *
 * input:
 * 9    -> 전체 사람의 수 n
 * 7 3  -> 촌수를 계산해야 하는 서로 다른 두 사람의 번호
 * 7    -> 부모 자식들 간의 관계의 개수 m
 * 1 2
 * 1 3
 * 2 7
 * 2 8
 * 2 9
 * 4 5
 * 4 6
 *
 * 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다. (각 사람의 부모는 최대 한 명만 주어진다.)
 *
 * output: 찾을 수 없으면 -1
 * 3
 *
 * 문제: https://www.acmicpc.net/problem/2644
 */
public class CalculationOfKinship {
    private static Map<Integer,List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] question = br.readLine().split(" ");
        int start = Integer.parseInt(question[0]);
        int target = Integer.parseInt(question[1]);
        int m = Integer.parseInt(br.readLine());

        // 간선 리스트 초기화 (1번부터 시작)
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            String[] data = br.readLine().split(" ");
            int u = Integer.parseInt(data[0]);
            int v = Integer.parseInt(data[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 방문 확인 배열 초기화 (1번부터 확인)
        visited = new boolean[n+1];
        int result = bfs(start, target);

        System.out.println(result);
    }

    // bfs
    public static int bfs(int start, int target){
        // 큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        // 큐 저장시 [현재노드, start-현재노드의 촌수]
        queue.add(new int[]{start, 0});
        // 방문 확인
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int person = current[0];
            int degree = current[1];

            // 만약 노드가 target이랑 같으면 반환
            if(person == target) {
                return degree;
            }

            for(int nv : graph.get(person)){
                if(!visited[nv]){
                    visited[nv] = true;
                    queue.add(new int[]{nv,degree+1});
                }
            }
        }
        return -1;
    }
}
