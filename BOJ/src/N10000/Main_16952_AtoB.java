package N10000;

import java.util.Scanner;

public class Main_16952_AtoB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 1;
		int A = sc.nextInt();
		int B = sc.nextInt();

		int a = A;
		int b = B;

		while (b > A) {
			// 1-1. 2의 배수 o
			if (b % 2 == 0) {
				b /= 2;
			}
			// 1-2. 2의 배수 x
			else {
				// 2-1. 끝 자리가 1일 때
				if (b % 10 == 1) {
					b -= 1;
					b /= 10;
				}
			}
			res++;
		}
		if(b == A)
			System.out.println(res);
		else
			System.out.println(-1);

	}

}
