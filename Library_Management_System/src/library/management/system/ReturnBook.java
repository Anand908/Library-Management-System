package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;

public class ReturnBook implements ActionListener {
	
	private static ReturnBook singleInstance;
	public static ReturnBook getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new ReturnBook();
		}
		singleInstance.refreshButton();
		return singleInstance;
	}
	
	private JPanel page;	
	private JTextField bookIdEntry, stuIdEntry, bookNameEntry, studentNameEntry, courseEntry, dateOfIssueEntry;
	private JButton search, returnBook, refresh;
    private JDateChooser dateChooser;
    private JLabel bookIdRequired, stuIdRequired;
	
	public JPanel getReturnBook()
	{
		return page;
	}
	
	private ReturnBook() {

		page = new JPanel();
		page.setBounds(0,0,885,627);
		page.setBackground(Color.white);
		page.setLayout(null);
		
		ImageIcon wall1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Homebg.jpg"));
		Image wall2 = wall1.getImage().getScaledInstance(885 , 627, Image.SCALE_SMOOTH);
		ImageIcon wall3 = new ImageIcon(wall2);
		JLabel wall = new JLabel(wall3);
		wall.setBounds(0, 0, 885, 627);
		page.add(wall);
		
		JLabel title = new JLabel("Return Book");
		title.setBounds(350, 35, 200, 30);
		title.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		wall.add(title);
		
		JLabel bookId = new JLabel("Book_id");
		bookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookId.setForeground(new Color(47, 79, 79));
		bookId.setBounds(200, 150, 100, 23);
		wall.add(bookId);

		bookIdEntry = new JTextField();
		bookIdEntry.setForeground(new Color(47, 79, 79));
		bookIdEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookIdEntry.setBounds(300, 150, 90, 30);
		bookIdRequired = new JLabel();
		bookIdRequired.setBounds(300, 182, 150, 13);
		bookIdRequired.setForeground(Color.red);
		wall.add(bookIdRequired);
		bookIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				bookIdRequired.setText("");
			}
		});
		wall.add(bookIdEntry);
		
		JLabel studentId = new JLabel("Student Id");
		studentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentId.setForeground(new Color(47, 79, 79));
		studentId.setBounds(400, 150, 100, 23);
		wall.add(studentId);

		stuIdEntry = new JTextField();
		stuIdEntry.setForeground(new Color(47, 79, 79));
		stuIdEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		stuIdEntry.setBounds(500, 150, 90, 30);
		stuIdRequired = new JLabel();
		stuIdRequired.setBounds(500, 182, 150, 13);
		stuIdRequired.setForeground(Color.red);
		wall.add(stuIdRequired);
		stuIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				stuIdRequired.setText("");
			}
		});
		wall.add(stuIdEntry);
		
		search = new JButton("Search");
		search.addActionListener(this);
		search.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		search.setBackground(new Color(5,22,79));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		search.setBounds(604, 150, 100, 30);
		wall.add(search);

		JLabel bookName = new JLabel("Book Name");
		bookName.setForeground(new Color(47, 79, 79));
		bookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookName.setBounds(200, 200, 200, 23);
		wall.add(bookName);

		bookNameEntry = new JTextField();
		bookNameEntry.setEditable(false);
		bookNameEntry.setForeground(new Color(47, 79, 79));
		bookNameEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookNameEntry.setBounds(380, 200, 208, 30);
		bookNameEntry.setColumns(10);
		wall.add(bookNameEntry);

		JLabel studentName = new JLabel("Student Name");
		studentName.setForeground(new Color(47, 79, 79));
		studentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentName.setBounds(200, 250, 200, 23);
		wall.add(studentName);

		studentNameEntry = new JTextField();
		studentNameEntry.setEditable(false);
		studentNameEntry.setForeground(new Color(47, 79, 79));
		studentNameEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		studentNameEntry.setBounds(380, 250, 208, 30);
		studentNameEntry.setColumns(10);
		wall.add(studentNameEntry);

		JLabel course = new JLabel("Course");
		course.setForeground(new Color(47, 79, 79));
		course.setFont(new Font("Tahoma", Font.BOLD, 14));
		course.setBounds(200, 300, 200, 23);
		wall.add(course);

		courseEntry = new JTextField();
		courseEntry.setEditable(false);
		courseEntry.setForeground(new Color(47, 79, 79));
		courseEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		courseEntry.setBounds(380, 300, 208, 30);
		courseEntry.setColumns(10);
		wall.add(courseEntry);

		JLabel dateOfIssue = new JLabel("Date Of Issue");
		dateOfIssue.setForeground(new Color(47, 79, 79));
		dateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateOfIssue.setBounds(200, 350, 200, 23);
		wall.add(dateOfIssue);

		dateOfIssueEntry = new JTextField();
		dateOfIssueEntry.setEditable(false);
		dateOfIssueEntry.setForeground(new Color(47, 79, 79));
		dateOfIssueEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		dateOfIssueEntry.setBounds(380, 350, 208, 30);
		dateOfIssueEntry.setColumns(10);
		wall.add(dateOfIssueEntry);

		JLabel dateOfReturn = new JLabel("Date Of Return");
		dateOfReturn.setForeground(new Color(47, 79, 79));
		dateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateOfReturn.setBounds(200, 400, 200, 23);
		wall.add(dateOfReturn);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(380, 400, 208, 30);
		((JTextField) dateChooser.getDateEditor().getUiComponent()).setEditable(false);
		wall.add(dateChooser);
		
		returnBook = new JButton("Return Book");
		returnBook.addActionListener(this);
		returnBook.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		returnBook.setBackground(new Color(5,22,79));
		returnBook.setForeground(Color.WHITE);
		returnBook.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		returnBook.setBounds(250, 480, 150, 30);
		wall.add(returnBook);
		
		refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		refresh.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		refresh.setBackground(new Color(5,22,79));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		refresh.setBounds(430, 480, 150, 30);
		wall.add(refresh);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 2, true), "Return-Panel",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.setBounds(45, 100, 793, 480);
	    panel.setBackground(Color.WHITE);
		wall.add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			int flag = 0;
			if(bookIdEntry.getText().isBlank()) {
				bookIdRequired.setText("Required Field !");
			}
			else {
				flag = flag +1;
			}
			if(stuIdEntry.getText().isBlank()) {
				stuIdRequired.setText("Required Field !");
			}
			else {
				flag = flag +1;
			}
			if(flag == 2) {
				try {
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("SELECT * FROM issuebook WHERE book_id = '"+bookIdEntry.getText()+"' and student_id = '"+stuIdEntry.getText()+"'");
					if(rs.next()) {
						bookIdEntry.setEditable(false);
						stuIdEntry.setEditable(false);
						bookNameEntry.setText(rs.getString("bname"));
						studentNameEntry.setText(rs.getString("sname"));
						courseEntry.setText(rs.getString("course"));
						dateOfIssueEntry.setText(rs.getString("dateOfIssue"));
					}
					else {
						JOptionPane.showMessageDialog(null, "There is some isuue. \nMake sure you have entered correct Book id and Student Id");
					}
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null, "Oops! Server Disconnected");
				}
			}	
		}
		if(ae.getSource() == returnBook) {
			if(!((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isBlank() && !bookNameEntry.getText().isBlank()) {
				String bookId = bookIdEntry.getText();
				String studentId = stuIdEntry.getText();
				String bookName = bookNameEntry.getText();
				String studentName = studentNameEntry.getText();
				String course = courseEntry.getText();
				String dateOfIssue = dateOfIssueEntry.getText();
				String returnDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("INSERT INTO returnbook VALUES ('"+bookId+"','"+studentId+"','"+bookName+"','"+studentName+"','"+course+"','"+dateOfIssue+"','"+returnDate+"');");
					
					c.getStatement().executeUpdate("DELETE FROM issuebook WHERE book_id = '"+bookIdEntry.getText()+"' and student_id = '"+stuIdEntry.getText()+"';");
					
					ResultSet rs = c.getStatement().executeQuery("select numOfBook from book where book_id = '"+bookId+"'");
					rs.next();
					int num = Integer.parseInt(rs.getString("numOfBook"));
					num = num+1;
					c.getStatement().executeUpdate("UPDATE book SET numOfBook = '"+num+"' WHERE book_id = '"+bookId+"'");
					
					JOptionPane.showMessageDialog(null, "Congrates! Book Returned Successfully");
					
					refreshButton();
				}
				catch(Exception e) {
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Make Sure You have field using Search Button");
				if(bookIdEntry.getText().isBlank()) {
					bookIdRequired.setText("Required Field !");
				}
				if(stuIdEntry.getText().isBlank()) {
					stuIdRequired.setText("Required Field !");
				}
				if(((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Select Date also");
				}
			}
		}
		if(ae.getSource() == refresh) {
			refreshButton();
		}
	}
	private void refreshButton() {
		bookIdEntry.setEditable(true);
		stuIdEntry.setEditable(true);
		
		bookIdRequired.setText("");
		stuIdRequired.setText("");
		
		bookIdEntry.setText("");
		stuIdEntry.setText("");
		bookNameEntry.setText("");
		studentNameEntry.setText("");
		courseEntry.setText("");
		dateOfIssueEntry.setText("");
		((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");

	}
	
}
