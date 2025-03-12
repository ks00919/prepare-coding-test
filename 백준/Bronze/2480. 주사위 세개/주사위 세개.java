import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pip = new int[3];
        for (int i = 0; i < 3; i++) {
            pip[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pip);

        if (pip[0] == pip[1] && pip[1] == pip[2]) {
            System.out.println(10_000 + pip[0] * 1_000);
        } else if (pip[0] == pip[1]) {
            System.out.println(1_000 + pip[0] * 100);
        } else if (pip[1] == pip[2]) {
            System.out.println(1_000 + pip[1] * 100);
        } else {
            System.out.println(pip[2] * 100);
        }
    }

}
