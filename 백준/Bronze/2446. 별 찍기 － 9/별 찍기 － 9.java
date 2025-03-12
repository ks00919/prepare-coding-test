import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                bw.write(" ");
            }

            int star = (n - i) * 2 + 1;
            for (int j = 0; j < star; j++) {
                bw.write("*");
            }

            bw.write("\n");
        }

        for (int i = 1; i < n; i++) {
            int blank = n - i;
            for (int j = 1; j < blank; j++)
                bw.write(" ");

            int star = i * 2;
            for (int j = -1; j < star; j++)
                bw.write("*");

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}