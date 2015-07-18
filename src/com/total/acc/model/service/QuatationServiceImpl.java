package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.QuatationDAO;
import com.total.acc.model.domain.Quatation;

@Service("quatationService")
public class QuatationServiceImpl extends GenericServiceImpl<Quatation> implements QuatationService {
	
	@Autowired
	public QuatationServiceImpl(QuatationDAO genericDAO) {
		super(genericDAO);
	}
	
}
