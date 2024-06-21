import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 9498 시험 성적
 * 메모리 : 11520KB
 * 시간 : 76ms
 * 코드 길이 : 636B
 * 
 * @see <a href="https://www.acmicpc.net/problem/9498"/>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = parseInt(br.readLine());

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
