package com.TextEditor.personal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.TextEditor.res.Objects;

@SuppressWarnings("serial")
public class App extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;
	public static App frame;
	JButton btnWhite = new JButton("White");
	JPanel panel_Menu = new JPanel();
	JPanel panel_Frame = new JPanel();
	public static JLabel lblLines;
	boolean isEditing = true;
	public static JTextArea textArea;
	public static JPanel panel_2;
	public static JPanel panel_3;
	public static JPanel panel_6;
	public static JPanel panel_13;
	public static JPanel panel_12 = new JPanel();
	public static JPanel panel_1;
	boolean isChanged = true;
	int c = 0;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public App() {

  		try{
  			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  		}catch(Exception e){
  		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/com/TextEditor/res/picture/icon_N.png")));
		setTitle("Text Editor Personal Edition Version:0.3.1 Alpha Build 1013");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel_3 = new JPanel();
		panel_1 = new JPanel();
		panel_6 = new JPanel();
		panel_13 = new JPanel();
		textArea = new JTextArea();
		lblLines = new JLabel();
		panel_2 = new JPanel();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton lblFile = new JButton("File");
		lblFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c=10;
				CardLayout cl=(CardLayout) panel_3.getLayout();
				cl.show(panel_3,"m1");
				panel_Menu.setLocation(0, 0);
				panel_Menu.setSize(110,0);
				panel_Menu.show();
				Thread out = new Menuout();
				out.start();
			}
		});
		panel_1.add(lblFile);
		
		final JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=5;
				CardLayout cl=(CardLayout) panel_3.getLayout();
				cl.show(panel_3,"m3");
				panel_Menu.setLocation(btnHelp.getX(), 0);
				panel_Menu.setSize(110,0);
				panel_Menu.show();
				Thread out = new Menuout();
				out.start();
			}
		});
		
		//TODO Menu::Run
		final JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c=4;
				CardLayout cl=(CardLayout) panel_12.getLayout();
				cl.show(panel_12,"Run As");
				panel_12.setLocation(btnRun.getX(),0);
				panel_12.setSize(140,0);
				panel_12.show();
				Thread out = new ExMenuout();
				out.start();
			}
		});
		btnRun.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_1.add(btnRun);
		panel_1.add(btnHelp);
		
		JLabel label_8 = new JLabel("");
		panel_1.add(label_8);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		//TODO Settings
		panel_Frame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		panel_Frame.setBounds(262, 57, 278, 355);
		panel_2.add(panel_Frame);
		panel_Frame.setLayout(new BorderLayout(5, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_Frame.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new BorderLayout(2, 2));
		
		JLabel Title = new JLabel("Settings");
		Title.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		panel_14.add(Title, BorderLayout.CENTER);
		
		JLabel lblClose = new JLabel("");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea.setEnabled(true);
				textArea.setEditable(true);
				textArea.update(textArea.getGraphics());
//				textArea.updateUI();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
				panel_Frame.hide();
			}
		});
		lblClose.setVerticalAlignment(SwingConstants.TOP);
		lblClose.setIcon(new ImageIcon(App.class.getResource("/com/TextEditor/res/picture/close.png")));
		panel_14.add(lblClose, BorderLayout.EAST);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_Frame.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new CardLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_15.add(panel_16, "name_1949092464191");

		panel_16.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblFontColor = new JLabel("Font color:");
		panel_16.add(lblFontColor);
		
		final JButton btnBlack = new JButton("Black");
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Objects.fcolor++;
				switch(Objects.fcolor){
					case 1:
						btnBlack.setText("white");
						textArea.setForeground(Color.white);
						break;
					case 2:
						btnBlack.setText("Red");
						textArea.setForeground(Color.red);
						break;
					case 3:
						btnBlack.setText("Green");
						textArea.setForeground(Color.green);
						break;
					case 4:
						btnBlack.setText("Gray");
						textArea.setForeground(Color.gray);
						break;
					case 5:
						btnBlack.setText("Light Gray");
						textArea.setForeground(Color.lightGray);
						break;
					case 6:
						btnBlack.setText("black");
						textArea.setForeground(Color.black);
						Objects.fcolor=0;
						break;
				}
			}
		});
		panel_16.add(btnBlack);
		btnWhite = new JButton("White");
		
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Objects.bgcolor++;
				switch(Objects.bgcolor){
					case 1:
//						textArea.setSelectionColor(Color.white);
						textArea.setCaretColor(Color.white);
						btnWhite.setText("black");
						textArea.setBackground(Color.black);
						break;
					case 2:
						btnWhite.setText("Red");
						textArea.setBackground(Color.red);
						break;
					case 3:
						textArea.setCaretColor(Color.black);
						btnWhite.setText("white");
						textArea.setBackground(Color.white);
						Objects.bgcolor=0;
						break;
				}
			}
		});
		
		final JLabel lblBackgroundColor = new JLabel("Background color:");
		panel_16.add(lblBackgroundColor);
		panel_16.add(btnWhite);
		
		JLabel lblFontSize = new JLabel("Font size:");
		panel_16.add(lblFontSize);
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_17.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					textArea.setFont(new Font(textArea.getFont().getFontName(),Font.PLAIN,Integer.parseInt(textField.getText())));
				}
			}
		});
		textField.setText("12");
		textField.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18, BorderLayout.EAST);
		panel_18.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton button_1 = new JButton("/\\");
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setFont(new Font(textArea.getFont().getFontName(),Font.PLAIN,Integer.parseInt(textField.getText())+1));
				textField.setText(Integer.parseInt(textField.getText())+1+"");
			}
		});
		panel_18.add(button_1);
		
		JButton button_2 = new JButton("\\/");
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setFont(new Font(textArea.getFont().getFontName(),Font.PLAIN,Integer.parseInt(textField.getText())-1));
				textField.setText(Integer.parseInt(textField.getText())-1+"");
			}
		});
		panel_18.add(button_2);
		
		JLabel lblFont = new JLabel("Font:");
		panel_16.add(lblFont);
		
		final JButton button = new JButton("\u5FAE\u8F6F\u96C5\u9ED1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Objects.fontName++;
				switch(Objects.fontName){
					case 1:
						button.setText("宋体");
						textArea.setFont(new Font(button.getText(),Font.PLAIN,Integer.parseInt(textField.getText())));
						break;
					case 2:
						button.setText("黑体");
						textArea.setFont(new Font(button.getText(),Font.PLAIN,Integer.parseInt(textField.getText())));
						break;
					case 3:
						button.setText("微软雅黑");
						textArea.setFont(new Font(button.getText(),Font.PLAIN,Integer.parseInt(textField.getText())));
						Objects.fontName=0;
						break;
				}
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_16.add(button);
		
		//TODO save data
		
		JButton button_3 = new JButton("\u4FDD\u5B58\u8BBE\u7F6E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel label_10 = new JLabel("");
		panel_16.add(label_10);
		
		JLabel label_13 = new JLabel("");
		panel_16.add(label_13);
		
		JLabel label_12 = new JLabel("");
		panel_16.add(label_12);
		
		JLabel label_14 = new JLabel("");
		panel_16.add(label_14);
		
		JLabel label_15 = new JLabel("");
		panel_16.add(label_15);
		
		JLabel label_16 = new JLabel("");
		panel_16.add(label_16);
		
		JLabel label_17 = new JLabel("");
		panel_16.add(label_17);
		
		JLabel label_18 = new JLabel("");
		panel_16.add(label_18);
		panel_16.add(button_3);
		panel_Menu.setBackground(Color.WHITE);
		
		panel_Menu.setBounds(37, 10, 110, 176);
		panel_2.add(panel_Menu);
		panel_Menu.setLayout(new BorderLayout(0, 0));
		
		panel_Menu.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		panel_3.add(panel_4, "m1");
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton lblNewFile = new JButton("New File");
		lblNewFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
		});
		panel_4.add(lblNewFile);
		
		JButton label_6 = new JButton("Open");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    JFileChooser jChooser = new JFileChooser();
			    //设置默认的打开目录,如果不设的话按照window的默认目录(我的文档)
