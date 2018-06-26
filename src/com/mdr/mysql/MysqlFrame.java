package com.mdr.mysql;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.MouseAdapter;

public class MysqlFrame extends JFrame{
	private static JPanel panel_mysql = new JPanel();
	private JButton btn_mysql_ShengCheng,btn_mysqlLuJing;
	 private JLabel label_mysql_radio_name,label_mysqlLuJing;
	 private JTextField text_mysqlname,text_mysqlLuJing;
	 private JFileChooser mysql_Chooser;
	 private String mysqlfilePath;
	 private JRadioButton radio_mysql_shujuku,radio_mysql_biao;
	 private ButtonGroup mysqlbg;
	 private JLabel label;
	public MysqlFrame() {
		setBounds(600, 300, 450, 450);
		panel_mysql.setLayout(null);
		getContentPane().add(panel_mysql);
		
		btn_mysql_ShengCheng = new JButton("一键生成");
		btn_mysql_ShengCheng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radio_mysql_shujuku.isSelected()) {
					String mysqlname = text_mysqlname.getText().trim();
					String mysql_test = new Mysql().getShuJuKu(mysqlname, mysqlfilePath);
					File mysql = new File(mysqlfilePath+"\\"+mysqlname+".txt");
					try {
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(mysql));
						bos.write(mysql_test.getBytes());
						bos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println(mysql_test);
				}
				if(radio_mysql_biao.isSelected()) {
					String mysqlbiao = text_mysqlname.getText().trim();
					String mysql_test = new Mysql().getBiao(mysqlbiao, mysqlfilePath);
					File mysql = new File(mysqlfilePath+"\\"+mysqlbiao+".txt");
					try {
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(mysql));
						bos.write(mysql_test.getBytes());
						bos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println(mysqlbiao);
				}
			}
		});
        btn_mysql_ShengCheng.setBounds(144, 263, 120, 46);
        
        panel_mysql.add(btn_mysql_ShengCheng);
        
        label_mysql_radio_name = new JLabel("数据库名:");
        label_mysql_radio_name.setBounds(14, 101, 72, 18);
        panel_mysql.add(label_mysql_radio_name);
        
        text_mysqlname = new JTextField();
        text_mysqlname.setBounds(100, 98, 172, 24);
        panel_mysql.add(text_mysqlname);
        text_mysqlname.setColumns(10);
        
        label_mysqlLuJing = new JLabel("保存的路径:");
        label_mysqlLuJing.setBounds(14, 195, 83, 18);
        panel_mysql.add(label_mysqlLuJing);
        
        text_mysqlLuJing = new JTextField("C:\\Program Files");
        text_mysqlLuJing.setBounds(116, 192, 172, 24);
        panel_mysql.add(text_mysqlLuJing);
        text_mysqlLuJing.setColumns(10);
        
        btn_mysqlLuJing = new JButton("...");
        btn_mysqlLuJing.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {//
        		JFileChooser fileChooser = new JFileChooser("C:\\");//初始位置
    			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    			int returnVal = fileChooser.showOpenDialog(fileChooser);
    			if(returnVal == JFileChooser.APPROVE_OPTION){
    			mysqlfilePath = fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
    			}
    			text_mysqlLuJing.setText(mysqlfilePath);
        	}
        });
        btn_mysqlLuJing.setBounds(302, 192, 37, 24);
        panel_mysql.add(btn_mysqlLuJing);
        
        radio_mysql_shujuku = new JRadioButton("数据库");
        radio_mysql_shujuku.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		label_mysql_radio_name.setText("数据库名:");
        		System.out.println("数据库被点击");
        	}
        });
        radio_mysql_shujuku.setBounds(14, 35, 73, 27);
        panel_mysql.add(radio_mysql_shujuku);
        
        radio_mysql_biao = new JRadioButton("表");
        radio_mysql_biao.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		label_mysql_radio_name.setText("表名:");
        		System.out.println("表被点击");
        	}
        });
        radio_mysql_biao.setBounds(97, 35, 50, 27);
        panel_mysql.add(radio_mysql_biao);
        
        mysqlbg=new ButtonGroup();
        mysqlbg.add(radio_mysql_shujuku);
        mysqlbg.add(radio_mysql_biao);
        radio_mysql_shujuku.setSelected(true);//默认选中的是b1
        
        label = new JLabel("!路径只选择到目录，文件名会自动生成!");
        label.setBounds(48, 159, 291, 18);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//会让整个程序都退出
        panel_mysql.add(label);
	}
	public static JPanel getPanel() {
		return panel_mysql;
	}
}
