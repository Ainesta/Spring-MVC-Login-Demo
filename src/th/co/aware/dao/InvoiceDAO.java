package th.co.aware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import th.co.aware.bean.Invoice;
import th.co.aware.bean.Product;
import th.co.aware.bean.Store;



@Component
public class InvoiceDAO implements IInvoiceDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.setJdbcTemplate(new JdbcTemplate(dataSource));
	}


	public List<Invoice> viewVat() {
		// TODO Auto-generated method stub
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		String sql = "select * from invoices i join products p on i.product_code = p.product_code join stores s on s.store_id = p.store_id where s.store_id = '14'";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows){
			Invoice invoice = new Invoice();
			invoice.setProductCode((String) row.get("product_code"));
			invoice.setVat((String) row.get("vat"));
			
			Store store = new Store();
			store.setName((String) row.get("name"));
			
			Product product = new Product();
			product.setPrice((Float) row.get("price"));
			product.setPname((String) row.get("pname"));
			
			product.setStore(store);
			
			invoice.setProduct(product);
			invoiceList.add(invoice);
		}
		
		return invoiceList;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	

}
