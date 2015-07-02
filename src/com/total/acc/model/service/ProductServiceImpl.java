/**
 * 
 */
package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.ProductDAO;
import com.total.acc.model.domain.Product;

/**
 * @author Sirimongkol
 *
 */
@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

	@Autowired
	public ProductServiceImpl(ProductDAO genericDAO) {
		super(genericDAO);
	}
}
