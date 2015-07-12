/**
 * 
 */
package com.total.acc.model.dao;

import org.springframework.stereotype.Repository;

import com.total.acc.model.domain.Question;

/**
 * @author Sirimongkol
 *
 */
@Repository("questionDAO")
public class QuestionDAOImpl extends GenericDAOImpl<Question> implements QuestionDAO {
	
}
