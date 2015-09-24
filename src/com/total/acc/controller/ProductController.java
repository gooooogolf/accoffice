/**
 * 
 */
package com.total.acc.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.model.domain.Product;
import com.total.acc.model.service.ProductService;
import com.total.acc.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
    public List<Product> getProducts() {
		return productService.findAll();
    }
	
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String products(Model model) {
		model.addAttribute("products", productService.findAll());
		return "product-list";
    }
	
	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String createProduct() {
		return "product-create";
    }
	
	
	@RequestMapping(value = "/product/update", method = RequestMethod.GET)
    public String updateProduct() {
		return "product-update";
    }
	
	@RequestMapping(value = "/product/update/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productService.find(id);
		model.addAttribute("product", product);
		return "product-update";
    }
	
	
	@RequestMapping(value = "/product/download/{id}", method = RequestMethod.GET)
    public String updateDownloadProduct(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("product", productService.find(id));
		return "product-download";
    }
	
	@RequestMapping(value = "/product/price/{id}", method = RequestMethod.GET)
    public String updatePriceProduct(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("product", productService.find(id));
		return "product-price";
    }
	
	@RequestMapping(value = "/product/create.do", method = RequestMethod.POST)
	@ResponseBody
    public Product doCreateProduct(@RequestBody JSONObject formProduct) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
//			System.out.println(formProduct);
			Product product = mapper.readValue(formProduct.toString(), Product.class);
//			System.out.println(product);
			product.setEffectiveDateTime(DateTime.stringtoDate(DateTime.ddsMMsyyyy() + " " +  DateTime.HHcmm(), "dd/MM/yyyy HH:mm"));
			productService.save(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
	@RequestMapping(value = "/product/update.do", method = RequestMethod.POST)
	@ResponseBody
    public Product doUpdateProduct(@RequestBody JSONObject formProduct) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
//			System.out.println(formProduct);
			Product product = mapper.readValue(formProduct.toString(), Product.class);
//			System.out.println(product);
			product.setEffectiveDateTime(DateTime.stringtoDate(DateTime.ddsMMsyyyy() + " " +  DateTime.HHcmm(), "dd/MM/yyyy HH:mm"));
			productService.saveOrUpdate(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
	@RequestMapping(value = "/product/delete.do", method = RequestMethod.DELETE)
	@ResponseBody
    public Product doDeleteProduct(@RequestBody JSONObject formProduct) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Product product = mapper.readValue(formProduct.toString(), Product.class);
			productService.delete(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
}
