package N1200;

import java.util.Scanner;

public class Solution_1210_Ladder1 {
	public static int[][] arr;

	// 올라가기
	public static void goUp(int c, int r) {
		// 2. 좌우 중에 꺾을 곳 나올 때까지 올라가기
		while (arr[c][r] == 1 && arr[c][r + 1] == 0 && arr[c][r - 1] == 0) {
			c--;
		}
		// 999. 도착
		if (c == 0 && arr[c + 1][r] == 1) {
			// 전체 배열 크기를 상하좌우로 1개씩 늘렸으니 r-1로 출력
			System.out.println(r - 1);
			return; // 종료
		}

		// 3. 좌우 중에 꺾을 곳이 나오면
		// 3-1. 오른쪽에 길이 있으면 : 우로 가기
		if (arr[c][r + 1] == 1) {
			goRight(c, r + 1);
		}
		// 3-2. 왼쪽에 길이 있으면 : 좌로 가기
		else if (arr[c][r - 1] == 1) {
			goLeft(c, r - 1);
		}
	}

	// 4. 우로 가기
	public static void goRight(int c, int r) {
		// 5. 위쪽으로 가는 길이 나올 때까지 옆으로 가능 중 
		while (arr[c][r] == 1 && arr[c - 1][r] == 0) {
			r++;
		}
		// 6. 위쪽 길 있으면 다시 위로 올라가기
		if (arr[c - 1][r] == 1) {
			goUp(c - 1, r);
		}
	}

	// 4. 좌로 가기
	public static void goLeft(int c, int r) {
		// 5. 위쪽으로 가는 길이 나올 때까지 옆으로 가능 중 
		while (arr[c][r] == 1 && arr[c - 1][r] == 0) {
			r--;
		}
		// 6. 위쪽 길 있으면 다시 위로 올라가기
		if (arr[c - 1][r] == 1) {
			goUp(c - 1, r);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T;
		for (int test_case = 1; test_case <= 10; test_case++) {
			T = sc.nextInt();
			arr = new int[102][102];
			// 배열 입력
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i == 0 || i == arr.length - 1 || j == 0 || j == arr.length - 1)
						arr[i][j] = 0;
					else
						arr[i][j] = sc.nextInt();
				}
			}

			System.out.print("#" + T + " ");
			for (int i = arr.length - 2; i > 0; i--) {
				// 당첨 위치에서 시작
				if (arr[arr.length - 2][i] == 2) {
					// 1. 올라가기
					goUp(arr.length - 3, i);
				}
			}
		}
	}

}
