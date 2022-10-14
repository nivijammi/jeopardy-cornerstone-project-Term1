package com.kenzie.app;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {
    static Random random = new Random();

    public static void printRandomNumbers() {
        Set<Integer> set = new HashSet();
        for (int i= 0 ; i< 99; i++){
            int randomIndex = getNextInt(100);//
            System.out.print(randomIndex +" ");
            if (set.contains(randomIndex))
                System.out.print(" [dup " +i +"] ");
            else
                set.add(randomIndex);
        }
        System.out.println(set);
    }

    public static int getNextInt(int bound) {
        // random.nextInt(bound) returns 0 to  bound-1 [for bound = 100], bound being exclusive
        // adding + 1 to get around min val of 0
        return random.nextInt(bound) + 1 ;
    }

    public static void main(String[] args) {
        printRandomNumbers();
    }
}
