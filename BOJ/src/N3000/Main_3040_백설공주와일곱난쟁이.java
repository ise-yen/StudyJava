package N3000;

import java.util.Scanner;

public class Main_3040_백설공주와일곱난쟁이 {

	static boolean visited[];
	static int[] dobie;
	static int sum2;
	static int sum9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 난쟁이 번호 입력 받으면서 총합 구하기
		visited = new boolean[9];
		dobie = new int[9];
		for (int i = 0; i < dobie.length; i++) {
			dobie[i] = sc.nextInt();
			sum9 += dobie[i];
		}
		// 총합 - 난쟁이 2명(조합)의 합 = 100인 거 찾기
		DFS(0, 0);
		
		sc.close();
	}

	static void DFS(int index, int cnt) {
		// 난쟁이 2명 뽑기
		if (cnt == 2) {
			sum2 = 0;
			for (int i = 0; i < dobie.length; i++) {
				if (visited[i]) {
//					System.out.print(dobie[i] + ", ");
					sum2 += dobie[i];
				}
			}
//			System.out.println();

			// 뽑은 애들만 없을 때 모자합이 100이라면 정답
			if (sum9 - sum2 == 100) {
				for (int i = 0; i < dobie.length; i++) {
					if (!visited[i])
						System.out.println(dobie[i]);
				}
			}
			return;
		}
		for (int i = index; i < dobie.length; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			DFS(i, cnt + 1);
			visited[i] = false;
		}
	}

}
