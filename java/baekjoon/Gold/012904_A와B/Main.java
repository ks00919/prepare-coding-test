import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G5] 백준 12904 A와 B
 * 메모리 : 12772KB
 * 시간 : 100ms
 * 코드 길이 : 681B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/12904"/>
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// S에서 T로 만들지 않고 역으로 T로 S를 만들어보자!
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());

		solution(S, T);
	}

	static void solution(String S, StringBuilder T) {
		int cursor = T.length();
		
		// 무조건 문자가 하나 감소하므로 cursor 1씩 감소하면서 문자열 탐색
		while (--cursor >= 0) {
			// 만약 S와 T가 같은 문자열이라면 만들 수 있는 경우이므로 1 출력
			if (S.equals(T.toString())) {
				System.out.println(1);
				return;
			}
			
			// 만약 맨 뒤 문자가 'B'라면 B를 제거하고 나머지 문자열을 거꾸로 reverse
			if (T.charAt(cursor) == 'B') {
				T.deleteCharAt(cursor);
				T.reverse();
			} else {
				// 맨 뒤 문자가 'A'라면 A를 제거
				T.deleteCharAt(cursor);
			}

		}

		System.out.println(0);
	}
}
