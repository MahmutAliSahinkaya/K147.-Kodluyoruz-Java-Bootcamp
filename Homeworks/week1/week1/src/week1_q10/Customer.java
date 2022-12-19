package week1_q10;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
    private int age;

    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.orderList = new ArrayList<>();
    }

    public Customer(String name, int age, List<Order> orderList) {
        this.name = name;
        this.age = age;
        this.orderList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderList=" + orderList +
                '}';
    }
}