import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * SWEA 2383 [모의 SW 역량테스트] 점심 식사시간 
 * 메모리 : 24808KB 
 * 실행시간 : 141ms 
 * 코드길이 : 2821
 * 
 * @author 김민주
 */
public class Solution {

	static int size;
	static List<Pair> people;
	static List<Pair> stairs;

	static int[] selected;
	static int min;

	static class Pair implements Comparable<Pair> {
		// 사람 : 위치, 계단 입구까지의 거리, 목적 계단을 내려가는 시간 저장
		// 계단 : 위치, 계단 길이 저장
		int x, y, distance, time;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int distance) {
			this(x, y);
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair o) {
			return this.distance - o.distance;
		}
	}

	/*
	 * 중복조합(dfs), 시뮬레이션 사용
	 * 무조건 가까운 거리의 계단 입구만 선택하는 것이 아니기 때문에, 계단 입구를 선택하는 경우의 수 고려
	 * 최대 인원수가 10명이고, 계단입구는 2개, 최대 3명이기 때문에 dfs와 큐 2개 사용해도 된다고 판단
	 * 
	 * 1. 각 사람마다 목적지로 할 계단입구(총 2개 중 1개)를 dfs로 선택 
	 * 2. 모든 사람이 목적지를 정했다면 시뮬레이션 시작 
	 * 	2-1. 계단 두개를 우선순위큐로 정의(목적 계단입구까지의 거리가 짧을수록 우선순위 높음) 
	 * 	2-2. 사람과 선택한 계단 입구 사이의 거리를 구해서 저장 후 우선순위큐에 삽입 
	 * 	2-3. 현재 도착하여 계단을 내려가고 있는 사람을 배열에 저장하고, 반복문으로 길이를 줄이면서 진행 
	 * 	2-4. 만약 3명 중에 계단을 다 내려간 사람이 있다면, 큐의 가장 우선순위가 높은 사람이 계단입구에 도착했는지 확인하고 갱신 
	 * 	2-5. 도중에 시간이 최소값을 초과했다면 시뮬레이션은 종료되고, 모든 사람이 계단을 다 내려갔다면 새로운 최소값이므로 최소값 갱신
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = parseInt(br.readLine());
			min = MAX_VALUE;

			stairs = new ArrayList<>();
			people = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int input = parseInt(st.nextToken());

					if (input == 1) {
						people.add(new Pair(i, j));
					} else if (input > 1) {
						stairs.add(new Pair(i, j, input));
					}
				}
			}
			size = people.size();
			selected = new int[size];

			dfs(0);
			sb.append(String.format("#%d %d%n", tc, min));
		}

		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == size) {
			simulate();
			return;
		}

		selected[depth] = 0;
		dfs(depth + 1);
		selected[depth] = 1;
		dfs(depth + 1);
	}

	// 시뮬레이션
	public static void simulate() {
		
		// 계단입구까지의 거리가 가장 짧은 사람이 우선순위 제일 높음
		Queue<Pair>[] qs = new PriorityQueue[2];
		qs[0] = new PriorityQueue<>();
		qs[1] = new PriorityQueue<>();

		// 선택한 계단입구와의 거리 저장 후 큐에 넣기
		for (int i = 0; i < size; i++) {
			Pair person = people.get(i);
			Pair stair = stairs.get(selected[i]);

			person.distance = Math.abs(person.x - stair.x) + Math.abs(person.y - stair.y);
			person.time = stair.distance;
			qs[selected[i]].offer(person);
		}

		int count = 1;
		int[] stair1 = new int[3];
		int[] stair2 = new int[3];

		do {
			down(qs[0], stair1, count);
			down(qs[1], stair2, count);

			if (++count >= min)
				return;
			
		}while(check(stair1, stair2, qs));
		min = count;
	}
	
	// 계단을 내려가는 메서드
	static void down(Queue<Pair> q, int[] stair, int count) {
		for (int i = 0; i < 3; i++) {
			// 계단을 다 내려갔고, 현재 계단 입구에 다른 사람이 도착했다면 갱신
			// 도착 후 1분이 지나고 내려가기 때문에 갱신할 때 숫자는 감소 안함
			if (--stair[i] <= 0 && !q.isEmpty() && q.peek().distance <= count) {
				stair[i] = q.poll().time;
			}
		}
	}

	// 모든 계단 입구에 사람이 없고 올 예정인 사람도 없는지 검사하는 메서드
	static boolean check(int[] stair1, int[] stair2, Queue<Pair>[] qs) {
		for (int i = 0; i < 3; i++) {
			if (stair1[i] > 0 || stair2[i] > 0) {
				return true;
			}
		}

		return !qs[0].isEmpty() || !qs[1].isEmpty();
	}
}
