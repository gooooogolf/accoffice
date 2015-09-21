/**
 * 
 */
package com.total.acc.controller;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.config.Configuration;
import com.total.acc.util.MailUtil;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/mail")
public class EmailController {
	
	@RequestMapping(value = "/contact/send.do", method = RequestMethod.POST)
	@ResponseBody
    public boolean sendContactMail(@RequestBody JSONObject formContact) {		
		try {
//			System.out.println(formContact);
			String body =  formContact.getString("contactMessage");
			body += "\n\n" + formContact.getString("contactEmail");
			String[] to = {formContact.getString("contactEmail"), Configuration.MAIL_RETURN};
			return MailUtil.sendFromHostMail(Configuration.MAIL_HOST, Configuration.MAIL_PORT, Configuration.MAIL_USER, Configuration.MAIL_PASSWORD,  to , "คุณ" + formContact.getString("contactName") + " ทำการติดต่อเรา", body);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
    }

}
