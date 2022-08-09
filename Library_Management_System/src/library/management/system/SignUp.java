package library.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class SignUp implements ActionListener {
	
	private static SignUp singleInstance;
	public static SignUp getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new SignUp();
		}
		singleInstance.refresh();
		return singleInstance;
	}
	
	JTextField nameEntry,classEntry,collegeIdEntry,stuPhoneEntry,parentPhoneEntry,securityQueEntry,securityAnsEntry;
	
	JPasswordField passwordEntry;
	
	JLabel nameRequired,classRequired,idRequired,phoneRequired1,phoneRequired2,queRequired,ansRequired,passRequired,termRequired; 
	
	JCheckBox terms;
	
	JButton submit, back;
	
	JPanel mainPanel;
	
	public JPanel getSignUpPanel()
	{
		return mainPanel;
	}
	
	private SignUp() {
		
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
		
		JLabel stuName = new JLabel("Student name");
		stuName.setBounds(30,60,120,12);
		stuName.setForeground(Color.white);
		stuName.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(stuName);
		
		nameEntry = new JTextField();
		nameEntry.setBounds(30, 80, 340, 28);
		nameEntry.setOpaque(false);
		nameEntry.setBackground(new Color(0,0,0,0));
		nameEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		nameEntry.setForeground(new Color(255,255,255));
		nameEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		nameEntry.setCaretColor(Color.white);
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
		
		JLabel stuClass = new JLabel("Class");
		stuClass.setBounds(30,130,100,12);
		stuClass.setForeground(Color.white);
		stuClass.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(stuClass);
		
		classEntry = new JTextField();
		classEntry.setBounds(30, 150, 160, 30);
		classEntry.setOpaque(false);
		classEntry.setCaretColor(Color.white);
		classEntry.setBackground(new Color(0,0,0,0));
		classEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		classEntry.setForeground(Color.white);
		classEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		classRequired = new JLabel();
		classRequired.setBounds(30, 182, 100, 10);
		classRequired.setForeground(Color.red);
		panel1.add(classRequired);
		classEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				classRequired.setText("");
			}
		});
		panel1.add(classEntry);
		
		JLabel collegeId = new JLabel("Student College Id");
		collegeId.setBounds(210,130,130,12);
		collegeId.setForeground(Color.white);
		collegeId.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(collegeId);
		
		collegeIdEntry = new JTextField();
		collegeIdEntry.setBounds(210, 150, 160, 30);
		collegeIdEntry.setOpaque(false);
		collegeIdEntry.setCaretColor(Color.white);
		collegeIdEntry.setBackground(new Color(0,0,0,0));
		collegeIdEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		collegeIdEntry.setForeground(Color.white);
		collegeIdEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		idRequired = new JLabel();
		idRequired.setBounds(210, 182, 100, 10);
		idRequired.setForeground(Color.red);
		panel1.add(idRequired);
		collegeIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				idRequired.setText("");
			}
		});
		panel1.add(collegeIdEntry);
		
		JLabel stuPhone = new JLabel("Phone Number");
		stuPhone.setBounds(30,200,120,12);
		stuPhone.setForeground(Color.white);
		stuPhone.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(stuPhone);
		
		stuPhoneEntry = new JTextField();
		stuPhoneEntry.setBounds(30, 220, 160, 30);
		stuPhoneEntry.setOpaque(false);
		stuPhoneEntry.setCaretColor(Color.white);
		stuPhoneEntry.setBackground(new Color(0,0,0,0));
		stuPhoneEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		stuPhoneEntry.setForeground(Color.white);
		stuPhoneEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		phoneRequired1  = new JLabel();
		phoneRequired1.setBounds(30, 252, 100, 10);
		phoneRequired1.setForeground(Color.red);
		panel1.add(phoneRequired1);
		stuPhoneEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				phoneRequired1.setText("");
			}
		});
		panel1.add(stuPhoneEntry);
		
		JLabel parentPhone = new JLabel("Parent's Number");
		parentPhone.setBounds(210,200,140,12);
		parentPhone.setForeground(Color.white);
		parentPhone.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel1.add(parentPhone);
		
		parentPhoneEntry = new JTextField();
		parentPhoneEntry.setBounds(210, 220, 160, 30);
		parentPhoneEntry.setOpaque(false);
		parentPhoneEntry.setCaretColor(Color.white);
		parentPhoneEntry.setBackground(new Color(0,0,0,0));
		parentPhoneEntry.setFont(new Font("Tahoma", Font.BOLD , 14));
		parentPhoneEntry.setForeground(Color.white);
		parentPhoneEntry.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		phoneRequired2 = new JLabel();
		phoneRequired2.setBounds(210, 252, 100, 10);
		phoneRequired2.setForeground(Color.red);
		panel1.add(phoneRequired2);
		parentPhoneEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				phoneRequired2.setText("");
			}
		});
		panel1.add(parentPhoneEntry);
		
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
		infoBtn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent ae) {
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
		
		terms = new JCheckBox("I accept the ");
		terms.setBounds(30, 474, 95, 20);
		terms.setBackground(new Color(0,0,0,0));
		terms.setOpaque(false);
		terms.setForeground(Color.white);
		termRequired = new JLabel();
		termRequired.setBounds(270, 480, 100, 10);
		termRequired.setForeground(Color.red);
		panel1.add(termRequired);
		terms.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				termRequired.setText("");
			}
		});
		panel1.add(terms);
		
		JLabel conditions = new JLabel("Terms And Conditions");
		conditions.setBounds(122, 480, 130, 10);
		conditions.setForeground(Color.red);
		conditions.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
		conditions.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(securityQue, "<html><h1>Terms And Conditions</h1><br>1. You can get only two books at a time. \n2. You will have to return the book under 3 days \n3. In case of delayed return of books, You will have to pay 5 rs. per book per day. \n4. If you have'n return the books under 15 days, Your parents will be informed about this. \n5. In case of not returning book, Your college security fee will not be refunded. \n\n\t\t Thank You Have a Bright Future");
			}
		});
		panel1.add(conditions);
		
		submit = new JButton("Submit");
		submit.setBounds(30, 510, 150, 40);
		submit.setBackground(new Color(61,21,110));
		submit.setFont(new Font("Tahoma", Font.BOLD , 14));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		panel1.add(submit);
		
		back = new JButton("Back");
		back.setBounds(200, 510, 150, 40);
		back.setBackground(new Color(61,21,110));
		back.setFont(new Font("Tahoma", Font.BOLD , 14));
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel1.add(back);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(400, 0, 400, 600);
		panel2.setLayout(null);
		mainPanel.add(panel2);
		
		ImageIcon right1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/stu-reg.jpg"));
		Image right2 = right1.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		ImageIcon right3 = new ImageIcon(right2);
		JLabel right = new JLabel(right3);
		right.setBounds(0, 0, 400, 600);
		panel2.add(right);
	}
	
	private void refresh() {
		nameEntry.setText("");
		classEntry.setText("");
		collegeIdEntry.setText("");
		stuPhoneEntry.setText("");
		parentPhoneEntry.setText("");
		securityQueEntry.setText("");
		securityAnsEntry.setText("");
		passwordEntry.setText("");
		terms.setSelected(false);
		
		nameRequired.setText("");
		classRequired.setText("");
		idRequired.setText("");
		phoneRequired1.setText("");
		phoneRequired2.setText("");
		queRequired.setText("");
		ansRequired.setText("");
		passRequired.setText("");
		termRequired.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String name="",course="",collegeId="",stuPhone="",parentPhone="",question="",answer="",pass="";
			int flag = 0;
			
			if(nameEntry.getText().isBlank()) {
				nameRequired.setText("Required Field !");
			}
			else {
				name = nameEntry.getText();
				flag = flag + 1;
			}	
			if(classEntry.getText().isBlank()) {
				classRequired.setText("Required Field !");
			}
			else {
				 course = classEntry.getText();
				 flag = flag+1;
			}
			if(collegeIdEntry.getText().isBlank()) {
				idRequired.setText("Required Field !");
			}
			else {
				 collegeId = collegeIdEntry.getText();
				 flag = flag+1;
			}
			if(stuPhoneEntry.getText().isBlank()) {
				phoneRequired1.setText("Required Field !");
			}
			else {
				try {
					if(Double.parseDouble(stuPhoneEntry.getText()) < 10000000000d && Double.parseDouble(stuPhoneEntry.getText()) > 1000000000d) {
						stuPhone = stuPhoneEntry.getText();
						flag = flag+1;
					}
					else {
						phoneRequired1.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					phoneRequired1.setText("Wrong Input");
				}
			}
			if(parentPhoneEntry.getText().isBlank()) {
				phoneRequired2.setText("Required Field !");
			}
			else {
				try {
					if(Double.parseDouble(parentPhoneEntry.getText()) < 10000000000d && Double.parseDouble(parentPhoneEntry.getText()) > 1000000000d) {
						parentPhone = parentPhoneEntry.getText();
						flag = flag+1;
					}
					else {
						phoneRequired2.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					phoneRequired2.setText("Wrong Input");
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
			if(!terms.isSelected()) {
				termRequired.setText("Check Required !");
			}
			if(flag == 8 && terms.isSelected()){
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("INSERT INTO studentdata (name, course, collegeId, stuPhone, parentPhone, question, answer, pass) VALUES ('"+name+"','"+course+"','"+collegeId+"','"+stuPhone+"','"+parentPhone+"','"+question+"','"+answer+"','"+pass+"');");
					JOptionPane.showMessageDialog(null, "Congrats! Data Submitted Successfully");
					
					SignIn.getInstance().switchPanels(1);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Oops! Server Disconnected Try Again Later");
				}
			}
		}
		if(ae.getSource() == back) {
			SignIn.getInstance().switchPanels(1);
		}
		
	}
}
