package cracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash_Tables_Ransom_Note {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String ransomWords;

    public Hash_Tables_Ransom_Note(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        String[] words = magazine.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (magazineMap.containsKey(words[i])) {
                magazineMap.put(words[i], magazineMap.get(words[i]) + 1);
            } else {
                magazineMap.put(words[i], 1);
            }
        }
        ransomWords = note;
    }

    public boolean solve() {
        String[] words = ransomWords.split(" ");
        for (String word : words) {
            if (magazineMap.containsKey(word)) {
                int number = magazineMap.get(word);
                if (number > 0) {
                    magazineMap.put(word, number - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Hash_Tables_Ransom_Note s = new Hash_Tables_Ransom_Note(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
