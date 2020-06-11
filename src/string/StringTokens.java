package string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
//        String delimeter = "[ !,?._'@]+";
        //method1
//        Pattern pattern = Pattern.compile(delimeter, Pattern.CASE_INSENSITIVE);
//        String[] tokens = pattern.split(s);

        //method 2
//        String[] tokens = s.split(delimeter);
//
//        if (s.trim().isEmpty()) {
//            System.out.println(0);
//        } else if (tokens.length ==0) {
//            return;
//        } else{
//            System.out.println(tokens.length);
//            for (String token: tokens) {
//                System.out.println(token);
//            }
//        }

        //method 3
        StringTokenizer st = new StringTokenizer(s, "A-Z !,?._'@");
        System.out.println(st.countTokens());

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }


        scan.close();
    }

}
