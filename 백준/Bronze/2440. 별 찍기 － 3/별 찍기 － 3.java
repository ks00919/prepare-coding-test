import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int star = t - i;
            for (int j = 0; j <= star; j++)
                bw.write("*");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}