package com.company;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Result: 906609
 */
public class LargestPalindromeProduct {

    private static final int LIMIT = 999;

    public void run() {
        int result = largestPalindromeProduct();
        System.out.println(result);
    }

    public int largestPalindromeProduct() {
        int number = 0;
        int check;

        for (int i=LIMIT; i>0; i--) {
            // Check only multiplier numbers between 900 and 999
            for (int j=0; j<100; j++) {
                System.out.println("Check numbers: 1st: " + i + ", 2nd: " + (LIMIT - j));
                check = (LIMIT - j) * i;
                System.out.println("Check is " + check);
                // Largest number should be 6 digits number
                if (isPalindrome(check) && findLength(check) == 6) {
                    if (check > number) {
                        System.out.println("the largest palindrome made from " + check + " and multiplier " + i);
                        number = check;
                    }
                }
            }
        }
        return number;
    }

    public boolean isPalindrome(int number) {
        int printNumber = number;
        int divisor = findDivisor(number);
//        System.out.println(divisor);

        while ( number != 0 ) {
            int leading = number / divisor;
            int trailing = number % 10;

//            System.out.println("leading: " + leading);
//            System.out.println("trailing: " + trailing);

            if (leading != trailing) {
//                System.out.println("number " + number + " is not a palindrome");
                return false;
            }

            // removing leading and trailing numbers
            number = (number % divisor) / 10;
            // 2 digits were dropped, reducing divisor by factor 2
            divisor = divisor / 100;

//            System.out.println("number: " + number);
//            System.out.println("divisor: " + divisor);
//            System.out.println("===");
        }
        System.out.println("number " + printNumber + " is a palindrome");
        return true;
    }

    private int findDivisor(int number) {
        int divisor = 1;
        while (number / divisor >= 10) {
            divisor *= 10;
        }
        return divisor;
    }

    private int findLength(int number) {
        int length = 1;
        while (number / 10 != 0) {
            length++;
        }
        return length;
    }
}
