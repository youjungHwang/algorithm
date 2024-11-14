package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 5                        -> 굴다리의 길이 N 이 주어진다. (1 ≤ N ≤ 100,000)
 * 2                        -> 가로등의 개수 M 이 주어진다. (1 ≤ M ≤ N)
 * 2 4                      -> M 개의 설치할 수 있는 가로등의 위치 x 가 주어진다. (0 ≤ x ≤ N)
 *
 * 출력 : 굴다리의 길이 N을 모두 비추기 위한 가로등의 최소 높이
 * 2
 *
 * 문제 : https://www.acmicpc.net/problem/17266
 */
import java.io.*;

public class 어두운_굴다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] info = br.readLine().split(" ");
        int[] place = new int[m];

        for (int i = 0; i < m; i++) {
            place[i] = Integer.parseInt(info[i]);
        }

        // 가로등 간격의 최대 절반값 찾기
        int maxHalfGap = 0;

        // 첫 번째 가로등 이전 거리
        maxHalfGap = Math.max(maxHalfGap, place[0]);

        // 중간
        for (int i = 1; i < m; i++) {
            int gap = place[i] - place[i - 1];
            maxHalfGap = Math.max(maxHalfGap, (gap + 1) / 2);
        }

        // 마지막 가로등 이후 거리
        maxHalfGap = Math.max(maxHalfGap, n - place[m - 1]);

        System.out.print(maxHalfGap);
    }

}
