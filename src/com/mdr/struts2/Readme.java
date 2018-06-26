package com.mdr.struts2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Readme {
	public Readme(String filePath){
		String str = "";
		
		str += "About Struts2-使用前先阅读"+"\r\n";
		str += ""+"\r\n";
		str += "第一：导入相关的包到WEB-INF下的lib文件中"+"\r\n";
		str += "第二：把文件导入项目的src下"+"\r\n";
		str += "第三：web.xml覆盖WEB-INF下原来的web.xml";
		
		File struts = new File(filePath+"\\使用前先阅读.txt");//
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(struts));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("readme完成");
	}
}
