package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;

public class StudentDetail {
	
	private static StudentDetail singleInstance;
	public static StudentDetail getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new StudentDetail();
		}
		singleInstance.student();
		return singleInstance;
	}
	
	private JPanel page;	
	
	public JPanel getStudentDetail()
	{
		return page;
	}

    private JTable table;
    private JTextField search;
    
	StudentDetail (){
		page = new JPanel();
		page.setBounds(0,0,1100,627);
		page.setLayout(null);
		
		ImageIcon wall1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Homebg.jpg"));
		Image wall2 = wall1.getImage().getScaledInstance(885 , 627, Image.SCALE_SMOOTH);
		ImageIcon wall3 = new ImageIcon(wall2);
		JLabel wall = new JLabel(wall3);
		wall.setBounds(0, 0, 885, 627);
		page.add(wall);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 133, 771, 435);
		wall.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                int row = table.getSelectedRow();
	                search.setText(table.getModel().getValueAt(row, 1).toString());
	            }
		});
		table.setBackground(new Color(240, 248, 255));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				searchResult();
			}
		});
		searchButton.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
		searchButton.setBackground(new Color(5,22,79));
		searchButton.setForeground(Color.white);
		searchButton.setBounds(524, 89, 138, 33);
		wall.add(searchButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				deleteResult();
			}
		});
		deleteButton.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
		deleteButton.setBackground(new Color(5,22,79));
		deleteButton.setForeground(Color.white);
		deleteButton.setBounds(670, 89, 138, 33);
		wall.add(deleteButton);

		JLabel l1 = new JLabel("Student Details");
		l1.setForeground(new Color(16, 29, 37));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(350, 15, 400, 47);
		wall.add(l1);


		search = new JTextField();
		search.setBackground(new Color(255, 240, 245));
		search.setBorder(new LineBorder(new Color(5,22,79), 2, true));
		search.setForeground(new Color(47, 79, 79));
		search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		search.setBounds(150, 89, 357, 33);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchResult();
			}
		});
		wall.add(search);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
		panel.setBounds(45, 54, 793, 530);
	    panel.setBackground(Color.WHITE);
		wall.add(panel);
	}
	private void student() {
    	search.setText("");
        try {
            Conn con = new Conn();
            String sql = "select SR,Name,Course,CollegeId,StuPhone, ParentPhone from studentdata";
            ResultSet rs = con.getStatement().executeQuery(sql);

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            con.getConnection().close();
        } catch (Exception e) {

        }
    }
	private void searchResult() {
		try {
			Conn c = new Conn();
			ResultSet rs = c.getStatement().executeQuery("select SR,Name,Course,CollegeId,StuPhone, ParentPhone from studentdata where concat(name, collegeId, course) like '%"+search.getText()+"%'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            c.getConnection().close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops! Server Disconneted, Try again later");
		}

	}
	private void deleteResult() {
		if(!search.getText().isBlank()) {
	        int row = table.getSelectedRow();
			String id = table.getModel().getValueAt(row, 3).toString();
			
			int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (response == JOptionPane.NO_OPTION) {

			} 
			if (response == JOptionPane.YES_OPTION) {
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("DELETE FROM studentdata WHERE CollegeId = '"+id+"'");
					
					c.getStatement().close();
					
	                JOptionPane.showMessageDialog(null, "Deleted !!");
	                student();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Oops! Server Disconneted, Try again later");
				}
            } 
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select a Student first to delete");
		}
	}
		
}
