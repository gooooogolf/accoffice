/**
 * 
 */
package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.QuestionDAO;
import com.total.acc.model.domain.Question;

/**
 * @author Sirimongkol
 *
 */
@Service("questionService")
public class QuestionServiceImpl  extends GenericServiceImpl<Question> implements QuestionService {

	@Autowired
	public QuestionServiceImpl(QuestionDAO genericDAO) {
		super(genericDAO);
	}
	
}
