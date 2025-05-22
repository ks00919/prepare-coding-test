import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                result[stack.pop()] = input[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}