package com.algorithm.problemsolving.java.programmers;

import java.util.*;

/**
 * 코딩테스트 연습 > 2022 KAKAO TECH INTERNSHIP
 * 두 큐 합 같게 만들기
 *
 * https://lealea.tistory.com/293
 */
public class MakeTwoQueuesEqual {
    public int solution(int[] queue1, int[] queue2){
        int cnt = 0;
        int loop = 0;
        long sumQ1 = 0;
        long sumQ2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sumQ1 += queue1[i];
        }

        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sumQ2 += queue2[i];
        }

        while(loop < queue1.length * 3){
            if(sumQ1 < sumQ2) {
                int element = q2.remove();
                q1.add(element);
                sumQ1 += element ;
                sumQ2 -= element;
            }else if(sumQ1 > sumQ2){
                int element = q1.remove();
                q2.add(element);
                sumQ1 -= element;
                sumQ2 += element;
            }else{
                return cnt;
            }
            cnt ++;
            loop ++;
        }
        return -1;
    }
}
