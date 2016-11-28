package com.geekhub.hw4.words;

class InputValidator {

    static boolean isNumberOfLines(String numberOfLines) throws NumberFormatException {
        try {
            int numberLines = Integer.parseInt(numberOfLines);
            if (numberLines > 0 && numberLines <= 100) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isSymbolCorrect(String word) {
        return word.matches("^[a-z]+$");
    }
}

