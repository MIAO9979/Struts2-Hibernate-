package com.mdr.struts2;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Struts2Frame extends JFrame{
	private JTextField text_BaoMing;
	private JTextField text_LeiMing;
	private JButton btn_ShengCheng ;
	private String filepath;
	private JTextField text_XiangMu;
	private JLabel lblXiangmuming;
	private static JPanel panel_struts2 = new JPanel();
		public Struts2Frame() {
			setBounds(600, 300, 450, 450);
			setDefaultCloseOperation(EXIT_ON_CLOSE);//会让整个程序都退出
			panel_struts2.setLayout(null);
			
			text_BaoMing = new JTextField();
			text_BaoMing.setBounds(131, 83, 188, 24);
			panel_struts2.add(text_BaoMing);
			text_BaoMing.setColumns(10);
			
			text_LeiMing = new JTextField();
			text_LeiMing.setBounds(131, 137, 188, 24);
			panel_struts2.add(text_LeiMing);
			text_LeiMing.setColumns(10);
			
			JLabel label = new JLabel("包 名：");
			label.setBounds(59, 86, 58, 18);
			panel_struts2.add(label);
			
			JLabel label_1 = new JLabel("类 名：");
			label_1.setBounds(59, 140, 58, 18);
			panel_struts2.add(label_1);
			
			btn_ShengCheng = new JButton("一键生成");
			btn_ShengCheng.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JFileChooser fileChooser = new JFileChooser("C:\\");//初始位置
	    			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    			int returnVal = fileChooser.showOpenDialog(fileChooser);
	    			if(returnVal == JFileChooser.APPROVE_OPTION){
	    				filepath = fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
	    			}
	    			//路径、包名、类名
	    			String BaoMing = text_BaoMing.getText().trim();
	    			String LeiMIng = text_LeiMing.getText().trim();
	    			String XiangMuMing = text_XiangMu.getText().trim();
	    			Struts2 struts2 = new Struts2();
	    			String struts = struts2.Struts(filepath,BaoMing,LeiMIng);
	    			String Lei = struts2.Lei(filepath,BaoMing,LeiMIng);
	    			String web = struts2.web(filepath, XiangMuMing);
	    			new Readme(filepath);
	    			text_BaoMing.setText(struts);
	    			text_LeiMing.setText(Lei);
	    			text_XiangMu.setText(web);
				}
			});
			btn_ShengCheng.setBounds(205, 263, 113, 40);
			panel_struts2.add(btn_ShengCheng);
			
			text_XiangMu = new JTextField();
			text_XiangMu.setBounds(131, 192, 188, 24);
			panel_struts2.add(text_XiangMu);
			text_XiangMu.setColumns(10);
			
			lblXiangmuming = new JLabel("项目名：");
			lblXiangmuming.setBounds(50, 195, 67, 18);
			panel_struts2.add(lblXiangmuming);
			add(panel_struts2);
		}
		public JPanel getPanel() {
			return panel_struts2;
		}
}
