import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [S3] 백준 17952 과제는 끝나지 않아!
 * 메모리 : 215952KB
 * 시간 : 1016ms
 * 코드 길이 : 1234B
 *
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17952">
**/
public class Main {

	static class Process {
		int A;
		int T;

		public Process(int A, int T) {
			this.A = A;
			this.T = T;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());

		Process[] list = new Process[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = parseInt(st.nextToken());

			if (order == 0) {
				list[i] = new Process(0, 0);
				continue;
			}

			list[i] = new Process(parseInt(st.nextToken()), parseInt(st.nextToken()));
		}

		Stack<Process> s = new Stack<>();

		int score = 0;
		for (int i = 0; i < N; i++) {
			s.push(list[i]);
			Process curr = s.pop();

			while (curr.A == 0 && curr.T == 0) {
				if (s.isEmpty())
					break;
				curr = s.pop();
			}

			if (curr.A == 0 && curr.T == 0)
				continue;

			if (--curr.T == 0) {
				score += curr.A;
				continue;
			}

			s.push(curr);
		}

		System.out.println(score);
	}
}
