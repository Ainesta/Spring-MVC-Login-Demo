package th.co.aware.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import th.co.aware.bean.Invoice;
import th.co.aware.bean.Product;
import th.co.aware.bean.UserBean;
import th.co.aware.service.ICombatService;
import th.co.aware.service.IProductService;
import th.co.aware.service.IInvoiceService;

@Controller
public class CombatController {

	@Autowired
	private ICombatService combatService;

	public ICombatService getCombatService() {
		return combatService;
	}

	public void setCombatService(ICombatService combatService) {
		this.combatService = combatService;
	}

	@Autowired
	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private IInvoiceService invoiceService;

	public IInvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(IInvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		model.addAttribute("userBean", new UserBean());
		return "login";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute @Valid UserBean userBean, BindingResult result) {
		ModelAndView view = new ModelAndView("login");

		if (!result.hasFieldErrors()) {
			if (!combatService.authenticateUser(userBean)) {
				result.addError(new ObjectError("err", "Username or Password is incorrect"));
			} else {
				view.setViewName("welcome");
			}
		}
		return view;
	}

	@RequestMapping("toAddProduct")
	public String toAddProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@RequestMapping(value = "doAddProduct", method = RequestMethod.POST)
	public ModelAndView doAddProduct(@ModelAttribute @Valid Product product, BindingResult result) {
		ModelAndView view = new ModelAndView("addProduct");
		productService.insert(product);
		view.setViewName("welcome");
		return view;
	}

	@RequestMapping("toDeleteProduct")
	public ModelAndView toDeleteProduct(Model model) {
		ModelAndView view = new ModelAndView("delProduct");
		view.addObject("productList", productService.selectProduct());
		return view;
	}

	@RequestMapping(value = "doDeleteProduct/productCode")
	@ResponseBody
	public ModelAndView doDeleteProduct(@RequestParam("productCode") String productCode) {
		ModelAndView view = new ModelAndView("delProduct");
		productService.delete(productCode);
		
		//productService.delete(id);
		view.setViewName("welcome");
		return view;
	}
//	
//	@RequestMapping(value = "doDeleteProduct",method = RequestMethod.GET)
//	public @ResponseBody void doDeleteProduct(@RequestParam("productCode") String id) {
//		productService.delete(id);
//	}

	@RequestMapping("doViewVat")
	public ModelAndView doViewVat(Model model) {
		ModelAndView view = new ModelAndView("callInvoice");

		float calVat = 0;
		String storeName = "";

		List<Invoice> invoices = new ArrayList<Invoice>(invoiceService.viewVat());

		for (Invoice invoice : invoices) {
			storeName = invoice.getProduct().getStore().getName();

			String vat = invoice.getVat();
			if (vat.equals("7")) {
				calVat += invoice.getProduct().getPrice() + (invoice.getProduct().getPrice() * 0.07);
			} else {
				calVat += invoice.getProduct().getPrice();
			}

		}
		view.addObject("storeName", storeName);
		view.addObject("vat", calVat);
		view.addObject("invoiceList", invoiceService.viewVat());
		return view;
	}
}
