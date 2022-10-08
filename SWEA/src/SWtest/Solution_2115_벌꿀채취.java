package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int N, M, C; // 맵 크기, 채취 가능 벌통의 수, 두 일꾼이 채취할 수 있는 꿀의 최대 양
	static int[][] map;

	// < 규칙 >
	// 1. 일꾼 = 2명
	// 가로로 연속된 M개의 벌통 선택 가능
	// 2. 일꾼 1명이 체취한 벌꿀 양 <= C
	// 3. 수익 = 꿀 제곱의 합

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 0. 입력
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 채취 가능 벌통 수
			C = Integer.parseInt(st.nextToken()); // 최대 양

			// 맵 정보
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // ===================== 입력 끝

			boolean[][] isSelect = new boolean[N][N]; // 좌표 방문 체크
			int totalMax = Integer.MIN_VALUE;
			int manCnt = 0;
			// 1. 가로로 연속 M개 고르기(좌표 방문 체크, 벌꿀양 개별로 저장)
			for (int i = 0; i < map.length; i++) {
				int cnt = 0;
				List<Integer> selectHoney = new ArrayList<>(); // 선택한 벌꿀
				for (int j = 0; j < map[i].length; j++) {
					if (!isSelect[i][j]) {
						selectHoney.add(map[i][j]);
						isSelect[i][j] = true;
					}

					// 2. M개 골랐으면 고른 좌표들의 벌꿀들 더하기
					int max = 0;
					if (cnt == M) {
						int sum = 0;
						for (int m = 0; m < M; m++) {
							sum += selectHoney.get(m);
							// <= C : 수익 계산
							if (sum <= C) {
								max = CalMoney();
							}
							// > C : 이 중에서 최대 수익 찾고 계산
							else {
								for (int k = M - 1; k >= 1; k--) {
									int maxSumInC = 0; // 그나마 최대인 거
									perm(0, k, maxSumInC);
								}
							}
						}
						// 계산한 수익이 이전 전체최대수익보다 크면 이번 거를 전체최대수익으로 지정
						Math.max(max, totalMax);
					}
				}
			}

			// 한 쌍 더 고르기
			// 주의! 같은 곳 겹치면 안 됨 : boolean[] select

			System.out.println("#" + t + " " + res);
		}
	}

	static void perm(int cnt, int maxCnt, int sum) {
		if (cnt == maxCnt)
			return;

		// 고른 M개의 벌꿀들 중 최대 찾기
		for (int i = 0; i < M; i++) {

		}
	}
	
	static int CalMoney() {
		int money = 0;
		return money;
	}

}
