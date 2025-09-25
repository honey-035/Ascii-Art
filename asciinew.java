import java.util.*;

public class asciinew {

    static String[][] s = {
        { " XXX  XXXX  XXXXX XXXX  XXXXX XXXXX XXXX  X   X XXXXX XXXXX X   X X     X   X X   X  XXX  XXXXX  XXX  XXXX  XXXXX XXXXX X   X X   X X   X X   X X   X XXXXX " },
        { "X   X X   X X     X   X X     X     X     X   X   X     X   X  X  X     XX XX XX  X X   X X   X X   X X   X X       X   X   X X   X X   X  X X   X X     X  " },
        { "XXXXX XXXX  X     X   X XXXX  XXXX  X  XX XXXXX   X     X   X X   X     X X X X X X X   X XXXXX X   X XXX   XXXXX   X   X   X X   X X X X   X     X     X   " },
        { "X   X X   X X     X   X X     X     X   X X   X   X   X X   X  X  X     X   X X  XX X   X X     X  XX X  X      X   X   X   X  X X  XX XX  X X    X    X    " },
        { "X   X XXXX  XXXXX XXXX  XXXXX X     XXXX  X   X XXXXX  XX   X   X XXXXX X   X X   X  XXX  X      XXXX X   X XXXXX   X   XXXXX   X   X   X X   X   X   XXXXX " }
    };

    static String[][] num = {
        {" XX   XX   XX   XX     X XXXX XXXX XXXX  XX  XXXX "},
        {"X  X XXX  X  X X  X   XX X    X       X X  X X  X "},
        {"X  X  XX    X    X   X X XXXX XXXX   X   XX  XXXX "},
        {"X  X  XX   X   X  X XXXX    X X  X  X   X  X    X "},
        {" XX  XXXX XXXX  XX     X XXXX XXXX X     XX  XXXX "}
    };

    static String[][] sym = {
        {"XX       X X     X  X     XX         X   XX      XXXX    XXXX "},
        {"XX       X X     X  X   XXXXXX  XX  X   X  X    XX   X  X    X"},
        {"XX              XXXXXX  X       XX X     XX         XX  X XX X"},
        {"XX               X  X   XXXXXX    X XX   XX X      XX   X X XX"},
        {"XX              XXXXXX       X   X  XX  X  X      XX    X XXXX"},
        {"                 X  X   XXXXXX  X        XX X           X     "},
        {"XX               X  X     XX                      XX     XXX  "}
    };

    public static void main(String[] args) {
        showASCIIMenu();
    }

    static void clearScreen() {  
        System.out.flush();
    }

    static void pause(Scanner sc) {
        System.out.print("\nDo you want to continue? (y/n): ");
        String ans = sc.nextLine().trim().toLowerCase();
        if (!ans.equals("y")) {
            System.out.println("\n Thank you! Program ended.");
            System.exit(0);
        } else {
            clearScreen();
        }
    }

