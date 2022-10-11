package N10000;
import java.util.Scanner;

// 별찍기
public class Main_10994_별찍기 {
//	위쪽
	static void stars(int n) {
		for (int i = 0; i < (n - 1) * 4; i++)
			System.out.print("*");
		System.out.println("*");
	}

	static void starsLeft() {
		System.out.print("*");
		for(int i =0; i< )
	}
	static void blank() {
		System.out.print(" ");
	}
	static void starsRightJump() {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		stars(n);
		
		sc.close();
	}

}
//*********
//*       *
//* ***** *
//* *   * *
//* * * * *
//* *   * *1 3 1
//* ***** * 1 1
//*       *  7
//*********