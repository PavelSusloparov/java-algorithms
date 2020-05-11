package com.company;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Result: 233168
 */
public class MultiplierOfThreeOrFive {

    public int limit;

    public MultiplierOfThreeOrFive(int limit) {
        System.out.println("constructor");
        this.limit = limit;
        System.out.println("limit is " + this.limit);
    }

    public void run() {
        System.out.println("run");
        java.util.List<Integer> list = java.util.stream.IntStream.rangeClosed(0, this.limit).boxed().collect(java.util.stream.Collectors.toList());
        list.forEach((i) -> {
            System.out.println("Value " + i);
        });
        System.out.println("===");
        int sum = list.stream()
                .skip(1)
                .limit(this.limit - 1)
                .filter((i) -> (i % 3 == 0) || (i % 5 == 0))
                .peek((i) -> System.out.println("Value " + i))
                .mapToInt(Integer::intValue).sum();
        System.out.println("Sum is " + sum);
    }

}
