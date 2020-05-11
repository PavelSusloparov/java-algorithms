package com.company;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Result: 232792560
 */
public class SmallestMultiplier {

    private static final int LIMIT = 20;
    /**
     * 1 2 3 [2*2] 5 [2*3] 7 [2*2*2] [3*3] [5*2]
     * 2520 = ( 1 * 2 * 3 * 5 * 7 ) * 2 * 3 * 2
     * 1 2 3 [2] 5 [3] 7 [2]
     * Take the number, if the number is not a primitive number,
     * find prime and update original list with only numbers, which are not part of the original list.
     *
     * Numbers from 1 to 20: 1 2 3 [2*2] 5 [2*3] 7 [2*4] [3*3] [5*2] 11 [2*3*2] 13 [7*2] [5*3] [4*2*2] 17 [3*3*2] 19 [5*2*2]
     * 1 2 3 [2] 5 [3] 7 [2] 11 13 [2] 17 19
     */
    public void run() {
        long result = uniqueMultipliers(LIMIT);
        System.out.println("smallest positive number that is evenly divisible by all of the numbers from 1 to " + LIMIT + " is " + result);
    }

    private long uniqueMultipliers(int number) {
        java.util.Map<Integer, Integer> numbersMultipliers = new java.util.HashMap<>();
        for (int i=1; i<number; i++) {
            java.util.ArrayList<Integer> primes = primeFactor(i);
            System.out.println("Number: " + i + ", primes: " + primes);
            for (int primeNumber: primes) {
                if (!numbersMultipliers.containsKey(primeNumber)) {
                    numbersMultipliers.put(primeNumber, 1);
                } else {
                    int numberOfRepetition = countNumberOfRepetitiveNumbersInArray(primeNumber, primes);
                    if (numberOfRepetition > numbersMultipliers.get(primeNumber)) {
                        numbersMultipliers.put(primeNumber, numberOfRepetition);
                    }
                }
            }
        }
        System.out.println("====");
        int result = 1;
        for (int key: numbersMultipliers.keySet()) {
            System.out.println("Number: " + key + ", count: " + numbersMultipliers.get(key));
            result *= Math.pow(key, numbersMultipliers.get(key));
            System.out.println("Result: " + result);
        }
        return result;
    }

    private int countNumberOfRepetitiveNumbersInArray(long number, java.util.ArrayList<Integer> array) {
        int repetitiveCount = 0;
        for (int i=0; i<array.size(); i++) {
            if (array.get(i) == number) {
                repetitiveCount++;
            }
        }
        System.out.println("Number: " + number + ", Number of repetitions: " + repetitiveCount);
        return repetitiveCount;
    }

    private java.util.ArrayList<Integer> primeFactor(int targetNumber) {
        return primeFactorRecursive(targetNumber, 2);
    }

    private java.util.ArrayList<Integer> primeFactorRecursive(int targetNumber, int numberForVerification) {
        if (targetNumber == 1) {
            java.util.ArrayList<Integer> factors = new java.util.ArrayList<>();
            factors.add(1);
            return factors;
        }
        if (targetNumber % numberForVerification == 0) {
            java.util.ArrayList<Integer> factors = primeFactorRecursive(targetNumber/numberForVerification, numberForVerification);
            factors.add(numberForVerification);
            return factors;
        } else {
            return primeFactorRecursive(targetNumber, numberForVerification+1);
        }
    }
}
