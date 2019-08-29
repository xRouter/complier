package com.iqianjin.sms.utils.lexer;

import java.util.ArrayList;
import java.util.List;

public class WordAnalyse {

    char[] chars = {'a','b','c'};

    int[][] dfa = new int[][]{
           //a, b, c
            {1, 0, 0},
            {0, 2, 0},
            {0, 0, 3},
            {1, 0, 0}
    };

    public int getOutStatus(String str) {
        int state = 0;
        boolean isSuccessful = false;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int curS = state;
            char curC = str.charAt(i);
            boolean match = false;
            for (int j = 0; j < chars.length; j++) {
                if(curC== chars[j]){
                    state = dfa[state][j];
                    match = true;
                    break;
                }
            }
            if (!match){
                state = 0;
            }
            System.out.println(String.format("state change:%s->%s i=%s char=%s", curS, state, i, curC));

            if (state == 3) {
                index.add(i - 2);
                isSuccessful = true;
            }
        }

        for (int i = 0; i < str.length(); ) {
            if (index.contains(i)) {
                System.out.print(str.charAt(i + 2) + "" + str.charAt(i + 1) + "" + str.charAt(i));
                i += 3;
            } else {
                System.out.print(str.charAt(i) + "");
                i++;
            }
        }

        System.out.println();
        return isSuccessful ? 3 : state;
    }

    public static void main(String[] args) {
        System.out.println(new WordAnalyse().getOutStatus("abccba")==3);
    }
}
