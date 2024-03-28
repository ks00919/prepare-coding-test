import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 3055 탈출
 * 메모리 : 14164KB
 * 시간 : 140ms
 * 코드 길이 : 2360B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/3055">
 */
public class Main {

	static class Location {
		int x, y, count;

		public Location(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	// 행과 열
	static int R, C;
	// 
	static char[][] map;
	static Location hog, beaver;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/* 1. 물 상하좌우 이동 (돌, 비버굴 이동불가), 물범람 예정인 곳에는 고슴도치가 갈 수 없기 때문에 먼저 이동
	 * 2. 같은 너비의 고슴도치 모두 이동
	 * 3. 만약 비버굴에 도착한 고슴도치가 있다면 객체 반환, 탈출할 수 없다면 null 반환
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == 'S') {
					hog = new Location(i, j, 0);
				} else if (map[i][j] == 'D')
					beaver = new Location(i, j, 0);
			}
		}

		Location result = bfs();
		System.out.println(result == null ? "KAKTUS" : result.count);
	}

	public static Location bfs() {
		Queue<Location> q = new ArrayDeque<>();
		q.add(hog);

		int time = 0;
		while (!q.isEmpty()) {
			Location curr = q.poll();

			if (curr.x == beaver.x && curr.y == beaver.y)
				return curr;
			
			// 같은 이동거리의 고슴도치들이 모두 이동했다면 물 범람
			if (curr.count != time) {
				time++;
				flood();
			}
			
			// 현재 고슴도치가 서있는 곳에 물이 있다면 넘기기
			if (map[curr.x][curr.y] == '*')
				continue;
			
			// 고슴도치 4방 이동
			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= R || y >= C)
					continue;
				if (map[x][y] != '.' && map[x][y] != 'D')
					continue;
				map[x][y] = 'S';
				q.add(new Location(x, y, curr.count + 1));
			}

		}

		return null;
	}

	public static void flood() {
		char[][] copy = new char[R][C];
		// 배열 복사
		for (int i = 0; i < R; i++) {
			copy[i] = Arrays.copyOf(map[i], C);
		}
		
		// 원본 배열에서 물이라면 4방향 물 복사
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];

						if (x < 0 || x >= R || y < 0 || y >= C)
							continue;
						if (map[x][y] == 'X' || map[x][y] == 'D')
							continue;
						copy[x][y] = '*';
					}
				}
			}
		}

		map = copy;
	}
}
