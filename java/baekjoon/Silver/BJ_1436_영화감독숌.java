import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [S5] 백준 1436 영화감독 숌
 * 메모리 : 158624KB
 * 시간 : 356ms
 * 코드 길이 : 497B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1436">
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n 입력
		int n = parseInt(br.readLine());

		int count = 0;
		int number = 0;

		while (count != n) {
			// 숫자 안에 666이 연속으로 있다면 count 1증가
			if (String.valueOf(++number).contains("666")) {
				count++;
			}
		}
		// n번째로 큰 종말의 수 출력
		System.out.println(number);
	}
}
