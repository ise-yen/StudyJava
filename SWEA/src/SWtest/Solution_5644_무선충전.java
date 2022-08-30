package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int timeM; // 이동시간
	static int numBC; // BC의 개수
	static int[][] BC; // BC의 좌표 정보
	static int[] C; // BC의 충전 범위
	static int[] P; // BC의 충전량

	static int[] A; // A의 이동 정보
	static int[] B; // B의 이동 정보
	static int ai, aj; // A 좌표
	static int bi, bj; // B 좌표

	// 움직x, 상, 우, 하, 좌
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= TC; tc++) {
			int sumP = 0; // 총 충전량
			///// =====> 입력 시작
			st = new StringTokenizer(br.readLine());
			timeM = Integer.parseInt(st.nextToken());
			numBC = Integer.parseInt(st.nextToken());

			// A의 정보
			ai = aj = 1; // 좌표 초기화
			st = new StringTokenizer(br.readLine());
			A = new int[timeM + 1]; // 0초일 때도 카운트. index = 0일 때는 안 움직이도록 0으로 초기화
			for (int i = 1; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			// B의 정보
			bi = bj = 10; // 좌표 초기화
			st = new StringTokenizer(br.readLine());
			B = new int[timeM + 1]; // 0초일 때도 카운트. index = 0일 때는 안 움직이도록 0으로 초기화
			for (int i = 1; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// BC의 정보. BC 1번~numBC번까지 존재. 기억하기 쉽게 배열 크기를 +1 해줌
			BC = new int[numBC + 1][2]; // BC의 좌표(x, y)
			C = new int[numBC + 1]; // 충전 범위
			P = new int[numBC + 1]; // 처리량
			for (int i = 1; i < BC.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				BC[i][0] = y;
				BC[i][1] = x;
				C[i] = Integer.parseInt(st.nextToken());
				P[i] = Integer.parseInt(st.nextToken());
			}
			///// <===== 입력 끝

			
			// 0. 주어진 시간 동안 : m초에
			for (int m = 0; m <= timeM; m++) {
				// 1. A, B 이동
				ai += dr[A[m]];
				aj += dc[A[m]];
				bi += dr[B[m]];
				bj += dc[B[m]];

				// 2. A, B가 BC 범위에 들어갔다면 충전량 넣기
				// m초일 때 A, B가 각각 받을 수 있는 충전량(균등 분배 고려x), index = BC의 1번~numBC번
				int aP[] = new int[numBC + 1];
				int bP[] = new int[numBC + 1];

				for (int bc = 1; bc < BC.length; bc++) {
					int aD = Math.abs(BC[bc][0] - ai) + Math.abs(BC[bc][1] - aj);
					int bD = Math.abs(BC[bc][0] - bi) + Math.abs(BC[bc][1] - bj);
					if (aD <= C[bc]) {
						aP[bc] = P[bc];
					}
					if (bD <= C[bc]) {
						bP[bc] = P[bc];
					}
				}

				// 3. m초에 A, B가 받는 최대 충전량(균등 분배 고려)
				int max = 0;
				int tempSumP = 0;
				for (int aBC = 1; aBC < BC.length; aBC++) {
					for (int bBC = 1; bBC < BC.length; bBC++) {
						if (aBC == bBC && aP[aBC] == bP[bBC])
							tempSumP = aP[aBC];
						else
							tempSumP = aP[aBC] + bP[bBC];
						max = Math.max(max, tempSumP);
					}
				}
				sumP += max;
			} // end of timeM

			// 정답 출력
			System.out.println("#" + tc + " " + sumP);

		} // end of test case
	}

}
