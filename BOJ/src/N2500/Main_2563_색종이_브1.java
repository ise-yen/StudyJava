package N2500;

import java.util.Scanner;

public class Main_2563_색종이_브1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] pos = new int[n][2];
		for (int i = 0; i < n; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
		}
		int res = 0;

		int[][] white = new int[100][100];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					if(white[pos[i][0] + j][pos[i][1] + k] == 0) {
						white[pos[i][0] + j][pos[i][1] + k] = 1;
						res++;
					}
				}
			}
		}

		System.out.println(res);

	}

}
