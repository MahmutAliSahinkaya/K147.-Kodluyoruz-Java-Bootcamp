package week1_q1;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

	static long reverse(long total) {
		long reverse = 0;
		long remainder;
		while (total > 0) {
			remainder = total % 10;
			reverse = (reverse * 10) + remainder;
			total = total / 10;
		}
		return reverse;
	}

	static boolean isPalindrom(long number) {
		long temp = number, reverseNumber = 0, lastNumber;
		while (temp != 0) {
			lastNumber = temp % 10;
			reverseNumber = (reverseNumber * 10) + lastNumber;
			temp /= 10;
		}
		return number == reverseNumber;
	}

	public static void main(String[] args) {
		long total;
		int number;
		List<Integer> numbers = new ArrayList<>();
		for (int i = 10; i <= 100; i++) {
			number = i;
			total = i;
			total += reverse(i);
			if (total != reverse(i)) {
				while (!isPalindrom(total)) {
					System.out.println(
							" " + number + " sayısı için " + total + " " + total + " = " + (total + reverse(total)));
					total += reverse(total);
					numbers.add(number);
				}
			}
		}
		int popular = numbers.get(0);
		int count = 1;
		int tempcount = 0;
		int temp = 0;
		for (int i = 0; i < numbers.size(); i++) {
			temp = numbers.get(i);
			tempcount = 0;
			for (int j = 1; j < numbers.size(); j++) {
				if (temp == numbers.get(j))
					tempcount++;
			}
			if (tempcount > count) {
				popular = temp;
				count = tempcount;
			}
		}
		System.out.println("En uzun zinciri oluşturan rakamlar:  " + popular + " ve tersi olan " + reverse(popular));
	}
}