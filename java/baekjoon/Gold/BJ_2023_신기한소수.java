package BJ_2023;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [G5] 백준 2023 신기한 소수 
 * 메모리 : 11776KB 
 * 시간 : 84ms 
 * 코드 길이 : 1118B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2023">
 */

public class Main {

	static StringBuilder number = new StringBuilder();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		solution(n, 0);
		System.out.println(sb);
	}

	public static void solution(int n, int depth) {
		if (n == depth) {
			// n자리 수가 모두 소수라면 결과값 저장
			if (isPrime(parseInt(number.toString()))) {
				sb.append(number).append('\n');
			}
			// depth-1로 초기화
			number.setLength(depth - 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			number.append(i);
			// 만약 소수가 아니라면 탐색 중지
			if (!isPrime(parseInt(number.toString()))) {
				// 넣었던 숫자 초기화
				number.setLength(depth);
				continue;
			}
			// 다음 자리수 소수 검사
			solution(n, depth + 1);
			// 실행 후 넣었던 숫자 초기화
			number.setLength(depth);
		}
	}

	// 소수 검사
	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		// 제곱근 만큼 나눠가면서 검사
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
