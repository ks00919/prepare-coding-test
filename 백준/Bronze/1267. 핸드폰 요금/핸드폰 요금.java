import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long y = 0;
        long m = 0;

        for (int i = 0; i < n; i++) {
            int second = Integer.parseInt(st.nextToken());

            y += (second / 30 + 1) * 10;
            m += (second / 60 + 1) * 15;
        }

        StringBuilder sb = new StringBuilder();
        if (y > m) {
            sb.append("M").append(" ").append(m);
        } else if (y < m) {
            sb.append("Y").append(" ").append(y);
        } else {
            sb.append("Y M").append(" ").append(m);
        }
        System.out.println(sb);
    }
}