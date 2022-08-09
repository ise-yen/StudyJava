

import java.util.Scanner;

// 농작물 수확하기
public class Solution_2805_농작물 수확하기 {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			// 배열 입력
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 농작물 수확
			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = n / 2 - k; j <= n / 2 + k; j++) {
					sum += map[i][j];
				}
				 // 중간 전까지는 마름모로 넓어지기
				if (i < n / 2) k++;
				// 중간부터는 마름모로 좁아지기
				else k--; 
			}
			System.out.println("#" + test_case + " " + sum);
		}

	}
}
