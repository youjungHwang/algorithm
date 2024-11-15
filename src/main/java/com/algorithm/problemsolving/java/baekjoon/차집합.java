package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4 3                          -> 집합 A의 원소의 개수 n와 집합 B의 원소의 개수 m (1 ≤ n, m ≤ 500,000)
 * 2 5 11 7                     -> 집합 A의 원소
 * 9 7 4                        -> 집합 B의 원소
 *
 * 출력 :
 * 3                            -> 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수 (없으면 0)
 * 2 5 11                       -> 구체적인 원소, 증가하ㅡㄴ 순서
 *
 * 문제 : https://www.acmicpc.net/problem/1822
 * - List에서 removeAll -> 시간복잡도 O(n * m)
 * - Set에서 removeAll -> Set을 사용하면 contains와 remove 연산이 해시 기반으로 작동하여, 시간복잡도 O(n + m)
 */
import java.util.*;
import java.io.*;

public class 차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        String[] inputA = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            setA.add(Integer.parseInt(inputA[i]));
        }

        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            setB.add(Integer.parseInt(inputB[i]));
        }

        // B에 없는 A의 원소들만 남김
        setA.removeAll(setB);

        if(setA.isEmpty()) {
            System.out.println(0);
        }

        if(!setA.isEmpty()) {
            // 정렬을 하기 위해 HashSet -> List 변환
            List<Integer> list = new ArrayList<>(setA);
            Collections.sort(list);

            System.out.println(list.size());
            for(int data : list) {
                System.out.print(data + " ");
            }
        }
    }
}
