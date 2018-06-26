package com.mdr.hibernate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Readme {
	public Readme(String filePath){
		String str = "";
		
		str += "使用前先阅读"+"\r\n";
		str += ""+"\r\n";
		str += "第一：导入相关的包"+"\r\n";
		str += "第二：把文件导入项目的src下"+"\r\n";
		str += "第三：不能以数据库关键字来定义表名，比如table（包括大小写）。";
		File mysql = new File(filePath+"\\使用前先阅读.txt");//
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(mysql));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("readme完成");
	}
}
