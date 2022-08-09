package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;

public class StudentInfo implements ActionListener {
	
	private static StudentInfo singleInstance;
	public static StudentInfo getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new StudentInfo();
		}
		
		singleInstance.passwordData.setText("************");
		singleInstance.passButton.setText("Show Password");
		
		return singleInstance;
	}
	
	private JPanel page;	
	
	public JPanel getStudentInfo()
	{
		return page;
    }
	
	JLabel yourNameData, courseData, collegeIdData, stuPhoneData, parentPhoneData, questionData, answerData, passwordData;
	
	JButton passButton;
	
	private StudentInfo (){
		page = new JPanel();
		page.setBounds(0,0,1100,627);
		page.setLayout(null);

		ImageIcon wall1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Homebg.jpg"));
		Image wall2 = wall1.getImage().getScaledInstance(885 , 627, Image.SCALE_SMOOTH);
		ImageIcon wall3 = new ImageIcon(wall2);
		JLabel wall = new JLabel(wall3);
		wall.setBounds(0, 0, 885, 627);
		page.add(wall);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 50, 745, 530);
		panel.setBackground(new Color(0,0,0,170));
		panel.setOpaque(false);
		panel.setLayout(null);
		wall.add(panel);
		
		JLabel title = new JLabel("Student Information");
		title.setBounds(300,20,250,30);
		title.setFont(new Font("Tahoma", Font.BOLD , 22));
		panel.add(title);
		
		JLabel yourName = new JLabel("Your Name");
		yourName.setBounds(100,80,200,20);
		yourName.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(yourName);
		
		yourNameData = new JLabel();
		yourNameData.setBounds(350, 80, 340, 20);
		yourNameData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(yourNameData);
		
		JLabel course = new JLabel("Course");
		course.setBounds(100,130,200,20);
		course.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(course);
		
		courseData = new JLabel();
		courseData.setBounds(350, 130, 340, 20);
		courseData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(courseData);
		
		JLabel collegeId = new JLabel("College Id");
		collegeId.setBounds(100,170,200,20);
		collegeId.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(collegeId);
		
		collegeIdData = new JLabel();
		collegeIdData.setBounds(350, 170, 340, 20);
		collegeIdData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(collegeIdData);
		
		JLabel stuPhone = new JLabel("Student Phone");
		stuPhone.setBounds(100,210,200,20);
		stuPhone.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(stuPhone);
		
		stuPhoneData = new JLabel();
		stuPhoneData.setBounds(350, 210, 340, 20);
		stuPhoneData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(stuPhoneData);
		
		JLabel parentPhone = new JLabel("Parent's Phone");
		parentPhone.setBounds(100,250,200,20);
		parentPhone.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(parentPhone);
		
		parentPhoneData = new JLabel();
		parentPhoneData.setBounds(350, 250, 340, 20);
		parentPhoneData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(parentPhoneData);
		
		JLabel question = new JLabel("Security Question");
		question.setBounds(100,290,200,20);
		question.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(question);
		
		questionData = new JLabel();
		questionData.setBounds(350, 290, 340, 20);
		questionData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(questionData);
		
		JLabel answer = new JLabel("Security Answer");
		answer.setBounds(100,330,200,20);
		answer.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(answer);
		
		answerData = new JLabel();
		answerData.setBounds(350, 330, 340, 20);
		answerData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(answerData);
		
		JLabel password = new JLabel("Password");
		password.setBounds(100,370,200,20);
		password.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(password);
		
		passwordData = new JLabel("************");
		passwordData.setBounds(350, 370, 340, 20);
		passwordData.setFont(new Font("Tahoma", Font.BOLD , 18));
		panel.add(passwordData);
		
		passButton = new JButton("Show Password");
		passButton.setBounds(250, 450, 200, 40);
		passButton.setBackground(new Color(5,22,79));
		passButton.setFont(new Font("Tahoma", Font.BOLD , 14));
		passButton.setForeground(Color.white);
		passButton.addActionListener(this);
		panel.add(passButton);
		
		JPanel bg = new JPanel();
		bg.setBounds(0, 0, 745, 530);
		bg.setBackground(Color.white);
		bg.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Student Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		bg.setLayout(null);
		panel.add(bg);
		
		getStuData();
	}
	private void getStuData() {
		try {
			Conn c = new Conn();
			ResultSet rs = c.getStatement().executeQuery("Select * from studentdata where collegeId = '"+SignIn.getUserId()+"'");
			rs.next();
			
			yourNameData.setText(rs.getString(2));
			courseData.setText(rs.getString(3)); 
			collegeIdData.setText(rs.getString(4));
			stuPhoneData.setText(rs.getString(5));
			parentPhoneData.setText(rs.getString(6));
			questionData.setText(rs.getString(7));
			answerData.setText(rs.getString(8));
			
			c.getStatement().close();
			rs.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops! Server Disconnected Try Again Later");
		}
		
	}
	private void getPass() {
		try {
			Conn c = new Conn();
			ResultSet rs = c.getStatement().executeQuery("Select pass from studentdata where collegeId = '"+SignIn.getUserId()+"'");
			rs.next();
			
			passwordData.setText(rs.getString(1));
			
			c.getStatement().close();
			rs.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops! Server Disconnected Try Again Later");
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(passwordData.getText().equals("************")) {
			getPass();
			passButton.setText("Hide Password");
		}
		else {
			passwordData.setText("************");
			passButton.setText("Show Password");
		}
	}
}
