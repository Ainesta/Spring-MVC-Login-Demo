package th.co.aware.dao;

import java.util.List;

import javax.sql.DataSource;

import th.co.aware.bean.Product;

public interface IProductDAO {
	
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean insert(Product product);
	public abstract List<Product> selectProduct();
	public abstract boolean delete(String id);
}