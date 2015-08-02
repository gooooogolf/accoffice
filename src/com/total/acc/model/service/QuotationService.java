package com.total.acc.model.service;

import com.total.acc.model.domain.Quotation;

public interface QuotationService extends GenericService<Quotation> {
	int getQuotationLastId();
}
