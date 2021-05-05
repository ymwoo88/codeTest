package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] phone_book1 = new String[]{"119", "97674223", "1195524421"};
        String[] phone_book2 = new String[]{"06345","123","1535","153567","88","333"};
        String[] phone_book3 = new String[]{"123", "456", "789"};
        solution(phone_book1);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort ( phone_book , new Comparator <String> ( ) {
            public int compare(String o1 , String o2) {
                return o2.length ( ) - o1.length ( );
            }
        } );

        Map <String, String> map = new HashMap <> ( );
        for (String num : phone_book) {
            if ( map.containsKey ( num ) ) {
                answer = false;
                break;
            }
            for (int i = 1; i < num.length ( ); i++) {
                map.put ( num.substring ( 0 , i ) , num );
            }
        }

        System.out.println (answer );
        return answer;
    }

    public static boolean temp1(String[] phone_book) {
        boolean answer = true;

        for(String num1 : phone_book) {
            if(!answer){
                break;
            }
            for(String num2 : phone_book) {
                if(num1.equals(num2) || num1.length() > num2.length()){
                    continue;
                }
                String cutValue = num2.substring ( 0, num1.length ());
                if(num1.equals ( cutValue )) {
                    answer = false;
                    break;
                }
            }
        }

        System.out.println (answer );
        return answer;
    }

    public static boolean temp2(String[] phone_book) {
        boolean answer = true;

        Map<Integer, List <String>> mapLength = new HashMap<>();
        for(String num : phone_book) {
            List <String> value;
            if(mapLength.containsKey( num.length ())){
                value = mapLength.get ( num.length ( ) );
            } else {
                value = new ArrayList <> ( );
            }
            value.add ( num );
            mapLength.put ( num.length (), value );
        }

        for(List<String> arr : mapLength.values()) {
            if(!answer){
                break;
            }
            for(String sortNum : arr) {
                if(!answer){
                   break;
                }
                int sortNumLen = sortNum.length();
                for(String num : phone_book) {
                    if(sortNum.equals(num) || num.length() < sortNumLen){
                        continue;
                    }
                    String key = num.substring (0, sortNumLen);
                    if(sortNum.equals(key)) {
                        answer = false;
                        break;
                    }
                }
            }
        }

        System.out.println (answer );
        return answer;
    }

    public static boolean temp3(String[] phone_book) {
        boolean answer = true;

        Arrays.sort( phone_book, Collections.reverseOrder());
        int length = Integer.MAX_VALUE;
        for(String out : phone_book) {
            if(length > out.length()) {
                length = out.length ();
            }
        }

        Map <String, Integer> map = new HashMap<> (  );
        for(String out : phone_book) {
            String key = out.substring ( 0,length );
            if (map.containsKey ( key )) {
                answer = false;
                break;
            } else {
                map.put ( key, 1 );
            }
        }

        System.out.println (answer );
        return answer;
    }
}
