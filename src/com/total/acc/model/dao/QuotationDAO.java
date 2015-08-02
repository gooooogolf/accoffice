package com.total.acc.model.dao;

import com.total.acc.model.domain.Quotation;

public interface QuotationDAO  extends GenericDAO<Quotation> {
	
	int getQuotationLastId();

}
