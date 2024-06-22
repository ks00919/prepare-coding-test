import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B4] 백준 2440 별찍기 - 3
 * 
 * 메모리 : 11572KB
 * 시간 : 80ms
 * 코드 길이 : 563B
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}