package com.total.acc.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.total.acc.util.FTPUploader;

public class FTPTest {

	public static void main(String[] args) throws Exception {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("C:\\Users\\Sirimongkol\\Desktop\\acc\\report.jpg");
			FTPUploader ftpUploader = new FTPUploader(
					com.total.acc.config.Configuration.FTP_HOST,
					com.total.acc.config.Configuration.FTP_USERNAME,
					com.total.acc.config.Configuration.FTP_PASSWORD);

			ftpUploader.uploadFileWithStream(in, "httpdocs/temp/report.jpg");
			ftpUploader.disconnect();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
