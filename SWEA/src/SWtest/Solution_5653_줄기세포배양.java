package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int N, M, K; // 세로크기, 가로크기, 배양 시간
	static int[][] map;
	static int[][] timer;
	static eStatus[][] status;

	// 초기세팅, 세포가 새로 생긴 자리인지, 비활성화, 활성화, 죽은 세포
	static enum eStatus {
		idle, newSepo, notActivate, activate, die
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0; // 살아있는 줄기세포 개수 = 비활성상태+활성상태

			// 0. 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// <POINT!> K 시간 후까지만 알면 되니까
			map = new int[N + K][M + K];
			timer = new int[N + K][M + K];
			status = new eStatus[N + K][M + K];

			for (int i = 0; i < status.length; i++) {
				for (int j = 0; j < status[i].length; j++) {
					status[i][j] = eStatus.idle;
				}
			}
			// <POINT!> 입력 크기만큼만 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int sepoI = i + map.length / 2 - 1;
					int sepoJ = j + map[i].length / 2 - 1;
					// <POINT!> 가운데부터 세포증식
					map[sepoI][sepoJ] = Integer.parseInt(st.nextToken());
					timer[sepoI][sepoJ] = map[sepoI][sepoJ];
					if (map[sepoI][sepoJ] != 0) {
						status[sepoI][sepoJ] = eStatus.newSepo; // 새로 생긴 세포들
						res++;
					}
				}
			}
			// ===== 입력 끝

//			// [DEBUG] 맵
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}

			// [LOGIC]
			// <POINT!> k시간 후 .. K시간 후까지
			for (int k = 0; k <= K; k++) {
				// 맵 돌기
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						int hp = map[i][j]; // 생명력 수치
						switch (status[i][j]) {
						case newSepo: // 신입 세포
							status[i][j] = eStatus.notActivate;
							break;
						case notActivate: // 활성화 X
							// activate 타이머 돌리기
							timer[i][j]--;
							if (timer[i][j] == 0) {
								status[i][j] = eStatus.activate;
								timer[i][j] = map[i][j]; // die 타이머 활성화
							}
							break;
						case activate: // 활성화 O
							// die 타이머 돌리기
							timer[i][j]--;
							// die 타이머 종료시 사망
							if (timer[i][j] == 0) {
								status[i][j] = eStatus.die;
							}
							// 활성화 O && 타이머가 1시간 돌았을 때 => 주변으로 번식
							else if (timer[i][j] == map[i][j] - 1) {
								for (int d = 0; d < deltas.length; d++) {
									int ni = i + deltas[d][0];
									int nj = j + deltas[d][1];

									// 빈 공간일 때 번식
									if (status[ni][nj] == eStatus.idle) {
										map[ni][nj] = hp;
										res++;
										System.out.println("번식: " + ni + ", " + nj);
										status[ni][nj] = eStatus.newSepo;
									}
									// <POINT!> 이번 시간대에 새로 번식한 곳 => 근데 hp가 더 큰 값이 있으면 그걸로 번식
									else if (status[ni][nj] == eStatus.newSepo) {
										if (map[ni][nj] < hp) {
											map[ni][nj] = hp;
										}
									}
								}
							}
							break;
						case die: // 죽음
							// 죽었으면 아무일도 없음
							break;
						} // end of switch
					}
				}
			} // end of K timer
			System.out.println("#" + t + " " + res);
		} // end of test case
	}
}