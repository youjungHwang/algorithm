package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 4                    -> 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 10^6)
 * Baha enter           -> 출입 기록이 순서대로 주어짐
 * Askar enter
 * Baha leave
 * Artem enter
 *
 * 출력 : 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력
 * Askar
 * Artem
 *
 * 문제 : https://www.acmicpc.net/problem/7785
 */
import java.util.*;
import java.io.*;

public class 회사에_있는_사람 {
    static TreeSet<String> hashSet = new TreeSet<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String log = input[1];

            if(log.equals("enter")) {
                hashSet.add(name);
            }else if(log.equals("leave")) {
                hashSet.remove(name);
            }
        }

        for(String print : hashSet) {
            System.out.println(print);
        }
    }
}
