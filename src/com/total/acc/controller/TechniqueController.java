/**
 * 
 */
package com.total.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
