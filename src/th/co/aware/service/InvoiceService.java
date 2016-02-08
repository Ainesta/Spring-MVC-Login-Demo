package th.co.aware.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.bean.Invoice;
import th.co.aware.dao.IInvoiceDAO;

@Component
public class InvoiceService implements IInvoiceService {
	
	
	@Autowired
	private IInvoiceDAO invoiceDAO;


	public List<Invoice> viewVat() {
		return invoiceDAO.viewVat();
	}

	public IInvoiceDAO getInvoiceDAO() {
		return invoiceDAO;
	}

	public void setInvoiceDAO(IInvoiceDAO invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}

}
