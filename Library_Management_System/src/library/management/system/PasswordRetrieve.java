package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class PasswordRetrieve implements ActionListener {
	
	private static PasswordRetrieve singleInstance;
	public static PasswordRetrieve getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new PasswordRetrieve();
		}
		singleInstance.refresh();
		return singleInstance;
	}

	private JTextField name,answer; 
	
	private JPasswordField pass;
	
	private JLabel nameRequired, answerRequired, passRequired, question, user_icon;
	
	private JButton search, next, submit, back;
	
	private JPanel panel2, panel3, panel4;
	
	private String who = "";
	
	private JPanel mainPanel;
	
	public JPanel getFisrtPanel()
	{
		return mainPanel;
	}
	
	public JPanel getPasswordPanel()
	{
		return mainPanel;
	}
	
	private PasswordRetrieve(){
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0,0,790,565);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 400, 600);
		panel1.setLayout(null);
		mainPanel.add(panel1);
		
		ImageIcon left1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Reset1.jpeg"));
		Image left2 = left1.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		ImageIcon left3 = new ImageIcon(left2);
		JLabel left_I = new JLabel(left3);
		left_I.setBounds(0, 0, 400, 600);
		panel1.add(left_I);
		
		panel2 = new JPanel();
		panel2.setBounds(400, 0, 400, 600);
		panel2.setBackground(new Color(157,157,157));
		panel2.setLayout(null);
		panel2.setVisible(true);
		mainPanel.add(panel2);
		
		ImageIcon user_icon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Reset2.png"));
		Image user_icon2 = user_icon1.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
		ImageIcon user_icon3 = new ImageIcon(user_icon2);
		user_icon = new JLabel(user_icon3);
		user_icon.setBounds(110,20,150,150);
		user_icon.setForeground(Color.white);
		user_icon.setFont(new Font("Tahoma", Font.BOLD , 20));
		panel2.add(user_icon);
		
		JLabel username = new JLabel("User College ID");
		username.setBounds(40,200,180,12);
		username.setForeground(Color.white);
		username.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel2.add(username);
		
		name = new JTextField();
		name.setBounds(40, 220, 300, 30);
		name.setOpaque(false);
		name.setCaretColor(Color.white);
		name.setBackground(new Color(0,0,0,0));
		name.setFont(new Font("Tahoma", Font.BOLD , 12));
		name.setForeground(Color.white);
		name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
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
		
		search = new JButton("Next");
		search.setBounds(40,300,150,40);
		search.setBackground(new Color(10,168,7));
		search.setFont(new Font("Tahoma", Font.BOLD , 14));
		search.setForeground(Color.white);
		search.addActionListener(this);
		panel2.add(search);
		
		back = new JButton("Back To Sign In");
		back.setBounds(200, 300, 150, 40);
		back.setBackground(new Color(10,168,7));
		back.setFont(new Font("Tahoma", Font.BOLD , 14));
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel2.add(back);
		
		panel3 = new JPanel();
		panel3.setBounds(400, 0, 400, 600);
		panel3.setBackground(new Color(157,157,157));
		panel3.setLayout(null);
		panel3.setVisible(false);
		mainPanel.add(panel3);
		
		question = new JLabel();
		question.setBounds(40,200,300,20);
		question.setForeground(Color.white);
		question.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel3.add(question);
		
		answer = new JTextField();
		answer.setBounds(40, 220, 300, 30);
		answer.setOpaque(false);
		answer.setCaretColor(Color.white);
		answer.setBackground(new Color(0,0,0,0));
		answer.setFont(new Font("Tahoma", Font.BOLD , 12));
		answer.setForeground(Color.white);
		answer.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		answerRequired = new JLabel();
		answerRequired.setBounds(40, 255, 100, 10);
		answerRequired.setForeground(Color.red);
		panel3.add(answerRequired);
		answer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				answerRequired.setText("");
			}
		});
		panel3.add(answer);
		
		next = new JButton("Next");
		next.setBounds(40,300,150,40);
		next.setBackground(new Color(10,168,7));
		next.setFont(new Font("Tahoma", Font.BOLD , 14));
		next.setForeground(Color.white);
		next.addActionListener(this);
		panel3.add(next);
		
		panel4 = new JPanel();
		panel4.setBounds(400, 0, 400, 600);
		panel4.setBackground(new Color(157,157,157));
		panel4.setLayout(null);
		panel4.setVisible(false);
		mainPanel.add(panel4);
		
		JLabel password = new JLabel("New Password");
		password.setBounds(40,200,300,12);
		password.setForeground(Color.white);
		password.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel4.add(password);
		
		pass = new JPasswordField();
		pass.setBounds(40, 220, 300, 30);
		pass.setOpaque(false);
		pass.setCaretColor(Color.white);
		pass.setBackground(new Color(0,0,0,0));
		pass.setFont(new Font("Tahoma", Font.BOLD , 12));
		pass.setForeground(Color.white);
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passRequired = new JLabel();
		passRequired.setBounds(40, 255, 100, 10);
		passRequired.setForeground(Color.red);
		panel4.add(passRequired);
		pass.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				passRequired.setText("");
			}
		});
		panel4.add(pass);
		
		submit = new JButton("Submit");
		submit.setBounds(40,300,150,40);
		submit.setBackground(new Color(10,168,7));
		submit.setFont(new Font("Tahoma", Font.BOLD , 14));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		panel4.add(submit);
	}
	
	private void refresh() {
		panel2.add(user_icon);
		panel2.add(back);

		panel2.setVisible(true);
		panel3.setVisible(false);
		panel4.setVisible(false);
		name.setText("");
		answer.setText("");
		pass.setText("");
		
		nameRequired.setText("");
		answerRequired.setText("");
		passRequired.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			if(!name.getText().isBlank()) {
				idChecking();
			}
			else
			{
				nameRequired.setText("Required Field !");
			}
		}
		if(ae.getSource() == next) {
			if(!answer.getText().isBlank()) {
				try {
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("select answer from "+who+" where answer = '"+answer.getText()+"' and collegeId = '"+name.getText()+"'");
					if(rs.next()) {
						panel4.add(user_icon);
						panel4.add(back);
						panel4.setVisible(true);
						panel2.setVisible(false);
						panel3.setVisible(false);
					}
					else
					{
						answerRequired.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				answerRequired.setText("Required Field !");
			}
		}
		if(ae.getSource() == submit) {
			if(!pass.getText().isBlank()) {
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("UPDATE "+who+" SET pass = '"+pass.getText()+"' WHERE collegeId = '"+name.getText()+"';");
					JOptionPane.showMessageDialog(null, "Your Password has been changed successfully !");
					
					SignIn.getInstance().switchPanels(1);
						
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				passRequired.setText("Required Field !");
			}
		}
		if(ae.getSource() == back) {
			SignIn.getInstance().switchPanels(1);
		}
	}
	private void idChecking() {
		String option[] = {"Student","Librarian"};
		JComboBox signUp_as = new JComboBox(option);
		
		int input;
		
		input = JOptionPane.showConfirmDialog(null, signUp_as, "You want to Sign Up with", JOptionPane.DEFAULT_OPTION);
		
		if(input == JOptionPane.OK_OPTION) {
			if("Student".equals(signUp_as.getSelectedItem())) {
				try {
					who = "studentdata";
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("Select question from studentdata where collegeId = '"+name.getText()+"';");
					if(rs.next()) {
						question.setText(rs.getString("question"));
						panel3.add(user_icon);
						panel3.add(back);
						panel3.setVisible(true);
						panel2.setVisible(false);
						panel4.setVisible(false);
					}
					else
					{
						nameRequired.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					
				}
			}
			if("Librarian".equals(signUp_as.getSelectedItem())) {
				try {
					who = "librariandata";
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("Select question from librariandata where collegeId = '"+name.getText()+"'");
					if(rs.next()) {
						question.setText(rs.getString("question"));
						panel3.add(user_icon);
						panel3.add(back);
						panel3.setVisible(true);
						panel2.setVisible(false);
						panel4.setVisible(false);
					}
					else
					{
						nameRequired.setText("Wrong Input");
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
