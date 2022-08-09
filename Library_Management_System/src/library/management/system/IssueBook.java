package library.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class IssueBook implements ActionListener {
	
	private static IssueBook singleInstance;
	public static IssueBook getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new IssueBook();
		}
		singleInstance.refreshButton();
		return singleInstance;
	}
	
	private JPanel page;
	private JTextField bookIdEntry, bookNameEntry, isbnEntry, publisherEntry, editionEntry, priceEntry, pagesEntry, stuIdEntry, stuNameEntry, courseEntry, stuPhoneEntry, parentPhoneEntry;
	private JButton bookSearch, studentSearch, issueBook, refresh;
    private JDateChooser dateChooser;
    private JLabel bookIdRequired, stuIdRequired;

	private int bookNumber = 0;
	
	public JPanel getIssueBook()
	{
		return page;
	}
	
	private IssueBook() {

		page = new JPanel();
		page.setBounds(0,0,885,627);
		page.setBackground(Color.white);
		page.setLayout(null);
		
		ImageIcon wall1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Homebg.jpg"));
		Image wall2 = wall1.getImage().getScaledInstance(885 , 627, Image.SCALE_SMOOTH);
		ImageIcon wall3 = new ImageIcon(wall2);
		JLabel wall = new JLabel(wall3);
		wall.setBounds(0, 0, 885, 627);
		wall.setLayout(null);
		page.add(wall);
		
		JLabel bookId = new JLabel("Book_id");
		bookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookId.setForeground(new Color(47, 79, 79));
		bookId.setBounds(100, 150, 100, 23);
		wall.add(bookId);

		bookIdEntry = new JTextField();
		bookIdEntry.setForeground(new Color(47, 79, 79));
		bookIdEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookIdEntry.setBounds(200, 150, 90, 30);
		bookIdRequired = new JLabel();
		bookIdRequired.setBounds(200, 182, 150, 13);
		bookIdRequired.setForeground(Color.red);
		wall.add(bookIdRequired);
		bookIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				bookIdRequired.setText("");
			}
		});
		wall.add(bookIdEntry);
		
		bookSearch = new JButton("Search");
		bookSearch.addActionListener(this);
		bookSearch.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		bookSearch.setBackground(new Color(5,22,79));
		bookSearch.setForeground(Color.WHITE);
		bookSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookSearch.setBounds(304, 150, 100, 30);
		wall.add(bookSearch);

		JLabel name = new JLabel("Book Name");
		name.setForeground(new Color(47, 79, 79));
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(100, 200, 100, 23);
		wall.add(name);

		bookNameEntry = new JTextField();
		bookNameEntry.setEditable(false);
		bookNameEntry.setForeground(new Color(47, 79, 79));
		bookNameEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookNameEntry.setBounds(200, 200, 208, 30);
		bookNameEntry.setColumns(10);
		wall.add(bookNameEntry);

		JLabel isbn = new JLabel("ISBN");
		isbn.setForeground(new Color(47, 79, 79));
		isbn.setFont(new Font("Tahoma", Font.BOLD, 14));
		isbn.setBounds(100, 250, 100, 23);
		wall.add(isbn);

		isbnEntry = new JTextField();
		isbnEntry.setEditable(false);
		isbnEntry.setForeground(new Color(47, 79, 79));
		isbnEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		isbnEntry.setBounds(200, 250, 208, 30);
		isbnEntry.setColumns(10);
		wall.add(isbnEntry);

		JLabel publisher = new JLabel("Publisher");
		publisher.setForeground(new Color(47, 79, 79));
		publisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		publisher.setBounds(100, 300, 100, 23);
		wall.add(publisher);

		publisherEntry = new JTextField();
		publisherEntry.setEditable(false);
		publisherEntry.setForeground(new Color(47, 79, 79));
		publisherEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		publisherEntry.setBounds(200, 300, 208, 30);
		publisherEntry.setColumns(10);
		wall.add(publisherEntry);

		JLabel edition = new JLabel("Edition");
		edition.setForeground(new Color(47, 79, 79));
		edition.setFont(new Font("Tahoma", Font.BOLD, 14));
		edition.setBounds(100, 350, 100, 23);
		wall.add(edition);

		editionEntry = new JTextField();
		editionEntry.setEditable(false);
		editionEntry.setForeground(new Color(47, 79, 79));
		editionEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		editionEntry.setBounds(200, 350, 208, 30);
		editionEntry.setColumns(10);
		wall.add(editionEntry);

		JLabel price = new JLabel("Price");
		price.setForeground(new Color(47, 79, 79));
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		price.setBounds(100, 400, 100, 23);
		wall.add(price);

		priceEntry = new JTextField();
		priceEntry.setEditable(false);
		priceEntry.setForeground(new Color(47, 79, 79));
		priceEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		priceEntry.setBounds(200, 400, 208, 30);
		priceEntry.setColumns(10);
		wall.add(priceEntry);

		JLabel pages = new JLabel("Pages");
		pages.setForeground(new Color(47, 79, 79));
		pages.setFont(new Font("Tahoma", Font.BOLD, 14));
		pages.setBounds(100, 450, 100, 23);
		wall.add(pages);

		pagesEntry = new JTextField();
		pagesEntry.setEditable(false);
		pagesEntry.setForeground(new Color(47, 79, 79));
		pagesEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		pagesEntry.setBounds(200, 450, 208, 30);
		pagesEntry.setColumns(10);
		wall.add(pagesEntry);
		
		JLabel title = new JLabel("Isuue Book");
		title.setBounds(350, 20, 200, 30);
		title.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		wall.add(title);
		
		JPanel bookpanel = new JPanel();
		bookpanel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Book-Details",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		bookpanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookpanel.setBounds(50, 80, 391, 480);
		bookpanel.setBackground(Color.WHITE);
		wall.add(bookpanel);
		
		JLabel studentId = new JLabel("Student Id");
		studentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentId.setForeground(new Color(47, 79, 79));
		studentId.setBounds(470, 150, 100, 23);
		wall.add(studentId);

		stuIdEntry = new JTextField();
		stuIdEntry.setForeground(new Color(47, 79, 79));
		stuIdEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		stuIdEntry.setBounds(600, 150, 90, 30);
		stuIdRequired = new JLabel();
		stuIdRequired.setBounds(600, 182, 150, 13);
		stuIdRequired.setForeground(Color.red);
		wall.add(stuIdRequired);
		stuIdEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				stuIdRequired.setText("");
			}
		});
		wall.add(stuIdEntry);
		
		studentSearch = new JButton("Search");
		studentSearch.addActionListener(this);
		studentSearch.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		studentSearch.setBackground(new Color(5,22,79));
		studentSearch.setForeground(Color.WHITE);
		studentSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		studentSearch.setBounds(704, 150, 100, 30);
		wall.add(studentSearch);

		JLabel studentName = new JLabel("Student Name");
		studentName.setForeground(new Color(47, 79, 79));
		studentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentName.setBounds(470, 200, 100, 23);
		wall.add(studentName);

		stuNameEntry = new JTextField();
		stuNameEntry.setEditable(false);
		stuNameEntry.setForeground(new Color(47, 79, 79));
		stuNameEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		stuNameEntry.setBounds(600, 200, 208, 30);
		stuNameEntry.setColumns(10);
		wall.add(stuNameEntry);

		JLabel course = new JLabel("Class");
		course.setForeground(new Color(47, 79, 79));
		course.setFont(new Font("Tahoma", Font.BOLD, 14));
		course.setBounds(470, 250, 100, 23);
		wall.add(course);

		courseEntry = new JTextField();
		courseEntry.setEditable(false);
		courseEntry.setForeground(new Color(47, 79, 79));
		courseEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		courseEntry.setBounds(600, 250, 208, 30);
		courseEntry.setColumns(10);
		wall.add(courseEntry);

		JLabel studentPhone = new JLabel("Student Phone");
		studentPhone.setForeground(new Color(47, 79, 79));
		studentPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentPhone.setBounds(470, 300, 120, 23);
		wall.add(studentPhone);

		stuPhoneEntry = new JTextField();
		stuPhoneEntry.setEditable(false);
		stuPhoneEntry.setForeground(new Color(47, 79, 79));
		stuPhoneEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		stuPhoneEntry.setBounds(600, 300, 208, 30);
		stuPhoneEntry.setColumns(10);
		wall.add(stuPhoneEntry);

		JLabel parentPhone = new JLabel("Parent Phone");
		parentPhone.setForeground(new Color(47, 79, 79));
		parentPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		parentPhone.setBounds(470, 350, 100, 23);
		wall.add(parentPhone);

		parentPhoneEntry = new JTextField();
		parentPhoneEntry.setEditable(false);
		parentPhoneEntry.setForeground(new Color(47, 79, 79));
		parentPhoneEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		parentPhoneEntry.setBounds(600, 350, 208, 30);
		parentPhoneEntry.setColumns(10);
		wall.add(parentPhoneEntry);

		JLabel issueDate = new JLabel("Issue Date");
		issueDate.setForeground(new Color(207, 79, 79));
		issueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		issueDate.setBounds(470, 400, 100, 23);
		wall.add(issueDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(600, 400, 200, 29);
		((JTextField) dateChooser.getDateEditor().getUiComponent()).setEditable(false);
		wall.add(dateChooser);
		
		issueBook = new JButton("Issue Book");
		issueBook.addActionListener(this);
		issueBook.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		issueBook.setBackground(new Color(5,22,79));
		issueBook.setForeground(Color.WHITE);
		issueBook.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		issueBook.setBounds(490, 480, 130, 30);
		wall.add(issueBook);
		
		refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		refresh.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		refresh.setBackground(new Color(5,22,79));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		refresh.setBounds(650, 480, 130, 30);
		wall.add(refresh);

		JPanel studentPanel = new JPanel();
		studentPanel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student-Details",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		studentPanel.setForeground(new Color(0, 100, 0));
		studentPanel.setBounds(450, 80, 391, 480);
		studentPanel.setBackground(Color.WHITE);
	    wall.add(studentPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int flag = 0;
		if(ae.getSource() == bookSearch) {
			if(bookIdEntry.getText().isBlank()) {
				bookIdRequired.setText("Required Field !");
			}
			else {
				flag = flag +1;
				try {
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("Select * from book where book_id = '"+bookIdEntry.getText()+"'");
					if(rs.next()) {
						bookNumber = Integer.parseInt(rs.getString("numOfBook"));
						if(bookNumber > 0) {
							bookIdEntry.setEditable(false);
							bookNameEntry.setText(rs.getString("name"));
							isbnEntry.setText(rs.getString("isbn"));
							publisherEntry.setText(rs.getString("publisher"));
							editionEntry.setText(rs.getString("edition"));
							priceEntry.setText(rs.getString("price"));
							pagesEntry.setText(rs.getString("pages"));
						}
						else {
							JOptionPane.showMessageDialog(null, "Oops! "+rs.getString("name")+" book is not available. \nSomebody have taken before");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "There is no such book available");
					}
				}
				catch(Exception e) {
					
				}
			}
		}
		if(ae.getSource() == studentSearch) {
			if(stuIdEntry.getText().isBlank()) {
				stuIdRequired.setText("Required Field !");
			}
			else {
				flag = flag +1;
				try {
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("Select * from studentdata where collegeId = '"+stuIdEntry.getText()+"'");
					if(rs.next()) {
						stuIdEntry.setEditable(false);
						stuNameEntry.setText(rs.getString("name"));
						courseEntry.setText(rs.getString("course"));
						stuPhoneEntry.setText(rs.getString("stuPhone"));
						parentPhoneEntry.setText(rs.getString("parentPhone"));
					}
					else {
						JOptionPane.showMessageDialog(null, "There is no such Student available");
					}
				}
				catch(Exception e) {
					
				}
			}
		}
		if(ae.getSource() == issueBook) {
			
			if(!((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isBlank()  && !bookNameEntry.getText().isBlank() && !stuNameEntry.getText().isBlank()) {
			
				boolean flag2 = true;
				
				try {
					Conn c = new Conn();
					ResultSet rs = c.getStatement().executeQuery("Select book_id, student_id from issuebook where student_id = '"+stuIdEntry.getText()+"';");
					int a = 0;
					while(rs.next()) {
						if(rs.getString("book_id").equals(bookIdEntry.getText()) && rs.getString("student_id").equals(stuIdEntry.getText())) {
							flag2 =  false;
							JOptionPane.showMessageDialog(null, "This Student has already taken this book before");
						}
						a = a + 1;
						if(a == 2) {
							flag2 = false;
							JOptionPane.showMessageDialog(null, "This Student has already taken two book before. \nAnd Three books shouldn't issue as per terms and conditions");
						}
					}
				}
				catch(Exception e) {
					
				}
				if(flag2 == true) {
					String bookId = bookIdEntry.getText();
					String studentId = stuIdEntry.getText();
					String bookName = bookNameEntry.getText();
					String studentName = stuNameEntry.getText();
					String course = courseEntry.getText();
					String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
					
					bookNumber = bookNumber - 1;
					
					try {
						Conn c = new Conn();
						c.getStatement().executeUpdate("INSERT INTO issuebook VALUES ('"+bookId+"','"+studentId+"','"+bookName+"','"+studentName+"','"+course+"', '"+date+"');");
						JOptionPane.showMessageDialog(null, "Book Isuued Happy Learning");
						
						c.getStatement().executeUpdate("UPDATE book SET numOfBook = '"+bookNumber+"' WHERE book_id = '"+bookId+"'");

						refreshButton();
					}
					catch(Exception e) {
						e.printStackTrace();
						
					}
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
		bookIdEntry.setText("");
		bookNameEntry.setText("");
		isbnEntry.setText("");
		publisherEntry.setText("");
		editionEntry.setText("");
		priceEntry.setText("");
		pagesEntry.setText("");
		
		bookIdRequired.setText("");
		stuIdRequired.setText("");
		
		stuIdEntry.setEditable(true);
		stuIdEntry.setText("");
		stuNameEntry.setText("");
		courseEntry.setText("");
		stuPhoneEntry.setText("");
		parentPhoneEntry.setText("");
		((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");
	}
	
}
