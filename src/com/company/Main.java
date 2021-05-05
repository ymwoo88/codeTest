package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        solution (participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap <String, Integer> map =new HashMap<>();
        for(String key : participant){
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        for(String key : completion){
            map.put(key, map.get(key)-1);
        }

        for(String key : participant){
            if(map.get(key)!=0){
                answer=key;
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
