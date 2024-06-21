import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B5] 백준 1000 A+B
 * 메모리 : 11508KB
 * 시간 : 80ms
 * 코드 길이 : 667B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1000">
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a + b);
    }
}
