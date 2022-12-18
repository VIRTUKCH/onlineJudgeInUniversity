package 알고리즘_과제;

import java.util.Scanner;

public class Problem17 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] start = new int[num];
		int[] end = new int[num];
		for (int i = 0; i < num; i++) {
			start[i] = scanner.nextInt();
			end[i] = scanner.nextInt();
			end[i] += start[i];
		}
		int[] index = new int[num];

		for (int i = 0; i < num; i++) {
			index[i] = i;
		}
		int temp;
		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				if (end[index[i]] > end[index[j]]) {
					temp = index[i];
					index[i] = index[j];
					index[j] = temp;
				}
			}
		}
		temp = 0;
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			if (temp <= start[index[i]]) {
				temp = end[index[i]];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}