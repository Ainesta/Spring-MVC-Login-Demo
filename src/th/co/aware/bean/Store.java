package th.co.aware.bean;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the stores database table.
 * 
 */

public class Store implements Serializable {
	private static final long serialVersionUID = 1L;


	private int storeId;


	private String description;

	private String name;

	private List<Product> products;

	public Store() {
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setStore(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setStore(null);

		return product;
	}

}