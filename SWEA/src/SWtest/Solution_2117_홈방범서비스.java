package SWtest;

/**
 * 완탐, 시뮬레이션
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 손해 보지 않는 한 최대한 많은 집에 제공
public class Solution_2117_홈방범서비스 {
	static int N; // 맵 크기
	static int M; // 한 집이 지불 가능한 비용
	static int serviceCost; // 운영 비용 = K * K + (K-1) * (K-1)
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 한 집이 지불 가능한 비용
			map = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxHouse = Integer.MIN_VALUE; // 서비스 가능한 가장 많은 집

			// 어떤 K일 때가 가장 많은 서비스 가능한지
			for (int k = map.length; k > 0; k--) {
				int cntHouse = 0;
				serviceCost = k * k + (k - 1) * (k - 1); // 운영비용
				if (k == 1) {
					cntHouse = 1;
				} else {
					cntHouse = CheckHouse(k);
				}
				// 손해를 안 볼 때
				if (cntHouse * M >= serviceCost)
					maxHouse = Math.max(maxHouse, cntHouse);
			}

			System.out.println("#" + tc + " " + maxHouse);
		}
	}

	// 상 하 좌 우
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int[][] deltas = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int CheckHouse(int K) {
		int maxHouse = Integer.MIN_VALUE;

		// 범위가 K일 때 i, j를 중심으로 가장 이득일지(가장 많은 집을 가질 지)
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int cntHouse = 0;
				// i, j에서 K 범위 내의 집 개수(cntHouse) 계산
				for (int k = 0; k < K; k++) {
					for (int d = 0; d < dr.length; d++) {
						if (i + dr[d] * k >= 0 && i + dr[d] * k < map.length && j + dc[d] * k >= 0
								&& j + dc[d] * k < map[i].length)
							if (map[i + dr[d] * k][j + dc[d] * k] == '1')
								cntHouse++;
					}
				}
				// => 이렇게 하며 직선만 체크함.대각서 무시됨

				// 손해를 안 볼 때
				if (cntHouse * M >= serviceCost) {
					maxHouse = Math.max(maxHouse, cntHouse);
//					System.out.println(i + ", " +  j);
				}
			}
		}

		return maxHouse;
	}

}
