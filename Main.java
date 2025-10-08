import java.util.Scanner;

/**
 * @Filename-Main.java
 * @Description-This is the entry point
 * @Author-Aditya Virmani
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Initial string");
        String initialString = sc.nextLine();
        MyString s = new MyString(initialString);
        int choice;
        do {
            System.out.println(
                    "\nEnter your choice:\n" +
                            "1. Append\n" +
                            "2. CountWords\n" +
                            "3. Replace\n" +
                            "4. isPalindrome\n" +
                            "5. Splice\n" +
                            "6. Split\n" +
                            "7. MaxRepeatingCharacter\n" +
                            "8. Sort\n" +
                            "9. Shift\n" +
                            "10. Reverse\n" +
                            "0. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter string to be appended");
                    String append = sc.nextLine();
                    s.append(append);
                    System.out.println("Result is:" + s.str);
                    break;

                case 2:
                    int word = s.countWords();
                    System.out.println("Total Words: " + word);
                    break;

                case 3:
                    System.out.println("Enter character to be replaced");
                    char prevChar = sc.next().charAt(0);
                    System.out.println("Replace with");
                    char newChar = sc.next().charAt(0);
                    s.replace(prevChar, newChar);
                    System.out.println("Result is:" + s.str);
                    break;

                case 4:
                    boolean result = s.isPalindrome();
                    System.out.println(result ? "String is palindrome" : "String is not palindrome");
                    break;

                case 5:
                    System.out.println("Enter starting index");
                    int start = sc.nextInt();
                    System.out.println("Enter Length");
                    int length = sc.nextInt();
                    s.splice(start, length);
                    System.out.println("Result is:" + s.str);
                    break;

                case 6:
                    System.out.println("Enter the pattern to split");
                    char ch = sc.next().charAt(0);
                    String[] result1 = s.split(ch);
                    System.out.println("Result is:");
                    for (String str : result1) {
                        System.out.println(str);
                    }
                    break;

                case 7:
                    System.out.println(s.maxRepeatingCharacter());
                    break;

                case 8:
                    s.sort();
                    System.out.println("Result is:" + s.str);
                    break;

                case 9:
                    System.out.println("Enter number of characters to shift from start to end");
                    int n = sc.nextInt();
                    s.shift(n);
                    System.out.println("Result is:" + s.str);
                    break;

                case 10:
                    s.reverse();
                    System.out.println("Result is:" + s.str);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Not a valid choice");
                    break;
            }

        } while (choice != 0);

    }
}
