package com.algorithm.problemsolving.java.programmers;

import java.util.*;

/**
 * [고득점 kit] 코딩테스트 연습 > 해시 > 완주하지 못한 선수
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // [주의] 참가자 이름 : 출현 횟수를 저장
        Map<String, Integer> participantMap = new HashMap<>();

        // 참가자 배열을 순회하며 각 참가자의 이름을 해시맵에 저장하고, 출현 횟수를 1씩 증가
        for(int i=0; i<participant.length; i++){
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
        }

        // 완주자 배열을 순회하며 해시맵에서 해당 이름이 있다면 1씩 감소 (기존데이터를 대체 가능)
        for(String person : completion){
            participantMap.put(person, participantMap.get(person)-1) ;

            // 만약 해당 이름의 출현 횟수가 0이 되면 해시맵에서 제거
            if(participantMap.get(person) == 0){
                participantMap.remove(person);
            }
        }

        // 해시맵에서 출현 횟수가 존재하면 answer에 넣고 반환
        for(String remainPerson : participantMap.keySet()){
            answer = remainPerson;
            // 남아있는 이름은 하나이므로 찾으면 바로 break
            break;
        }

        return answer;
    }

}
