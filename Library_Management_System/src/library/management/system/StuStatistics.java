package library.management.system;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;

public class StuStatistics {
	
	private static StuStatistics singleInstance;
	public static StuStatistics getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new StuStatistics();
		}
		singleInstance.issueBook();
		singleInstance.returnBook();
		return singleInstance;
	}
	
	private JPanel page;	
	
	public JPanel getStuStatistics()
	{
		return page;
	}
    private JTable issueBookTable, returnBookTable;
	
	private StuStatistics() {

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

		JLabel l1 = new JLabel("Statistics");
		l1.setForeground(new Color(16, 29, 37));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(350, 10, 400, 30);
		wall.add(l1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 75, 771, 230);
		wall.add(scrollPane);

		issueBookTable = new JTable();
		issueBookTable.setBackground(new Color(224, 255, 255));
		issueBookTable.setForeground(new Color(128, 128, 0));
		issueBookTable.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		scrollPane.setViewportView(issueBookTable);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setForeground(new Color(0, 128, 128));
		panel.setBounds(45, 54, 793, 260);
	    panel.setBackground(Color.WHITE);
		wall.add(panel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 345, 771, 230);
		wall.add(scrollPane_1);

		returnBookTable = new JTable();
		returnBookTable.setBackground(new Color(204, 255, 255));
		returnBookTable.setForeground(new Color(153, 51, 0));
		returnBookTable.setFont(new Font("Sitka Small", Font.BOLD, 12));
		scrollPane_1.setViewportView(returnBookTable);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return-Book-Details",
			TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 102, 51)));
		panel_1.setBounds(45, 324, 793, 260);
	    panel_1.setBackground(Color.WHITE);
		wall.add(panel_1);
		
	}

    public void issueBook() {
		try {
	            Conn con =  new Conn();
	            String sql = "select book_id, bname, dateOfIssue from issueBook where student_id = '"+SignIn.getUserId()+"'";
	            PreparedStatement st = con.getConnection().prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	
	            issueBookTable.setModel(DbUtils.resultSetToTableModel(rs));
	
		} 
		catch (Exception e) {
				// TODO: handle exception
		}
    }

    public void returnBook() {
        try {
            Conn con = new Conn();
            String sql = "select book_id, bname, dateOfIssue, dateOfReturn from returnBook where student_id = '"+SignIn.getUserId()+"'";
            PreparedStatement st = con.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            returnBookTable.setModel(DbUtils.resultSetToTableModel(rs));
		} 
        catch (Exception e) {
				// TODO: handle exception
		}
    }
}
