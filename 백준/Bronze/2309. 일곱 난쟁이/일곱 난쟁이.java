import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static boolean finished;
    private static int[] length = new int[9];
    private static int[] choices = new int[7];
    private static boolean[] chosen = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0);
    }

    public static void dfs(int depth, int sum) {
        if (finished) return;
        if (sum > 100) return;

        if (depth == 7) {
            if (sum == 100) {
                finished = true;

                StringBuilder sb = new StringBuilder();
                Arrays.sort(choices);
                for (int i = 0; i < 7; i++) {
                    sb.append(choices[i]).append("\n");
                }
                System.out.println(sb);
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            choices[depth] = length[i];
            dfs(depth + 1, sum + length[i]);
            chosen[i] = false;
        }
    }
}