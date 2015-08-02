/**
 * 
 */
package com.total.acc.model.dao;

import org.springframework.stereotype.Repository;

import com.total.acc.model.domain.Quotation;

/**
 * @author Sirimongkol
 *
 */
@Repository("quotationDAO")
public class QuoationDAOImpl extends GenericDAOImpl<Quotation> implements QuotationDAO {

	@Override
	public int getQuotationLastId() {
		String SQL_QUERY = "SELECT quotationId FROM Quotation q GROUP BY q.quotationId"; 
//		String hql = "from Quotation";
		return sessionFactory.getCurrentSession().createQuery(SQL_QUERY).list().size();
	}
	
}
