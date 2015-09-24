/**
 * 
 */
package com.total.acc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.acc.model.dao.UploadFileDAO;
import com.total.acc.model.domain.UploadFile;

/**
 * @author Sirimongkol
 *
 */
@Service("uploadFileService")
public class UploadFileServiceImpl extends GenericServiceImpl<UploadFile> implements UploadFileService{

	@Autowired
	public UploadFileServiceImpl(UploadFileDAO genericDAO) {
		super(genericDAO);
		// TODO Auto-generated constructor stub
	}

}
