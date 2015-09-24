/**
 * 
 */
package com.total.acc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.UploadFile;
import com.total.acc.model.domain.Video;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.UploadFileService;
import com.total.acc.model.service.VideoService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/vdo", "/video"})
public class VideoController {
	
//	private static Logger logger = Logger.getLogger(VideoController.class);
	
	@Autowired
	private VideoService videoService;
	@Autowired
	private UploadFileService uploadFileService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String vdoPage(Model model, HttpServletRequest request) {
		List<Video> videos = videoService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		Product product = null;
		for (Video video: videos) {
			if(productMap.get(video.getProductId()) == null) {
				product = productService.find(Integer.parseInt(video.getProductId()));
				try {
					product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
				} catch(Exception e) {
					
				}	
				productMap.put(video.getProductId(), product);
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("videos", videos);
		return "video";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String vdoListPage(Model model, HttpServletRequest request) {
		List<Video> videos = videoService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		Product product = null;
		for (Video video: videos) {
			if(productMap.get(video.getProductId()) == null) {
				product = productService.find(Integer.parseInt(video.getProductId()));
				try {
					product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
				} catch(Exception e) {
					
				}	
				productMap.put(video.getProductId(), product);
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("videos", videos);
		return "video-list";
    }

	@RequestMapping(value = "/update", method = RequestMethod.GET)
    public String vdoUpdatePage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "video-update";
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateVideo(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("video", videoService.find(id));
		model.addAttribute("products", productService.findAll());
		return "video-update";
    }
	
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
    public Video doUpdateVideo(@RequestBody JSONObject formVideo) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Video vdo = mapper.readValue(formVideo.toString(), Video.class);
			videoService.saveOrUpdate(vdo);
			return vdo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewVideo(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		Video video = videoService.find(id);
		model.addAttribute("video", video);
		Product product = null;
		try {
			product = productService.find(Integer.parseInt(video.getProductId()));
			product.setImgSrc(getImage(request, Integer.parseInt(product.getImgSrc())));
		} catch(Exception e) {
			
		}	

		model.addAttribute("product", product);
		return "video-view";
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
