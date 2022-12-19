package week1_q10;

import java.util.List;

public class Order {
	  private Invoice invoice;
	    private List<Product> productList;
	    private Customer customer;

	    public Order(Invoice invoice, List<Product> productList) {
	        this.invoice = invoice;
	        this.productList = productList;
	    }

	    public Order() {
	        this.invoice = invoice;
	        this.productList = productList;
	    }

	    public Order(Invoice invoice, List<Product> productList, Customer customer) {
	        this.invoice = invoice;
	        this.productList = productList;
	        this.customer = customer;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public Invoice getInvoice() {
	        return invoice;
	    }

	    public void setInvoice(Invoice invoice) {
	        this.invoice = invoice;
	    }

	    public List<Product> getProductList() {
	        return productList;
	    }

	    public void setProductList(List<Product> productList) {
	        this.productList = productList;
	    }
	}

