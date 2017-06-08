package com.student.attendance.utils;

import java.io.File;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;


public class ExifPhoto {
	public void Exif() throws Exception{
		File img = new File("C:\\Users\\ZWBIAO\\Desktop\\1.jpg");  //路径
        Metadata metadata = ImageMetadataReader.readMetadata(img);  //格式	        
        for (Directory directory : metadata.getDirectories()) {  
  
            if("ExifSubIFDDirectory".equalsIgnoreCase( directory.getClass().getSimpleName() )){  
                //光圈F值=镜头的焦距/镜头光圈的直径  
                System.out.println("光圈值: f/" + directory.getString(ExifSubIFDDirectory.TAG_FNUMBER) );  	  
                System.out.println("曝光时间: " + directory.getString(ExifSubIFDDirectory.TAG_EXPOSURE_TIME)+ "秒" );  
                System.out.println("ISO速度: " + directory.getString(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT) );  
                System.out.println("焦距: " + directory.getString(ExifSubIFDDirectory.TAG_FOCAL_LENGTH) + "毫米" );  	  
                System.out.println("拍照时间: " + directory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL) );  
                System.out.println("宽: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH) );  
                System.out.println("高: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT) );  
  
            }  
  
            if("ExifIFD0Directory".equalsIgnoreCase( directory.getClass().getSimpleName() )){  
                System.out.println("照相机制造商: " + directory.getString(ExifIFD0Directory.TAG_MAKE) );  
                System.out.println("照相机型号: " + directory.getString(ExifIFD0Directory.TAG_MODEL) );  
                System.out.println("水平分辨率: " + directory.getString(ExifIFD0Directory.TAG_X_RESOLUTION) );  
                System.out.println("垂直分辨率: " + directory.getString(ExifIFD0Directory.TAG_Y_RESOLUTION) );  
            }  
        }  
    }  
}
