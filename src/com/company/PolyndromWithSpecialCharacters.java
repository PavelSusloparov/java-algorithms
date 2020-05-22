package com.company;

public class PolyndromWithSpecialCharacters {

    public void run() {
        System.out.println(isPolyndrom("a$%A"));
        System.out.println(isPolyndrom("bC%cb"));
        System.out.println(isPolyndrom("nmu#uNM"));
        System.out.println(isPolyndrom("a$tA#"));
        System.out.println(isPolyndrom(""));
        System.out.println(isPolyndrom(null));
    }

    private Boolean isPolyndrom(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // set up two pointers - start and end string
        int start = 0;
        int end = str.length() - 1;
        // normalize string to lower character to simplify verification condition
        str = str.toLowerCase();
        // while start index less then end index check characters
        while (start <= end) {
            char startCharacter = str.charAt(start);
            boolean isStartCharacter = isLowerUpperCaseCharacter(startCharacter);
            char endCharacter = str.charAt(end);
            boolean isEndCharacter = isLowerUpperCaseCharacter(endCharacter);
            // increment start when it is a upper/lower case character
            if (!isStartCharacter) {
                start++;
            }
            // decrement end when it is a upper/lower case character
            if (!isEndCharacter) {
                end--;
            }
            // Compare start and end characters only when they are valid characters
            if (isStartCharacter && isEndCharacter) {
                if (startCharacter != endCharacter) {
                    return false;
                }
                // Move on to the next characters for start and end
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isLowerUpperCaseCharacter(char ch) {
        return ch >= 97 && ch <= 122;
    }
}
