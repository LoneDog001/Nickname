package Homework;
import java.util.Random;
import static Homework.Methods.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread thread1 = new Thread(() -> {
            for (String text : texts) {
                if (isPalindromes(text)) {
                    isCounter(text.length());
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (String text : texts) {
                if (isSameLetter(text)) {
                    isCounter(text.length());
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (String text : texts) {
                if (isAscending(text)) {
                    isCounter(text.length());
                }
            }
        });
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        System.out.println("Красивых слов с длиной 3: " + threeLength);
        System.out.println("Красивых слов с длиной 4: " + fourLength);
        System.out.println("Красивых слов с длиной 5: " + fiveLength);
    }
}
