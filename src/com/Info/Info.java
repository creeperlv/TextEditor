package com.Info;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class Info extends Thread {
	/**
	 * @wbp.parser.entryPoint
	 */
	JFrame info = new JFrame("");
	JTextArea txtrAlpha;
	JLabel lblNewLabel;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void run(){
		info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		info.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		info.setTitle("Text Editor 0.3 Alpha Personal Edition");
		info.getContentPane().setBackground(new Color(30, 144, 255));
//		info.setIconImage(Toolkit.getDefaultToolkit().getImage(Info.class.getResource("/com/res/icon16.png")));
		info.setResizable(false);
		info.setAlwaysOnTop(true);
		info.setVisible(true);
		info.setSize(400, 300);
		info.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Info.class.getResource("/com/TextEditor/res/picture/Title.png")));
		lblNewLabel.setBounds(0, 0, 394, 50);
//		lblNewLabel.setIcon(new ImageIcon(Info.class.getResource("/com/res/1024.png")));
		info.getContentPane().add(lblNewLabel);
		
		txtrAlpha = new JTextArea();
		txtrAlpha.setBounds(0, 50, 394, 185);
		txtrAlpha.setText("\r\n\r\n                  Text Editor 0.3.1 Alpha Personal Edition\r\n\t           By:Creeper Java Lv");
		txtrAlpha.setForeground(Color.WHITE);
		txtrAlpha.setBackground(new Color(0, 153, 255));
		txtrAlpha.setEditable(false);
		txtrAlpha.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		txtrAlpha.setLineWrap(true);
		info.getContentPane().add(txtrAlpha);
		
		JButton button = new JButton("O   K");
		button.setBounds(0, 233, 394, 39);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				info.hide();
				return;
			}
		});
		info.getContentPane().add(button);
		info.update(info.getGraphics());
	}
}
