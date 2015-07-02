/**
 * 
 */
package com.total.acc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value={"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String home() {
		return "index";
    }
    

}
