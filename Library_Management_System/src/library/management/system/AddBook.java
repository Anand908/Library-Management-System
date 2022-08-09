package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddBook implements ActionListener {
	
	/*******Single Instance********/
	
	private static AddBook singleInstance;
	public static AddBook getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance = new AddBook();
		}
		singleInstance.random();
		singleInstance.refresh();
		return singleInstance;
	}
	/******Getting AddBook panel*******/
	private JPanel page;	
	
	public JPanel getAddBook()
	{
		return page;
    }
	
	private JTextField bookIdEntry, numOfBookEntry, bookNameEntry, isbnEntry, publisherEntry, priceEntry, pagesEntry;
	
	private JComboBox editionEntry;
	
	private JLabel bookNameRequired, isbnRequired, publisherRequired, priceRequired, pagesRequired, numOfBookRequired; 
	
	private JButton submit;
	
	//*********Constructor***********//
	
	private AddBook (){
		page = new JPanel(); //********Main Panel which is to be added in tha dashboard frame*********//
		page.setBounds(0,0,1100,627);
		page.setLayout(null);

		ImageIcon wall1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/Homebg.jpg"));
		Image wall2 = wall1.getImage().getScaledInstance(885 , 627, Image.SCALE_SMOOTH);
		ImageIcon wall3 = new ImageIcon(wall2);
		JLabel wall = new JLabel(wall3);
		wall.setBounds(0, 0, 885, 627);
		page.add(wall);					//*****Background Images on panel*****//
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 50, 745, 530);		//*****Panel, on which form added******//
		panel.setBackground(new Color(0,0,0,170));
		panel.setOpaque(false);
		panel.setLayout(null);
		wall.add(panel);
		
		JLabel title = new JLabel("Add Book");   //******Title heading******//
		title.setBounds(300,20,200,30);
		title.setFont(new Font("Tahoma", Font.BOLD , 22));
		panel.add(title);
		
		JLabel bookId = new JLabel("Book Id");		//******Book Id Label******//
		bookId.setBounds(70,87,120,12);
		bookId.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(bookId);
		
		bookIdEntry = new JTextField(); 			//******Book Id Entry field******//
		bookIdEntry.setBounds(200, 80, 340, 28);
		bookIdEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		bookIdEntry.setEditable(false);
		panel.add(bookIdEntry);
		
		JLabel bookName = new JLabel("Book Name");	//******Book Name Label******//
		bookName.setBounds(70,132,120,12);
		bookName.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(bookName);
		
		bookNameEntry = new JTextField();			//****Book Name Entry Field****//
		bookNameEntry.setBounds(200, 130, 340, 28);
		bookNameEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		bookNameRequired = new JLabel();
		bookNameRequired.setBounds(560, 130, 150, 20);
		bookNameRequired.setForeground(Color.red);
		bookNameRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(bookNameRequired);
		bookNameEntry.addKeyListener(new KeyAdapter() {			//****Required Label for book name entry field*****//
			public void keyPressed(KeyEvent e) {
				bookNameRequired.setText("");
			}
		});
		panel.add(bookNameEntry);
		
		JLabel isbn = new JLabel("Book ISBN");		//*****Book ISBN Label*****//
		isbn.setBounds(70,172,120,12);
		isbn.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(isbn);
		
		isbnEntry = new JTextField();				//*****Boook ISBN Entry field*****//
		isbnEntry.setBounds(200, 170, 340, 28);
		isbnEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		isbnRequired = new JLabel();
		isbnRequired.setBounds(560, 170, 150, 20);		//*****Required label Boook ISBN*****//
		isbnRequired.setForeground(Color.red);
		isbnRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(isbnRequired);
		isbnEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				isbnRequired.setText("");
			}
		});
		panel.add(isbnEntry);
		
		JLabel publisher = new JLabel("Publisher");
		publisher.setBounds(70,212,120,12);
		publisher.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(publisher);
		
		publisherEntry = new JTextField();
		publisherEntry.setBounds(200, 210, 340, 28);
		publisherEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		publisherRequired = new JLabel();
		publisherRequired.setBounds(560, 210, 150, 20);
		publisherRequired.setForeground(Color.red);
		publisherRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(publisherRequired);
		publisherEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				publisherRequired.setText("");
			}
		});
		panel.add(publisherEntry);
		
		JLabel edition = new JLabel("Edition");
		edition.setBounds(70,252,120,12);
		edition.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(edition);
		
		String [] editionNum = {"1","2","3","4","5","6","7","8","9"};
		
		editionEntry = new JComboBox(editionNum);
		editionEntry.setBounds(200, 250, 340, 28);
		editionEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		panel.add(editionEntry);
		
		JLabel price = new JLabel("Price");
		price.setBounds(70,292,120,12);
		price.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(price);
		
		priceEntry = new JTextField();
		priceEntry.setBounds(200, 290, 340, 28);
		priceEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		priceRequired = new JLabel();
		priceRequired.setBounds(560, 290, 150, 20);
		priceRequired.setForeground(Color.red);
		priceRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(priceRequired);
		priceEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				priceRequired.setText("");
			}
		});
		panel.add(priceEntry);
		
		JLabel pages = new JLabel("Pages");
		pages.setBounds(70,332,120,12);
		pages.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(pages);
		
		pagesEntry = new JTextField();
		pagesEntry.setBounds(200, 330, 340, 28);
		pagesEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		pagesRequired = new JLabel();
		pagesRequired.setBounds(560, 330, 150, 20);
		pagesRequired.setForeground(Color.red);
		pagesRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(pagesRequired);
		pagesEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				pagesRequired.setText("");
			}
		});
		panel.add(pagesEntry);
		
		JLabel numOfBook = new JLabel("Number Of Book");
		numOfBook.setBounds(70,372,120,12);
		numOfBook.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(numOfBook);
		
		numOfBookEntry = new JTextField();
		numOfBookEntry.setBounds(200, 370, 340, 28);
		numOfBookEntry.setFont(new Font("Tahoma", Font.BOLD , 12));
		numOfBookRequired = new JLabel();
		numOfBookRequired.setBounds(560, 370, 150, 20);
		numOfBookRequired.setForeground(Color.red);
		numOfBookRequired.setFont(new Font("Tahoma", Font.BOLD , 14));
		panel.add(numOfBookRequired);
		numOfBookEntry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				numOfBookRequired.setText("");
			}
		});
		panel.add(numOfBookEntry);
		
		submit = new JButton("Submit");
		submit.setBounds(250, 450, 150, 40);
		submit.setBackground(new Color(5,22,79));
		submit.setFont(new Font("Tahoma", Font.BOLD , 14));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		panel.add(submit);
		
		JPanel bg = new JPanel();
		bg.setBounds(0, 0, 745, 530);
		bg.setBackground(Color.white);
		bg.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Add Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		bg.setLayout(null);
		panel.add(bg);
	}

    private void random() {			//********Getting Random number for Book id**********//
        Random rd = new Random();
        bookIdEntry.setText("" + rd.nextInt(1000 + 1));
    }

	@Override
	public void actionPerformed(ActionEvent ae) { //**********Action Listener for button action*********//
		if(ae.getSource() == submit) {
			
			String id="", name="", isbn="", publisher="", edition="", price="",pages="", numOfBook="";
			int flag = 0;
			
			id = bookIdEntry.getText();
				
			if(bookNameEntry.getText().isBlank()) {
				bookNameRequired.setText("Required Field !");
			}
			else {
				 name = bookNameEntry.getText();
				 flag = flag+1;
			}
			if(isbnEntry.getText().isBlank()) {
				isbnRequired.setText("Required Field !");
			}
			else {
				 isbn = isbnEntry.getText();
				 flag = flag+1;
			}
			if(publisherEntry.getText().isBlank()) {
				publisherRequired.setText("Required Field !");
			}
			else {
				publisher = publisherEntry.getText();
				flag = flag+1;
			}
			
			edition =  (String)editionEntry.getSelectedItem();

			if(priceEntry.getText().isBlank()) {
				priceRequired.setText("Required Field !");
			}
			else {
				price = priceEntry.getText();
				flag = flag+1;
			}
			if(pagesEntry.getText().isBlank()) {
				pagesRequired.setText("Required Field !");
			}
			else {
				pages = pagesEntry.getText();
				flag = flag+1;
			}
			if(numOfBookEntry.getText().isBlank()) {
				numOfBookRequired.setText("Required Field !");
			}
			else {
				numOfBook = numOfBookEntry.getText();
				flag = flag+1;
			}
			if(flag == 6){
				try {
					Conn c = new Conn();
					c.getStatement().executeUpdate("INSERT INTO book VALUES ('"+id+"','"+name+"','"+isbn+"','"+publisher+"','"+edition+"','"+price+"','"+pages+"', '"+numOfBook+"');");
					JOptionPane.showMessageDialog(null, "Congrats! Data Submitted Successfully");
					refresh();
					c.getStatement().close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Oops! Server Disconnected Try Again Later");
				}
			}
		}
	}
	private void refresh() {
		
		bookNameEntry.setText("");
		isbnEntry.setText("");
		random();
		publisherEntry.setText("");
		priceEntry.setText("");
		pagesEntry.setText("");
		numOfBookEntry.setText("");
	}
}
