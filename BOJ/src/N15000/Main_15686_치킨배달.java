package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N; // 도시 크기
	static int M; // 살릴 치킨집 수
	static int[][] map;

	static ArrayList<Integer> cityChickenLoads = new ArrayList<>(); // 도시 치킨 거리 모음집
	static int[][] homePos; // 집 위치
	static int sumH; // 집 수
	static int[][] chickenPos; // 기존 치킨집 위치
	static int sumCh; // 기존의 치킨집 수

	static boolean visited[]; // dfs 방문용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 도시 정보 입력 (0 : 빈 칸 / 1 : 집 / 2 : 치킨집)
		map = new int[N + 1][N + 1]; // r, c가 1부터 시작하므로 한 개씩 키워주기)
		chickenPos = new int[13][2];
		homePos = new int[2 * N][2];
		for (int i = 1; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 기존 치킨집 수와 위치
				if (map[i][j] == 2) {
					chickenPos[sumCh][0] = i;
					chickenPos[sumCh][1] = j;
					sumCh++;
				}
				// 집 위치
				else if (map[i][j] == 1) {
					homePos[sumH][0] = i;
					homePos[sumH][1] = j;
					sumH++;
				}
			}
		}

		visited = new boolean[sumCh]; // DFS 방문용
		DFS(0, 0);
		// 도시 치킨 거리들 정렬 후 최소값 출력
		Collections.sort(cityChickenLoads);
		System.out.println(cityChickenLoads.get(0));
	}

	// 살릴 치킨집 고르기
	static void DFS(int index, int cnt) {
		if (cnt == M) {
			int sumCL = 0; // 도시치킨거리 계산용

			// h번째 집과 조합으로 뽑은 치킨집과의 거리
			for (int h = 0; h < sumH; h++) {
				int dis = Integer.MAX_VALUE;
				for (int i = 0; i < visited.length; i++) {
					if (visited[i]) {
						dis = Math.min(dis, Math.abs(homePos[h][0] - chickenPos[i][0])
								+ Math.abs(homePos[h][1] - chickenPos[i][1]));
					}
				}
				sumCL += dis;
			}
			// 도시 치킨 거리 결과 나올 때마다 리스트에 넣기
			cityChickenLoads.add(sumCL);
			return;
		}

		for (int i = index; i < visited.length; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			DFS(i, cnt + 1);
			visited[i] = false;
		}
	}
}
