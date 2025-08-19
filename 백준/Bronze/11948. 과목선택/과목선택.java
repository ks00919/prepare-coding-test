import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()); // 물리
        int b = Integer.parseInt(br.readLine()); // 화학
        int c = Integer.parseInt(br.readLine()); // 생물
        int d = Integer.parseInt(br.readLine()); // 지구과학
        int e = Integer.parseInt(br.readLine()); // 역사
        int f = Integer.parseInt(br.readLine()); // 지리

        System.out.println((a + b + c + d) - Math.min(a, Math.min(b, Math.min(c, d))) + Math.max(e, f));

    }
}