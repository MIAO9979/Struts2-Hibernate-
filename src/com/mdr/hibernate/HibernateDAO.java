package com.mdr.hibernate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class HibernateDAO {
	private String[] strs = null;
	public HibernateDAO(String filePath,String Biao,String LieMing,String BaoMing) {
		String biao = Biao.toLowerCase();//转换小写
		strs = LieMing.split("\n");//分解列名
		String list = "";
		String canshu = "";
		for(int i=0;i<strs.length;i++) {
			String s = strs[i].substring(0, 1).toUpperCase();//转换成大写
			String ub = strs[i].substring(1, strs[i].length());
			String sub = biao+".set"+s+ub+"("+strs[i]+");";
			list += "			"+sub+"\r\n";//user.setName();
			
			if(i>=strs.length-1) {
				canshu += "String "+strs[i];
			}else {
				canshu += "String "+strs[i]+",";
			}
			
		}
		
		String str = "";
		str +="package "+BaoMing+";"+"\r\n";
		str +="import org.hibernate.Query;"+"\r\n";
		str +="import org.hibernate.Session;"+"\r\n";
		str +="import org.hibernate.SessionFactory;"+"\r\n";
		str +="import org.hibernate.Transaction;"+"\r\n";
		str +="import org.hibernate.cfg.Configuration;"+"\r\n";
		str +="import org.hibernate.SQLQuery;"+"\r\n";
		str +="import java.util.Arrays;"+"\r\n";
		str +="import java.util.List;"+"\r\n";
		str +="import "+BaoMing+"."+Biao+";"+"\r\n";

		str +="		public class HibernateDAO {"+"\r\n";
		str +="			static Configuration cfg = null;"+"\r\n";
		str +="			static SessionFactory sessionFactory = null;"+"\r\n";
		str +="			static Session session = null;"+"\r\n";
		str +="			static Transaction tx = null;"+"\r\n";
		str +=""+"\r\n";			
		str +="			/**"+"\r\n";
		str +="		     * @author 功能：添加"+"\r\n";
		str +="		     * @return 返回：false 添加失败 / true 添加成功"+"\r\n";
		str +="		     */"+"\r\n";
		str +="			public boolean mdrAdd("+canshu+"){//添加"+"\r\n";
		str +="		    	boolean F = false;"+"\r\n";
		str +="					try{"+"\r\n";
		str +="						session = getSessionObject();"+"\r\n";
		str +="						tx = session.beginTransaction();"+"\r\n";
		str +="						"+Biao+" "+biao+" = new "+Biao+"();"+"\r\n";
		str +=list;
		str +="						session.saveOrUpdate("+biao+");"+"\r\n";
		str +="						tx.commit();"+"\r\n";
		str +="						F = true;"+"\r\n";
		str +="					}catch(Exception e){"+"\r\n";
		str +="						//回滚事务"+"\r\n";
		str +="						tx.rollback();"+"\r\n";
		str +="						F = false;"+"\r\n";
		str +="					}"+"\r\n";
		str +="				return F;"+"\r\n";
		str +="			}"+"\r\n";
	str +="		    /**"+"\r\n";
	str +="		     * @author 功能：修改"+"\r\n";
	str +="		     * @return boolean true成功 / false失败"+"\r\n";
	str +="		     */"+"\r\n";
	str +="		    public boolean mdrUpdate(int id,"+canshu+"){"+"\r\n";
	str +="		    	try{"+"\r\n";
	str +="					session = getSessionObject();"+"\r\n";
	str +="					tx = session.beginTransaction();"+"\r\n";
	str +="					"+Biao+" "+biao+" = ("+Biao+")session.get("+Biao+".class, id);  "+"\r\n";
	str +=list;
	str +="					session.saveOrUpdate("+biao+");"+"\r\n";
	str +="					tx.commit();"+"\r\n";
	str +="					return true;"+"\r\n";
	str +="				}catch(Exception e){"+"\r\n";
	str +="					//回滚事务"+"\r\n";
	str +="					tx.rollback();"+"\r\n";
	str +="					return false;"+"\r\n";
	str +="				}"+"\r\n";
	str +="		    }"+"\r\n";
	str +="		    public static Session getSessionObject(){"+"\r\n";
	str +="				cfg = new Configuration();"+"\r\n";
	str +="				cfg.configure();"+"\r\n";
	str +="				sessionFactory = cfg.buildSessionFactory();"+"\r\n";
	str +="				return sessionFactory.openSession();"+"\r\n";
	str +="		    }"+"\r\n";
	str +=""+"\r\n";		    
	str +="		    /**"+"\r\n";
	str +="		     * @author 功能：查询"+"\r\n";
	str +="		     * @return 返回：List "+Biao+"[]"+"\r\n";
	str +="		     */"+"\r\n";
	str +="			public List mdrQueryAll(){//查询"+"\r\n";
	str +="					List<"+Biao+"> list = null;"+"\r\n";
	str +="			    	try{"+"\r\n";
	str +="						session = getSessionObject();"+"\r\n";
	str +="						tx = session.beginTransaction();"+"\r\n";
	
	str +="						Query query = session.createQuery(\"from "+Biao+"\");"+"\r\n";
	str +="						"+"\r\n";
	str +="						list = query.list();"+"\r\n";
	
	str +="						tx.commit();"+"\r\n";
	str +="				}catch(Exception e){"+"\r\n";
	str +="						//回滚事务"+"\r\n";
	str +="						tx.rollback();"+"\r\n";
	str +="					}"+"\r\n";
	str +="			    	return list;"+"\r\n";
	str +="			 }"+"\r\n";
	str +=""+"\r\n";		    
	str +="		    /**"+"\r\n";
	str +="		     * @author 功能：查询单个体"+"\r\n";
	str +="		     * @author 参数：要查询的id"+"\r\n";
	str +="		     * @return 返回：String"+"\r\n";
	str +="		     */"+"\r\n";
	str +="		    public String mdrQuery(int id){"+"\r\n";
	str +="		    	String value = null;"+"\r\n";
	str +="		    	try{"+"\r\n";
	str +="					session = getSessionObject();"+"\r\n";
	str +="					tx = session.beginTransaction();"+"\r\n";
	str +=""+"\r\n";					
	str +="					String str_sql = \"select * from  "+Biao+" where uid=\"+id;"+"\r\n";
	str +="					SQLQuery sql = session.createSQLQuery(str_sql);"+"\r\n";
	str +="					List<Object[]> list = sql.list();"+"\r\n";
	str +="					if(list.size()>0){//表示存在数据"+"\r\n";

	str +="							value = Arrays.toString(list.get(0));"+"\r\n";

	str +="						tx.commit();"+"\r\n";
	str +="						return value;"+"\r\n";
	str +="					}"+"\r\n";
	str +="				}catch(Exception e){"+"\r\n";
	str +="					//回滚事务"+"\r\n";
	str +="					tx.rollback();"+"\r\n";
	str +="				}"+"\r\n";
	str +="		    	 return \"null\";"+"\r\n";
	str +="		    }"+"\r\n";
	str +="		   /**"+"\r\n";
	str +="		    * @author 功能：删除"+"\r\n";
	str +="		    * @author 参数：要删除的id"+"\r\n";
	str +="		    * @return 返回：true 成功 / false 失败"+"\r\n";
	str +="		    */"+"\r\n";
	str +="		    public boolean mdrDelete(int id){"+"\r\n";
	str +="		    	try{"+"\r\n";
	str +="					session = getSessionObject();"+"\r\n";
	str +="					tx = session.beginTransaction();"+"\r\n";
	str +=""+"\r\n";				
	str +="					 String hql = \"Delete FROM "+Biao+" Where id=?\" ;    "+"\r\n"; 
	str +="				     Query q = this.session.createQuery(hql) ;    "+"\r\n"; 
	str +="				     q.setInteger(0, id) ;     "+"\r\n";
	str +="				     q.executeUpdate() ;     "+"\r\n";
	str +=""+"\r\n";					
	str +="					tx.commit();"+"\r\n";
	str +="				return true;"+"\r\n";
	str +="				}catch(Exception e){"+"\r\n";
	str +="					//回滚事务"+"\r\n";
	str +="					tx.rollback();"+"\r\n";
	str +="					"+"\r\n";
	str +="				}"+"\r\n";
	str +="		    	return false;"+"\r\n";
	str +="		    }"+"\r\n";
	str +="		}"+"\r\n";

		
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
		File mysql = new File(filePath+"\\HibernateDAO.java");//固定xml
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(mysql));
			bos.write(str.getBytes());
			bos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("HibernateDemo.java完成");
	}
}
