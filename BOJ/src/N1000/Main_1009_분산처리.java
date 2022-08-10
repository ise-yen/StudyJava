package N1000;

import java.util.Scanner;

public class Main_1009_분산처리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int data = (int)Math.pow(a, b);
			while(data < 10) {
				data %= 10;
			}
			System.out.println(data);
		}

		sc.close();
	}
	
}
