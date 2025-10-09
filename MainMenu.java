import java.util.Scanner;

/**
 * @Filename-MainMenu.java
 * @Description-This is the entry point for menu driven program on string-number
 * @Author-Aditya Virmani
 */
public class MainMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringNumberOperations operation = new StringNumberOperations();
        int choice = 0;
        String string = "";

        do {
            System.out.println("\n===== MENU =====\n" +
                    "1. Count Unique Palindromes\n" +
                    "2. Fibonacci Nth Number\n" +
                    "3. Snake Case to Camel Case\n" +
                    "4. Count Consonants\n" +
                    "5. Binary to Decimal Conversion\n" +
                    "6. Character Expansion\n" +
                    "7. Character Frequency\n" +
                    "8. Prime Number Checker\n" +
                    "9. Number to Words Converter\n" +
                    "10. Longest Substring Without Repeating Characters\n" +
                    "11. Exit\n");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // for leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter string");
                    string = input.nextLine();
                    int palindromes = operation.countPalindrome(string);
                    System.out.println(
                            "The number of unique palindromic substrings present in a given string is: " + palindromes);
                    break;

                case 2:
                    System.out.println("Enter Nth number");
                    int number = input.nextInt();
                    System.out.println("Nth Fibonacci number: " + operation.getFibonacciNumber(number));

                    break;

                case 3:
                    System.out.print("Enter snake_case string: ");
                    string = input.nextLine();
                    System.out.println("CamelCase: " + operation.snakeToCamel(string));

                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    string = input.nextLine();
                    System.out.println("Number of consonants is: " + operation.countConsonants(string));

                    break;

                case 5:
                    System.out.print("Enter binary number: ");
                    string = input.nextLine();
                    System.out.println("Decimal Equivalent: " + operation.binaryToDecimal(string));

                    break;

                case 6:
                    System.out.print("Enter string");
                    string = input.nextLine();
                    System.out.println("Result is: " + operation.expandCharacters(string));

                    break;

                case 7:
                    System.out.print("Enter a string: ");
                    string = input.nextLine();
                    System.out.println("Character Frequency: " + operation.characterFrequency(string));

                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    int num = input.nextInt();
                    input.nextLine();
                    System.out.println(
                            operation.isPrime(num) ? "The given number is PRIME" : "The given number is NOT PRIME");

                    break;

                case 9:

                    System.out.print("Enter a number: ");
                    long number1 = input.nextLong();
                    input.nextLine();
                    System.out.println("In words: " + operation.numberToWords(number1));

                    break;

                case 10:
                    System.out.print("Enter a string: ");
                    string = input.nextLine();
                    System.out.println("Length of longest substring without repeating characters: "
                            + operation.longestUniqueSubstring(string));

                    break;

                case 11:
                    System.out.println("\nExiting the program. Thank you!\n");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.\n");
            }
        } while (choice != 11);

    }
}
