package basic;

import java.util.Random;
import java.util.Scanner;

public class mang2chieu {
	public int[][] nhapmang(int n, int m) {
		int[][] arr = new int[n][m];
		Scanner scanner = new java.util.Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("nhap phan tu thu [" + i + "][" + j + "]: ");
				arr[i][j] = scanner.nextInt();
			}
		}
		return arr;
	}

	public int[][] randommang(int n, int m) {
		int[][] arr = new int[n][m];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = random.nextInt(100);
				;
			}
		}
		return arr;
	}

	public void inmang(int[][] arr) {
		System.out.println("cac phan tu trong mang la: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void lenhonhat(int[][] arr) {
		int min = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 != 0) {
					if (arr[i][j] < min) {
						min = arr[i][j];
					}
				}

			}
		}
		System.out.println("phan tu nho nhat trong mang la: " + min);
	}

	public void dongcotonglonnhat(int[][] arr) {
		int max = Integer.MIN_VALUE;
		Integer index = null;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			System.out.println(sum);
			if (sum >= max) {
				max = sum;
				index = i;
			}
		}
		System.out.println("dong co tong lon nhat la dong thu: " + (index + 1));
	}

	public void dongcotonglonnhat1(int[][] arr) {
		int sumMax = 0;
		int indexmax = 0;
		for (int i = 0; i < arr.length; i++) {
			int sumRow = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sumRow += arr[i][j];
			}
			if (i == 0 || sumRow > sumMax) {
				indexmax = i;
				sumMax = sumRow;
			}
		}
		System.out.println("dong co tong lon nhat la " + sumMax +";  dong thu: " + (indexmax + 1));

	}

	public static void main(String[] args) {
		Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("nhap cot: ");
		int cot = scanner.nextInt();
		System.out.print("nhap hang: ");
		int hang = scanner.nextInt();
		mang2chieu mang2chieu = new mang2chieu();
		int[][] mang = mang2chieu.randommang(hang, cot);
		System.out.println("mang vua nhap la: ");
		mang2chieu.inmang(mang);
		mang2chieu.lenhonhat(mang);
		mang2chieu.dongcotonglonnhat1(mang);
	}
}
