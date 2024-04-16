import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S5] 백준 30457 단체줄넘기
 * 메모리 : 11848KB
 * 시간 : 84ms
 * 코드 길이 : 602B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/30457">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] players = new int[1001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int length = parseInt(st.nextToken());
			// 만약 양방향을 보는 선수가 같은 키 두명이 다 찼다면 설 수 없는 선수
			if (players[length] == 2)
				continue;
			players[length]++;
		}

		int sum = 0;
		for (int count : players) {
			sum += count;
		}
		System.out.println(sum);
	}

}
