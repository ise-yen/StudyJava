package N5000;

import java.io.IOException;
import java.util.Scanner;

public class Solution_5607_조합 {
	public static int N, R;
	public static int Q = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			R = sc.nextInt();
			System.out.println("#" + t + " " + nCr(N, R, Q));
		}
	}

	static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	static long nCr(int n, int r, int p) {
		if (r == 0)
			return 1L;
		if (r == n)
			return 1L;

		long[] fac = new long[n + 1];
		fac[0] = 1;
		// 메모이제이션
		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;
		// 페르마 소정리
		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}
}
