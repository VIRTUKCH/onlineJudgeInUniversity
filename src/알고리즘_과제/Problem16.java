package 알고리즘_과제;

import java.util.Arrays;
import java.util.Scanner;

public class Problem16 {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int sum = 0;
		for (int i = array.length - 1; i >= 0; i -= 2) {
			sum += array[i];
		}
		System.out.print(sum);
		sc.close();
	}
}