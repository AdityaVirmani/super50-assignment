import java.util.Scanner;

/**
 * @Filename-StringNumberOperations.java
 * @Description-It will contain methods of string-number operations
 * @Author-Aditya Virmani
 */
public class StringNumberOperations {

    public static int expandAroundCenter(String s, String[] palindrome, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > 1) {
                String temp = "";
                for (int i = left; i <= right; i++) {
                    temp += s.charAt(i);
                }
                boolean exist = false;
                for (int j = 0; j < count; j++) {
                    if (palindrome[j].equals(temp)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    palindrome[count++] = temp;
                }
            }
            left--;
            right++;
        }

        return count;
    }

    public int countPalindrome(String string) {
        String[] palindrome = new String[1000];
        int count = 0;
        for (int center = 0; center < string.length(); center++) {
            count = expandAroundCenter(string, palindrome, center, center, count);
            count = expandAroundCenter(string, palindrome, center, center + 1, count);

        }
        return count;

    }

    public int getFibonacciNumber(int number) {
        if (number <= 1)
            return number;
        int first = 0, second = 1;
        for (int i = 2; i <= number; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    public String snakeToCamel(String s) {
        String result = "";
        Boolean nextCapital = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                nextCapital = true;
            } else if (nextCapital) {
                result += Character.toUpperCase(s.charAt(i));
                nextCapital = false;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public int countConsonants(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            currentCharacter = Character.toLowerCase(currentCharacter);
            if (currentCharacter >= 'a' && currentCharacter <= 'z') {
                if (currentCharacter != 'a' && currentCharacter != 'e' && currentCharacter != 'i'
                        && currentCharacter != 'o' && currentCharacter != 'u') {
                    count++;
                }
            }
        }
        return count;
    }

    public int binaryToDecimal(String s) {
        if (s == null || s.length() == 0) {
            System.out.println("Invalid input: empty string.");
            return -1;
        }
        int decimal = 0;
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                decimal += Math.pow(2, length - i - 1);
            }
        }
        return decimal;
    }

    public String expandCharacters(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i += 2) {
            char currentCharacter = s.charAt(i);
            int currentDigit = s.charAt(i + 1) - '0';

            for (int j = 0; j < currentDigit; j++) {
                result += currentCharacter;
            }
        }
        return result;
    }

    public String characterFrequency(String s) {
        String result = "";
        for (int i = 0; i < s.length();) {
            char currentCharacter = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == currentCharacter) {
                count++;
                i++;
            }
            result += currentCharacter;
            result += count;
        }
        return result;
    }

    public Boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    static String convertTwoDigits(int n) {
        if (n < 20)
            return ones[n];
        else {
            return tens[n / 10] + (n % 10 != 0 ? " " + ones[n % 10] : "");
        }
    }

    public String numberToWords(long n) {
        String result = "";

        int crore = (int) (n / 10000000);
        n %= 10000000;

        int lakh = (int) (n / 100000);
        n %= 100000;

        int thousand = (int) (n / 1000);
        n %= 1000;
        int hundred = (int) (n);

        if (crore > 0) {
            result += convertTwoDigits(crore);
            result += " crore ";
        }
        if (lakh > 0) {
            result += convertTwoDigits(lakh);
            result += " lakh ";
        }
        if (thousand > 0) {
            result += convertTwoDigits(thousand);
            result += " thousand ";
        }
        if (hundred > 0) {
            String temp = "";
            if (hundred > 99) {
                temp += ones[hundred / 100] + " hundred ";
                if (hundred % 100 != 0) {
                    temp += " ";
                }
            }
            if (hundred % 100 != 0) {
                hundred = hundred % 100;
                temp += convertTwoDigits(hundred);
            }
            result += temp;
        }

        return result;

    }

    public int longestUniqueSubstring(String s) {
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++)
            lastIndex[i] = -1;

        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
