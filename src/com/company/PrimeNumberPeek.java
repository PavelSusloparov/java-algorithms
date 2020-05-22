package com.company;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class PrimeNumberPeek {

    public void run() {
        System.out.println(primeFactorPeek());
    }

    private int primeFactorPeek() {
        return primeFactorRecursive(1000000000, 2);
    }

    private int primeFactorRecursive(int upperLimitNumber, int numberForVerification) {
        return -1;
    }
}
