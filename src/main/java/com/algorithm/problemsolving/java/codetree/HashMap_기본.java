package com.algorithm.problemsolving.java.codetree;

import java.util.*;

/**
 * HashMap_기본
 * <p>
 * 문제 :
 * n개의 명령이 주어졌을 때, 각 명령을 수행하는 프로그램을 작성해보세요. 명령의 종류는 크게 3가지 입니다.
 * 명령들은 순서대로 수행되어 출력됩니다.
 * - add k v : (k, v) 쌍을 hashmap에 추가합니다. key가 k, value가 v라는 뜻입니다. 이때 만약 동일한 k가 이미 존재한다면, v로 덮어씁니다.
 * - remove k : key가 k인 쌍을 찾아 hashmap에서 제거합니다. 잘못된 입력은 주어지지 않습니다.
 * - find k : key가 k인 쌍이 hashmap에 있는지를 판단합니다. 있다면 해당하는 value를 출력하고, 없다면 None을 출력합니다.
 * <p>
 * input:
 * 11
 * add 3 5
 * add 10000 1
 * find 3
 * find 5
 * find 10000
 * add 3 10
 * find 3
 * add 7 15
 * remove 3
 * remove 7
 * find 7
 * <p>
 * output:
 * 5
 * None
 * 1
 * 10
 * None
 */
public class HashMap_기본 {
    public static HashMap<Integer, Integer> hashmap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("add")) {
                int keyA = sc.nextInt();
                int valueA = sc.nextInt();
                hashmap.put(keyA, valueA);
            } else if (command.equals("remove")) {
                int keyR = sc.nextInt();
                hashmap.remove(keyR);
            } else if (command.equals("find")) {
                int keyF = sc.nextInt();
                if (hashmap.containsKey(keyF)) { // 시간복잡도 O(1)
                    System.out.println(hashmap.get(keyF));
                } else {
                    System.out.println("None");
                }
            }
        }
    }
}
