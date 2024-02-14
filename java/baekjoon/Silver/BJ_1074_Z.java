import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] 백준 1074 Z
 * 메모리 : 11532KB
 * 시간 : 72ms
 * 코드 길이 : 1051B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1074">
 */
public class Main {

	// 전부 재귀로 값을 구하게 되면 시간초과가 발생한다! (제한시간 0.5초)
	// 수학적 규칙을 찾아서 일부분만 재귀로 값 구하기
	
	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		r = parseInt(st.nextToken());
		c = parseInt(st.nextToken());
		
		// 한 변의 길이 2^n
		int length = (int) Math.pow(2, N);
		z(length, 0, 0, 0);
	}

	// 한 변의 길이, 방문 순서 값, 현재 구역의 맨 처음 인덱스
	public static void z(int l, int value, int x, int y) {
		// 한변의 길이가 1일때 해당 값 출력 후 프로그램 종료
		if (l == 1) {
			System.out.println(value);
			return;
		}

		// 한 변의 길이를 절반으로 나눈 값과 x, y값을 가지고 4등분 내의 r, c의 위치 판단
		// 4등분의 한 분면의 처음 값은 현재 처음 값 + 현재 한 변의 길이 제곱 * 분면위치(Z 탐색 순서대로 0, 1, 2, 3)
		// 한 변의 길이가 1이 될때까지(처음 값 = 전체 값) 재귀 호출
		int half = l / 2;
		int size = l * l / 4;
		if (r < x + half && c < y + half) {
			z(half, value, x, y);
		} else if (r < x + half && c >= y + half) {
			z(half, value + size, x, y + half);
		} else if (r >= x + half && c < y + half) {
			z(half, value + size * 2, x + half, y);
		} else {
			z(half, value + size * 3, x + half, y + half);
		}

		return;
	}

}
