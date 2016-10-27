package cracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful.
 * We consider two strings to be anagrams of each other if the first string's
 * letters can be rearranged to form the second string. In other words, both
 * strings must contain the same exact letters in the same exact frequency For
 * example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * 
 * Alice decides on an encryption scheme involving two large strings where
 * encryption is dependent on the minimum number of character deletions required
 * to make the two strings anagrams. Can you help her find this number?
 * 
 * Given two strings, and , that may or may not be of the same length, determine
 * the minimum number of character deletions required to make and anagrams. Any
 * characters can be deleted from either of the strings.
 * 
 * @author vsidda
 *
 */
public class Making_Anagrams {
    public static int numberNeeded(String first, String second) {
        int number_of_deletions_needed = 0;
        Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
        for (int i = 0; i < first.length(); i++) {
            if (characterCount.get(first.charAt(i)) != null) {
                characterCount.put(first.charAt(i), characterCount.get(first.charAt(i)) + 1);
            } else {
                characterCount.put(first.charAt(i), 1);
            }
        }
        for (int i = 0; i < second.length(); i++) {
            if (characterCount.get(second.charAt(i)) != null) {
                characterCount.put(second.charAt(i), characterCount.get(second.charAt(i)) - 1);
            } else {
                characterCount.put(second.charAt(i), -1);
            }
        }

        for (Character key : characterCount.keySet()) {
            number_of_deletions_needed += Math.abs(characterCount.get(key));
        }
        return number_of_deletions_needed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
