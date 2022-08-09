import java.util.Scanner;
// 신기한소수
public class Main_2023_신기한소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		StringBuffer strb = new StringBuffer();
		String str;
		boolean p = false;
		// 2 3 5 7
		for (int s = 0; s < 4; s++) {
			if (s == 0)
				strb.append(2);
			else if (s == 1)
				strb.append(3);
			else if (s == 2)
				strb.append(5);
			else
				strb.append(7);

			for (int i = 1; i < N; i++) {
				int k = 1;
				strb.append(k);
				str = strb.toString();
				if (!isPrime(Integer.parseInt(str))) {
					p = false;
					break;
				} else
					p = true;
			}
			if (p) {
				str = strb.toString();
				if (isPrime(Integer.parseInt(str))) {
					System.out.println(Integer.parseInt(str));
				}
			}
		}

	}

	// 소수인지 판별
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
