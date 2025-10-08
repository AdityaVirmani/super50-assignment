import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * @Filename-MyString.java
 * @Description-This will perform most of the string operations
 * @Author-Aditya Virmani
 */

public class MyString {
    String str;
    static Scanner sc = new Scanner(System.in);

    MyString(String s) {
        str = s;
    }

    public String append(String str) {
        this.str = this.str + str; // append to existing string
        return this.str;
    }

    public int countWords() {
        String str = this.str;
        str = str.trim();
        if (this.str.length() == 0) {
            return 0;
        }
        int words = 1;
        char curr = str.charAt(1), prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            prev = str.charAt(i - 1);
            curr = str.charAt(i);
            char ch = Character.toLowerCase(curr);
            if (prev == ' ' && ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')))
                words++;
        }
        return words;

    }

    public String replace(char ch1, char ch2) {
        String str = this.str;
        String s = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch1)
                s = s + str.charAt(i);
            else
                s = s + ch2;
        }
        this.str = s;
        return this.str;
    }

    public boolean isPalindrome() {
        String str = this.str;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String splice(int start, int length) {
        String str = this.str;
        String s = "";
        int i = 0;
        for (i = 0; i < start; i++) {
            s = s + str.charAt(i);
        }
        int cnt = 1;
        while (cnt <= length) {
            i++;
            cnt++;
        }
        while (i < str.length()) {
            s = s + str.charAt(i);
            i++;
        }
        this.str = s;
        return this.str;
    }

    public String[] split(char ch) {
        String str = this.str;
        int cnt = 1;

        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i))
                cnt++;
        }
        String[] result = new String[cnt];
        int index = 0;
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                result[index] = word;
                word = "";
                index++;
            } else {
                word = word + str.charAt(i);
            }
        }
        result[index] = word;

        return result;
    }

    public String maxRepeatingCharacter() {
        String str = this.str;
        if (str.length() == 0)
            return "No characters in string";

        int[] frequency = new int[256]; // ASCII character frequency
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }

        int maxi = 0;
        char ch = ' ';
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > maxi) {
                maxi = frequency[i];
                ch = (char) i;
            }
        }

        return ch + " -> " + maxi;
    }

    public String sort() {
        String str = this.str;
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        String sortedStr = new String(chars);
        this.str = sortedStr;
        return this.str;
    }

    public String shift(int n) {
        String str = this.str;
        String s = "";
        int cnt = 1;
        int i = 0;
        while (cnt <= n) {
            cnt++;
            i++;
        }
        while (i < str.length()) {
            s = s + str.charAt(i);
            i++;
        }
        for (int j = 0; j < n; j++) {
            s = s + str.charAt(j);
        }
        this.str = s;
        return this.str;
    }

    public String reverse() {
        String str = this.str;
        char[] chars = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        String reversedString = new String(chars);
        this.str = reversedString;
        return this.str;
    }
}