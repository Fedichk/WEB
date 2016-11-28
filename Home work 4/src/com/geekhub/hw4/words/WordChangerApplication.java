package com.geekhub.hw4.words;

import java.util.ArrayList;
import java.util.Scanner;

class WordChangerApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listOfWords = new ArrayList<>();
        System.out.println("Please, enter number of lines:");
        String numberOfLines = sc.nextLine();
        while (!InputValidator.isNumberOfLines(numberOfLines)) {
            System.out.println("Please, enter correct number of lines:");
            numberOfLines = sc.nextLine();
        }
        System.out.println("Please, enter the words:");
        for (int i = 0; i < Integer.parseInt(numberOfLines); i++) {
            String word = sc.nextLine();
            if (InputValidator.isSymbolCorrect(word)) {
                listOfWords.add(word);
            } else {
                listOfWords.add("error");
            }
        }
        for (String element : WordChanger.changeOfWords(listOfWords)) {
            System.out.println(element);
        }
    }
}
