package com.total.acc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.config.Configuration;
import com.total.acc.model.domain.Product;
import com.total.acc.model.domain.Quotation;
import com.total.acc.model.service.ProductService;
import com.total.acc.model.service.QuotationService;
import com.total.acc.util.DateTime;
import com.total.acc.util.MailUtil;

@Controller
@RequestMapping("/quotation")
public class QuotationController {
	
	@Autowired
	private QuotationService quotationService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String quotaionPage(Model model) {
		model.addAttribute("products", productService.findAll());
		return "quotaion";
    }
	
	@RequestMapping(value = "/contact/send.do", method = RequestMethod.POST)
	@ResponseBody
    public boolean sendContactMail(@RequestBody JSONObject jsonquotation, HttpServletRequest request, HttpServletResponse response) {		
		try {
			Date effectiveDateTime = DateTime.stringtoDate(DateTime.ddsMMsyyyy() + " " + DateTime.HHcmmcss(), "dd/MM/yyyy HH:mm:ss");
			List<Quotation> quotations = new ArrayList<Quotation>();
			Quotation quotation = null;
			String quotationContactName = jsonquotation.getString("quotationName");
			String quotationContactEmail = jsonquotation.getString("quotationEmail");
			JSONArray jsonArrayProduct = jsonquotation.getJSONArray("products");
			JSONObject jsonProduct = null;
			Product product = null;
			float sumPrice = 0, vat = 0;
			File pdf = null;
			String srcFolder = "D://DATA/";
			if (!jsonArrayProduct.isEmpty()) {
				String quotationId = "QT" + DateTime.yyyy_TH().substring(2, 4) + DateTime.mm() + String.format("%04d", quotationService.getQuotationLastId() + 1);
				for (int i = 0; i < jsonArrayProduct.size(); i++) {
					jsonProduct = JSONObject.fromObject(jsonArrayProduct.get(i));
					product = productService.find(jsonProduct.getInt("id"));
					if (product != null) {
						quotation = new Quotation();
						quotation.setQuotationSeq(String.valueOf(i + 1));
						quotation.setQuotationContactName(quotationContactName);
						quotation.setQuotationContactEmail(quotationContactEmail);						
						quotation.setQuotationId(quotationId);
						quotation.setQuantity(jsonProduct.getInt("quantity"));
						quotation.setQuotationProductId(String.valueOf(product.getId()));
						quotation.setQuotationDesc(product.getProductId() + " " + product.getProductName());
						quotation.setPrice(product.getProductPrice());
						sumPrice = quotation.getQuantity() * product.getProductPrice();
						vat = (float) (sumPrice * 0.07);
						sumPrice = sumPrice + vat;
						quotation.setVat(vat);
						quotation.setSumPrice(sumPrice);
						quotation.setEffectiveDateTime(effectiveDateTime);
						quotations.add(quotation);
//						System.out.println(quotation);
						quotationService.save(quotation);
					}
				}
				
				ServletContext servletContext = request.getSession().getServletContext();
				String report = servletContext.getRealPath("/resources/report"); 
				
				JRBeanCollectionDataSource reportSource = new JRBeanCollectionDataSource(quotations);
				
			    try {
			    	HashMap<String, String> parameters = new HashMap<String, String> ();
			    	parameters.put("quotationId", quotationId);
			    	parameters.put("quotationEmail", quotationContactEmail);
			    	parameters.put("quotationName", quotationContactName);
			    	parameters.put("quotationDate", DateTime.formatDate(effectiveDateTime, "dd/MM/yyyy", new Locale("th","TH")));
			    	JasperPrint print = JasperFillManager.fillReport(report + "/ACC_QUATATION.jasper", parameters, reportSource);
			    	pdf = File.createTempFile(quotationId + "_", ".pdf", new File(srcFolder));
			    	FileOutputStream fout = new FileOutputStream(pdf);
			    	JasperExportManager.exportReportToPdfStream(print, fout);  
			    	fout.close();
			    } catch(JRException e) {
			      e.printStackTrace();
			    }
			    
		        String host = "smtp.gmail.com";
		        String port = "587";
		        String userName = Configuration.MAIL_USER;
		        String password  = Configuration.MAIL_PASSWORD;
		        String toAddress = quotationContactEmail;
		        String subject = "ใบเสนอราคา TOTAL COMMUNICATION INTERNATIONAL CO., LTD";
		        String message = "เรียน คุณ" + quotationContactName + "<br> ใบเสนอราคาเลขที่ " + quotationId;
		        String[] attachFiles = new String[1];
		        attachFiles[0] = srcFolder + pdf.getName();
		        
				MailUtil.sendEmailWithAttachments(host, port, userName, password, toAddress, subject, message, attachFiles);

			}

			return quotations.isEmpty() ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
}
