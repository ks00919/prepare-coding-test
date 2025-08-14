import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.add(input);
            } else right.add(input);

            if (!right.isEmpty() && right.peek() < left.peek()) {
                int tmp = right.poll();
                right.add(left.poll());
                left.add(tmp);
            }

            if (left.size() < right.size()) {
                left.add(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}