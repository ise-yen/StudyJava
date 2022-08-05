package swea;

// 달팽이 숫자
import java.util.Scanner;

public class Solution_1954 {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case < T; test_case++) {
			int n = sc.nextInt();
			int map[][] = new int[n][n];
			int snail = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0) {
						map[i][j] = snail++;
					}
				}
				for (int j = n - 1; j >= 0; j--) {
					if (i == n - 1)
						map[i][j] = snail++;
				}
			}
			for (int i = 0; i < n; i++) {
			}
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (i == n - 1 && map[i][j] == 0)
						map[i][j] = snail++;
				}
			}
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (j == 0 && map[i][j] == 0)
						map[i][j] = snail++;
				}
			}

			System.out.println("#" + test_case);
			System.out.println();
		}
	}

}
