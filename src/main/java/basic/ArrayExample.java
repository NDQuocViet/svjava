package basic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Chương trình sắp xếp mảng tăng dần
 */

public class ArrayExample {
	public int timPhanTuX(int[] arr) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Nhập x = ");
		int x = sc.nextInt();
		sc.close();
		
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int midd = left + (right - left) / 2;

			if (arr[midd] < x) {
				left = midd + 1;
			} else if (arr[midd] > x) {
				right = midd - 1;
			} else {
				System.out.println(midd);
				return midd;
			}
		}
		System.out.println("Không tìm thấy");
		return -1;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public static ArrayList<Integer> findPrimes(int[] arr) {
		ArrayList<Integer> primes = new ArrayList<>();
		
		for (int num : arr) {
			if (isPrime(num)) {
				primes.add(num);
			}
		}
		return primes;
	}
	//Bài 3 câu e
	public static Scanner scanner = new Scanner(System.in);

	// Hàm Sắp xếp theo thứ tự tăng dần
	/**
	 * Sử dụng thuật toán sắp xếp chọn(Selection Sort)
	 * @param arr
	 */
	public static void sapXep(int [] arr) {
		int temp = arr[0];
		for (int i = 0 ; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	// Hàm in các phần tử của mảng ra màn hình
	public static void show(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	
	public static int[] initArray() {
		Random rd = new Random();
		System.out.println("Nhập số phần tử của mảng: ");
		int n = scanner.nextInt();
		int arr[]  = new int [n];
		System.out.println("Nhập các phần tử của mảng: ");
		for (int i = 0; i < n; i ++) {
//			System.out.printf("a[%d] = ", i);
			arr[i] = rd.nextInt(100);
		}
		return arr;
	}
	
	public static int[] daoMang( int[] arr) {
		int m = arr.length / 2;
		for(int i = 0; i < m; i ++) {
			int a = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = arr[i];
			arr[i] = a;
		}
		return arr;
	}
	
	public void timmax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("phan tu lon nhat trong mang la: " + max);
    }
    public void timmin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("phan tu nho nhat trong mang la: " + min);
    }
    
    

	// Hàm Main
	public static void main(String[] args) {
		int arr[] = initArray();
		show(arr);
		
		System.out.println(">>>>>> Dao Mang:");
		daoMang(arr);
		show(arr);
		
//		sapXep(arr);
//		System.out.println("Dãy số được sắp xếp tăng dần: ");
//		show(arr);
//
//		ArrayList<Integer> primeNumbers = findPrimes(arr);
//        System.out.println("Các số nguyên tố trong mảng là: " + primeNumbers);
	}
}
