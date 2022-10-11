package N2000;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	static int N;
	// 5kg, 3kg
	static int kg5 = 5;
	static int kg3 = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(Suger());
		
		sc.close();
	}

	static int Suger() {
		for (int cnt5 = N / kg5; cnt5 >= 0; cnt5--) {
			for (int cnt3 = 0; cnt3 <= N / kg3; cnt3++) {
				if (N == kg5 * cnt5 + kg3 * cnt3) {
					return cnt5 + cnt3;
				}
			}
		}
		return -1;
	}

}
