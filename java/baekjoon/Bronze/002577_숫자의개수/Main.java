import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B2] 백준 2577 숫자의 개수
 * 메모리 : 11532KB
 * 시간 : 72ms
 * 코드 길이 : 655B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2577">
 */

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		result *= Integer.parseInt(br.readLine());

		int[] count = new int[10];
		String results = String.valueOf(result);

		int length = results.length();
		for (int i = 0; i < length; i++) {
			count[results.charAt(i) - '0']++;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