    static void showASCIIMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n==================================");
            System.out.println("        ASCII PROJECT MENU ");
            System.out.println("==================================");
            System.out.println("1. Show All Alphabets (A-Z)");
            System.out.println("2. Show Single Letter");
            System.out.println("3. Show Word");
            System.out.println("4. Show Range of Letters");
            System.out.println("5. Show Numbers");
            System.out.println("6. Show Symbol");
            System.out.println("7. Show Mix (Letters + Numbers + Symbols)");
            System.out.println("8. Exit");
            System.out.print(" Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> { Alphabet(); pause(sc); }
                case 2 -> {
                    System.out.print(" Enter a single letter (A-Z): ");
                    String letter = sc.nextLine();
                    Letter(letter);
                    pause(sc);
                }
                case 3 -> {
                    System.out.print(" Enter a word (A-Z only): ");
                    String word = sc.nextLine();
                    Word(word);
                    pause(sc);
                }
                case 4 -> {
                    System.out.print(" Enter a range (e.g. H-R): ");
                    String range = sc.nextLine();
                    Range(range);
                    pause(sc);
                }
                case 5 -> { Numbers(); pause(sc); }
                case 6 -> { Symbols(); pause(sc); }
                case 7 -> {
                    System.out.print(" Enter mix (letters, numbers, symbols): ");
                    String mix = sc.nextLine();
                    Mix(mix);
                    pause(sc);
                }
                case 8 -> {
                    System.out.println("\n Thank you! Program ended.");
                    sc.close();
                    return;
                }
                default -> System.out.println(" Invalid choice! Please enter 1–8.");
            }
        }
    }

    static void Alphabet() {
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i][0]);
        }
    }

    static void Letter(String s1) {
        if (s1.length() != 1 || !Character.isLetter(s1.charAt(0))) return;
        int p = Character.toUpperCase(s1.charAt(0)) - 64;
        int cnt = 6 * (p - 1);
        for (int i = 0; i < s.length; i++) {
            char[] c = s[i][0].toCharArray();
            for (int j = cnt; j < cnt + 6; j++) System.out.print(c[j]);
            System.out.println();
        }
    }

    static void Word(String s1) {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < s1.length(); k++) {
                int p = Character.toUpperCase(s1.charAt(k)) - 64;
                int cnt = 6 * (p - 1);
                char[] c = s[i][0].toCharArray();
                for (int j = cnt; j < cnt + 6; j++) System.out.print(c[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Range(String s1) {
        char startChar = Character.toUpperCase(s1.charAt(0));
        char endChar = Character.toUpperCase(s1.charAt(2));
        for (int i = 0; i < 5; i++) {
            for (char currentChar = startChar; currentChar <= endChar; currentChar++) {
                int p = currentChar - 64;
                int startCol = 6 * (p - 1);
                System.out.print(s[i][0].substring(startCol, startCol + 6));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Symbols() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose one of (!, \", #, $, %, &, ?, @): ");
        char c1 = input.next().charAt(0);
        int p = switch (c1) {
            case '!' -> 1;
            case '"' -> 2;
            case '#' -> 3;
            case '$' -> 4;
            case '%' -> 5;
            case '&' -> 6;
            case '?' -> 7;
            case '@' -> 8;
            default -> -1;
        };
        if (p == -1) return;
        int cnt = 8 * (p - 1);
        for (int i = 0; i < sym.length; i++) {
            char[] c = sym[i][0].toCharArray();
            for (int j = cnt; j < cnt + 6; j++) if (j < c.length) System.out.print(c[j]);
            System.out.println();
        }
    }

    static void Numbers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        String s1 = input.next();
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < s1.length(); k++) {
                int p = s1.charAt(k) - 47;
                int cnt = 5 * (p - 1);
                char[] c = num[i][0].toCharArray();
                for (int j = cnt; j < cnt + 5; j++) if (j < c.length) System.out.print(c[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Mix(String s1) {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < s1.length(); k++) {
                char ch = s1.charAt(k);
                if (Character.isLetter(ch)) {
                    int p = Character.toUpperCase(ch) - 64;
                    int cnt = 6 * (p - 1);
                    char[] c = s[i][0].toCharArray();
                    for (int j = cnt; j < cnt + 6; j++) System.out.print(c[j]);
                } else if (Character.isDigit(ch)) {
                    int p = ch - 47;
                    int cnt = 5 * (p - 1);
                    char[] c = num[i][0].toCharArray();
                    for (int j = cnt; j < cnt + 5; j++) if (j < c.length) System.out.print(c[j]);
                } else {
                    int idx = "!\"#$%&?@".indexOf(ch) + 1;
                    if (idx > 0) {
                        int cnt = 8 * (idx - 1);
                        char[] c = sym[i][0].toCharArray();
                        for (int j = cnt; j < cnt + 6; j++) if (j < c.length) System.out.print(c[j]);
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