//			    jChooser.setCurrentDirectory(new File(".\\"));
			    jChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    //打开一个对话框
			    int index = jChooser.showDialog(null, "打开文件");
			    if (index == JFileChooser.APPROVE_OPTION) {
			     File f = jChooser.getSelectedFile();
					try {
						FileReader fr = new FileReader(f);
						BufferedReader br = new BufferedReader(fr);
						String temp=br.readLine();
						String temp2="";
						int i=0;
						for(;temp!=null;){
							if(i==0){temp2=temp2+temp;i=1;}
							else temp2=temp2+"\r\n"+temp;
							temp=br.readLine();
						}
						com.TextEditor.res.Objects.usingFile=f;
						isChanged = false;
						textArea.setText(temp2);
						br.close();
						fr.close();
					} catch (Exception e1) {
					}
			    }
			}
		});
		panel_4.add(label_6);
		
		//TODO Save As
		JButton label_5 = new JButton("Save As...");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt", "txt","All Files","*");
				JFileChooser jFileChooser=new JFileChooser();
				jFileChooser.setFileFilter(filter);
				int result=jFileChooser.showSaveDialog(null);
				if (result==JFileChooser.APPROVE_OPTION) {
					File f=jFileChooser.getSelectedFile();
					try {
						if(!f.exists())f.createNewFile();
						FileWriter fr = new FileWriter(f);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(textArea.getText());
						br.close();
						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(f.getPath());
				}
			}
		});
		
		JButton label_7 = new JButton("Save");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isChanged == true){
					FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt", "txt","All Files","*");
					JFileChooser jFileChooser=new JFileChooser();
					jFileChooser.setFileFilter(filter);
					int result=jFileChooser.showSaveDialog(null);
					if (result==JFileChooser.APPROVE_OPTION) {
						File f=jFileChooser.getSelectedFile();
						try {
							if(!f.exists())f.createNewFile();
							FileWriter fr = new FileWriter(f);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(textArea.getText());
							com.TextEditor.res.Objects.usingFile=f;
							isChanged = false;
							br.close();
							fr.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(f.getPath());
					}
				}else{
					FileWriter fr;
					try {
						fr = new FileWriter(com.TextEditor.res.Objects.usingFile);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(textArea.getText());
						isChanged = false;
						br.close();
						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		panel_4.add(label_7);
		panel_4.add(label_5);
		
		JButton label_4 = new JButton("Settings");
		label_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_Frame.show();
				textArea.setEnabled(false);
				textArea.setEditable(false);
				textArea.update(textArea.getGraphics());
//				textArea.updateUI();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_4.add(label_4);
		
		JLabel label_3 = new JLabel("");
		panel_4.add(label_3);
		
		JButton lblExit = new JButton("Exit");
		lblExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		lblExit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_4.add(lblExit);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_3.add(panel_5, "m2");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBackground(new Color(0, 204, 255));
		panel_5.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCopy = new JButton("Copy");
		panel_11.add(btnCopy);
		
		JButton btnCut = new JButton("Cut");
		panel_11.add(btnCut);
		
		JButton btnPaste = new JButton("Paste");
		panel_11.add(btnPaste);
		
		JButton btnSelectAll = new JButton("Select All");
		panel_11.add(btnSelectAll);
		
		JButton btnUndo = new JButton("Undo");
		panel_11.add(btnUndo);
		
		//TODO Run As
		final JButton btnRunAs = new JButton("Run As...");
		btnRunAs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c=4;
				CardLayout cl=(CardLayout) panel_12.getLayout();
				cl.show(panel_12,"Run As");
				panel_12.setLocation(panel_Menu.getX()+panel_Menu.getWidth(),panel_Menu.getY()+panel_Menu.getHeight()-30);
				panel_12.setSize(140,0);
				panel_12.show();
				Thread out = new ExMenuout();
				out.start();
			}
		});
		btnRunAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_11.add(btnRunAs);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(App.class.getResource("/com/TextEditor/res/picture/Menu.png")));
		panel_5.add(label_9, BorderLayout.WEST);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(211, 211, 211));
		panel_3.add(panel_8, "m3");
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnWebPage = new JButton("Web Page");
		btnWebPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime.getRuntime().exec("explorer.exe https://www.github.com/creeperlv/");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_8.add(btnWebPage);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread info = new com.Info.Info();
				info.start();
				textArea.setEnabled(true);
				textArea.setEditable(true);
				textArea.update(textArea.getGraphics());
