package com.mdr.struts2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Struts2 {
	public String Struts(String filepath,String BaoMing,String LeiMing) {
		//路径、包名、类名
		String str = "";
		str += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n";
		str += "<!DOCTYPE struts PUBLIC"+"\r\n";
		str += "	\"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN\""+"\r\n";
		str += "	\"http://struts.apache.org/dtds/struts-2.3.dtd\">"+"\r\n";
		str += "	"+"\r\n";
		str += "<struts>"+"\r\n";
		str += "    <constant name=\"struts.i18n.encoding\" value=\"utf-8\"></constant>"+"\r\n";
		str += "    <package name=\"index\" extends=\"struts-default\" namespace=\"/\">"+"\r\n";
		str += ""+"\r\n";     
		str += "        <action name=\"*\" class=\""+BaoMing+"."+LeiMing+"\" method=\"{1}\">"+"\r\n";
		str += "           <result name=\"errer\">/errer.jsp</result>"+"\r\n";
		str += "           <result name=\"OK\">/index.jsp</result>"+"\r\n";
		str += "       </action>"+"\r\n";
		str += "   </package>"+"\r\n";
		str += "   <!-- <include file=\"other.xml\"></include> -->"+"\r\n";
		str += "</struts>"+"\r\n";
		
		File struts2 = new File(filepath+"\\struts.xml");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(struts2));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("struts.xml完成");
		Lei(filepath, BaoMing, LeiMing);
		
		return "struts.xml完成";
	}
	public String Lei(String filepath,String BaoMing,String LeiMing) {
		String str = "";
		str += "package "+BaoMing+";"+"\r\n";

		str += "import com.opensymphony.xwork2.ActionSupport;"+"\r\n";
		str += "import javax.servlet.http.HttpServletRequest;"+"\r\n";

		str += "import org.apache.struts2.ServletActionContext;"+"\r\n";
		str += "public class "+LeiMing+" extends ActionSupport{"+"\r\n";
		str += "	HttpServletRequest request =  ServletActionContext.getRequest();"+"\r\n";
		str += "	public String ZhuCe() {"+"\r\n";
		str += "	String username = request.getParameter(\"\");"+"\r\n";
		str += "		return \"OK\";"+"\r\n";
		str += "	}"+"\r\n";
		str += "	public String errer() {"+"\r\n";
		str += "		System.out.println(\"errer into ...\");"+"\r\n";
		str += "		return \"errer\";"+"\r\n";
		str += "	}"+"\r\n";
			
		str += "}"+"\r\n";

		
		
		String name[] = BaoMing.split("\\.");
		for(int i = 0;i<name.length;i++) {
			filepath += "\\"+name[i];
			File file = new File(filepath);//创建目录
			if(file.exists()) {
				if(file.isDirectory()) {//判断是否是目录
					continue;
				}
			}else {
				//file.mkdirs();
				file.mkdir();
			}
		}
		File LeiLuJin = new File(filepath+"\\"+LeiMing+".java");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(LeiLuJin));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(LeiMing+".java完成");
		return LeiMing+".java完成";
	}
	
	public String web(String filepath,String XiangMu) {
		String str = "";
		str += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n";
		str += "<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://java.sun.com/xml/ns/javaee\" xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\" id=\"WebApp_ID\" version=\"3.0\">"+"\r\n";
		str += "  <display-name>"+XiangMu+"</display-name>"+"\r\n";
		str += ""+"\r\n";
		str += "  <filter>"+"\r\n";
		str += "        <filter-name>struts2</filter-name>"+"\r\n";
		str += "        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>"+"\r\n";
		str += "   </filter>"+"\r\n";
		str += ""+"\r\n";
		str += "    <filter-mapping>"+"\r\n";
		str += "        <filter-name>struts2</filter-name>"+"\r\n";
		str += "       <url-pattern>/*</url-pattern>"+"\r\n";
		str += "    </filter-mapping>"+"\r\n";
		str += ""+"\r\n"; 
		str += "  <welcome-file-list>"+"\r\n";
		str += "    <welcome-file>index.html</welcome-file>"+"\r\n";
		str += "    <welcome-file>index.htm</welcome-file>"+"\r\n";
		str += "   <welcome-file>index.jsp</welcome-file>"+"\r\n";
		str += "    <welcome-file>default.html</welcome-file>"+"\r\n";
		str += "    <welcome-file>default.htm</welcome-file>"+"\r\n";
		str += "   <welcome-file>default.jsp</welcome-file>"+"\r\n";
		str += "  </welcome-file-list>"+"\r\n";
		str += "</web-app>"+"\r\n";
		File file = new File(filepath+"\\web.xml");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return "web.xml完成";
	}
}
