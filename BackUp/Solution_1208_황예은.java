

import java.util.Scanner;

// Flatten
public class Solution_1208_황예은 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int maxI;
	static int minI;
	static int map[] = new int[100];

	// 최대값, 최소값, index값 찾기
	static void maxmin() {
		for (int i = 0; i < map.length; i++) {
			if (map[i] > max) {
				max = map[i];
				maxI = i;
			}
			if (map[i] < min) {
				min = map[i];
				minI = i;
			}
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 초기화
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			maxI = minI = 0;

			int dump = sc.nextInt();

			// 배열 입력
			for (int i = 0; i < map.length; i++)
				map[i] = sc.nextInt();
			// 최대 최소 확인
			maxmin();

			for (int i = 0; i < dump; i++) {
				// 배열 값 바꾸면서 최대최소값도 바꾸기
				max = --map[maxI];
				min = ++map[minI];
				// 최대 최소 확인
				maxmin();
			}

			System.out.println("#" + test_case + " " + (max - min));
		}
	}
}