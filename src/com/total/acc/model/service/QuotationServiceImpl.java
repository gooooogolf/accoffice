package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.QuotationDAO;
import com.total.acc.model.domain.Quotation;

@Service("quotationService")
public class QuotationServiceImpl extends GenericServiceImpl<Quotation> implements QuotationService {
	
	@Autowired
	public QuotationServiceImpl(QuotationDAO genericDAO) {
		super(genericDAO);
	}

	@Autowired
	QuotationDAO genericDAO;
	
	@Override
	public int getQuotationLastId() {
		return genericDAO.getQuotationLastId();
	}
	
}
