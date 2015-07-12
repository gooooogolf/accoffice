/**
 * 
 */
package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.VideoDAO;
import com.total.acc.model.domain.Video;

/**
 * @author Sirimongkol
 *
 */
@Service("videoService")
public class VideoServiceImpl extends GenericServiceImpl<Video> implements VideoService {

	@Autowired
	public VideoServiceImpl(VideoDAO genericDAO) {
		super(genericDAO);
		// TODO Auto-generated constructor stub
	}
	
}
