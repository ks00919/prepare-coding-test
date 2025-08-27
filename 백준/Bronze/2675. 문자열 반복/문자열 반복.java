import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String string = st.nextToken();

            for (int j = 0; j < string.length(); j++) {
                for (int k = 0; k < count; k++) {
                    answer.append(string.charAt(j));
                }
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}