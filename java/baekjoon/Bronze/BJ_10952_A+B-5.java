import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 10952 A + B - 5
 * 메모리 : 11604KB
 * 시간 : 76ms
 * 코드 길이 : 676B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10952">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0"))
                break;

            st = new StringTokenizer(input);
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            sb.append(a + b).append("\n");
        }

        System.out.println(sb);
    }

}