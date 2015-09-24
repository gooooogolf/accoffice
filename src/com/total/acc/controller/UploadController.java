package com.total.acc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.total.acc.model.domain.UploadFile;
import com.total.acc.model.service.UploadFileService;
import com.total.acc.util.DateTime;

@Controller
@RequestMapping("/upload")
public class UploadController {

	private static Logger logger = Logger.getLogger(UploadController.class);
	@Autowired
	private UploadFileService uploadFileService;
	
	@RequestMapping(value="/file", method=RequestMethod.POST)
	public @ResponseBody List<UploadFile> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		ServletContext servletContext = request.getSession().getServletContext();
		String uploadFolder = servletContext.getRealPath("/resources/temp"); 
//		String uploadFolder = "D://DATA/UPLOADFILE";
//		System.out.println(uploadFolder);
		String filename = null;
		try {
			if (file.getSize() > 0) { 
				filename = DateTime.yyyyMMdd().replaceAll("-", "")
						+ DateTime.HHcmmcss().replaceAll(":", "")
						+ (FilenameUtils.getExtension(file.getOriginalFilename()) == "" ? "" : ("." + FilenameUtils.getExtension(file.getOriginalFilename())));
//				File upLoadedfile = new File(uploadFolder + "/" + DateTime.yyyy() + "/" + DateTime.mm() + "/" + DateTime.dd());
				File upLoadedfile = new File(uploadFolder);
				if(!upLoadedfile.exists()) {
					upLoadedfile.mkdirs();
				}
				upLoadedfile = new File(upLoadedfile + "/" + filename);
				upLoadedfile.createNewFile(); 
				FileOutputStream fos = new FileOutputStream(upLoadedfile); 
				fos.write(file.getBytes());
				fos.close(); //setting the value of fileUploaded variable
				logger.debug("Writing file to disk...done on " + upLoadedfile);	
				
				List<UploadFile> uploadedFiles = new ArrayList<UploadFile>();
//				UploadFile uploadFile = new UploadFile(0, file.getOriginalFilename(), Long.valueOf(file.getSize()).intValue(), DateTime.yyyy() + "/" + DateTime.mm() + "/" + DateTime.dd() + "/" + filename, file.getBytes());
				UploadFile uploadFile = new UploadFile();
				uploadFile.setName(file.getOriginalFilename());
				uploadFile.setSize(Long.valueOf(file.getSize()).intValue());
//				uploadFile.setUrl(DateTime.yyyy() + "/" + DateTime.mm() + "/" + DateTime.dd() + "/" + filename);
				uploadFile.setUrl(filename);
				uploadFile.setImage(file.getBytes());
//				System.out.println(uploadFile);
				uploadFileService.save(uploadFile);
				uploadedFiles.add(uploadFile);
				return uploadedFiles;
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			throw e;

		}
		return null;

	}
	
	@RequestMapping(value="/getImage", method=RequestMethod.GET)
	@ResponseBody
    public UploadFile getImage(HttpServletRequest request, @RequestParam("id") int id) {
		ServletContext servletContext = request.getSession().getServletContext();
		String uploadFolder = servletContext.getRealPath("/resources/temp"); 
		UploadFile uploadFile = uploadFileService.find(id);
		if (uploadFile != null) {
			  try{
				  File file = new File(uploadFolder + "/" + uploadFile.getName());
				  if (!file.exists()) {
					  file.createNewFile(); 
				  }
				  FileOutputStream fos = new FileOutputStream(file); 
				  fos.write(uploadFile.getImage());
				  fos.close();
				  return uploadFile;
		        }catch(Exception e){
		            e.printStackTrace();
		            return null;
		        }
		}
//		return "none.jpg";
		return null;
    }
}
