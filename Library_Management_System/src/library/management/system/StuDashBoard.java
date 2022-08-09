package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class StuDashBoard extends JFrame{
	
	private static StuDashBoard singleInstance;
	public static StuDashBoard getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new StuDashBoard();
		}
		singleInstance.getUserName();
		singleInstance.switchTab(1);
		return singleInstance;
	}
	
	private JLabel userName, issuedBookText = null, bookDetailText = null, stuDetailText = null;
	
	private JPanel page;
	
	private StuDashBoard() {
		
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
		
		bookDetailText = new JLabel("Book Details");
		bookDetailText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(1);
			}
		});
		bookDetailText.setBounds(0,125,300,125);
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
		
		issuedBookText = new JLabel("      Issued Book");
		issuedBookText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(2);
			}
		});
		issuedBookText.setBounds(0,250,300,125);
		issuedBookText.setForeground(Color.white);
		issuedBookText.setOpaque(true);
		issuedBookText.setBackground(null);
		issuedBookText.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
		issuedBookText.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(issuedBookText);
		
		ImageIcon issuedBookIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/addBook.png"));
		Image issuedBookIcon2 = issuedBookIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon issuedBookIcon3 = new ImageIcon(issuedBookIcon2);
		JLabel issuedBookIcon = new JLabel(issuedBookIcon3);
		issuedBookIcon.setBounds(10,0,300,125);
		issuedBookIcon.setHorizontalAlignment(SwingConstants.LEFT);
		issuedBookText.add(issuedBookIcon);
		
		stuDetailText = new JLabel("Your Details");
		stuDetailText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				switchTab(3);
			}
		});
		stuDetailText.setBounds(0,375,300,125);
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
			ResultSet rs = c.getStatement().executeQuery("Select name From studentdata where collegeId = '"+SignIn.getUserId()+"';");
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
			bookDetailText.setBackground(new Color(4,129,208));
			issuedBookText.setBackground(null);
			stuDetailText.setBackground(null);
			
			activateStuBookInfo();
		}
		if(num==2)
		{
			bookDetailText.setBackground(null);
			issuedBookText.setBackground(new Color(4,129,208));
			stuDetailText.setBackground(null);
			
			activateStuIssuedBook();
		}
		if(num==3)
		{
			bookDetailText.setBackground(null);
			issuedBookText.setBackground(null);
			stuDetailText.setBackground(new Color(4,129,208));
			
			activateStudentInfo();
		}
	}
	
	private void addPages() {
		page.add(StuBookInfo.getInstance().getStuBookInfo());
		page.add(StuStatistics.getInstance().getStuStatistics());
		page.add(StudentInfo.getInstance().getStudentInfo());
	}
	private void activateStuBookInfo() {
		StuBookInfo.getInstance().getStuBookInfo().setVisible(true);
		StuStatistics.getInstance().getStuStatistics().setVisible(false);
		StudentInfo.getInstance().getStudentInfo().setVisible(false);
	}
	private void activateStuIssuedBook() {
		StuBookInfo.getInstance().getStuBookInfo().setVisible(false);
		StuStatistics.getInstance().getStuStatistics().setVisible(true);
		StudentInfo.getInstance().getStudentInfo().setVisible(false);
	}
	private void activateStudentInfo() {
		StuBookInfo.getInstance().getStuBookInfo().setVisible(false);
		StuStatistics.getInstance().getStuStatistics().setVisible(false);
		StudentInfo.getInstance().getStudentInfo().setVisible(true);
	}
}
