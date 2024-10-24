package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 2                                -> 테스트 케이스의 개수
 * 10 3                             -> 막대의 길이와 개미의 수 n
 * 2                                -> 개미의 초기 위치
 * 6
 * 7
 * 214 7
 * 11
 * 12
 * 7
 * 13
 * 176
 * 23
 * 191
 *
 * 출력 : 각 테스트 케이스에 대해, 개미가 모두 땅으로 떨어지는 가장 빠른 시간, 두 번째 숫자는 가장 늦은 시간
 * 4 8
 * 38 207
 *
 * 문제 : https://www.acmicpc.net/problem/4307
 */
import java.io.*;
import java.util.*;

public class 개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            // 리스트 초기화
            List<Integer> line = new ArrayList<>();
            String[] question = br.readLine().split(" ");
            int stickLength = Integer.parseInt(question[0]);
            int ant = Integer.parseInt(question[1]);

            for(int j=0; j<ant; j++) {
                int antAmount = Integer.parseInt(br.readLine());
                line.add(antAmount);
            }

            int fast = fastTime(stickLength, line);
            int slow = slowTime(stickLength, line);

            System.out.println(fast + " " + slow);
        }
    }

    // 가장 빠른 시간 : 막대기를 절반으로 나눈 뒤 이를 기준으로(s/2), max(왼쪽에서 가장 멀리 떨어진 개미 - 0, s - 오른쪽에서 가장 멀리 떨어진 개미)
    private static int fastTime(int stickLength, List<Integer> line) {
        // 막대기 절반으로 나누기
        int dividedStick = stickLength / 2;

        // 정렬
        Collections.sort(line);

        // 막대기 절반 기준으로, 왼쪽에서 가장 멀리 떨어진 개미 찾기
        int farAntFromLeft = 0;
        for(int i=0; i<line.size(); i++) {
            if(line.get(i) <= dividedStick) {
                farAntFromLeft = Math.max(farAntFromLeft, line.get(i));
            }
        }

        // 막대기 절반 기준으로, 오른쪽에서 가장 멀리 떨어진 개미 찾기
        int farAntFromRight = 1000000;
        for(int i=0; i<line.size(); i++) {
            if(line.get(i) >= dividedStick) {
                farAntFromRight = Math.min(farAntFromRight, line.get(i));
            }
        }

        // 가장 빠른 시간
        return Math.max(farAntFromLeft, stickLength - farAntFromRight);
    }

    // 가장 늦은 시간 : max(2s - 왼쪽에서 가장 가까이 있는 개미, 오른쪽에서 가장 가까이 있는 개미 - 0)
    private static int slowTime(int stickLength, List<Integer> line) {
        // 정렬
        Collections.sort(line);

        // 왼쪽에서 가장 가까이 있는 개미 찾기
        int closeAntFromLeft = line.get(0);

        // 오른쪽에서 가장 가까이 있는 개미 찾기
        int closeAntFromRight = line.get(line.size() - 1);

        // 가장 늦은 시간
        return Math.max(stickLength - closeAntFromLeft, closeAntFromRight);
    }
}
