package th.co.aware.service;

import java.util.List;

import th.co.aware.bean.Product;

public interface IProductService {
	
	public abstract boolean insert(Product product);
	public abstract List<Product> selectProduct();
	public abstract boolean delete(String id);
}
