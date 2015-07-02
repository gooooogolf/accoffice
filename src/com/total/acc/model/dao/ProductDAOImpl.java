/**
 * 
 */
package com.total.acc.model.dao;

import org.springframework.stereotype.Repository;

import com.total.acc.model.domain.Product;

/**
 * @author Sirimongkol
 *
 */
@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO {

}
