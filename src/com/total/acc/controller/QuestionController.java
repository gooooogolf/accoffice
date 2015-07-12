package com.total.acc.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.total.acc.model.domain.Question;
import com.total.acc.model.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questionPage(Model model) {
		model.addAttribute("questions", questionService.findAll());
		return "question";
    }
	
	@RequestMapping(value = "/question/list", method = RequestMethod.GET)
    public String questionListPage(Model model) {
		model.addAttribute("questions", questionService.findAll());
		return "question-list";
    }
	
	@RequestMapping(value = "/question/update/{id}", method = RequestMethod.GET)
    public String updateQuestion(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("question", questionService.find(id));
		return "question-update";
    }
	
	@RequestMapping(value = "/question/update.do", method = RequestMethod.POST)
	@ResponseBody
    public Question doUpdateQuestion(@RequestBody JSONObject formQuestion) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Question question = mapper.readValue(formQuestion.toString(), Question.class);
			questionService.saveOrUpdate(question);
			return question;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
	@RequestMapping(value = "/question/delete.do", method = RequestMethod.DELETE)
	@ResponseBody
    public Question doDeleteQuestion(HttpServletRequest request) {		
		try {
			Question question = questionService.find(Integer.parseInt(request.getParameter("id")));
			questionService.delete(question);
			return question;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
    }
	
}
