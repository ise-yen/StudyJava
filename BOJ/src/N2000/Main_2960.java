package N2000;
// 에라토스테네스의 체
import java.util.Scanner;

public class Main_2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;

		int nums[] = new int[N + 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}

		nums[0] = nums[1] = 0;
		for (int i = 2; i <= N; i++) {
			// 지워진 수라면
			if (nums[i] == 0) {
				continue;
			}
			for (int j = i; j <= N; j += i) {
				if(nums[j] !=0) {
					nums[j] = 0;
					cnt++;
					if (cnt == K) {
						System.out.println(j);
						break;
					}
				}
			}
		}
	}
}
