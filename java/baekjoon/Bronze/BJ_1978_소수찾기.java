import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [B2] 백준 1978 소수 찾기
 * 메모리 : 11560
 * 시간 : 76ms
 * 코드 길이 : 839
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1978">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            int number = parseInt(st.nextToken());
            count += isPrime(number) ? 1 : 0;
        }

        System.out.println(count);
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