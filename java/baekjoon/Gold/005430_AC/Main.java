import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 * [G5] 백준 5430 AC
 * 메모리 : 87804KB
 * 시간 : 600ms
 * 코드 길이 : 2038B
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<String> q = new ArrayDeque<>();
            if (n > 0) {
                String[] numbers = input.substring(1, input.length() - 1).split(",");
                Collections.addAll(q, numbers);
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReverse = !isReverse;
                    continue;
                } else if (q.isEmpty()) {
                    isError = true;
                    break;
                }

                if (isReverse)
                    q.removeLast();
                else
                    q.removeFirst();
            }

            if (isError) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            if (isReverse) {
                if (!q.isEmpty())
                    sb.append(q.removeLast());
                while (!q.isEmpty()) {
                    sb.append(",").append(q.removeLast());
                }
            } else {
                if (!q.isEmpty())
                    sb.append(q.removeFirst());
                while (!q.isEmpty()) {
                    sb.append(",").append(q.removeFirst());
                }
            }
            sb.append("]\n");
        }

        System.out.println(sb);
    }
}