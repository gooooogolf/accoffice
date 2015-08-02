/**
 * 
 */
package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.TechniqueDAO;
import com.total.acc.model.domain.Technique;

/**
 * @author Sirimongkol
 *
 */
@Service("TechniqueService")
public class TechniqueServiceImpl extends GenericServiceImpl<Technique> implements TechniqueService {

	@Autowired
	public TechniqueServiceImpl(TechniqueDAO genericDAO) {
		super(genericDAO);
		// TODO Auto-generated constructor stub
	}
	
}
