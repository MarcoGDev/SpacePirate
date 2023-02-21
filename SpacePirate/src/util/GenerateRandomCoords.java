package util;

import java.util.Random;

    /*
        Genereert de random x, y voor de alien arrayList om random spawns te krijgen in de Board class
    */

public class GenerateRandomCoords {

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
