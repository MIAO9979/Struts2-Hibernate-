package com.mdr.hibernate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hibernate_cfg {
	Hibernate_cfg(String filePath,String Username,String Password,String SQLName,String Biao,String BaoMing){
		//路径、账号、密码、数据库名、表名
		String bao = BaoMing.replaceAll("\\.", "/");
		String str = "";
		str += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n";
		str += "<!DOCTYPE hibernate-configuration PUBLIC"+"\r\n";
		str += "	\"-//Hibernate/Hibernate Configuration DTD 3.0//EN\""+"\r\n";
		str += "	\"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd\">"+"\r\n";
		str +="<hibernate-configuration>"+"\r\n";
		str +="<session-factory>"+"\r\n";
		str +="	<property name=\"hibernate.connection.driver_class\">com.mysql.jdbc.Driver</property>"+"\r\n";
		str +="	<property name=\"hibernate.connection.url\">jdbc:mysql:///"+SQLName+"</property>"+"\r\n";
		str +="	<property name=\"hibernate.connection.username\">"+Username+"</property>"+"\r\n";
		str +="	<property name=\"hibernate.connection.password\">"+Password+"</property>"+"\r\n";
		str +=""+"\r\n";
		str +="	<property name=\"hibernate.show_sql\">true</property>"+"\r\n";
		str +="	<property name=\"hibernate.format_sql\">true</property>"+"\r\n";
		str +="	<property name=\"hibernate.hbm2ddl.auto\">update</property>"+"\r\n";
		str +="	<property name=\"hibernate.dialect\">org.hibernate.dialect.MySQLDialect</property>"+"\r\n";
		str +="	<property name=\"hibernate.current_session_context_class\">thread</property>"+"\r\n";
		str +="	<mapping resource=\""+bao+"/"+Biao+".hbm.xml\"/>"+"\r\n";
		str +="</session-factory>"+"\r\n";
		str +="</hibernate-configuration>"+"\r\n";
		File file = new File(filePath+"\\hibernate.cfg.xml");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("hibernate.cfg.xml完成！");
	}
}
