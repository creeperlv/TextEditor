package com.TextEditor.personal.Language.ForHtml;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.TextEditor.personal.App;

public class DebugWindow extends Thread{
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("deprecation")
	public void run(){
		String code = App.textArea.getText();
		final JFrame f = new JFrame("Debug(Sample) - Html");
		f.setVisible(true);
		f.setSize(800, 600);
		
		JLabel lblJustForSample = new JLabel("");
		lblJustForSample.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2){
					f.hide();
					return;
				}
			}
		});
		lblJustForSample.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblJustForSample.setVerticalAlignment(SwingConstants.TOP);
		lblJustForSample.setHorizontalAlignment(SwingConstants.LEFT);
		lblJustForSample.setToolTipText("Just for sample html code test!");
		f.getContentPane().add(lblJustForSample, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel label_1 = new JLabel(""+code.getBytes());
		panel.add(label_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.hide();
				return;
			}
		});
		panel.add(btnExit);
		
		label_1.setText(""+code.getClass());
		lblJustForSample.setText("<html>\r\n<body>\r\n<p><br/><br/><br/><br/>                           Just for sample html code test!</p>\r\n</body>\r\n</html>Just for sample html code test!");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblJustForSample.setText(code);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(lblJustForSample, popupMenu);
		
		JMenuItem mntmOpenInGoogle = new JMenuItem("Open in Google Chrome");
		mntmOpenInGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File(".\\Debug\\Html\\testPage.htm");
				FileWriter fr;
				try {
					fr = new FileWriter(f);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(App.textArea.getText());
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				com.TextEditor.personal.Language.ForHtml.OpenWithChrome.V37(f.getAbsolutePath());
			}
		});
		popupMenu.add(mntmOpenInGoogle);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

	
