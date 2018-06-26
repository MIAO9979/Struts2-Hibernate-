package com.mdr.show;
import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.mdr.hibernate.HibernateFrame;
import com.mdr.mysql.Mysql;
import com.mdr.mysql.MysqlFrame;
import com.mdr.struts2.Struts2Frame;


public class Show extends JFrame{
	 private JTabbedPane tabbedPane;  
	 private JLabel label_mysql,label_hibernate,label_struts2,label4,label5;  
	 private JPanel panel_mysql,panel_hibernate,panel_struts2,panel4,panel5; 
	public Show() {
		setResizable(false);
		setTitle("A2C2A:十六进制  v2.2");
		/*
		 * 修改日期：2018.03.09 10:39//v1.7
		 * 修改日期：2018.03.24 18:59//v2.0
		 */
		setBounds(600, 300, 450, 450);

		tabbedPane = new JTabbedPane();//
		label_mysql=new JLabel("1",SwingConstants.CENTER);//
		label_hibernate=new JLabel("2",SwingConstants.CENTER);  
		label_struts2=new JLabel("3",SwingConstants.CENTER);
        label4=new JLabel("4",SwingConstants.CENTER);
        //
        panel_mysql=new MysqlFrame().getPanel();
        panel_mysql.setLayout(null);
        panel_hibernate=new HibernateFrame().getPanel();
        panel_hibernate.setLayout(null);
        panel_struts2=new Struts2Frame().getPanel();
        panel_struts2.setLayout(null);
        panel4=new JPanel();
        panel4.setLayout(null);
        
//        panel_hibernate.setBackground(Color.blue);  
        panel4.setBackground(Color.cyan);
         
        
       
        //第一个面板
        tabbedPane.addTab("hibernate",null,panel_hibernate,"hibernate");  
        //第二个面板
        tabbedPane.addTab("Struts2",null,panel_struts2,"Struts2");
        //第三个面板
        tabbedPane.addTab("MySql",null,panel_mysql,"MySql");
        //第四个面板
        tabbedPane.addTab("4444",null,panel4,"44");
        
        getContentPane().add(tabbedPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Show();
	}

}
