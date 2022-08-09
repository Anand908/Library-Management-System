package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class SignIn extends JFrame implements ActionListener {
	
	private static SignIn singleInstance;
	public static SignIn getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new SignIn();
		}
		singleInstance.refresh();
		return singleInstance;
	}

	private JTextField name; 
	
	private JPasswordField pass;
	
	private JLabel passRequired, nameRequired;
	
	private JButton signIn;
	
	private static String userId;
	
	private JPanel mainPanel, panel1, panel2;
	
	private SignIn(){
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0,0,790,565);
		mainPanel.setLayout(null);
		this.add(mainPanel);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 400, 600);
		panel1.setLayout(null);
		
		ImageIcon left1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/login.jpg"));
		Image left2 = left1.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		ImageIcon left3 = new ImageIcon(left2);
		JLabel left_I = new JLabel(left3);
		left_I.setBounds(0, 0, 400, 600);
		panel1.add(left_I);
		
		panel2 = new JPanel();
		panel2.setBounds(400, 0, 400, 600);
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(null);
		
		ImageIcon user_icon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/user.png"));
		Image user_icon2 = user_icon1.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
		ImageIcon user_icon3 = new ImageIcon(user_icon2);
		JLabel user_icon = new JLabel(user_icon3);
		user_icon.setBounds(110,20,150,150);
		user_icon.setForeground(Color.white);
		user_icon.setFont(new Font("Tahoma", Font.BOLD , 20));
		panel2.add(user_icon);
		
		JLabel username = new JLabel("User College ID");
		username.setBounds(40,200,180,12);
		username.setForeground(Color.white);
		username.setFont(new Font("Tahoma", Font.BOLD , 16));
		panel2.add(username);
		
		name = new JTextField();
		name.setBounds(40, 222, 300, 30);
		name.setOpaque(false);
		name.setBackground(new Color(0,0,0,0));
		name.setFont(new Font("Tahoma", Font.BOLD , 14));
		name.setForeground(Color.white);
		name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		name.setCaretColor(Color.white);
		nameRequired = new JLabel();
		nameRequired.setBounds(40, 255, 100, 10);
		nameRequired.setForeground(Color.red);
		panel2.add(nameRequired);
		name.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				nameRequired.setText("");
			}
		});
		panel2.add(name);
		
		JLabel password = new JLabel("Password");
		password.setBounds(40,280,100,12);
		password.setForeground(Color.white);
		password.setFont(new Font("Tahoma", Font.BOLD , 16));
		panel2.add(password);
		
		pass = new JPasswordField();
		pass.setBounds(40, 302, 300, 30);
		pass.setOpaque(false);
		pass.setBackground(new Color(0,0,0,0));
		pass.setFont(new Font("Tahoma", Font.BOLD , 18));
		pass.setForeground(Color.white);
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		pass.setCaretColor(Color.white);
		passRequired = new JLabel();
		passRequired.setBounds(40, 335, 100, 10);
		passRequired.setForeground(Color.red);
		panel2.add(passRequired);
		pass.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				passRequired.setText("");
			}
		});
		panel2.add(pass);
		
		JLabel forgot = new JLabel("Forgotten Password ?");
		forgot.setBounds(40, 370, 130, 12);
		forgot.setForeground(new Color(42,177,246));
		forgot.setBorder(new MatteBorder(0, 0, 1, 0, new Color(42,177,246)));
		forgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				switchPanels(4);
			}
		});
		panel2.add(forgot);
		
		signIn = new JButton("Sign In");
		signIn.setBounds(40, 400, 150, 40);
		signIn.setBackground(new Color(42,177,246));
		signIn.setFont(new Font("Tahoma", Font.BOLD , 14));
		signIn.setForeground(Color.white);
		signIn.addActionListener(this);
		panel2.add(signIn);
		
		JLabel signUp = new JLabel("Doesn't Have Account!  Sign Up");
		signUp.setBounds(40, 470, 200, 15);
		signUp.setFont(new Font("Tahoma", Font.PLAIN , 14));
		signUp.setForeground(new Color(42,177,246));
		signUp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(42,177,246)));
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				String option[] = {"Student","Librarian"};
				JComboBox signUp_as = new JComboBox(option);
				
				int input;
				
				input = JOptionPane.showConfirmDialog(panel2, signUp_as, "You want to Sign Up with", JOptionPane.DEFAULT_OPTION);
				
				if(input == JOptionPane.OK_OPTION) {
					if("Student".equals(signUp_as.getSelectedItem())) {
						switchPanels(2);
					}
					if("Librarian".equals(signUp_as.getSelectedItem())) {
						switchPanels(3);
					}
				}
			}
		});
		panel2.add(signUp);
		
		addPanels();
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/favicon.png"));
		this.setIconImage(icon.getImage());
		
		this.setTitle("Library Management System");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static String getUserId() {
		return userId;
	}
	private void refresh() {
		name.setText("");
		pass.setText("");
		nameRequired.setText("");
		passRequired.setText("");
	}
	
	//*******Add Panels******//
	private void addPanels() {
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(SignUp.getInstance().getSignUpPanel());
		mainPanel.add(LibSignUp.getInstance().getLibSignUpPanel());
		mainPanel.add(PasswordRetrieve.getInstance().getPasswordPanel());
	}
	
	//******* Switch Panels******//
	
	public void switchPanels(int num) {
		if(num == 1) {
			activateSignInPanel();
		}
		if(num == 2) {
			activateSignUpPanel();
		}
		if(num == 3) {
			activateLibSignUpPanel();
		}
		if(num == 4) {
			activatePasswordPanel();
		}
	}
	
	//*******Activators*******//
	
	private void activateSignInPanel() {
		panel1.setVisible(true);
		panel2.setVisible(true);
		SignUp.getInstance().getSignUpPanel().setVisible(false);
		LibSignUp.getInstance().getLibSignUpPanel().setVisible(false);
		PasswordRetrieve.getInstance().getPasswordPanel().setVisible(false);
	}
	private void activateSignUpPanel() {
		panel1.setVisible(false);
		panel2.setVisible(false);
		SignUp.getInstance().getSignUpPanel().setVisible(true);
		LibSignUp.getInstance().getLibSignUpPanel().setVisible(false);
		PasswordRetrieve.getInstance().getPasswordPanel().setVisible(false);
	}
	private void activateLibSignUpPanel() {
		panel1.setVisible(false);
		panel2.setVisible(false);
		SignUp.getInstance().getSignUpPanel().setVisible(false);
		LibSignUp.getInstance().getLibSignUpPanel().setVisible(true);
		PasswordRetrieve.getInstance().getPasswordPanel().setVisible(false);
	}
	private void activatePasswordPanel() {
		panel1.setVisible(false);
		panel2.setVisible(false);
		SignUp.getInstance().getSignUpPanel().setVisible(false);
		LibSignUp.getInstance().getLibSignUpPanel().setVisible(false);
		PasswordRetrieve.getInstance().getPasswordPanel().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == signIn) {
			String id = "",password = "";
			
			if(name.getText().isBlank()) {
				nameRequired.setText("Required Field !");
			}
			else {
				id = name.getText();
			}
			if(pass.getText().isBlank()) {
				passRequired.setText("Required Field !");
			}
			else {
				password = pass.getText();
			}
			if(!name.getText().isBlank() && !pass.getText().isBlank()) {
				String option[] = {"Student","Librarian"};
				JComboBox signIn_as = new JComboBox(option);
				
				int input;
				
				input = JOptionPane.showConfirmDialog(null, signIn_as, "You want to Sign In with", JOptionPane.DEFAULT_OPTION);
				
				if(input == JOptionPane.OK_OPTION) {
					if("Student".equals(signIn_as.getSelectedItem())) {
						try {
							Conn c = new Conn();
							ResultSet rs = c.getStatement().executeQuery("SELECT collegeId,pass FROM studentdata WHERE collegeId = '"+id+"' AND pass = '"+password+"';");
							
							if(rs.next()) {
								userId = id;
								StuDashBoard.getInstance().setVisible(true);
								this.setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Username Password :(");
							}
							
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Oops! Sever Disconneted Try Again Later :(");
						}
					}
					if("Librarian".equals(signIn_as.getSelectedItem())) {
						try {
							Conn c = new Conn();
							ResultSet rs = c.getStatement().executeQuery("SELECT collegeId,pass FROM librariandata WHERE collegeId = '"+id+"' AND pass = '"+password+"';");
							
							if(rs.next()) {
								userId = id;
								DashBoard.getInstance().setVisible(true);
								this.setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Username Password :(");
							}
							
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Oops! Sever Disconneted Try Again Later :(");
						}
					}
				}
			}
		}
	}
}
