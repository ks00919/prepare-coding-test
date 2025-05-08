import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int start = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            while (start <= number) {
                stack.push(start++);
                sb.append("+\n");
            }

            if (stack.peek() == number) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}