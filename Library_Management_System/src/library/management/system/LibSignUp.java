package library.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class LibSignUp implements ActionListener {
	
	private static LibSignUp singleInstance;
	public static LibSignUp getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new LibSignUp();
		}
		singleInstance.refresh();
		return singleInstance;
	}
	
	JTextField nameEntry,collegeIdEntry,phoneEntry,securityQueEntry,securityAnsEntry;
	
	JPasswordField passwordEntry;
	
	JLabel nameRequired,idRequired,phoneRequired,queRequired,ansRequired,passRequired;
	
	JButton submit, back;
	
	JPanel mainPanel;
	
	public JPanel getLibSignUpPanel()
	{
		return mainPanel;
	}
	
	private LibSignUp() {
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0,0,790,565);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 400, 600);
		panel1.setBackground(new Color(42,04,88));
		panel1.setLayout(null);
		mainPanel.add(panel1);
		
		JLabel title = new JLabel("Sign Up");
		title.setBounds(150,10,100,30);
		title.setForeground(Color.white);
		title.setFont(new Font("Tahoma", Font.BOLD , 22));
		panel1.add(title);
		
		JLabel stuName = new JLabel("Librarian name");
		stuName.setBounds(30,60,120,12);
		stuName.setForeground(Color.white);
		stuName.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(stuName);
		
		nameEntry = new JTextField();
		nameEntry.setBounds(30, 80, 340, 28);
		nameEntry.setCaretColor(Color.white);
		nameEntry.setOpaque(false);
		nameEntry.setBackground(new Color(0,0,0,0));
		nameEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		nameEntry.setForeground(new Color(255,255,255));
		nameEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		nameEntry.setColumns(10);
		nameRequired = new JLabel();
		nameRequired.setBounds(30, 115, 100, 10);
		nameRequired.setForeground(Color.red);
		panel1.add(nameRequired);
		nameEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				nameRequired.setText("");
			}
		});
		panel1.add(nameEntry);
		
		JLabel collegeId = new JLabel("Employee College Id");
		collegeId.setBounds(30,130,180,20);
		collegeId.setForeground(Color.white);
		collegeId.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(collegeId);
		
		collegeIdEntry = new JTextField();
		collegeIdEntry.setBounds(30, 150, 340, 30);
		collegeIdEntry.setOpaque(false);
		collegeIdEntry.setCaretColor(Color.white);
		collegeIdEntry.setBackground(new Color(0,0,0,0));
		collegeIdEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		collegeIdEntry.setForeground(Color.white);
		collegeIdEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		idRequired = new JLabel();
		idRequired.setBounds(30, 182, 100, 10);
		idRequired.setForeground(Color.red);
		panel1.add(idRequired);
		collegeIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				idRequired.setText("");
			}
		});
		panel1.add(collegeIdEntry);
		
		JLabel phone = new JLabel("Phone Number");
		phone.setBounds(30,200,120,12);
		phone.setForeground(Color.white);
		phone.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(phone);
		
		phoneEntry = new JTextField();
		phoneEntry.setBounds(30, 220, 340, 30);
		phoneEntry.setOpaque(false);
		phoneEntry.setCaretColor(Color.white);
		phoneEntry.setBackground(new Color(0,0,0,0));
		phoneEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		phoneEntry.setForeground(Color.white);
		phoneEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		phoneRequired  = new JLabel();
		phoneRequired.setBounds(30, 252, 100, 10);
		phoneRequired.setForeground(Color.red);
		panel1.add(phoneRequired);
		phoneEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				phoneRequired.setText("");
			}
		});
		panel1.add(phoneEntry);
		
		JLabel securityQue = new JLabel("Security Question");
		securityQue.setBounds(30,270,150,20);
		securityQue.setForeground(Color.white);
		securityQue.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(securityQue);
		
		ImageIcon infoBtn1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/info.png"));
		Image infoBtn2 = infoBtn1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon infoBtn3 = new ImageIcon(infoBtn2);
		JButton infoBtn = new JButton(infoBtn3);
		infoBtn.setBounds(200, 270, 20, 20);
		infoBtn.setBackground(new Color(0,0,0,0));
		infoBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(securityQue, "<html><h1>Password Retrieve</h1><br></html>\nThis question will be asked in the case of forgot password\nAnd you will have to reaply same answer.\nThen you password will be retrieved");
			}
		});
		panel1.add(infoBtn);
		
		securityQueEntry = new JTextField();
		securityQueEntry.setBounds(30, 290, 340, 30);
		securityQueEntry.setOpaque(false);
		securityQueEntry.setCaretColor(Color.white);
		securityQueEntry.setBackground(new Color(0,0,0,0));
		securityQueEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		securityQueEntry.setForeground(Color.white);
		securityQueEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		queRequired = new JLabel();
		queRequired.setBounds(30, 322, 100, 10);
		queRequired.setForeground(Color.red);
		panel1.add(queRequired);
		securityQueEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				queRequired.setText("");
			}
		});
		panel1.add(securityQueEntry);
		
		JLabel securityAns = new JLabel("Security Answer");
		securityAns.setBounds(30,340,150,20);
		securityAns.setForeground(Color.white);
		securityAns.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(securityAns);
		
		securityAnsEntry = new JTextField();
		securityAnsEntry.setBounds(30, 360, 340, 30);
		securityAnsEntry.setOpaque(false);
		securityAnsEntry.setCaretColor(Color.white);
		securityAnsEntry.setBackground(new Color(0,0,0,0));
		securityAnsEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		securityAnsEntry.setForeground(Color.white);
		securityAnsEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		ansRequired = new JLabel();
		ansRequired.setBounds(30, 392, 100, 10);
		ansRequired.setForeground(Color.red);
		panel1.add(ansRequired);
		securityAnsEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				ansRequired.setText("");
			}
		});
		panel1.add(securityAnsEntry);
		
		JLabel password = new JLabel("Make a Password");
		password.setBounds(30,410,180,20);
		password.setForeground(Color.white);
		password.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(password);
		
		passwordEntry = new JPasswordField();
		passwordEntry.setBounds(30, 430, 340, 30);
		passwordEntry.setOpaque(false);
		passwordEntry.setCaretColor(Color.white);
		passwordEntry.setBackground(new Color(0,0,0,0));
		passwordEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		passwordEntry.setForeground(Color.white);
		passwordEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passRequired = new JLabel();
		passRequired.setBounds(30, 462, 100, 10);
		passRequired.setForeground(Color.red);
		panel1.add(passRequired);
		passwordEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				passRequired.setText("");
			}
		});
		panel1.add(passwordEntry);
		
		submit = new JButton("Submit");
		submit.setBounds(30, 500, 150, 40);
		submit.setBackground(new Color(61,21,110));
		submit.setFont(new Font("Tahoma", Font.BOLD , 14));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		panel1.add(submit);
		
		back = new JButton("Back");
		back.setBounds(200, 500, 150, 40);
		back.setBackground(new Color(61,21,110));
		back.setFont(new Font("Tahoma", Font.BOLD , 14));
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel1.add(back);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(400, 0, 400, 600);
		panel2.setLayout(null);
		mainPanel.add(panel2);
		
		ImageIcon right1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/lib-reg.jpg"));
		Image right2 = right1.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		ImageIcon right3 = new ImageIcon(right2);
		JLabel right = new JLabel(right3);
		right.setBounds(0, 0, 400, 600);
		panel2.add(right);
	}
	
	private void refresh() {
		nameEntry.setText("");
		collegeIdEntry.setText("");
		phoneEntry.setText("");
		securityQueEntry.setText("");
		securityAnsEntry.setText("");
		passwordEntry.setText("");
		
		nameRequired.setText("");
		idRequired.setText("");
		phoneRequired.setText("");
		queRequired.setText("");
		ansRequired.setText("");
		passRequired.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String name="",collegeId="",phone="",question="",answer="",pass="";
			int flag = 0;
			
			if(nameEntry.getText().isBlank()) {
				nameRequired.setText("Required Field !");
			}
			else {
				name = nameEntry.getText();
				flag = flag + 1;
			}	
			if(collegeIdEntry.getText().isBlank()) {
				idRequired.setText("Required Field !");
			}
			else {
				 collegeId = collegeIdEntry.getText();
				 flag = flag+1;
			}
			if(phoneEntry.getText().isBlank()) {
				phoneRequired.setText("Required Field !");
			}
			else {
				try {
					if(Double.parseDouble(phoneEntry.getText()) < 10000000000d && Double.parseDouble(phoneEntry.getText()) > 1000000000d) {
						phone = phoneEntry.getText();
						flag = flag+1;
					}
					else {
						phoneRequired.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					phoneRequired.setText("Wrong Input");
				}
			}
			if(securityQueEntry.getText().isBlank()) {
				queRequired.setText("Required Field !");
			}
			else {
				question = securityQueEntry.getText();
				flag = flag+1;
			}
			if(securityAnsEntry.getText().isBlank()) {
				ansRequired.setText("Required Field !");
			}
			else {
				answer = securityAnsEntry.getText();
				flag = flag+1;
			}
			if(passwordEntry.getText().isBlank()) {
				passRequired.setText("Required Field !");
			}
			else {
				pass = passwordEntry.getText();
				flag = flag+1;
			}
			if(flag == 6){
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("INSERT INTO librariandata (name, collegeId, phone, question, answer, pass) VALUES ('"+name+"','"+collegeId+"','"+phone+"','"+question+"','"+answer+"','"+pass+"');");
					JOptionPane.showMessageDialog(null, "Congrats! Data Submitted Successfully");
					
					SignIn.getInstance().switchPanels(1);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Oops! Server Disconnected Try Again Later or You have entered wrong id");
				}
			}
		}
		if(ae.getSource() == back) {
			SignIn.getInstance().switchPanels(1);
		}
		
	}
}
