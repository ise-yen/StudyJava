package N3000;

// 페르마의 정리
// nCr = n-1Cr + n-1Cr-1
// a^p ≡ a (mod p)
// ap % p == a% p
// a^(p-1) ≡ 1 (mod p)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_이항계수구하기 {
	static long N, R;
	static int P;
	static long[] nCr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		nCr = new long[P + 1];

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Long.parseLong(st.nextToken().trim());
			R = Long.parseLong(st.nextToken().trim());
			P = Integer.parseInt(st.nextToken().trim());
			System.out.printf("#%d %d\n", t, nCr(N, R, P));
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

	static long modInverse(long n, long p) {
		return power(n, p - 2, p);
	}

	static long nCr(long n, long r, int p) {
		if (r == 0 || r == n)
			return 1L;
		else if (r == 1 || r == n - 1) {
			return n % p;
		}
		long[] fac = new long[p + 1];
		fac[0] = 1;

		// 메모이제이션
		for (int i = 1; i < fac.length; i++) {
			fac[i] = i * fac[i - 1] % p;
		}

		if (n < p) {
			// 페르마 소정리
			return (fac[(int) n] * modInverse(fac[(int) r], p) % p * modInverse(fac[(int) (n - r)], p) % p) % p;
		} else {

			long ret = 1;
			while (n > 0 || r > 0) {
				long a = n % p;
				long b = r % p;
				if (a < b) ret = 0;
				if (ret == 0) break;
				ret *= fac[(int) a];
				ret %= p;
				ret *= modInverse((fac[(int) b] * fac[(int) a - (int) b]) % p, p);
				ret %= p;
				n /= p;
				r /= p;
			}
			return ret;
		}

	}

}
