package com.student.attendance.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.student.attendance.valid.AttendanceForm;
@Service
public class PhotosExtract {
	public void handleFileUpload(AttendanceForm attendanceForm,MultipartFile file, HttpServletRequest request) throws Exception {
		try {//HttpServletRequest对象代表客户端的请求，当客户端通过HTTP协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中，开发人员通过这个对象的方法，可以获得客户这些信息。
			if (file.isEmpty()) {
				System.out.println("Fiile_is_null");
			} else {
				String path = "I:/upload";// 获取物理路径
				File f = new File(path);
				if (!f.exists()) {
					f.mkdirs();
				}
				File uploadfile = new File(path + "/" + file.getOriginalFilename());// 得到上传时的文件名
				FileCopyUtils.copy(file.getBytes(), uploadfile);// 用于文件和流复制的简单实用方法uploadfile文件名
				attendanceForm.setStart_photo(uploadfile.toString());

				 }

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
