package com.company;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2+2^2+...+10^2=385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1+2+...+10)^2=55^2=3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025−385=2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class SumSquareDifference {

    public void run() {
        int upperRangeLimit = 100;
        java.util.List<Integer> listOfIntegers = java.util.stream.IntStream.rangeClosed(1, upperRangeLimit).boxed().collect(java.util.stream.Collectors.toList());

        double sumOfSquares = calculateSumOfSquares(listOfIntegers);
        System.out.printf("sumOfSquares: %f\n", sumOfSquares);
        double squareOfSums = calculateSquareOfSums(listOfIntegers);
        System.out.printf("squareOfSums: %f\n", squareOfSums);
        double result = squareOfSums - sumOfSquares;
        System.out.printf("Result: %f\n", result);
    }

    private double calculateSumOfSquares(java.util.List<Integer> listOfIntegers) {
        return listOfIntegers.stream().map(it -> java.lang.Math.pow(it, 2)).peek(System.out::println).mapToDouble(Double::doubleValue).sum();
    }

    private double calculateSquareOfSums(java.util.List<Integer> listOfIntegers) {
        double sumOfIntegers = listOfIntegers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sumOfIntegers: " + sumOfIntegers);
        return java.lang.Math.pow(sumOfIntegers, 2);
    }

    public void runOptimized() {
        double upperRangeLimit = 100.0;

        double sumOfSquares = (2* upperRangeLimit + 1) * (upperRangeLimit + 1) * upperRangeLimit/6;
        System.out.printf("sumOfSquares: %f\n", sumOfSquares);
        double squareOfSums = java.lang.Math.pow(upperRangeLimit * (upperRangeLimit + 1)/2, 2);
        System.out.printf("squareOfSums: %f\n", squareOfSums);
        double result = squareOfSums - sumOfSquares;
        System.out.printf("Result: %f\n", result);
    }

}
