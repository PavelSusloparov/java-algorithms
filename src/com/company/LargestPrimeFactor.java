package com.company;

import java.util.ArrayList;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Result: 6857
 */
public class LargestPrimeFactor {

    private static final long TARGET_NUMBER = 9699690L;

    public void run() {
        ArrayList<Long> result = primeFactor(TARGET_NUMBER);
        java.util.Collections.sort(result);
        System.out.println(result);
    }

    private ArrayList<Long> primeFactor(long targetNumber) {
        return primeFactorRecursive(targetNumber, 2);
    }

    private ArrayList<Long> primeFactorRecursive(long targetNumber, long numberForVerification) {
        if (targetNumber == 1) {
            return new java.util.ArrayList<>();
        }
        if (targetNumber % numberForVerification == 0) {
            ArrayList<Long> factors = primeFactorRecursive(targetNumber/numberForVerification, numberForVerification);
            factors.add(numberForVerification);
            return factors;
        } else {
            return primeFactorRecursive(targetNumber, numberForVerification+1);
        }
    }
}
