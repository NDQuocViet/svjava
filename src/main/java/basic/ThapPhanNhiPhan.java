package basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThapPhanNhiPhan {
	public String doisangnhiphan(int n){
		if(n==0){
			return "0";
		}
		if(n==1){
			return "1";
		}
		return doisangnhiphan(n/2) + (n%2);
	}

	public void thapPhanSangNhiPhan(int a) {
		if(a / 2 > 0) thapPhanSangNhiPhan( a/2) ;
		System.out.print(a % 2);
	}

	public static void main(String[] args) {
		ThapPhanNhiPhan tpnp = new ThapPhanNhiPhan();
		
		Scanner sc = null;
		boolean isInputed = false; 
		int n = 0;
		
		while(isInputed == false ) {
			try {
				 sc = new Scanner(System.in);
				System.out.print("So thap phan can chuyen N =");
				n = sc.nextInt();
				isInputed = true;
			} catch (InputMismatchException ex) {
				System.out.println("Ban can nhap vao mot so nguyen");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("----------------------------");
			}
		}
		
		System.out.println(tpnp.doisangnhiphan(n));
		System.out.println("###########");
		tpnp.thapPhanSangNhiPhan(n);
	}
}
