package basic.dongvat;

import basic.customException.AnimalCustomException;

public class MainAppOOPExample {
	
    public static void main(String[] args) {
        AnimalInterface d1 = new dog("cho becgie", 3, "nha", 13);
        AnimalInterface c1 = new cat(" meo ngu", 2, "nha", 0);
        AnimalInterface meo = new cat("meo mun", 2, "nha", 15);
        
        System.out.println("So sanh tuoi d1 va c1");
        try {
			d1.sosanh((dongvat) c1);
		} catch (AnimalCustomException e) {
			e.printStackTrace();
		}

        meo.inthongtin();

        dog cho = new dog("cho becgie", 3, "nha", 13);
        cho.inthongtin();

        fish ca = new fish("ca vang", 1, "ho", 5);
        ca.inthongtin();
    }
}
