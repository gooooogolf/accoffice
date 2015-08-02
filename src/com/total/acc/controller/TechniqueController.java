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
import com.total.acc.model.domain.Technique;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.TechniqueService;

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
	
	@RequestMapping(method = RequestMethod.GET)
    public String techniquePage(Model model) {
		List<Technique> techniques = techniqueService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		for (Technique technique: techniques) {
			if(productMap.get(technique.getProductId()) == null) {
				productMap.put(technique.getProductId(), productService.find(Integer.parseInt(technique.getProductId())));
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("techniques", techniques);
		return "technique";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String techniqueListPage(Model model) {
		List<Technique> techniques = techniqueService.findAll();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		for (Technique technique: techniques) {
			if(productMap.get(technique.getProductId()) == null) {
				productMap.put(technique.getProductId(), productService.find(Integer.parseInt(technique.getProductId())));
			}
		}
		model.addAttribute("productMaps", productMap);
		model.addAttribute("techniques", techniques);
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
    public String viewTechnique(@PathVariable("id") Integer id, Model model) {
		Technique technique  = techniqueService.find(id);
		model.addAttribute("tech", technique);
		model.addAttribute("product", productService.find(Integer.parseInt(technique.getProductId())));
		return "technique-view";
    }
}
