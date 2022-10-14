package com.kenzie.app;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class tests and generates a random Number
 */
public class RandomNumberGenerator {
    static Random random = new Random();

    // to test  for unique random numbers
    public static void printRandomNumbers() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 99; i++) {
            int randomIndex = getNextInt(100);//
            System.out.print(randomIndex + " ");
            if (set.contains(randomIndex))
                System.out.print(" [duplicates " + i + "] ");
            else
                set.add(randomIndex);
        }
        System.out.println(set);
    }

    public static int getNextInt(int bound) {
        return random.nextInt(bound);
    }

}
