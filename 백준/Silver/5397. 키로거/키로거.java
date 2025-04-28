import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char text = input.charAt(j);

                if (Character.isLetterOrDigit(text)) {
                    left.push(text);
                } else if (text == '<') {
                    if (!left.isEmpty())
                        right.push(left.pop());
                } else if (text == '>') {
                    if (!right.isEmpty())
                        left.push(right.pop());
                } else if (text == '-') {
                    if (!left.isEmpty())
                        left.pop();
                }

            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}