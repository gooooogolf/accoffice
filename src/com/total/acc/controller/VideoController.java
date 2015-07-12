/**
 * 
 */
package com.total.acc.controller;

import java.util.HashMap;
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
import com.total.acc.model.domain.Video;
import com.total.acc.model.service.ProductService;
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
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String vdoPage(Model model) {
		List<Video> videos = videoService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		for (Video video: videos) {
			if(productMap.get(video.getProductId()) == null) {
				productMap.put(video.getProductId(), productService.find(Integer.parseInt(video.getProductId())));
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("videos", videos);
		return "video";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String vdoListPage(Model model) {
		List<Video> videos = videoService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		for (Video video: videos) {
			if(productMap.get(video.getProductId()) == null) {
				productMap.put(video.getProductId(), productService.find(Integer.parseInt(video.getProductId())));
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
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewVideo(@PathVariable("id") Integer id, Model model) {
		Video video = videoService.find(id);
		model.addAttribute("video", video);
		model.addAttribute("product", productService.find(Integer.parseInt(video.getProductId())));
		return "video-view";
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
}
