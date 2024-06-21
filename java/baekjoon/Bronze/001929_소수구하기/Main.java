import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S3] 백준 1929 소수 구하기
 * 메모리 : 16432KB
 * 시간 : 368ms
 * 코드 길이 : 899B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1929">
 */
public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = parseInt(st.nextToken());
        int n = parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int j = 2; j * j <= number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

}