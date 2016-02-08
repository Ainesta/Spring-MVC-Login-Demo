package th.co.aware.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import th.co.aware.bean.Product;
import th.co.aware.dateutil.DateTimeStamp;

@Component
public class ProductDAO implements IProductDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		int storeId = 13;
		String isActive = "Y";
		int rowcount = jdbcTemplate.update("insert into products ( product_code, pname, price, store_id, isactive, created, updated ) values (?,?,?,?,?,?,?)",
				product.getProductCode(),
				product.getPname(),
				product.getPrice(),
				storeId,
				isActive,
				DateTimeStamp.getTs(),
				DateTimeStamp.getTs());
		if (rowcount == 1) {
			return true;
		}
		return false;
	}


	
	public List<Product> selectProduct() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		String sql = "select * from products";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows){
			Product product = new Product();
			product.setProductCode((String) row.get("product_code"));
			product.setPname((String) row.get("pname"));
			product.setPrice((Float) row.get("price"));
			product.setStoreId((int) row.get("store_id"));
			product.setIsactive((String) row.get("isactive"));

			productList.add(product);
		}
		return productList;
	}


	
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM products WHERE product_code = '" + id+ "'";
		int rowcount = jdbcTemplate.update(sql);
		if (rowcount == 1) {
			return true;
		}
		return false;
	}	
}
