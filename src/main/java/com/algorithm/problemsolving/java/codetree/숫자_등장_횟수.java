package com.algorithm.problemsolving.java.codetree;

import java.util.*;
/**
 * 숫자_등장_횟수
 *
 * 입력:
 * 5 2
 * 1 1 3 2 3
 * 1 4                   // 해당 원소들이 몇 번 나왔는지 출력하는 문제
 *
 * 출력:
 * 2 0
 *
 *
 */
public class 숫자_등장_횟수 {
    public static HashMap<Integer, Integer> hashmap = new HashMap<>();

    public static void main(String[] args){
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            // 원소가 몇번 있는지 저장 : <원소, 값 + 1>
            if(hashmap.containsKey(k)){
                hashmap.put(k, hashmap.get(k) + 1);
            }else{
                hashmap.put(k,1);
            }
        }

        // 확인 단계
        for(int i=0; i<m; i++){
            int check = sc.nextInt();
            if(hashmap.containsKey(check)){
                System.out.print(hashmap.get(check) + " ");
            }else{
                System.out.print(0 + " ");
            }
        }
    }

}
