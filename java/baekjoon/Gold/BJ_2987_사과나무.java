import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 2987 사과나무
 * 메모리 : 11704KB
 * 시간 : 80ms
 * 코드길이 : 1595B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2987">
 */
public class Main {

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 수학적 지식으로 쉽게 풀리는 문제..ㅠㅠ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 삼각형의 세 좌표 입력받기
		Pair[] ground = new Pair[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ground[i] = new Pair(parseInt(st.nextToken()), parseInt(st.nextToken()));
		}
		
		// 전체 사과나무의 개수
		int N = parseInt(br.readLine());
		
		// 삼각형의 전체 넓이 구하기
		double totalArea = area(ground[0], ground[1], ground[2]);
		// 백준이의 사과 나무의 개수
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			
			/*
			 * 만약 입력받은 사과 나무가 삼각형 영역 내부에 있다면 
			 * 사과나무 위치와 삼각형의 꼭짓점 각각 두개로 구한 세개의 삼각형의 합과 삼각형의 전체 넓이와 같다
			 * 사과나무 위치가 내부에 있다고 가정하고 전체 삼각형 내부의 점으로 삼각형을 세개로 쪼개 넓이를 구한 후 합하는 것
			 * 사과나무가 영역 밖에 있다면 삼각형보다 넓이가 더 크다! 
			 */
			double sum = 0;
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					sum += area(x, y, ground[j], ground[0]);
					continue;
				}

				sum += area(x, y, ground[j], ground[j + 1]);
			}
			
			// 삼각형 안에 사과나무가 있다면 카운트 증가
			if (totalArea == sum)
				count++;
		}

		StringBuilder sb = new StringBuilder();
		// 전체 넓이 출력
		sb.append(totalArea).append("\n");
		// count 출력
		sb.append(count);

		System.out.println(sb);
	}

	// 편하게 계산하기 위해서 overloading으로 메서드 정의
	public static double area(Pair a, Pair b, Pair c) {
		return area(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	public static double area(int x, int y, Pair a, Pair b) {
		return area(x, y, a.x, a.y, b.x, b.y);
	}
	
	// 삼각형의 넓이 공식으로 넓이 계산
	public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a = x1 * (y2 - y3);
		double b = x2 * (y3 - y1);
		double c = x3 * (y1 - y2);
		return Math.abs(a + b + c) / 2;
	}
}
