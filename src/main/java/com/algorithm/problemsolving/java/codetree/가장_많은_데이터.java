package com.algorithm.problemsolving.java.codetree;

import java.util.*;
/**
 * 가장_많은_데이터
 * : 가장 많이 입력된 데이터의 등장 횟수를 출력하시오
 *
 * 입력:
 * 7
 * red
 * red
 * red
 * blue
 * blue
 * blue
 * green
 *
 * 출력:
 * 3
 */
public class 가장_많은_데이터 {
    public static HashMap<String, Integer> hashmap = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            String str = sc.next();
            hashmap.put(str, hashmap.getOrDefault(str,0) + 1);
        }

        // 출력
        int result = Collections.max(hashmap.values());

        System.out.print(result);
    }
}
