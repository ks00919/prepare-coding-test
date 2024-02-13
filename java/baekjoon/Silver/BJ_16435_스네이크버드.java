import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S5] 백준 16435 스네이크버드
 * 메모리 : 11960KB
 * 시간 : 84ms
 * 코드 길이 : 765B
 * 
 * @author 김민주
 * @see <a href = "https://www.acmicpc.net/problem/16435">
 */
public class Main {
	// 그리디 알고리즘 사용 - 스네이크버드의 최대 길이 얻기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int L = parseInt(st.nextToken());

		int[] fruits = new int[N];
		// 과일 높이 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = parseInt(st.nextToken());
		}
		// 높이 순으로 오름차순 정렬
		Arrays.sort(fruits);
		// 가장 낮은 과일부터 하나씩 먹기
		for (int i = 0; i < N; i++) {
			// 만약 먹을 수 있는 과일이라면 길이 1 증가
			if (fruits[i] <= L) {
				L++;
			}
		}

		System.out.println(L);
	}
}
