/**
 * 
 */
package com.total.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.total.acc.model.service.ProductService;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String homePage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "index";
    }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadPage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "download";
    }
    
	@RequestMapping(value = "/price", method = RequestMethod.GET)
    public String pricePage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "price";
    }
	
	@RequestMapping(value = "/quataion", method = RequestMethod.GET)
    public String quataionPage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "quataion";
    }
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage(Model model) {
		return "contact";
    }
	
}
