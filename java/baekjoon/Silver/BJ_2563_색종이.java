import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S5] 백준 2563 색종이
 * 메모리 : 11580KB
 * 시간 : 80ms
 * 코드 길이 : 847B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2563">
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 도화지 배열 생성
		boolean[][] paper = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			// 검은 색종이 면적만큼 체크
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = true;
				}
			}
		}

		// 도화지에서 검은 색종이 면적 체크
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j])
					count++;
			}
		}

		// 결과 출력
		System.out.println(count);
	}
}
