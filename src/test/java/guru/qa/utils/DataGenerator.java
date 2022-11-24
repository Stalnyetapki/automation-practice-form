package guru.qa.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    public static String getRandomString(int len){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail(int len) {
        return getRandomString(len) + "@gmail.com";
    }

    public static Long getRandomNumber(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
   }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String randomListItem(String[] values) {

        int index = randInt(0, values.length);
        return values[index];
    }
}
