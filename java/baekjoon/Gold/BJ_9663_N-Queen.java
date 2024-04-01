import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 9663 N-Queen
 * 메모리 : 12100KB
 * 시간 : 4940ms
 * 코드 길이 : 893B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/9663">
 */
public class Main {

	static int N, count;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = parseInt(br.readLine());
		selected = new int[N];
		dfs(0);
		System.out.println(count);
	}

	public static void dfs(int depth) {
		if (depth == N) {
			// 체스판 끝까지 퀸을 놨다면 경우의 수 증가
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// 퀸을 놓을 수 있는 경우만 유망하다고 보고 가지치기
			if (isValidQ(depth, i)) {
				selected[depth] = i;
				dfs(depth + 1);
			}
		}
	}

	public static boolean isValidQ(int depth, int index) {
		int count = 0;
		for (int i = depth - 1; i >= 0; i--) {
			// 위, 위쪽 대각선 양옆에 queen이 놓여있는지 확인하기
			if (selected[i] == index || selected[i] == (index - ++count) || selected[i] == (index + count))
				return false;
		}
		// 놓여있지 않으면 true
		return true;
	}

}
