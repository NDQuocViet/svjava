package basic.collectionExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import basic.dongvat.AnimalInterface;
import basic.dongvat.cat;
import basic.dongvat.dog;
import basic.dongvat.fish;

public class CollectionExample {
	Random rd = new Random();
	private static CompareAnimalByName cabn;
	public List initDogList () {
		List<dog> dogList = new ArrayList<dog>();
		
		dog d = null; 
		int tuoiTrungBinh = 15;
		for(int i = 0; i < 10; i ++) {
			d = new dog("Cun Con " + i, rd.nextInt(15), "nha", tuoiTrungBinh);
			dogList.add(d);
		}
		
		return dogList;
	}
	
	public List initCatList () {
		List<cat> catList = new ArrayList<cat>();
		
		cat c = null; 
		int tuoiTrungBinh = 12;
		for(int i = 0; i < 10; i ++) {
			c = new cat("Meo Con " + i, rd.nextInt(12), "nha", tuoiTrungBinh);
			catList.add(c);
		}
		
		return catList;
	}
	
	public List initFishList () {
		List<fish> fistList = new ArrayList<fish>();
		
		fish f = null; 
		int tuoiTrungBinh = 10;
		for(int i = 0; i < 10; i ++) {
			f = new fish("Ca Vang " + i, rd.nextInt(10), "duoi nuoc", tuoiTrungBinh);
			fistList.add(f);
		}
		
		return fistList;
	}
	
	public void testLinkedList () {
		LinkedList<String> ll = new LinkedList<String>();
		System.out.println("Initial list of elements:  " + ll);
		ll.add("hha");
		ll.add("hehe");
		ll.add("huhu");
		
		System.out.println("After invoking add(e) method:  " + ll);
		
		ll.add(1, "ios");
		System.out.println("After invoking add(1,e) method:  " + ll);
		
		LinkedList<String> ll2 = new LinkedList<String>();
		ll2.add("hha");
		ll2.add("hehe");
		ll.addAll(ll2);
		
		System.out.println("After invoking addAll(e) method:  " + ll);
		ll.addFirst("ngu");
		System.out.println("After invoking addFirst(e) method:  " + ll);
		ll.addLast("hehehehe");
		System.out.println("After invoking addLast(e) method:  " + ll);
		ll.removeFirst();
		System.out.println("After invoking removeFirst(e) method:  " + ll);
		ll.removeLast();
		System.out.println("After invoking removeLast(e) method:  " + ll);
	}
	
	public void testSet() {
		HashSet<String> strSet = new HashSet<String>();
		strSet.add("One");
		strSet.add("Two");
		strSet.add("Three");
		strSet.add("Four");
		strSet.add("Five");
		
		Iterator<String> strIte = strSet.iterator();
		while(strIte.hasNext()) {
//			String str = strIte.next();
			System.out.println(strIte.next());
		}
	}
	
	
	public static void main(String[] args) {
		CollectionExample ce = new CollectionExample();
		List<AnimalInterface> animalList = new ArrayList<AnimalInterface>();
		
		System.out.println(">>>>> Danh sach Meo:");
		for(Object obj : ce.initCatList()) {
			((AnimalInterface)obj).inthongtin();
			animalList.add((AnimalInterface)obj);
		}
		
		System.out.println("\n\n>>>>> Danh sach Cho:");
		for(Object obj : ce.initDogList()) {
			((AnimalInterface)obj).inthongtin();
			animalList.add((AnimalInterface)obj);
		}
		
		System.out.println("\n\n>>>>> Danh sach Ca:");
		for(Object obj : ce.initFishList()) {
			((AnimalInterface)obj).inthongtin();
			animalList.add((AnimalInterface)obj);
		}
		
		System.out.println("\n\n >>>>>> size of animal list: " + animalList.size());
		
		int dogSize = ce.initDogList().size();
		System.out.println(">>>>>> dogSize: " + dogSize);
		
		System.out.println();
		for (int i = 0; i < dogSize; i++) {
			((dog) ce.initDogList().get(i)).inthongtin();
		}
		List objList = ce.initDogList();
		System.out.println(">>>>>> objList's size: " + objList.size());
		objList.remove(3);
		System.out.println(">>>>>> objList's size: " + objList.size());
		
		System.out.println(">>>>>> dogSize: " + dogSize);
//		for (int i = 0; i < dogSize; i++) {
//			((dog) ce.initDogList().get(i)).inthongtin();
//		}
		
		ce.testLinkedList();
		
//		Iterator<AnimalInterface> aniIte = animalList.iterator();
		
		ce.testSet();
		
		Map<Integer, List<AnimalInterface>> aniMap = ce.mapTest(animalList);
		
		CompareAnimalByName cabn = new CompareAnimalByName();
		CompareAnimalByAge caba = new CompareAnimalByAge();
		List<AnimalInterface> aniList = null;
		
		for(Integer phanLoai : aniMap.keySet()) {
			System.out.println("-------------------------------------");
			
			System.out.println("Phan loa " + phanLoai);
			aniList = aniMap.get(phanLoai);
			for(AnimalInterface ani : aniList) {
				ani.inthongtin();
			}
			
			System.out.println("\n\t>>>>>> ket qua sau sap xep:\n");
			Collections.sort(aniList);
			for(AnimalInterface ani : aniList) {
				ani.inthongtin();
			}
			
			System.out.println("\n\t>>>>>> ket qua sau sap xep theo ten:\n");
			aniList.sort(cabn);
			for(AnimalInterface ani : aniList) {
				ani.inthongtin();
			}
			
			System.out.println("\n\t>>>>>> ket qua sau sap xep theo tuoi:\n");
			aniList.sort(caba);
			for(AnimalInterface ani : aniList) {
				ani.inthongtin();
			}
			
			System.out.println("-------------------------------------");
		}
		
	}
	
	static class CompareAnimalByName implements Comparator<AnimalInterface> {

		@Override
		public int compare(AnimalInterface o1, AnimalInterface o2) {
			return o1.getTen().compareTo(o2.getTen());
		}
		
	}
	
	static class CompareAnimalByAge implements Comparator<AnimalInterface> {

		@Override
		public int compare(AnimalInterface o1, AnimalInterface o2) {
			return o1.getTuoiht() - o2.getTuoiht();
		}
		
	}
	
	public Map<Integer, List<AnimalInterface>> mapTest(List<AnimalInterface> animalList) {
		Map<Integer, List<AnimalInterface>> animalMap = new HashMap<Integer, List<AnimalInterface>>();
		List<AnimalInterface> firtList = new ArrayList<AnimalInterface>();
		List<AnimalInterface> secondList = new ArrayList<AnimalInterface>();
		List<AnimalInterface> thirdList = new ArrayList<AnimalInterface>();
		for(AnimalInterface obj : animalList) {
			int phanLoai = obj.hashCode();
			if( phanLoai == 1) {
				firtList.add(obj);
			} else if (phanLoai == 2) {
				secondList.add(obj);
			} else {
				thirdList.add(obj);
			}
		}
		
		animalMap.put(1, firtList);
		animalMap.put(2, secondList);
		animalMap.put(3, thirdList);
		
		return animalMap;
		
	}
}