//				textArea.updateUI();
				panel_Menu.hide();
				isEditing = true;
				panel_2.updateUI();
				panel_2.update(panel_2.getGraphics());
			}
		});
		
		JLabel label_11 = new JLabel("");
		panel_8.add(label_11);
		panel_8.add(btnAbout);
		
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_Menu.hide();
			}
		});
		
		panel_12.setBounds(157, 10, 145, 106);
		panel_2.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));
		
		panel_12.add(panel_13, "Run As");
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnHtml = new JButton("Html(Sample)");
		btnHtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t= new com.TextEditor.personal.Language.ForHtml.DebugWindow();
				t.start();
			}
		});
		btnHtml.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_13.add(btnHtml);
		
		JButton btnHtmlinGoogle = new JButton("Html (Chrome)");
		btnHtmlinGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(".\\Debug\\Html\\testPage.htm");
				FileWriter fr;
				try {
					fr = new FileWriter(f);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(App.textArea.getText());
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				com.TextEditor.personal.Language.ForHtml.OpenWithChrome.V37(f.getAbsolutePath());
			}
		});
		btnHtmlinGoogle.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnHtmlinGoogle.setToolTipText("<html>\r\n<body>\r\n<p>Chrome<hr/><p/>\r\n<p>Google Chrome Version:37.0.2062.103 m<p/>\r\n<hr/>\r\n</body>\r\n</html>");
		panel_13.add(btnHtmlinGoogle);
		
		JButton btnC = new JButton("C++");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnC.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_13.add(btnC);
		
		JButton btnExorderOf = new JButton("Exorder of 1024+");
		btnExorderOf.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_13.add(btnExorderOf);
		panel_6.setBounds(0, 0, 784, 546);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JScrollPane scrollPane;
		scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				isChanged = true;
			}
		});
		textArea.setLineWrap(true);
		//TODO click text area.
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_12.hide();
				if((e.getModifiers()&InputEvent.BUTTON3_MASK)!=0){
					c=8;
					CardLayout cl=(CardLayout) panel_3.getLayout();
					cl.show(panel_3,"m2");
					panel_Menu.setLocation(e.getXOnScreen()-getX(),(e.getYOnScreen()-getY())-25);
					panel_Menu.setSize(120,0);
					panel_Menu.show();
					Thread out = new Menuout2();
					out.start();
				}else{
				if(isEditing==false){
					textArea.setEnabled(true);
					textArea.setEditable(true);
					textArea.update(textArea.getGraphics());
//					textArea.updateUI();
					panel_Menu.hide();
					isEditing = true;
					panel_2.updateUI();
					panel_2.update(panel_2.getGraphics());
				}
				}
			}
		});
		scrollPane.setViewportView(textArea);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.WEST);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10, BorderLayout.SOUTH);
		lblLines.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		panel_10.add(lblLines);
		//Initialize {
		panel_Menu.hide();
		panel_12.hide();
		panel_Frame.hide();
		Thread RSW = new com.TextEditor.ResizeW();
		RSW.start();
		
		//}
	}
	class Menuout extends Thread{
		public void run(){
			isEditing = false;
			textArea.setEnabled(false);
			textArea.setEditable(false);
			for(int i = 0; i<c; i++){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panel_Menu.setSize(110, i*20);
			}
			panel_Menu.updateUI();
			panel_2.updateUI();
			panel_2.update(panel_2.getGraphics());
		}
	}
	class TxtFileFilter implements FileFilter {
		 public boolean accept(File f) {
		  // TODO Auto-generated method stub
		  String nameString = f.getName();
		  return nameString.toLowerCase().endsWith(".txt");
		 }
		 public String getDescription() {
		  // TODO Auto-generated method stub
		  return "*.txt(文本文件)";
		 }
		 
	}
	class Menuout2 extends Thread{
		public void run(){
			isEditing = false;
			for(int i = 0; i<=c; i++){
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panel_Menu.setSize(120, i*20);
			}
			panel_Menu.updateUI();
			panel_2.updateUI();
			panel_2.update(panel_2.getGraphics());
		}
	}
	class ExMenuout extends Thread{
		public void run(){
			isEditing = false;
			for(int i = 0; i<=c; i++){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panel_12.setSize(panel_12.getWidth(), i*20);
			}
			panel_12.updateUI();
			panel_2.updateUI();
			panel_2.update(panel_2.getGraphics());
		}
	}
}
