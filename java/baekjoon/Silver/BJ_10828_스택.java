import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S4] 백준 10828 스택
 * 메모리 : 16644KB
 * 시간 : 132ms
 * 코드 길이 : 1174B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10828">
 */
public class Main {

	// 간단하게 스택 구현
	static int cursor = -1;
	static int[] stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = parseInt(br.readLine());
		// 입력이 최대 N개이기 때문에 배열을 N개까지만 생성
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			default:
				sb.append(top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	static void push(int n) {
		stack[++cursor] = n;
	}

	static int pop() {
		if (cursor == -1)
			return -1;
		return stack[cursor--];
	}

	static int size() {
		return cursor + 1;
	}

	static int empty() {
		return cursor == -1 ? 1 : 0;
	}

	static int top() {
		if (cursor == -1)
			return -1;
		return stack[cursor];
	}
}
