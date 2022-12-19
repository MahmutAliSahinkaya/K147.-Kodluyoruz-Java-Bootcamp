package week1_q9;

import java.util.Arrays;

public class MyList<T> {
	Object[] data;
	int size;

	public MyList() {
		size = 0;
		data = new Object[5];
	}

	public int getSize() {
		return data.length;
	}

	public T get(int index) {
		return (T) data[index];
	}

	public void add(String element) {
		if (element.substring(0, 1).equalsIgnoreCase("C")) {
			ensureCapacity(size + 1);
			data[size++] = element;
		} else {
			System.out.println("Yalnızca C harfiyle başlayan isimleri listeye ekleyebilirsiniz.");
		}
	}

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = getSize();
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity + 7;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	public void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}