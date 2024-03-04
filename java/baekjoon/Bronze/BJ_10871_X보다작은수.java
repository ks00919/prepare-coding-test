import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 10871 X보다 작은 수
 * 메모리 : 13276KB
 * 시간 : 108ms
 * 코드 길이 : 704B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10871">
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int X = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = parseInt(st.nextToken());

            if (number < X)
                sb.append(number).append(" ");
        }

        System.out.println(sb);
    }
}
