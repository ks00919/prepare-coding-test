import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D4] SWEA 5604 [Professional] 구간 합
 * 메모리 : 26420KB
 * 실행시간 : 109ms
 * 코드길이 : 1145
 * 
 * @author 김민주
 */
public class Solution {

	// 해시맵에 이전 값 저장
	static HashMap<Long, Long> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new HashMap<>();
		map.put(0l, 0l);
		for (long i = 1l; i < 10; i++) {
			map.put(i, map.get(i - 1) + i);
		}

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 입력값이 int 범위 넘는 점 주의..
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			sb.append("#").append(tc).append(" ");

			sb.append(cal(B) - cal(A - 1)).append("\n");
		}
		System.out.println(sb);
	}

	public static long cal(long n) {
		if (n == -1)
			return 0;
		
		// 이미 저장된 값이면 바로 return
		if (n < 10 || map.containsKey(n))
			return map.get(n);

		long v = V(n);
	
		// 점화식
		long result = cal(n - 1 - n % v) + (n / v * (n % v + 1) + cal(n % v));
		map.put(n, result);
		return result;
	}

	public static long V(long n) {
		long v = 1;
		while (n >= 10) {
			v *= 10;
			n /= 10;
		}
		return v;
	}

}
