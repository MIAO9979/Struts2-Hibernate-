package com.mdr.mysql;

public class Mysql{
	public String getShuJuKu(String name,String path) {
		String str = "";
		str += "CREATE DATABASE "+name+"\r\n";
		str += "ON PRIMARY"+"\r\n";
				str += "("+"\r\n";
				str += "NAME = '"+name+"_data',"+"\r\n";
				str += "FILENAME = '"+path+"\\"+name+".mdf',"+"\r\n";
				str += "SIZE = 10MB,"+"\r\n";
				str += "FILEGROWTH = 1MB"+"\r\n";
				str += ")"+"\r\n";
				str += "LOG ON"+"\r\n";
				str += "("+"\r\n";
				str += "NAME = '"+name+"_log',"+"\r\n";
				str += "FILENAME = '"+path+"\\"+name+"_log.ldf',"+"\r\n";
				str += "SIZE = 5MB,"+"\r\n";
				str += "FILEGROWTH = 10%"+"\r\n";
				str += ")"+"\r\n";
				str += "GO"+"\r\n";
				return str;
	}
	public String getBiao(String biao,String path) {
		String str = "";
		str += "CREATE TABLE `Êý¾Ý¿âÃû`.`"+biao+"` ("+"\r\n";
		str +=  "`id` INT NOT NULL,"+"\r\n";
		str += "`name` VARCHAR(45) NOT NULL,"+"\r\n";
		str += "`sex` VARCHAR(2) NOT NULL,"+"\r\n";
		str += "`age` INT NOT NULL,"+"\r\n";
		str += "`email` VARCHAR(45) NOT NULL,"+"\r\n";
		str += "PRIMARY KEY (`id`));"+"\r\n";
		return str;
	}

}
