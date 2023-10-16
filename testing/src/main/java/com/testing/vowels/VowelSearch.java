package com.testing.vowels;

import static java.lang.Character.toUpperCase;

public class VowelSearch {
    public static void main(String[] args) {

        String text = "Did you ever hear the Tragedy Of Darth Plagueis The Wise?";
        Searcher searcher = new Searcher();
        String result = searcher.search(text);

        System.out.println(result);


    }
}

class Searcher {

    public String search(String string) {
        String result = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (string.charAt(i) == vowels[j] || string.charAt(i) == toUpperCase(vowels[j])) {
                    result = result + string.charAt(i);
                }
            }

        }

        return result;
    }

}
