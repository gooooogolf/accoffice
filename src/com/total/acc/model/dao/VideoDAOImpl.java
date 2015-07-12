/**
 * 
 */
package com.total.acc.model.dao;

import org.springframework.stereotype.Repository;

import com.total.acc.model.domain.Video;

/**
 * @author Sirimongkol
 *
 */
@Repository("videoDAO")
public class VideoDAOImpl extends GenericDAOImpl<Video> implements VideoDAO {
	
}
