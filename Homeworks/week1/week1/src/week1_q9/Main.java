package week1_q9;

public class Main {

	public static void main(String[] args) {
		MyList<String> names = new MyList<>();
		System.out.println("size : " + names.getSize());
		names.add("Mahmut");
		System.out.println("size : " + names.getSize());
		names.add("Ali");
		System.out.println("size : " + names.getSize());
		names.add("Şahin");
		System.out.println("size : " + names.getSize());
		names.add("Kaya");
		System.out.println("size : " + names.getSize());
		names.add("Can1");
		System.out.println("size : " + names.getSize());
		names.add("Can2");
		System.out.println("size : " + names.getSize());
		names.add("Can3");
		System.out.println("size : " + names.getSize());
		names.add("Can4");
		System.out.println("size : " + names.getSize());
		names.add("Can5");
		System.out.println("size : " + names.getSize());
		names.add("Can6");
		System.out.println("size : " + names.getSize());
		names.print();
	}
}