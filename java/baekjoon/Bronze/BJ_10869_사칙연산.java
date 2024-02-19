import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 10869 사칙연산
 * 메모리 : 11496KB
 * 시간 : 80ms
 * 코드 길이 : 664B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10869">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = parseInt(st.nextToken());
        int b = parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(a + b).append("\n");
        sb.append(a - b).append("\n");
        sb.append(a * b).append("\n");
        sb.append(a / b).append("\n");
        sb.append(a % b);

        System.out.println(sb);
    }

}