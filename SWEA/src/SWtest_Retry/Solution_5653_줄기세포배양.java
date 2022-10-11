package SWtest_Retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, K; // 초기 맵 크기, 경과 시간
	static Sepo[][] map; // 맵

	static class Sepo {
		int i, j; // 좌표
		int x; // 생명력
		int timer;
		eStatus status; // 세포의 상태

		public Sepo(int i, int j, int x, eStatus status) {
			super();
			this.i = i;
			this.j = j;
			this.x = x;
			this.timer = x;
			this.status = status;
		}
	}

	static enum eStatus {
		init, deact, act, die;
	}

	static Queue<Sepo> qBreed;
	static int res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int curN = 0, curM = 0;

		/*
		 * N = M = 5 maxN = 5 + 38 = 43
		 */

		for (int t = 1; t <= T; t++) {
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// 최대 맵 크기
			int maxN = N + K;
			int maxM = M + K;
			map = new Sepo[maxN][maxM];

			// 맵 중앙
			curN = maxN / 2 - N / 2;
			curM = maxM / 2 - M / 2;

			// 1. 초기세팅
			for (int i = curN; i < curN + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = curM; j < curM + M; j++) {
					int x = Integer.parseInt(st.nextToken());
					if (x != 0) {
						Sepo s = new Sepo(i, j, x, eStatus.deact);
						map[i][j] = s;
					}
				}
			} // ================ 입력 끝

			// K시간 동안 반복
			int k = 0;

			while (k < K) {
				// [DEBUG]
//				System.out.println(k + "시간");
//				DebugMap();

				res = 0;
				qBreed = new LinkedList<>();

				// 맵 돌리기
				for (int i = curN - k / 2; i < curN + N + k / 2; i++) {
					for (int j = curM - k / 2; j < curM + M + k / 2; j++) {
						// 세포가 없거나 죽은 세포면 패스
						if (map[i][j] == null || map[i][j].status == eStatus.die)
							continue;
						switch (map[i][j].status) {
						case deact: // 3. 비활 => 타이머 == 0 -> 활성화
							map[i][j].timer--;
							if (map[i][j].timer <= 0) {
								map[i][j].status = eStatus.act;
								map[i][j].timer = map[i][j].x - 1; // 활성화 지속시간 타이머 세팅
							}
							res++;
							break;
						case act: // 활 => 타이머 == 0 -> 죽음
							map[i][j].timer--;
							if (map[i][j].timer <= 0) {
								map[i][j].status = eStatus.die;
								qBreed.add(map[i][j]); // 번식할 세포 리스트에 넣기
							}
							else
								res++;
							break;
						case die:
						default:
							break;
						}
					}
				} // ===== 맵 돌기 끝

				// 죽은 애들은 번식
				Breed();

				k++;
				// 2. 초기(방금 번식된 뉴비라면) => 비활 && 타이머 시작
				for (int i = curN - k / 2; i < curN + N + k / 2; i++) {
					for (int j = curM - k / 2; j < curM + M + k / 2; j++) {
						if (map[i][j] == null || map[i][j].status == eStatus.die)
							continue;
						if (map[i][j].status == eStatus.init) {
							map[i][j].status = eStatus.deact;
							res++;
						}
					}
				}
			} // === end of while(K)

			System.out.println("#" + t + " " + res);
		} // end of Test Case

	} // ======= end of main

	// 번식 - 주의 : 겹치면 생멱력이 큰 애 기준
	static void Breed() {
		while (qBreed.size() > 0) {
			Sepo s = qBreed.poll();
			for (int d = 0; d < deltas.length; d++) {
				int ni = s.i + deltas[d][0];
				int nj = s.j + deltas[d][1];

				// 맵 범위 이내
				if (isInMap(ni, nj)) {
					// 빈 자리면 번식
					if (map[ni][nj] == null) {
						Sepo newS = new Sepo(ni, nj, s.x, eStatus.init);
						map[ni][nj] = newS;
					}
					// 이미 세포가 있을 때
					else {
						// 방금 번식한 애라면
						if (map[ni][nj].status == eStatus.init) {
							// 지금 세포보다 생명력이 작다면 번식
							if (map[ni][nj].x < s.x) {
								Sepo newS = new Sepo(ni, nj, s.x, eStatus.init);
								map[ni][nj] = newS;
							}
						}
						// 원래 있던 세포라면
						else {
							// 번식하면 안됨
						}
					}
				}
			}
		}
	}

	// 맵 범위 초과 여부
	static boolean isInMap(int ni, int nj) {
		boolean res = (ni >= 0 && nj >= 0 && ni < map.length && nj < map[0].length) ? true : false;
		return res;
	}

	// [DEBUG] 세포 생명력
	static void DebugMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == null)
					System.out.printf("%2d ", 0);
				else {
					if (map[i][j].status == eStatus.die)
						System.out.printf("%2d ", -1 * map[i][j].x);
					else
						System.out.printf("%2d ", map[i][j].x)
						;
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	// [DEBUG] 세포 상태
	static void DebugStatus() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == null)
					System.out.printf("%5d ", 0);
				else {
					System.out.printf("%5s ", map[i][j].status);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
