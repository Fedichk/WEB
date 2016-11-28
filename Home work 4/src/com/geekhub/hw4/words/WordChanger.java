package com.geekhub.hw4.words;

import java.util.ArrayList;
import java.util.List;

class WordChanger {

    private static List<String> listOfChangedWords = new ArrayList<>();

    static List<String> changeOfWords(List<String> listOfWords) {
        for (String word : listOfWords) {
            if (word.length() > 10) {
                int count = 0;
                String[] letters = word.split("");
                for (int i = 1; i < (letters.length - 1); i++) {
                    count++;
                }
                listOfChangedWords.add(letters[0] + count + letters[letters.length - 1]);
            } else {
                listOfChangedWords.add(word);
            }
        }
        return listOfChangedWords;
    }
}
