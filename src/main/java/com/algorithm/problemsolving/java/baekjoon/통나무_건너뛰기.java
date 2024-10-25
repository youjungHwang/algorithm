package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 3                        -> 테스트 케이스 수
 * 7                        -> 통나무 수
 * 13 10 12 11 10 11 12     -> 통나무 높이
 * 5
 * 2 4 5 7 9
 * 8
 * 6 6 6 6 6 6 6 6
 *
 * 출력 :
 * 1
 * 4
 * 0
 *
 * 문제 : https://www.acmicpc.net/problem/11497
 * - 인접한 원소들의 최대 차이를 최소로 가져가기
 * - 정렬과 투 포인터 알고리즘을 활용해 풀이함
 */
import java.util.*;
import java.io.*;

public class 통나무_건너뛰기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int testCase = Integer.parseInt(br.readLine());
            rearrangeLogs(testCase);
        }
    }

    private static void rearrangeLogs(int testCase) throws IOException {
        // 정렬
        List<Integer> origin = new ArrayList<>();
        String line = br.readLine();
        String[] lineArr = line.split(" ");

        for(int i=0; i<testCase; i++) {
            origin.add(Integer.valueOf(lineArr[i]));
        }
        Collections.sort(origin);

        // 재정렬 : 작은 원소를 왼쪽 한 번, 오른쪽 한 번 번갈아가며 채우기
        int[] update = new int[origin.size()];

        int left = 0;
        int right = testCase - 1;
        boolean flag = true;

        for(int i=0; i<testCase; i++) {
            if(flag) {
                // 왼쪽에 작은 원소 넣기
                update[left] = origin.get(i);
                left++;
            }else {
                // 오른쪽에 작은 원소 넣기
                update[right] = origin.get(i);
                right--;
            }
            flag = !flag;
        }

        // 최소 갭 찾기
        findMinGap(update);
    }

    private static void findMinGap(int[] update) {
        int result = 0;

        for(int i=1; i<update.length; i++) {
            // 절댓값으로 비교
            int gap = Math.abs(update[i] - update[i-1]);
            result = Math.max(result, gap);
        }
        System.out.println(result);
    }
}
