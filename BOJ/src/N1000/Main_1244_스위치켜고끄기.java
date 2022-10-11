package N1000;

import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 스위치 개수
		int bulbs[] = new int[n + 1]; // 스위치
		bulbs[0] = 2;
		for (int i = 1; i <= n; i++) {
			bulbs[i] = sc.nextInt();
		}

		int std = sc.nextInt(); // 학생수
		int students[][] = new int[std][2]; // 성별, 수위치 번호

		// 학생 성별, 숫자 입력
		for (int i = 0; i < std; i++) {
			for (int j = 0; j < 2; j++) {
				students[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < std; i++) {
			int s = students[i][1];
			// 남학생
			if (students[i][0] == 1) {
				int k = 1;
				while (s * k <= n) {
					if (bulbs[s * k] == 0)
						bulbs[s * k] = 1;
					else if (bulbs[s * k] == 1)
						bulbs[s * k] = 0;
					k++;
				}
			}
			// 여학생
			else if (students[i][0] == 2) {
				// 대칭 개수
				int k = 1;
				while ((s - k >= 1 && s + k <= n) && (bulbs[s - k] == bulbs[s + k])) {
					k++;
				}
				// 대칭인 구간은 스위치 바꾸기
				for (int j = 1; j < k; j++) {
					if (s - j >= 1 && s + j <= n) {
						if (bulbs[s - j] == 0) {
							bulbs[s - j] = 1;
							bulbs[s + j] = 1;
						} else if (bulbs[s - j] == 1) {
							bulbs[s - j] = 0;
							bulbs[s + j] = 0;
						} else {
						}
					}
				}
				// 대칭 구간의 중심(여학생의 카드 위치) 스위치 바꾸기
				if (bulbs[s] == 0)
					bulbs[s] = 1;
				else
					bulbs[s] = 0;
			} else {
			}
		}

		// 출력
		for (int i = 1; i <= n; i++) {
			System.out.print(bulbs[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

		sc.close();
	}
}
