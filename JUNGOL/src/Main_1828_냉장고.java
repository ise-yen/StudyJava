import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * xi <= ci의 보관온도 <= yi 가장 적은 수의 냉장고를 쓰는 게 목적
 * 
 */
public class Main_1828_냉장고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] temper = new int[N][2];
		for (int i = 0; i < N; i++) {
			int xi = sc.nextInt(); // 최저 온도
			int yi = sc.nextInt(); // 최고 온도
			temper[i][0] = xi;
			temper[i][1] = yi;
		}

		// 최고 온도 기준으로 정렬
		Arrays.sort(temper, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});

//		for (int i = 0; i < temper.length; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(temper[i][j] + " ");
//			}
//			System.out.println();
//		}

		int cnt = 1;
		// i번째 인덱스의 최고온도가 다른 애들 범위 내에 있는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (temper[i][1] >= temper[j][0] && temper[i][1] <= temper[j][1]) {
					
				}
				else {
					cnt++;
					break;
				}
			}
		} // end of check range
		
		System.out.println(cnt);

	} // end of main

}
