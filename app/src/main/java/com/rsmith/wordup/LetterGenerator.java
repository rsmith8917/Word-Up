package com.rsmith.wordup;

import java.util.Random;

/**
 * Created by RSmit on 12/4/2017.
 */

public class LetterGenerator {
    private char[] letters = new char[25];
    private Boolean first = true;

    public LetterGenerator(){

    }

    public char[] getLetters(){

        if (first){
            for (int i = 0; i < 25; i++) {
                letters[i] = getLetter();
            }
        } else {
            for (int i = 0; i < 20; i++) {
                letters[i] = letters[i+5];
            }
            for (int i = 20; i < 25; i++){
                letters[i] = getLetter();
            }
        }

        first = false;
        return letters;
    }

    private char getLetter(){
        Random rand = new Random();
        int r = rand.nextInt(150);
        char c;
        if (r < 19){
            c = 'E';
        } else if (r < 32){
            c = 'T';
        } else if (r < 56){
            int r2 = rand.nextInt(2);
            if (r2 == 0){
                c = 'A';
            } else {
                c = 'R';
            }
        } else if (r < 89){
            int r2 = rand.nextInt(3);
            if (r2 == 0){
                c = 'I';
            } else if (r2 == 1){
                c = 'N';
            } else {
                c = 'O';
            }
        } else if (r < 98){
            c = 'S';
        } else if (r < 104){
            c = 'D';
        } else if (r < 119){
            int r2 = rand.nextInt(3);
            if (r2 == 0){
                c = 'C';
            } else if (r2 == 1){
                c = 'H';
            } else {
                c = 'L';
            }
        } else if (r < 135){
            int r2 = rand.nextInt(4);
            if (r2 == 0){
                c = 'F';
            } else if (r2 == 1){
                c = 'M';
            } else if (r2 == 2){
                c = 'P';
            } else {
                c = 'U';
            }
        } else if (r < 141){
            int r2 = rand.nextInt(2);
            if (r2 == 0){
                c = 'G';
            } else {
                c = 'Y';
            }
        } else if (r < 143){
            c = 'W';
        } else {
            int r2 = rand.nextInt(7);
            if (r2 == 0){
                c = 'B';
            } else if (r2 == 1){
                c = 'J';
            } else if (r2 == 2){
                c = 'K';
            } else if (r2 == 3){
                c = 'Q';
            } else if (r2 == 4){
                c = 'V';
            } else if (r2 == 5){
                c = 'X';
            } else {
                c = 'Z';
            }
        }
        return c;
    }
}
