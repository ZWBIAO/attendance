package com.student.attendance.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.student.attendance.dao.AttendanceDao;
import com.student.attendance.model.Attendance;
import com.student.attendance.model.User;
import com.student.attendance.utils.PhotosExtract;
import com.student.attendance.valid.AttendanceForm;

@Controller
public class StudentController {
	@Autowired
	private AttendanceDao attendanceDao;
	@Autowired
	private PhotosExtract photosExtract;

	@GetMapping("/attendance")
	public String student(Model model,HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("loginuser");
		model.addAttribute("loginuserhtml", user);
		return "Attendance";
	}

	@PostMapping("/attendance")
	public String attendances(AttendanceForm attendanceForm, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		Date date = new Date();// 获取当前系统日期
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");// 将日期格式化，要求自己定义各式输出
		// String sDateSuffix = dateformat.format(date);//各式化出来，日期
		Attendance attendance = new Attendance();
		attendance.setId(UUID.randomUUID().toString());

		try {
			photosExtract.handleFileUpload(attendanceForm, file, request);
			attendance.setStart_photo(attendanceForm.getStart_photo());
		} catch (Exception e) {
			e.printStackTrace();
		}

		attendance.setStart_time(dateformat.format(date));
		attendance.setLeave_data(attendanceForm.getLeave_data());

		attendanceDao.save(attendance);

		return "Attendance";

	}

}
