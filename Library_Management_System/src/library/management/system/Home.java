package library.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Home {
	
	private static Home singleInstance;
	public static Home getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new Home();
		}
		return singleInstance;
	}
	
	private JPanel page;	
	
	public JPanel getHome()
	{
		return page;
	}
	
	Home (){
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
		
		JLabel issueBook = new JLabel("Issue Book");
		issueBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard.getInstance().switchTab(5);
			}
		});
		issueBook.setBounds(50, 200, 228, 228);
		issueBook.setOpaque(true);
		issueBook.setBackground(new Color(16, 29, 37));
		issueBook.setForeground(Color.white);
		issueBook.setBorder(new MatteBorder(0,0,25,0,new Color(16, 29, 37)));
		issueBook.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		issueBook.setHorizontalAlignment(SwingConstants.CENTER);
		issueBook.setVerticalAlignment(SwingConstants.BOTTOM);
		wall.add(issueBook);
		
		ImageIcon issueBookIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/issueBook.png"));
		Image issueBookIcon2 = issueBookIcon1.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon issueBookIcon3 = new ImageIcon(issueBookIcon2);
		JLabel issueBookIcon = new JLabel(issueBookIcon3);
		issueBookIcon.setBounds(0,0,228, 228);
		issueBookIcon.setHorizontalAlignment(SwingConstants.CENTER);
		issueBook.add(issueBookIcon);
		
		JLabel statistics = new JLabel("Staitistics");
		statistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard.getInstance().switchTab(6);
			}
		});
		statistics.setBounds(328, 200, 228, 228);
		statistics.setOpaque(true);
		statistics.setBackground(new Color(16, 29, 37));
		statistics.setForeground(Color.white);
		statistics.setBorder(new MatteBorder(0,0,25,0,new Color(16, 29, 37)));
		statistics.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		statistics.setHorizontalAlignment(SwingConstants.CENTER);
		statistics.setVerticalAlignment(SwingConstants.BOTTOM);
		wall.add(statistics);
		
		ImageIcon statisticIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/statistic.png"));
		Image statisticIcon2 = statisticIcon1.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		ImageIcon statisticIcon3 = new ImageIcon(statisticIcon2);
		JLabel statisticIcon = new JLabel(statisticIcon3);
		statisticIcon.setBounds(0,0,228, 228);
		statisticIcon.setHorizontalAlignment(SwingConstants.CENTER);
		statistics.add(statisticIcon);
		
		JLabel returnBook = new JLabel("Return Book");
		returnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard.getInstance().switchTab(7);
			}
		});
		returnBook.setBounds(606, 200, 228, 228);
		returnBook.setOpaque(true);
		returnBook.setBackground(new Color(16, 29, 37));
		returnBook.setForeground(Color.white);
		returnBook.setBorder(new MatteBorder(0,0,25,0,new Color(16, 29, 37)));
		returnBook.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		returnBook.setHorizontalAlignment(SwingConstants.CENTER);
		returnBook.setVerticalAlignment(SwingConstants.BOTTOM);
		wall.add(returnBook);
		
		ImageIcon returnBookIcon1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/returnbook.png"));
		Image returnBookIcon2 = returnBookIcon1.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon returnBookIcon3 = new ImageIcon(returnBookIcon2);
		JLabel returnBookIcon = new JLabel(returnBookIcon3);
		returnBookIcon.setBounds(0,0,228, 228);
		returnBookIcon.setHorizontalAlignment(SwingConstants.CENTER);
		returnBook.add(returnBookIcon);
	}

}
