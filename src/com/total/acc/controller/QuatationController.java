package com.total.acc.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.config.Configuration;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.QuatationService;
import com.total.acc.util.MailUtil;

@Controller
@RequestMapping("/quatation")
public class QuatationController {
	
	@Autowired
	private QuatationService quatationService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String quataionPage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "quataion";
    }
	
	@RequestMapping(value = "/contact/send.do", method = RequestMethod.POST)
	@ResponseBody
    public boolean sendContactMail(@RequestBody JSONObject formContact) {		
		try {
//			System.out.println(formContact);
			String body =  formContact.getString("contactMessage");
			body += "\n\n" + formContact.getString("contactEmail");
			String[] to = {Configuration.MAIL};
			return MailUtil.sendFromGMail(Configuration.MAIL_USER, Configuration.MAIL_PASSWORD, to , "คุณ" + formContact.getString("contactName") + " ทำการติดต่อเรา", body);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
    }
	
}
