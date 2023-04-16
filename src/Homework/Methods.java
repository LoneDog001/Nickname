package Homework;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Methods {
    public static AtomicInteger threeLength = new AtomicInteger();
    public static AtomicInteger fourLength = new AtomicInteger();
    public static AtomicInteger fiveLength = new AtomicInteger();


    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean isPalindromes(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean isSameLetter(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1))
                return false;
        }
        return true;
    }

    public static boolean isAscending(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1))
                return false;
        }
        return true;
    }

    public static void isCounter(int textLetters){
        if (textLetters == 3){
            threeLength.getAndIncrement();
        } else if (textLetters == 4) {
            fourLength.getAndIncrement();
        }else {
            fiveLength.getAndIncrement();
        }
    }
}