import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S4] 백준 2217 로프
 * 메모리 : 25616KB
 * 시간 : 252ms
 * 코드 길이 : 521B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2217">
 */
public class Main {

	// 그리디
	// 1. 로프들이 최대로 들 수 있는 무게를 기준으로 오름차순 정렬
	// 2. 현재 로프는 현재 로프가 들 수 있는 무게 * 현재 로프의 무게와 같거나 큰 무게의 로프 개수가 최대 무게
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] ropes = new int[N];

		for (int i = 0; i < N; i++) {
			ropes[i] = parseInt(br.readLine());
		}
		Arrays.sort(ropes);

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ropes[i] * (N - i));
		}
		System.out.println(max);
	}
}
