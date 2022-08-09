package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class DashBoard extends JFrame{
	
	private static DashBoard singleInstance;
	public static DashBoard getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new DashBoard();
		}
		singleInstance.getUserName();
		singleInstance.switchTab(1);
		return singleInstance;
	}
	
	private JLabel userName, homeText, addBookText = null, bookDetailText = null, stuDetailText = null;
	
	private JPanel page;
	
	private DashBoard() {
		
		JPanel navBar = new JPanel();
		navBar.setBounds(0, 0, 1185, 70);
		navBar.setBackground(new Color(4,129,208));
		navBar.setLayout(null);
		this.add(navBar);
		
		JLabel title = new JLabel("Library Management System");
		title.setBounds(40, 15, 500, 40);
		title.setForeground(Color.white);
		title.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
		navBar.add(title);
		
		userName = new JLabel();
		userName.setBounds(750, 25, 250, 20);
		userName.setForeground(Color.white);
		userName.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
		navBar.add(userName);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(1050,16,100,40);
		logout.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
		logout.setBackground(new Color(5,22,79));
		logout.setForeground(Color.white);
		logout.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent ae) {
				SignIn.getInstance().setVisible(true);
				dispose();
			}
			
		});
		navBar.add(logout);
		
		JPanel sideBar = new JPanel();
		sideBar.setBounds(0, 70, 300, 627);
		sideBar.setBackground(new Color(16, 29, 37));
		sideBar.setLayout(null);
		this.add(sideBar);
		
		JLabel menu = new JLabel("MENU BUTTONS");
		menu.setBounds(0,0,300,125);
		menu.setForeground(Color.white);
		menu.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(menu);
		
		homeText = new JLabel("Home");
		homeText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(1);
			}
		});
		homeText.setBounds(0,125,300,125);
		homeText.setForeground(Color.white);
		homeText.setOpaque(true);
		homeText.setBackground(null);
		homeText.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
		homeText.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(homeText);
		
		ImageIcon homeIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/homeicon.png"));
		Image homeIcon2 = homeIcon1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon homeIcon3 = new ImageIcon(homeIcon2);
		JLabel homeIcon = new JLabel(homeIcon3);
		homeIcon.setBounds(10,0,300,125);
		homeIcon.setHorizontalAlignment(SwingConstants.LEFT);
		homeText.add(homeIcon);
		
		addBookText = new JLabel("Add Book");
		addBookText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(2);
			}
		});
		addBookText.setBounds(0,250,300,125);
		addBookText.setForeground(Color.white);
		addBookText.setOpaque(true);
		addBookText.setBackground(null);
		addBookText.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
		addBookText.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(addBookText);
		
		ImageIcon addBookIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/addBook.png"));
		Image addBookIcon2 = addBookIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon addBookIcon3 = new ImageIcon(addBookIcon2);
		JLabel addBookIcon = new JLabel(addBookIcon3);
		addBookIcon.setBounds(10,0,300,125);
		addBookIcon.setHorizontalAlignment(SwingConstants.LEFT);
		addBookText.add(addBookIcon);
		
		bookDetailText = new JLabel("Book Details");
		bookDetailText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(3);
			}
		});
		bookDetailText.setBounds(0,375,300,125);
		bookDetailText.setForeground(Color.white);
		bookDetailText.setOpaque(true);
		bookDetailText.setBackground(null);
		bookDetailText.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
		bookDetailText.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(bookDetailText);
		
		ImageIcon bookDetailIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/bookDetails.png"));
		Image bookDetailIcon2 = bookDetailIcon1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon bookDetailIcon3 = new ImageIcon(bookDetailIcon2);
		JLabel bookDetailIcon = new JLabel(bookDetailIcon3);
		bookDetailIcon.setBounds(10,0,300,125);
		bookDetailIcon.setHorizontalAlignment(SwingConstants.LEFT);
		bookDetailText.add(bookDetailIcon);
		
		stuDetailText = new JLabel("Student Details");
		stuDetailText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(4);
			}
		});
		stuDetailText.setBounds(0,500,300,125);
		stuDetailText.setForeground(Color.white);
		stuDetailText.setOpaque(true);
		stuDetailText.setBackground(null);
		stuDetailText.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
		stuDetailText.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(stuDetailText);
		
		ImageIcon stuDetailIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/stuinfo.png"));
		Image stuDetailIcon2 = stuDetailIcon1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon stuDetailIcon3 = new ImageIcon(stuDetailIcon2);
		JLabel stuDetailIcon = new JLabel(stuDetailIcon3);
		stuDetailIcon.setBounds(10,0,300,125);
		stuDetailIcon.setHorizontalAlignment(SwingConstants.LEFT);
		stuDetailText.add(stuDetailIcon);
		
		switchTab(1);
		
		page = new JPanel();
		page.setBounds(300,70,885,627);
		page.setBackground(Color.white);
		page.setLayout(null);
		this.add(page);
		addPages();
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/favicon.png"));
		this.setIconImage(icon.getImage());
		
		this.setTitle("Library Management System");
		this.setSize(1200,736);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
	}
	private void getUserName() {
		try {
			Conn c = new Conn();
			ResultSet rs = c.getStatement().executeQuery("Select name From librariandata where collegeId = '"+SignIn.getUserId()+"';");
			if(rs.next()) {
				userName.setText("Welcome : "+rs.getString("name"));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops! Server Disconneted, Try again later");
		}
	}
	
	public void switchTab(int num) {
		if(num==1)
		{
			homeText.setBackground(new Color(4,129,208));
			addBookText.setBackground(null);
			bookDetailText.setBackground(null);
			stuDetailText.setBackground(null);
			
			activateHome();
		}
		if(num==2)
		{
			homeText.setBackground(null);
			addBookText.setBackground(new Color(4,129,208));
			bookDetailText.setBackground(null);
			stuDetailText.setBackground(null);
			
			activateAddBook();
		}
		if(num==3)
		{
			homeText.setBackground(null);
			addBookText.setBackground(null);
			bookDetailText.setBackground(new Color(4,129,208));
			stuDetailText.setBackground(null);
			
			activateBookDetails();
		}
		if(num==4)
		{
			homeText.setBackground(null);
			addBookText.setBackground(null);
			bookDetailText.setBackground(null);
			stuDetailText.setBackground(new Color(4,129,208));
			
			activateStudentDetail();
		}
		if(num==5) {
			activateIssueBook();
		}
		if(num==6) {
			activateStatistics();
		}
		if(num==7) {
			activateReturnBook();
		}
	}
	
	private void addPages() {
		page.add(Home.getInstance().getHome());
		page.add(AddBook.getInstance().getAddBook());
		page.add(BookDetails.getInstance().getBookDetails());
		page.add(StudentDetail.getInstance().getStudentDetail());
		
		/***********Home Pages****************/
		
		page.add(IssueBook.getInstance().getIssueBook());
		page.add(Statistics.getInstance().getStatistics());
		page.add(ReturnBook.getInstance().getReturnBook());
	}
	private void activateHome() {
		Home.getInstance().getHome().setVisible(true);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateAddBook() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(true);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateBookDetails() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(true);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateStudentDetail() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(true);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateIssueBook() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(true);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateStatistics() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(true);
		ReturnBook.getInstance().getReturnBook().setVisible(false);
	}
	private void activateReturnBook() {
		Home.getInstance().getHome().setVisible(false);
		AddBook.getInstance().getAddBook().setVisible(false);
		BookDetails.getInstance().getBookDetails().setVisible(false);
		StudentDetail.getInstance().getStudentDetail().setVisible(false);
		
		IssueBook.getInstance().getIssueBook().setVisible(false);
		Statistics.getInstance().getStatistics().setVisible(false);
		ReturnBook.getInstance().getReturnBook().setVisible(true);
	}
}
