package entities;

public class Product {
	
	private int id;
	private String name;
	private String category; // fosse una chiave esterna nel db
	// dovrei non scrivere String, ma creare la classe Category
	// e assumerebbe private Category category
	private double price;
	private int storage;
	
	/**
	 * Construct of the product without arguments
	 * 
	 */
	public Product() {}
	
	/**
	 * Construct of the product
	 * @param name insert the name of the product
	 * @param price insert the price of the product
	 * @param storage insert the storage of the product
	 */
	public Product(String name, double price, int storage) {
		this.name = name;
		this.price = price;
		this.storage = storage;
		this.id = 0;
		this.category = "Various Items";
	}
	

	public Product(int id, String name, String category, double price, int storage) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.storage = storage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", storage=" + storage + "]";
	}
	
	

}
