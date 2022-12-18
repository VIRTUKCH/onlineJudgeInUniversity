package 알고리즘_과제;

import java.util.Scanner;

public class Problem12 {
	public static void main(String[] asdf1) {
		Scanner sc = new Scanner(System.in);

		int totalCity = sc.nextInt();
		int totalBus = sc.nextInt();
		int[][] arr = new int[totalCity][totalCity];
		int a, b, c;

		for (int i = 0; i < totalCity; i++) {
			for (int j = 0; j < totalCity; j++) {
				if (i == j) {
					arr[i][i] = 0;
				} else {
					arr[i][j] = 999999999;
				}
			}
		}

		for (int i = 0; i < totalBus; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if (arr[a - 1][b - 1] > c)
				arr[a - 1][b - 1] = c;
		}

		int arr2[][] = new int[totalCity][totalCity];
		arr2 = arr;
		int[][] temp;
		int min = 999999999;

		for (int i = 0; i < totalCity - 1; i++) {
			temp = arr2;
			arr2 = arr;
			arr = temp;
			for (int j = 0; j < totalCity; j++) {
				for (int k = 0; k < totalCity; k++) {
					if (j == k) {
						continue;
					} else {
						min = 999999999;
						for (int z = 0; z < totalCity; z++) {
							if (min > arr[j][z] + arr[z][k]) {
								min = arr[j][z] + arr[z][k];
							}
						}
						arr2[j][k] = min;
					}
				}
			}
		}

		for (int i = 0; i < totalCity; i++) {
			for (int j = 0; j < totalCity; j++) {
				if (arr2[i][j] == 999999999) {
					arr2[i][j] = 0;
				}
			}
		}

		for (int h = 0; h < totalCity; h++) {
			for (int x = 0; x < totalCity; x++) {
				System.out.print(arr2[h][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}