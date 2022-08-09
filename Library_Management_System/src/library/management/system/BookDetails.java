package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;

public class BookDetails {
	
	private static BookDetails singleInstance;
	public static BookDetails getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new BookDetails();
		}
		singleInstance.book();
		return singleInstance;
	}
	
	private JPanel page;	
	
    private JTable table;
    private JTextField search;
    private JButton searchButton,deleteButton;
	
	public JPanel getBookDetails()
	{
		return page;
	}
	
	private BookDetails (){
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

		searchButton = new JButton("Search");
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
		searchButton.setBounds(524, 89, 138, 33);
		wall.add(searchButton);

		deleteButton = new JButton("Delete");
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

		JLabel l1 = new JLabel("Book Details");
		l1.setForeground(new Color(16, 29, 37));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(350, 15, 400, 47);
		wall.add(l1);
	        
		search = new JTextField();
		search.setBackground(new Color(255, 240, 245));
		search.setBorder(new LineBorder(new Color(25, 105, 180), 2, true));
		search.setForeground(new Color(47, 79, 79));
		search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		search.setBounds(150, 89, 357, 33);
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchResult();
			}
		});
		wall.add(search);
		search.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(45, 54, 793, 530);
		wall.add(panel);
	        panel.setBackground(Color.WHITE);
	}
    
    private void book() {
    	search.setText("");
		try {
	            Conn con = new Conn();
	            String sql = "select * from book";
	            ResultSet rs = con.getStatement().executeQuery(sql);
	
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	            rs.close();
	            con.getStatement().close();
		} catch (Exception e) {
		
		}
    }
	private void searchResult() {
		try {
			Conn c = new Conn();
			ResultSet rs = c.getStatement().executeQuery("select * from book where concat(book_id, name) like '%"+search.getText()+"%'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            c.getConnection().close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops! Server Disconneted, Try again later");
		}

	}
	private void deleteResult() {
		if(!search.getText().isBlank()) { //************Checking if textfields is filled****************//
	        int row = table.getSelectedRow();
			String id = table.getModel().getValueAt(row, 0).toString();
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.getStatement().executeQuery("Select numOfBook from book where book_id = '"+id+"'");
				rs.next();
				int number1 = Integer.parseInt(rs.getString("numOfBook"));
				int number2 = 0;
				boolean flag = false;
				if(number1 > 1) { // ************Checking if it is one book there*****************//
					try {
						number2 = Integer.parseInt(JOptionPane.showInputDialog("How many number of this book you want to Delete? Current of this book "+rs.getString("numOfBook")));
						if(number2 <= number1) {
							flag = true;
						}
					}
					catch(NumberFormatException ne) {
						JOptionPane.showMessageDialog(null, "Wrong Value Entered");
					}
				}
				if(flag) { //*******Checking if input number is less than real number of books***********//
					
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
					if (response == JOptionPane.NO_OPTION) { //*******Checking if No button pressed********//

					}
					if (response == JOptionPane.YES_OPTION) {//*******Checking if Yes button pressed********//
						int number3 = number1 - number2;
						if(number3 == 0) {				//********Checking for total number of book delete*******//
							c.getStatement().executeUpdate("DELETE FROM book WHERE book_id = '"+id+"'");
								
							c.getStatement().close();
								
				            JOptionPane.showMessageDialog(null, "Deleted !!");
				            book();
						}
						else {	//********Checking for custom number of book delete*********//
							c.getStatement().executeUpdate("UPDATE book SET numOfBook= '"+number3+"' WHERE book_id = '"+id+"';");
								
							c.getStatement().close();
								
				            JOptionPane.showMessageDialog(null, "Deleted !!");
				            book();
						}
					}
				}
				else if(flag) { //*******Checking it is only one book there*******//
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (response == JOptionPane.NO_OPTION) { //*******Checking if No button pressed********//

					} 
					if (response == JOptionPane.YES_OPTION) { //*******Checking if Yes button pressed********//
							c.getStatement().executeUpdate("DELETE FROM book WHERE book_id = '"+id+"'");
							
							c.getStatement().close();
							
			                JOptionPane.showMessageDialog(null, "Deleted !!");
			                book();
		            } 
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Oops! Server Disconneted, Try again later");
			}
		}
		else //*******Checking if book which be deleted if selected or not********//
		{
			JOptionPane.showMessageDialog(null, "Select a Book first to delete");
		}
	}
}
