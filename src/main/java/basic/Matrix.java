package basic;

public class Matrix {



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
		System.out.println("dong co tong lon nhat la: " + sumMax + "; tai dong thu: " + (indexmax + 1));

	}

}
