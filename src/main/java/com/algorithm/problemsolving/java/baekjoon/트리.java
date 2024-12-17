package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 2                -> 테스트 케이스의 개수 T
 * 4                -> 노드의 개수 n
 * 3 2 1 4          -> 전위 순회한 결과
 * 2 3 4 1          -> 중위 순회한 결과
 * 8
 * 3 6 5 4 8 7 1 2
 * 5 6 8 4 3 1 2 7
 *
 * 출력 : 순회한 결과를 출력
 * 2 4 1 3
 * 5 8 4 6 2 1 7 3
 *
 * 문제 : https://www.acmicpc.net/problem/4256
 * - 전위 + 중위 -> 후위 순회
 * - 재귀 사용
 */
import java.util.*;
import java.io.*;

public class 트리 {
    // 중위순회에서 전위순회 루트를 찾아내는 용도 (값, 인덱스)
    // 루트를 기준으로 왼쪽은 왼쪽 서브트리, 오른쪽은 오른쪽 서브트리 생성
    private static Map<Integer, Integer> inorderMap;

    // 전위 순회
    private static int[] preOrder;

    // 전위 순회 루트 인덱스 관리
    private static int preOrderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());

            // 케이스마다 초기화
            StringBuilder result = new StringBuilder();
            preOrderIndex = 0;

            // 초기화
            preOrder = new int[n];

            String[] infoPreOrder = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                preOrder[j] = Integer.parseInt(infoPreOrder[j]);
            }

            inorderMap = new HashMap<>();
            String[] infoInOrder = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                inorderMap.put(Integer.parseInt(infoInOrder[j]), j);
            }

            // 후위순회 생성 요청
            postOrder(0, n-1, result);

            // 결과
            System.out.println(result.toString().trim());
        }
    }

    private static void postOrder(int inOrderLeft, int inOrderRight, StringBuilder result) {
        // 종료 조건
        if(inOrderLeft > inOrderRight) return;

        // 전위 순회에서 루트 값을 찾는다
        int rootValue = preOrder[preOrderIndex++];
        int rootIndex = inorderMap.get(rootValue);

        // 왼쪽 서브트리 중위 순회
        postOrder(inOrderLeft, rootIndex - 1, result);

        // 오른쪽 서브트리 중위 순회
        postOrder(rootIndex + 1, inOrderRight, result);

        // 출력 result 만듦
        result.append(rootValue).append(" ");
    }
}
