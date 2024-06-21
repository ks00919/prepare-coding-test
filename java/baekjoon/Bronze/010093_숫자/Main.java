import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B2] 백준 10093 숫자
 * 
 * 메모리 : 24940KB
 * 시간 : 180ms
 * 코드 길이 : 936B
 * 
 * * @see <a href="https://www.acmicpc.net/problem/10093"/>
 */
public class Main {
    // 문제 조건을 잘 읽고 풀이할 것!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = parseLong(st.nextToken());
        long b = parseLong(st.nextToken());

        if (a == b) {
            System.out.println(0);
            return;
        } else if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(b - a - 1).append("\n");
        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
