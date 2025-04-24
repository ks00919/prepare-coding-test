import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            left.push(string.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.push(input.charAt(2));
                    break;
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}