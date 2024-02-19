import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B5] 백준 2741 N 찍기
 * 메모리 : 17168KB
 * 시간 : 168ms
 * 코드 길이 : 469B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2741">
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
