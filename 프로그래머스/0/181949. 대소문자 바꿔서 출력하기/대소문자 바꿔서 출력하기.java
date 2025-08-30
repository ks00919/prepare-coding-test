import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if ('a' <= a.charAt(i) && 'z' >= a.charAt(i)) {
                sb.append(String.valueOf(a.charAt(i)).toUpperCase());
            } else {
                sb.append(String.valueOf(a.charAt(i)).toLowerCase());
            }
        }
        System.out.println(sb);
    }
}