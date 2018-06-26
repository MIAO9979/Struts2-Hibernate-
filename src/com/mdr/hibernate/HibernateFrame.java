package com.mdr.hibernate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class HibernateFrame extends JFrame{
	private static JPanel panel_hibernate = new JPanel();//panel_hibernate
	private static JLabel label,label_1,label_2,label_3,label_4;
	private static JTextField text_SQLName,text_Biao,text_LieMing,text_Username,text_Password;
	private JTextArea textArea_LieMing;
	private JScrollPane scrollPane;
	private String filePath;
	private JTextField text_BaoMing;
	public HibernateFrame(){
		
		setBounds(600, 300, 450, 450);
		panel_hibernate.setLayout(null);
		/*---------------------------------*/
		
		/*---------------------------------*/
		
		/*---------------------------------*/
		show_label();//显示label集成方法
		show_test();//继承输入框方法；
		
		textArea_LieMing = new JTextArea();//作用：存储添加列显示
		textArea_LieMing.setBounds(134, 187, 243, 81);
		panel_hibernate.add(textArea_LieMing);
		
		
	/*	JButton btn_addLie = new JButton("+");
		btn_addLie.setBounds(310, 125, 67, 27);
		btn_addLie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//鼠标点击
				String str = text_LieMing.getText().trim();//获取value并清楚前后空格
				textArea_LieMing.append(str+"\n");
				text_LieMing.setText("");
			}
		});
		panel_hibernate.add(btn_addLie);
	*/
		
		
		JButton btn_ShengCheng = new JButton("生 成");
		btn_ShengCheng.setBounds(264, 331, 113, 42);
		
		btn_ShengCheng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//鼠标点击
				JFileChooser fileChooser = new JFileChooser("C:\\");//初始位置
    			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    			int returnVal = fileChooser.showOpenDialog(fileChooser);
    			if(returnVal == JFileChooser.APPROVE_OPTION){
    				filePath = fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
    			}
//				String value = textArea_LieMing.getText();
//				System.out.println(value);
				String SQLName = text_SQLName.getText().trim();//获取数据库名
				String Biao = text_Biao.getText().trim();//获取表明
				String LieMing = textArea_LieMing.getText();//获取整段列名
				String Username = text_Username.getText().trim();//获取数据库用户名
				String Password = text_Password.getText().trim();//获取登陆密码
				String BaoMing = text_BaoMing.getText().trim();//获取包名
				textArea_LieMing.setText("");
				//路径、账号、密码、数据库名、表名
				new Hibernate_cfg(filePath,Username,Password,SQLName,Biao,BaoMing);
				//表、列、路劲、包名
				new Table_hbm(Biao,LieMing,filePath,BaoMing);
				new HibernateDAO(filePath,Biao,LieMing,BaoMing);
				new Readme(filePath);
				//路径、表、列名、包名
				new Table(filePath,Biao,LieMing,BaoMing);
				
				text_SQLName.setText("");
				text_Biao.setText("");
				text_Username.setText("");
				text_Username.setText("");
				text_Username.setText("使用前先阅读手册");
				text_Password.setText("");
				text_Password.setText("|*文件生成完毕！*|");
			}
		});
		panel_hibernate.add(btn_ShengCheng);
		
		text_BaoMing = new JTextField();
		text_BaoMing.setBounds(134, 87, 243, 24);
		panel_hibernate.add(text_BaoMing);
		text_BaoMing.setColumns(10);
		
		JLabel lblbaming = new JLabel("*包名：");
		lblbaming.setBounds(63, 90, 53, 18);
		panel_hibernate.add(lblbaming);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 133, 243, 81);
		scrollPane.setViewportView(textArea_LieMing); 
		panel_hibernate.add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//会让整个程序都退出
		add(panel_hibernate);
	}
	static void show_test() {
		text_SQLName = new JTextField();
		text_SQLName.setBounds(134, 13, 243, 24);
		panel_hibernate.add(text_SQLName);
		text_SQLName.setColumns(10);
		
		text_Biao = new JTextField();
		text_Biao.setBounds(134, 50, 243, 24);
		panel_hibernate.add(text_Biao);
		text_Biao.setColumns(10);
		
		/*
		text_LieMing = new JTextField();
		text_LieMing.setBounds(134, 126, 162, 24);
		panel_hibernate.add(text_LieMing);
		text_LieMing.setColumns(10);
		*/
		
		text_Username = new JTextField();
		text_Username.setBounds(134, 257, 243, 24);
		panel_hibernate.add(text_Username);
		text_Username.setColumns(10);
		
		text_Password = new JTextField();
		text_Password.setBounds(134, 294, 243, 24);
		panel_hibernate.add(text_Password);
		text_Password.setColumns(10);
		
		
		
	}
	static void show_label() {
		label = new JLabel("*数据库用户名：");
		label.setBounds(14, 260, 116, 18);
		panel_hibernate.add(label);
		
		label_1 = new JLabel("*数据库密码：");
		label_1.setBounds(26, 297, 101, 18);
		panel_hibernate.add(label_1);
		
		label_2 = new JLabel("*数据库名：");
		label_2.setBounds(46, 16, 84, 18);
		panel_hibernate.add(label_2);
		
		label_3 = new JLabel("*表名：");
		label_3.setBounds(74, 53, 53, 18);
		panel_hibernate.add(label_3);
		
		label_4 = new JLabel("列名：");
		label_4.setBounds(74, 129, 45, 18);
		panel_hibernate.add(label_4);
	}
	public JPanel getPanel() {
		return panel_hibernate;
	}
}
