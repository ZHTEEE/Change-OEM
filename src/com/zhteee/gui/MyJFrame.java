package com.zhteee.gui;

import com.zhteee.onclick.ButtonOnClick;
import com.zhteee.onclick.JpanelOnClick;

import javax.swing.*;

public class MyJFrame extends JFrame {
	
	public static JTextField Manufacturer = new JTextField("制造商");
	public static JTextField Model = new JTextField("型号");
	public static JButton button = new JButton("生成");
	public static LogoPanel logoPanel = new LogoPanel();
//	public static JPanel massage = new JPanel();

	public  MyJFrame() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {


		//将UI风格设置为当前操作系统
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("OEM 生成器 v0.1");
		this.setBounds(200, 200, 400, 220);//设置框体尺寸位置

		Manufacturer.setBounds(190, 20, 180, 30);
		Model.setBounds(190, 55, 180, 30);
		button.setBounds(290, 110, 80, 40);
		button.addActionListener(new ButtonOnClick());

		logoPanel.setBounds(20,20,151,151);
		logoPanel.addMouseListener(new JpanelOnClick());

		this.add(logoPanel);
		this.add(Manufacturer);
		this.add(Model);
		this.add(button);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}