import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B5] 백준 2475 검증수
 * 메모리 : 11536KB
 * 시간 : 76ms
 * 코드 길이 : 525B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2475">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			sum += Math.pow(parseInt(st.nextToken()), 2);
		}

		System.out.println(sum % 10);
	}
}
