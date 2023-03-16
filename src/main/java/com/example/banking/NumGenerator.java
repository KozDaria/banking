package com.example.banking;

import java.util.Random;

public class NumGenerator {

    public String random(int n) {
        int max = 9;
        int min = 0;
        StringBuilder random = new StringBuilder();
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            random.append(rand.nextInt(max - min));
        }
        return String.valueOf(random);
    }
}
