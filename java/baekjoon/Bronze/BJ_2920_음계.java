import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B2] 백준 2920 음계
 * 메모리 : 11612KB
 * 시간 : 80ms
 * 코드 길이 : 501B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2920">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().replace(" ", "");

		if (input.equals("12345678")) {
			System.out.println("ascending");
		} else if (input.equals("87654321")) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}

	}
}
