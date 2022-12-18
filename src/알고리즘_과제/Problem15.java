package 알고리즘_과제;

import java.util.Scanner;

public class Problem15 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int[] arr = new int[num1];
		for (int i = 0; i < num1; i++) {
			arr[i] = scanner.nextInt();
		}
		int b = 0;
		while (num2 != 0) {
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (num2 >= arr[i])
					idx = i;
			}
			b = b + num2 / arr[idx];
			num2 = num2 % arr[idx]; // 500
		}
		System.out.println(b);
	}
}