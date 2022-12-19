package week1_q10;

import java.util.List;

public class Invoice {
	 private int id;
	    private int totalPrice;
	    private Customer customer;
	    private Product product;
	    private List<Order> orderList;

	    public Invoice() {
	        super();
	    }

	    public Invoice(int totalPrice) {
	        super();

	        this.totalPrice = totalPrice;
	    }

	    public Invoice(double totalPrice, Customer customer) {
	        this.totalPrice = 0;
	        this.customer = customer;
	    }

	    public Invoice(Product product, List<Order> orderList) {
	        this.product = product;
	        this.orderList = orderList;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public double getTotalPrice() {

	        return product.getPrice();
	    }

	    public void setTotalPrice(int totalPrice) {

	        this.totalPrice = totalPrice;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public List<Order> getOrderList() {
	        return orderList;
	    }

	    public void setOrderList(List<Order> orderList) {
	        this.orderList = orderList;
	    }

	    @Override
	    public String toString() {
	        return "totalPrice=" + totalPrice ;
	    }
	}
