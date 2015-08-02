/**
 * 
 */
package com.total.acc.model.dao;

import org.springframework.stereotype.Repository;

import com.total.acc.model.domain.Technique;

/**
 * @author Sirimongkol
 *
 */
@Repository("techniqueDAO")
public class TechniqueDAOImpl extends GenericDAOImpl<Technique> implements TechniqueDAO {
	
}
