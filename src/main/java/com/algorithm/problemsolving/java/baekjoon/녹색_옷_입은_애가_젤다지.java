package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 3                                -> 동굴의 크기를 나타내는 정수 N
 * 5 5 4                            -> 숫자는 도둑루피를 나타냄
 * 3 9 1
 * 3 2 7
 * 5
 * 3 7 2 0 1
 * 2 8 0 9 1
 * 1 2 1 8 1
 * 9 8 9 2 0
 * 3 6 5 1 5
 * 7
 * 9 0 5 1 1 5 3
 * 4 1 2 1 6 5 3
 * 0 7 6 1 6 8 5
 * 1 1 7 8 3 2 3
 * 9 4 0 7 6 4 1
 * 5 8 3 2 4 8 3
 * 7 4 8 4 8 3 4
 * 0                                -> N = 0인 입력이 주어지면 전체 입력이 종료된다.
 *
 * 출력 :
 * Problem 1: 20
 * Problem 2: 19
 * Problem 3: 36
 *
 * 문제 : https://www.acmicpc.net/problem/4485
 * - 도둑루피를 최소로 만나야 한다, 잃을 수밖에 없는 최소 금액을 출력
 * - 다익스트라 알고리즘 활용
 */
import java.util.*;
import java.io.*;

public class 녹색_옷_입은_애가_젤다지 {
    // 4방향 확인 후 최소 루피인 쪽으로 이동
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    // 동굴의 크기를 나타내는 n
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 0;

        while(true) {
            n = Integer.parseInt(br.readLine());
            // 입력 종료 조건
            if (n == 0) break;
            testCase ++;

            // 테스트 케이스마다 초기화
            int[][] costMatrix = new int[n][n];
            for(int i=0; i<n; i++) {
                String[] paths = br.readLine().split(" ");
                for(int j=0; j<n; j++) {
                    costMatrix[i][j] = Integer.parseInt(paths[j]);
                }
            }

            int minCost = dijkstra(costMatrix);
            System.out.println("Problem " + testCase +  ": " + minCost);
        }
    }

    private static int dijkstra(int[][] costMatrix) {
        // dist 배열을 최댓값으로 초기화 (계산된 최소 비용으로 갱신 반복)
        int MAX_VALUE = Integer.MAX_VALUE;
        int[] dist = new int[n * n];
        Arrays.fill(dist, MAX_VALUE);

        // 시작점 비용 설정
        dist[0] = costMatrix[0][0];

        // 우선순위 큐 선언 및 삽입
        Queue<Entry> pq = new PriorityQueue<>();
        // 시작점, 시작점 비용
        pq.add(new Entry(0, dist[0]));

        while(!pq.isEmpty()) {
            // 큐에서 원소 뽑음
            Entry curr = pq.remove();
            int currNode = curr.node;
            int currCost = curr.cost;

            // 이미 최소값으로 갱신 되었으면, 넘어감
            if(dist[currNode] < currCost) continue;

            // 1차원 배열 인덱스를 2차원 배열의 행과 열로 변환
            int currX = currNode / n;
            int currY = currNode % n;

            // 4방향 확인
            for(int i=0; i<4; i++) {
                int nX = currX + dr[i];
                int nY = currY + dc[i];

                if(isRange(nX, nY)) {
                    // 2차원 배열의 좌표를 1차원 배열의 인덱스로 변환
                    int nextNode = nX * n + nY;
                    int newCost = currCost + costMatrix[nX][nY];

                    // 갱신, 큐에 넣기
                    if(newCost < dist[nextNode]) {
                        dist[nextNode] = newCost;
                        pq.add(new Entry(nextNode, newCost));
                    }
                }
            }
        }
        // 도착점 (n-1)(n-1)
        return dist[n*n-1];
    }

    // entry : node, cost(해당 노드까지의 최소 비용)
    private static class Entry implements Comparable<Entry> {
        private int node;
        private int cost;

        public Entry(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Entry o) {
            return this.cost - o.cost; // 오름차순 정렬
        }
    }

    // 범위 확인
    private static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;

    }
}
