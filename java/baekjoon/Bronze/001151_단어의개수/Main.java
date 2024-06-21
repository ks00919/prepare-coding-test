import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * [B2] 백준 1152 단어의 개수
 * 메모리 : 20348KB
 * 시간 : 180ms
 * 코드 길이 : 417B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1152">
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Token으로 쪼개서 Token 개수 세기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());

        // String.split()을 쓰면 틀리는 이유 - 공백만 들어올 경우 결과가 1이 나온다!
    }
}
