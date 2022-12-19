package week1_q10;

public class Product {
	  private String category;
	    private String name;
	    private int price;
	    private int stockAmount;

	    public Product(String category, String name, int price, int stockAmount) {
	        this.category = category;
	        this.name = name;
	        this.price = price;
	        this.stockAmount = stockAmount;
	    }

	    public Product() {

	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getStockAmount() {
	        return stockAmount;
	    }

	    public void setStockAmount(int stockAmount) {
	        this.stockAmount = stockAmount;
	    }

	    @Override
	    public String toString() {
	        return "Product{" +
	                "category='" + category + '\'' +
	                ", name='" + name + '\'' +
	                ", price=" + price +
	                ", stockAmount=" + stockAmount +
	                '}';
	    }
	}