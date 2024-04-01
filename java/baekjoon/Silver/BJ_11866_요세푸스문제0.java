import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S5] 백준 11866 요세푸스 문제0
 * 메모리 : 12984KB
 * 시간 : 112ms
 * 코드길이 : 963B
 *
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11866"/>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.add(q.poll());
            }
            list.add(q.poll());
        }

        StringBuilder sb = new StringBuilder("<");
        for (int number : list) {
            sb.append(number).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}
