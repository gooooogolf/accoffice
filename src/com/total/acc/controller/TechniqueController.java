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
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.config.Configuration;
import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.Technique;
import com.total.acc.model.domain.UploadFile;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.TechniqueService;
import com.total.acc.model.service.UploadFileService;
import com.total.acc.util.FTPUploader;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/tech", "/technic", "/technique"})
public class TechniqueController {

	@Autowired
	private TechniqueService techniqueService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String techniquePage(Model model, HttpServletRequest request) {
		List<Technique> techniques = techniqueService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		Product product = null;
		for (Technique technique: techniques) {
			if(productMap.get(technique.getProductId()) == null) {
				product = productService.find(Integer.parseInt(technique.getProductId()));
				try {
					product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
				} catch(Exception e) {
					
				}	
				productMap.put(technique.getProductId(), product);
			}
		}
//		System.out.println(productMap);
//		System.out.println(techniques);
		model.addAttribute("productMaps", productMap);
		model.addAttribute("techniques", techniques);
		return "technique";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String techniqueListPage(Model model, HttpServletRequest request) {
		List<Technique> techniques = techniqueService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		Product product = null;
		for (Technique technique: techniques) {
			if(productMap.get(technique.getProductId()) == null) {
				product = productService.find(Integer.parseInt(technique.getProductId()));
				try {
					product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
				} catch(Exception e) {
					
				}	
				productMap.put(technique.getProductId(), product);
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("techniques", techniques);
//		System.out.println(productMap);
//		System.out.println(techniques);
		return "technique-list";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
    public String techniqueUpdatePage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "technique-update";
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTechnique(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("tech", techniqueService.find(id));
		model.addAttribute("products", productService.findAll());
		return "technique-update";
    }
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
    public Technique doUpdateTechnique(@RequestBody JSONObject formTechnique) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Technique technique = mapper.readValue(formTechnique.toString(), Technique.class);
			techniqueService.saveOrUpdate(technique);
			return technique;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewTechnique(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		Technique technique  = techniqueService.find(id);
		model.addAttribute("tech", technique);
		Product product = null;
		product = productService.find(Integer.parseInt(technique.getProductId()));
		try {
			product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
		} catch(Exception e) {
			
		}	
		model.addAttribute("product", product);
		return "technique-view";
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
////					  System.out.println("file is not exits!!");
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
