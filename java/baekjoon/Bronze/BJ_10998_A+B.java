import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 10998 AxB
 * 메모리 : 11532KB
 * 시간 : 84ms
 * 코드 길이 : 396B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10998">
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(parseInt(st.nextToken()) * parseInt(st.nextToken()));
    }
}
