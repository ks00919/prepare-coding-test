import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G5] 백준 9205 맥주 마시면서 걸어가기
 * 메모리 : 18256KB
 * 시간 : 188ms
 * 코드 길이 : 2223B
 *
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/9205"/>
 */
public class Main {

    static String success = "happy";
    static String fail = "sad";
    static int INF = 9999999;

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 플로이드 워샬 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = parseInt(br.readLine());
            Location[] locations = new Location[n + 2];

            for (int i = 0; i < locations.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                locations[i] = new Location(parseInt(st.nextToken()), parseInt(st.nextToken()));
            }

            int[][] fluid = new int[n + 2][n + 2];

            for (int i = 0; i < fluid.length; i++) {
                for (int j = 0; j < fluid.length; j++) {
                    // 출발 노드와 도착 노드가 같다면 INF 넣어두기
                    if (i == j) {
                        fluid[i][j] = INF;
                        continue;
                    }
                    
                    // 출발 노드와 도착 노드까지의 맥주가 20개 넘게 필요하면 갈 수 없으므로 INF 넣어두기
                    int beers = beersOf(locations[i], locations[j]);
                    fluid[i][j] = beers > 20 ? INF : beers;
                }
            }

            // 중간노드를 거쳐 도착할 수 있는지 확인하기
            for (int i = 0; i < fluid.length; i++) {
                for (int x = 0; x < fluid.length; x++) {
                    for (int y = 0; y < fluid.length; y++) {
                        fluid[x][y] = Math.min(fluid[x][y], fluid[x][i] + fluid[i][y]);
                    }
                }
            }
            
            // 만약 여전히 갈 수 없는(INF)라면 실패, 아니라면 성공
            if (fluid[0][n + 1] == INF) {
                sb.append(fail).append("\n");
            } else {
                sb.append(success).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int beersOf(Location location1, Location location2) {
        int distance = Math.abs(location1.x - location2.x) + Math.abs(location1.y - location2.y);
        // 50의 배수가 넘으면 맥주가 하나 더 필요하기 때문에 조건 처리
        return distance % 50 == 0 ? distance / 50 : distance / 50 + 1;
    }
}
