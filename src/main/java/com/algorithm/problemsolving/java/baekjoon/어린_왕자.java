package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 2                                -> 테스트 케이스의 개수 T
 * -5 1 12 1                        -> 출발점 (x1, y1)과 도착점 (x2, y2)
 * 7                                -> 행성계의 개수 n
 * 1 1 8                            -> n줄에 걸쳐 행성계의 중점과 반지름 (cx, cy, r)
 * -3 -1 1
 * 2 2 2
 * 5 5 1
 * -4 5 1
 * 12 1 1
 * 12 1 2
 *
 * -5 1 5 1
 * 1
 * 0 0 2
 *
 * 출력 :
 * 3
 * 0
 *
 * 문제 : https://www.acmicpc.net/problem/1004
 */
import java.io.*;

public class 어린_왕자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] agrs) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] data = br.readLine().split(" ");
            int x1 = Integer.parseInt(data[0]);
            int y1 = Integer.parseInt(data[1]);
            int x2 = Integer.parseInt(data[2]);
            int y2 = Integer.parseInt(data[3]);

            int n = Integer.parseInt(br.readLine());
            planetInfo(x1, y1, x2, y2, n);
        }
    }

    private static void planetInfo(int x1, int y1, int x2, int y2, int n) throws IOException {
        // 테스트 케이스마다 count 초기화
        int count = 0;

        for(int i=0; i<n; i++) {
            String[] planet = br.readLine().split(" ");
            int cx = Integer.parseInt(planet[0]);
            int cy = Integer.parseInt(planet[1]);
            int r = Integer.parseInt(planet[2]);

            count = calculate(x1, y1, x2, y2, cx, cy, r, count);
        }
        System.out.println(count);
    }

    private static int calculate(int x1, int y1, int x2, int y2, int cx, int cy, int r,
                                  int count) {
        // 출발점 또는 도착점과 행성의 중심과의 거리 < 행성의 반지름 -> +1 (행성 내부에 있으므로)
        // 출발점 그리고 도착점과 행성의 중심과의 거리 > 행성의 반지름 -> pass (행성 외부에 있으므로)

        int distS = (int) (Math.pow((cx - x1), 2) + Math.pow((cy - y1), 2));
        int distD = (int) (Math.pow((cx - x2), 2) + Math.pow((cy - y2), 2));
        int radius = r * r;

        if(distS < radius && distD > radius) {
            count++;
        }else if(distD < radius && distS > radius) {
            count++;
        }
        return count;
    }
}
