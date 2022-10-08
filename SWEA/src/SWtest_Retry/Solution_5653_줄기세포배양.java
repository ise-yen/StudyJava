package SWtest_Retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static Queue<Sepo> q;
	static PriorityQueue<Sepo> pq;
	static int N, M, K; // 세로크기, 가로크기, 배양 시간
	static int[][] map; // 전체 맵
	static int[][] timer; // 비활->활성화 카운트 & 활성->죽음 카운트 & 활성하고 1시간 지난 뒤에 번식할 타임체크
	static eStatus[][] status; // 세포의 상태

	// 빈 자리, 세포가 새로 생긴 자리인지, 비활성화, 활성화, 죽은 세포
	static enum eStatus {
		idle, newSepo, notActivate, activate, die
	};

	static class Sepo {
		int i, j, k; // 좌표 행, 열, 배양시간

		public Sepo(int i, int j, int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0; // 정답 변수: 살아있는 줄기세포 개수 = 비활성상태+활성상태
			q = new LinkedList<>();
			pq = new PriorityQueue<>();

			// 0. 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 초기 맵의 행
			M = Integer.parseInt(st.nextToken()); // 초기 맵의 열
			K = Integer.parseInt(st.nextToken()); // 경과 시간

			// <POINT1> K시간 후까지 알면 되니깐, 맵의 최종크기 = 초기 맵 크기 + 위아래양옆으로 K만큼
			map = new int[N + K * 2][M + K * 2];

			// <POINT2> 맵의 가운데부터 세포 증식
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int sepoI = i + map.length / 2 - 1;
					int sepoJ = j + map[i].length / 2 - 1;

					map[sepoI][sepoJ] = Integer.parseInt(st.nextToken());

					Sepo sepo = new Sepo(sepoI, sepoJ, map[sepoI][sepoJ]);
					q.add(sepo);
				}
			}

			for (int time = 0; time < K; time++) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
//					if(time == )
				}
			}
			// << 규칙 >>
			// 0. 탄생
			// 1. x시간 동안 비활성화(생존)
			// 2. 활성화(생존)
			// 3. 1시간 후 : 번식
			// 3-1. 겹치면 생명력 수치가 높은 줄기 세포가 장악
			// 4. x시간 후(활성화 시간에서) 사망

			System.out.println("#" + t + " " + res);
		} // end of test case
	}
}

// [DEBUG]
//for (int i = 0; i < map.length; i++) {
//	for (int j = 0; j < map[i].length; j++) {
//		System.out.print(map[i][j] + " ");
//	}
//	System.out.println();
//}
