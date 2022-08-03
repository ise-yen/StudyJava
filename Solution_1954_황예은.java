
// 달팽이 숫자
import java.util.Scanner;

public class Solution_1954_황예은 {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int map[][] = new int[n][n];
			int snail = 1;
			int c = 0, r = 0;
			int cnt = n, turn = 0;
			while (snail <= n * n && r < n && c < n) {
				if (cnt == n) {
					turn++;
					// 정가로
					while (snail <= n) {
						map[c][r] = snail++;
						r++;
						if (r >= n) {
							r--;
							c++;
						}
					}
					cnt--;
				} else {
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < cnt; j++) {
							map[c][r] = snail++;
							// 정가로
							if (turn % 4 == 0) {
								if (r + 1 < n && map[c][r + 1] == 0) {
									r++;
									if (r >= n) {
										r--;
										c++; // 한 줄 내려가기
									}
								} else {
									c++;
									continue;
								}
							}
							// 정세로
							else if (turn % 4 == 1) {
								if (c + 1 < n && map[c + 1][r] == 0) {
									c++;
									if (c >= n) {
										c--;
										r--; // 좌회전
									}
								} else {
									r--; // 좌회전
									continue;
								}
							}
							// 역가로
							else if (turn % 4 == 2) {
								if (r - 1 >= 0 && map[c][r - 1] == 0) {
									r--;
									if (r < 0) {
										r++;
										c--; // 한 줄 올라가기
									}
								} else {
									c--; // 한 줄 올라가기
									continue;
								}
							}
							// 역세로
							else {
								if (c - 1 >= 0 && map[c - 1][r] == 0) {
									c--;
									if (c < 0) {
										c++;
										r++; // 우회전
									}
								} else {
									r++;
									continue;
								}
							}
						}
						turn++;
					}
					cnt--;

				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
