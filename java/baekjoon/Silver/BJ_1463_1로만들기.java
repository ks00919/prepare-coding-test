import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [S3] 백준 1463 1로 만들기 
 * 메모리 : 15636KB 
 * 시간 : 104ms 
 * 코드 길이 : 745B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1463">
 */
public class Main {

	static int[] memo;

	// 메모이제이션으로 풀이(제한 시간 0.15초)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		memo = new int[N + 1];
		
		// 배열의 범위 이내일 때 초기화
		if (N > 1)
			memo[2] = 1;
		if (N > 2)
			memo[3] = 1;

		// 4부터 N까지 반복문으로 결과 저장하면서 찾기
		for (int i = 4; i < memo.length; i++) {
			int minus = memo[i - 1] + 1;

			int two = Integer.MAX_VALUE;
			int three = Integer.MAX_VALUE;

			if (i % 2 == 0) {
				two = memo[i / 2] + 1;
			}

			if (i % 3 == 0) {
				three = memo[i / 3] + 1;
			}
			
			// 1 감소 결과, 2로 나눈 결과 ,3으로 나눈 결과 중에서 최소값 찾기
			memo[i] = Math.min(minus, Math.min(two, three));
		}
		
		// 결과 출력
		System.out.println(memo[N]);
	}
}
