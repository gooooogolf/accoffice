/**
 * 
 */
package com.total.acc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.total.acc.config.Configuration;
import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.UploadFile;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.UploadFileService;
import com.total.acc.util.FTPUploader;

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
		String basePath = request.getContextPath() + "/resources/temp"; 
		UploadFile uploadFile = uploadFileService.find(id);
		if (uploadFile != null) {	
			  try {
				    File file = new File(uploadFile.getUrl());
					if (!file.exists()) {
					  file.createNewFile(); 
					  FileOutputStream fos = new FileOutputStream(file); 
					  fos.write(uploadFile.getImage());
					  fos.close();
					}
					
					String filePath = request.getScheme() + "://" + Configuration.FTP_HOST + "/temp/" + uploadFile.getUrl();
					URL url = new URL (filePath);
					URLConnection connection = url.openConnection();
					connection.connect(); 
					HttpURLConnection httpConnection = (HttpURLConnection) connection;
					int code = httpConnection.getResponseCode();
					if (code != 200) {
						FTPUploader ftpUploader = new FTPUploader(Configuration.FTP_HOST, Configuration.FTP_USERNAME, Configuration.FTP_PASSWORD);
					    FileInputStream fileInputStream = new FileInputStream(file);
						ftpUploader.uploadFileWithStream(fileInputStream, "httpdocs/temp/" + uploadFile.getUrl());
						ftpUploader.disconnect();
					}
					httpConnection.disconnect();
					return filePath;
		        }catch(Exception e){
		            e.printStackTrace();
		            return basePath + "/none.jpg";
		        }
		}
		return basePath + "/none.jpg";
    }
    
//    public String getImage(HttpServletRequest request, @RequestParam("id") int id) {
//		ServletContext servletContext = request.getSession().getServletContext();
//		String basePath = request.getContextPath() + "/resources/temp"; 
//		String uploadFolder = servletContext.getRealPath("/resources/temp"); 
//		UploadFile uploadFile = uploadFileService.find(id);
//		if (uploadFile != null) {	
//			  try {
//				  File file = new File(uploadFolder + "/" + uploadFile.getName());
//				  if (!file.exists()) {
//					  file.createNewFile(); 
//				  }
//				  FileOutputStream fos = new FileOutputStream(file); 
//				  fos.write(uploadFile.getImage());
//				  fos.close();
//				  return basePath + "/" +  uploadFile.getName();
//		        }catch(Exception e){
//		            e.printStackTrace();
//		            return basePath + "/none.jpg";
//		        }
//		}
//		return basePath + "/none.jpg";
//    }
	
}
