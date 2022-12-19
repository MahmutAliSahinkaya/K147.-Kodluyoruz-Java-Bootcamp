package week1_q10;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Product> customersProductList = new ArrayList<>();

        Customer customer1 = new Customer("Cem", 28);
        Customer customer2 = new Customer("Mahmut", 34);
        Customer customer3 = new Customer("Ali", 26);
        Customer customer4 = new Customer("Ahmet", 23);

        List<Customer> customerList = new ArrayList<>();

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);

        Product product1 = new Product("Laptop", "Asus", 1700, 5);
        Product product2 = new Product("Laptop", "Dell", 1200, 3);
        Product product3 = new Product("Laptop", "Hp", 1500, 6);
        Product product4 = new Product("Laptop", "Lenovo", 1200, 7);
        Product product5 = new Product("Laptop", "MSI", 1300, 2);

        customersProductList.add(product1);
        customersProductList.add(product2);
        customersProductList.add(product3);
        customersProductList.add(product4);
        customersProductList.add(product5);


        Invoice invoice1 = new Invoice();
        invoice1.setCustomer(customer1);
        invoice1.setTotalPrice(product1.getPrice());
        invoice1.setProduct(product1);

        Invoice invoice2 = new Invoice();
        invoice2.setCustomer(customer2);
        invoice2.setTotalPrice(product2.getPrice());
        invoice2.setProduct(product2);

        Invoice invoice3 = new Invoice();
        invoice3.setCustomer(customer3);
        invoice3.setTotalPrice(product3.getPrice());
        invoice3.setProduct(product3);

        Invoice invoice4 = new Invoice();
        invoice4.setCustomer(customer4);
        invoice4.setTotalPrice(product4.getPrice());
        invoice4.setProduct(product4);

        Invoice invoice5 = new Invoice();
        invoice5.setCustomer(customer4);
        invoice5.setTotalPrice(product5.getPrice());
        invoice5.setProduct(product5);
        List<Invoice> invoiceList = new ArrayList<>();
invoiceList.add(invoice1);

        Order order1 = new Order();
        order1.setCustomer(customer1);
        order1.setInvoice(invoice1);
        order1.setProductList(customersProductList);

        Order order2 = new Order(invoice2, customersProductList, customer2);
        Order order3 = new Order(invoice3, customersProductList, customer3);
        Order order4 = new Order(invoice4, customersProductList, customer4);

        List<Order> orderProductList = new ArrayList<>();
        orderProductList.add(order1);
        customer1.setOrderList(orderProductList);


        long totalProduct = customerList.stream().count();
        System.out.println("Toplam müşteri sayısı: " + totalProduct);
        System.out.println("*******************************");
        int counter = 0;
        int totalShopping = 0;

        for (Customer customer : customerList) {
            if (customer.getName().equals("Cem")) {
                for (Order order : customer.getOrderList()) {
                    counter += order.getCustomer().getOrderList().size();
                }
            }
        }
        System.out.println("İsmi Cem olan müşterilerin aldıkları ürün sayısı : " + counter);
        System.out.println("*******************************");
        for (Customer customer : customerList) {
            if (customer.getName().equals("Cem") && (30>customer.getAge() && customer.getAge() > 25)) {
                for (Order order : customer.getOrderList()) {
                    totalShopping += order.getInvoice().getTotalPrice();
                }
            }
        }
        System.out.println("İsmi Cem olan ve \nyaşı 30'dan küçük \n25'den büyük müşterilerin toplam alışveriş tutarı : " + totalShopping);
        System.out.println("*******************************");
        for (Customer customer : customerList) {
            for (Order order : customer.getOrderList()) {
                if (order.getInvoice().getTotalPrice() > 1500) {
                    System.out.println("Sistemdeki 1500 TL üzerindeki faturalar : " + order.getInvoice());
                }
            }
        }
    }
}