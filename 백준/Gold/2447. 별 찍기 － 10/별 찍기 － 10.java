import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stars = new String[n][n];
        draw(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void draw(int x, int y, int size, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    stars[i][j] = " ";
                }
            }
            return;
        }

        if (size == 1) {
            stars[x][y] = "*";
            return;
        }

        int end = size / 3;
        int count = 0;
        for (int i = x; i < x + size; i += end) {
            for (int j = y; j < y + size; j += end) {
                count++;
                draw(i, j, end, count == 5);
            }
        }
    }
}