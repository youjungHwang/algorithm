package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 8 900                                    -> 지름길의 개수 N과 고속도로의 길이 D
 * 0 10 9                                   -> 지름길의 시작 위치, 도착 위치, 지름길의 길이 (음의 정수 없음)
 * 20 60 45
 * 80 190 100
 * 50 70 15
 * 160 180 14
 * 140 160 14
 * 420 901 5
 * 450 900 0
 *
 * 출력 : 운전해야 하는 거리의 최솟값
 * 432
 *
 * 문제 : https://www.acmicpc.net/problem/1446
 */
import java.io.*;
import java.util.*;

public class 지름길 {
    // 인접리스트, 키로 정렬하기 위해 TreeMap 사용
    static Map<Integer, List<Edge>> graph = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int d = Integer.parseInt(info[1]);

        for(int i=0; i<n; i++) {
            String[] parts = br.readLine().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int distance = Integer.parseInt(parts[2]);

            if(end <= d && (end - start) > distance) {
                graph.putIfAbsent(start, new ArrayList<>());
                graph.get(start).add(new Edge(end, distance));
            }
        }

        // 시작위치에서 최종위치까지 갈때, 최소 거리를 구하는 메서드 호출
        int minDistance = dijkstra(0, d);
        System.out.print(minDistance);
    }

    private static int dijkstra(int start, int destination) {
        int MAX_VALUE = Integer.MAX_VALUE;

        // dist 배열 선언 및 초기화
        int dist[] = new int[destination + 1];
        Arrays.fill(dist, MAX_VALUE);

        // 우선순위 큐 선언
        Queue<Entry> pq = new PriorityQueue<>();

        // 우선순위 큐 삽입
        pq.add(new Entry(start, 0));

        // dist 추가
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Entry curr = pq.remove();
            int currNode = curr.node;
            int toCurrDistance = curr.distance;

            // 만약 현재 거리 비용이 기록된 비용보다 크다면, 이미 더 적은 비용으로 도달한 경로가 존재하므로 무시
            if(dist[currNode] < toCurrDistance) continue;

            // 일반 도로로 이동
            if(currNode + 1 <= destination &&  toCurrDistance + 1 < dist[currNode + 1] ) {
                dist[currNode + 1] = toCurrDistance + 1;
                pq.add(new Entry(currNode + 1, toCurrDistance + 1));
            }

            // 지름길로 이동
            if (graph.containsKey(currNode)) {
                for(Edge edge : graph.get(currNode)) {
                    int newDist = toCurrDistance + edge.distance;

                    if(newDist < dist[edge.to]) {
                        dist[edge.to] = newDist;
                        pq.add(new Entry(edge.to, newDist));
                    }
                }
            }
        }
        return dist[destination];
    }

    // to 목적지, distance 거리(가중치)
    private static class Edge {
        private int to;
        private int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    // node 현재 노드, distance 현재 노드까지의 최소 거리
    private static class Entry implements Comparable<Entry> {
        private int node;
        private int distance;

        public Entry(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Entry o) {
            return this.distance - o.distance; // 오름차순 정렬
        }
    }
}

