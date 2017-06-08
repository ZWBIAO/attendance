package com.student.attendance.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Time {

	public static void main(String[] args) throws ParseException {
		// 一天的毫秒数
		 long daySpan = 24 * 60 * 60 * 1000;
		  
		 // 规定的每天时间15:33:30运行
		 final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd '13:51:10'");

		 
		 // 首次运行时间
		 Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
		  
		 // 如果今天的已经过了 首次运行时间就改为明天
		 if(System.currentTimeMillis() > startTime.getTime())
		  startTime = new Date(startTime.getTime() + daySpan);
		  
		 Timer t = new Timer();
		  
		 TimerTask task = new TimerTask(){
		  @Override
		  public void run() {
		   // 要执行的代码
		   System.err.println("xxxxxxxxx");
		  }
		 };
		 
		 // 以每24小时执行一次
		 t.scheduleAtFixedRate(task, startTime, daySpan);
	}

}
