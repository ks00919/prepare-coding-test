import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S2] 백준 17087 숨바꼭질 6
 * 메모리 : 27472KB
 * 시간 : 256ms
 * 코드 길이 : 836B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17087"/>
 */
public class Main {

	// 유클리드 호제법 사용
	// 현재 수빈이와 동생들과 떨어진 거리들의 최대공약수가 정답!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int S = parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int answer = distance(S, parseInt(st.nextToken()));
		
		for (int i = 1; i < N; i++) {
			int distance = distance(S, parseInt(st.nextToken()));
			if (distance == 0)
				continue;
			answer = gcd(answer, distance);
		}

		System.out.println(answer);
	}

	public static int distance(int a, int b) {
		return Math.abs(a - b);
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
