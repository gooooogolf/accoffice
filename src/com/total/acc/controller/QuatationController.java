package com.total.acc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.Quatation;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.QuatationService;
import com.total.acc.util.DateTime;

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
    public boolean sendContactMail(@RequestBody JSONObject jsonQuatation) {		
		try {
			Date effectiveDateTime = DateTime.stringtoDate(DateTime.ddsMMsyyyy() + " " + DateTime.HHcmmcss(), "dd/MM/yyyy HH:mm:ss");
			List<Quatation> quatations = new ArrayList<Quatation>();
			Quatation quatation = null;
			String quatationContactName = jsonQuatation.getString("quatationName");
			String quatationContactEmail = jsonQuatation.getString("quatationEmail");
			JSONArray jsonArrayProduct = jsonQuatation.getJSONArray("products");
			JSONObject jsonProduct = null;
			Product product = null;
			float sumPrice = 0;
			if (!jsonArrayProduct.isEmpty()) {
				String quatationId = "QT" + DateTime.yyyy_TH().substring(2, 4) + DateTime.mm() + String.format("%04d", quatationService.countAll() + 1);
				for (int i = 0; i < jsonArrayProduct.size(); i++) {
					jsonProduct = JSONObject.fromObject(jsonArrayProduct.get(i));
					product = productService.find(jsonProduct.getInt("id"));
					if (product != null) {
						quatation = new Quatation();
						quatation.setQuatationContactName(quatationContactName);
						quatation.setQuatationContactEmail(quatationContactEmail);						
						quatation.setQuatationId(quatationId);
						quatation.setQuantity(jsonProduct.getInt("quantity"));
						quatation.setQuatationProductId(String.valueOf(product.getId()));
						quatation.setQuatationDesc(product.getProductId() + " " + product.getProductName());
						sumPrice = quatation.getQuantity() * product.getProductPrice();
						quatation.setSumPrice(sumPrice);
						quatation.setEffectiveDateTime(effectiveDateTime);
						quatations.add(quatation);
					}
				}
			}
			return quatations.isEmpty() ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
}
