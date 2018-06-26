package com.mdr.hibernate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Table_hbm {
	
	private String[] strs = null;
	public Table_hbm(String Biao,String LieMing,String filePath,String BaoMing) {
		//表、列、路劲
		strs = LieMing.split("\n");//分解列名
		String list = "";
		for(int i=0;i<strs.length;i++) {
			list += "	  <property name=\""+strs[i]+"\" column=\""+strs[i]+"\"></property>"+"\r\n";
		}
		String str = "";
		str += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n";
		str += "<!DOCTYPE hibernate-mapping PUBLIC "+"\r\n";
		str += "	\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\""+"\r\n";
		str += "	\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">"+"\r\n";
		str += "<hibernate-mapping>"+"\r\n";
		str += "<class name=\""+BaoMing+"."+Biao+"\" table=\""+Biao+"\">"+"\r\n";
		str += "	  <id name=\"uid\" column=\"uid\">"+"\r\n";
		str += "	  		<generator class=\"native\"></generator>"+"\r\n";
		str += "	  </id>"+"\r\n";
		str += list;
		str += "</class>"+"\r\n";
		str += "</hibernate-mapping>"+"\r\n";
		
		
		String name[] = BaoMing.split("\\.");
		for(int i = 0;i<name.length;i++) {
			filePath += "\\"+name[i];
			File file = new File(filePath);//创建目录
			if(file.exists()) {
				if(file.isDirectory()) {//判断是否是目录
					continue;
				}
			}else {
				//file.mkdirs();
				file.mkdir();
			}
		}
		
		File file = new File(filePath+"\\"+Biao+".hbm.xml");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(Biao+".hbm.xml完成！");
	}
}
