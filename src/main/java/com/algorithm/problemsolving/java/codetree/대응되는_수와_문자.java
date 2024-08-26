package com.algorithm.problemsolving.java.codetree;

import java.util.*;
/**
 * 대응되는_수와_문자
 * : 각각의 입력값에 대응하는 값을 한 줄에 하나씩 출력합니다.
 *
 * 입력:
 * 5 3
 * qw
 * er
 * ty
 * ui
 * op           // 5개(n) 문자열 받음
 * 2            // 앞으로 3개(m)를 조사할 것이다
 * ty
 * op
 *
 * 출력:
 * er
 * 3
 * 5
 */
public class 대응되는_수와_문자 {
    public static Map<String, Integer> hashmap = new HashMap<>();

    public static void main(String[] args){
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=1; i<=n; i++){
            String str = sc.next();
            // {qw,1}
            hashmap.put(str, i);
        }

        for(int i=0; i<m; i++){
            // 입력받는게 숫자라면? 문자열이라면?
            if(sc.hasNextInt()) {
                // 숫자라면 키를 반환
                int num = sc.nextInt();
                for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
                    if(num == entry.getValue()){
                        System.out.println(entry.getKey());
                        break;
                    }
                }
            }else{
                // 문자열이라면 값을 반환
                String str = sc.next();
                System.out.println(hashmap.get(str));
            }
        }
    }
}
