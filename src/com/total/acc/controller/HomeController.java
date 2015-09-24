/**
 * 
 */
package com.total.acc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.UploadFile;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.UploadFileService;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UploadFileService uploadFileService;
	
	@RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String homePage(Model model, HttpServletRequest request) {
		List<Product> products = productService.findAll(), products__ = new ArrayList<Product>();
		for (Product product: products) {
			try {
				product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
			} catch(Exception e) {
				
			}		
			products__.add(product);
		}
		model.addAttribute("products", products__);
		return "index";
    }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadPage(Model model, HttpServletRequest request) {
		List<Product> products = productService.findAll(), products__ = new ArrayList<Product>();
		for (Product product: products) {
			try {
				product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
			} catch(Exception e) {
				
			}		
			products__.add(product);
		}
		model.addAttribute("products", products__);
		return "download";
    }
    
	@RequestMapping(value = "/price", method = RequestMethod.GET)
    public String pricePage(Model model, HttpServletRequest request) {
		List<Product> products = productService.findAll(), products__ = new ArrayList<Product>();
		for (Product product: products) {
			try {
				product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
			} catch(Exception e) {
				
			}		
			products__.add(product);
		}
		model.addAttribute("products", products__);
		return "price";
    }
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage(Model model) {
		return "contact";
    }
	
    public String getImage(HttpServletRequest request, @RequestParam("id") int id) {
		ServletContext servletContext = request.getSession().getServletContext();
		String basePath = request.getContextPath() + "/resources/temp"; 
		String uploadFolder = servletContext.getRealPath("/resources/temp"); 
		UploadFile uploadFile = uploadFileService.find(id);
		if (uploadFile != null) {	
			  try {
				  File file = new File(uploadFolder + "/" + uploadFile.getName());
				  if (!file.exists()) {
//					  System.out.println("file is not exits!!");
					  file.createNewFile(); 
				  }
				  FileOutputStream fos = new FileOutputStream(file); 
				  fos.write(uploadFile.getImage());
				  fos.close();
				  return basePath + "/" +  uploadFile.getName();
		        }catch(Exception e){
		            e.printStackTrace();
		            return basePath + "/none.jpg";
		        }
		}
		return basePath + "/none.jpg";
    }
	
}
