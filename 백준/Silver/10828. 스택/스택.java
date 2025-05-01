import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] stack = new String[n];
        int size = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack[++size] = st.nextToken();
                    break;
                case "pop":
                    if (size == -1) sb.append(size).append("\n");
                    else sb.append(stack[size--]).append("\n");
                    break;
                case "size":
                    sb.append(size + 1).append("\n");
                    break;
                case "empty":
                    sb.append(size == -1 ? 1 : 0).append("\n");
                    break;
                case "top":
                    if (size == -1) sb.append(size).append("\n");
                    else sb.append(stack[size]).append("\n");
            }
        }

        System.out.println(sb);
    }
}