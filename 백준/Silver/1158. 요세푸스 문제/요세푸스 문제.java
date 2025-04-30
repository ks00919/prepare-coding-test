import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        Queue<Integer> removed = new ArrayDeque<>();
        while (q.size() != 1) {
            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            removed.add(q.poll());
        }
        removed.add(q.poll());

        StringBuilder sb = new StringBuilder("<").append(removed.poll());
        while (!removed.isEmpty()) {
            sb.append(", ").append(removed.poll());
        }
        sb.append(">");
        System.out.println(sb);
    }
}