import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1620 나는야 포켓몬 마스터 이다솜
 * 메모리 : 61284KB
 * 시간 : 472ms
 * 코드 길이 : 1002B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1620">
 */
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		// 빠른 검색을 위해 HashMap 사용 : 포켓몬 도감번호, 포켓몬 이름 key로 저장
		Map<Integer, String> numbers = new HashMap<>();
		Map<String, Integer> names = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			numbers.put(i, name);
			names.put(name, i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			// 입력값이 숫자라면 도감 번호로 검색
			if (Character.isDigit(input.charAt(0))) {
				sb.append(numbers.get(parseInt(input))).append('\n');
			} else {
				// 영어라면 포켓몬 이름으로 검색
				sb.append(names.get(input)).append('\n');
			}
		}

		System.out.println(sb);
	}
}
