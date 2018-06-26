package com.mdr.hibernate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Table {
	private String[] strs = null;
	public Table(String filePath,String Biao,String LieMing,String BaoMing) {
		String biao = Biao.toLowerCase();//转换小写
		strs = LieMing.split("\n");//分解列名
		String list = "";
		String getORset = "";
		String toStr = "uid=\" + uid ";;
		for(int i=0;i<strs.length;i++) {
			toStr += "+"+"\", "+strs[i]+"=\""+"+"+strs[i];
			String s = strs[i].substring(0, 1).toUpperCase();//转换成大写U
			String ub = strs[i].substring(1, strs[i].length());//ser
			String sub = s+ub;
			getORset += "	public void set"+sub+"(String "+strs[i]+") {"+"\r\n";
			getORset += "		this."+strs[i]+" = "+strs[i]+";"+"\r\n";
			getORset += "	}"+"\r\n";
			getORset += "	public String get"+sub+"() {"+"\r\n";
			getORset += "		return "+strs[i]+";"+"\r\n";
			getORset += "	}"+"\r\n";
			
			list += "	  private String "+strs[i]+";"+"\r\n";
		}
		getORset += "	public void setUid(int uid) {"+"\r\n";
		getORset += "		this.uid = uid;"+"\r\n";
		getORset += "	}"+"\r\n";
		getORset += "	public int getUid() {"+"\r\n";
		getORset += "		return uid;"+"\r\n";
		getORset += "	}"+"\r\n";
		getORset += "	public String toString(){"+"\r\n";
		getORset += "		return \""+toStr+"+\"\\n\\r\";\r\n";
		getORset += "	}"+"\r\n";
		//strs
		//路径、表、列名
		String str = "";
		str += "package "+BaoMing+";"+"\r\n";
		str += ""+"\r\n";
		str += "public class "+Biao+" {"+"\r\n";
		str += "	private int uid;//默认自动排序"+"\r\n";
		str += list;
		str += getORset;
		str += "}"+"\r\n";
		
		
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
		
		File file = new File(filePath+"\\"+Biao+".java");
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(Biao+".java完成！");
	}
		
}
