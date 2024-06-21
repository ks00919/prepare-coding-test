import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B1] 백준 2609 최대공약수와 최소공배수
 * 메모리 : 11536KB
 * 시간 : 76ms
 * 코드 길이 : 621B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2609">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = parseInt(st.nextToken());
		int b = parseInt(st.nextToken());

		int result = gcd(a, b);

		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n").append(a * b / result);
		System.out.println(sb);
	}

	// 유클리드 호제법
	// 두수를 나눠서(a%b) 나머지가 0이면 최대공약수, 0이 아니면 0이 될때까지
	// 최소 공배수는 두 수를 곱해서 최대공약수로 나누면 최소 공배수
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
