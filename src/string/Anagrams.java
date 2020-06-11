package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function

        if(a.length() != b.length()) return false;

        Map<Character, Integer> m1 = new HashMap();
        a = a.toUpperCase();
        b = b.toUpperCase();

        for (int i = 0; i < a.length(); i++) {
            m1.computeIfPresent(a.charAt(i), (key, val) -> val+1);
            m1.computeIfAbsent(a.charAt(i), k -> 1);

            m1.computeIfPresent(b.charAt(i), (key, val) -> val-1);
            m1.computeIfAbsent(b.charAt(i), k -> -1);
        }

        for (Map.Entry<Character, Integer> entry:m1.entrySet()) {
            if(m1.get(entry.getKey()) != 0)  return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        long startTime = System.currentTimeMillis();
        boolean ret = isAnagramEfficient(a, b);
        long endTime = System.currentTimeMillis();
        System.out.println( (ret) ? "string.Anagrams" : "Not string.Anagrams" );
        System.out.println("time taken: "+ (endTime-startTime)+"--start: "+startTime+" end: "+endTime);
    }


    static boolean isAnagramEfficient(String a, String b) {
        if(a.length() != b.length()) return false;

        a = a.toUpperCase();
        b = b.toUpperCase();

        int c[] = new int[26];

        for (int i = 0; i < a.length(); i++) {
            c[a.charAt(i) - 'A']++;
            c[b.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) return false;
        }
        return true;
    }
}
