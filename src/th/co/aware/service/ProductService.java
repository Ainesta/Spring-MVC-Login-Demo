package th.co.aware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.bean.Product;
import th.co.aware.dao.IProductDAO;

@Component
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		return productDAO.insert(product);
	}

	public IProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> selectProduct() {
		return productDAO.selectProduct();
		// TODO Auto-generated method stub
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return productDAO.delete(id);
	}
	
	
}
