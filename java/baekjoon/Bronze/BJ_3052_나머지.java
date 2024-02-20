import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * [B2] 백준 3052 나머지
 * 메모리 : 11472KB
 * 시간 : 76ms
 * 코드 길이 : 500B
 *  
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/3052"
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			set.add(parseInt(br.readLine()) % 42);
		}

		System.out.println(set.size());
	}
}
