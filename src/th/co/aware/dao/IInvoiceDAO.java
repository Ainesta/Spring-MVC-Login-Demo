package th.co.aware.dao;


import java.util.List;

import javax.sql.DataSource;

import th.co.aware.bean.Invoice;



//import th.co.aware.bean.Product;

public interface IInvoiceDAO {
	
	public abstract void setDataSource(DataSource dataSource);
	
	public abstract List<Invoice> viewVat();

}
