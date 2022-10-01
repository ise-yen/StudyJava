package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 집 번호 : 1~N번
		int[][] cost = new int[N][3]; // N개의 집, rgb
		int[][] minCostColor = new int[N][3];
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int minCost = Integer.MAX_VALUE; // i층에서 제일 작은 비용 찾기...를 1~N까지
			int minColor = 0;
			for (int c = 0; c < 3; c++) {
				cost[n][c] = Integer.parseInt(st.nextToken());
				if (minCost > cost[n][c]) {
					minColor = c;
				}
			}
		}
		// ======== 입력 끝

	}
}

/*
 * 1번 집 색 != 2번 집 색 N-1번 색 != N번 색 i-1 != i != i+1
 * 
 * 
 * 1층을 최솟값 + 로 시작했을 때 => 2층을.. => 3층을.. 으로 계산하기
 * 
 * 
 * 
 * 
 */
