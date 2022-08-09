package library.management.system;

import java.awt.*;

import javax.swing.*;

public class Starting {
	
	private JLabel per;
	private JLabel load;
	private JProgressBar bar;
	private static JFrame frame;
	
	Starting() {
		
		frame = new JFrame("Library Management System");
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/1.jpg"));
		JLabel label = new JLabel(image);
		label.setBounds(0, 0, 500, 350);
		frame.add(label);
		
		load = new JLabel("Loading...");
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Times New Roman", Font.BOLD,14));
		load.setBounds(10,300,200,30);
		label.add(load);
		
		per = new JLabel("0 %");
		per.setForeground(Color.WHITE);
		per.setBackground(new Color(0,0,0,0));
		per.setFont(new Font("Times New Roman", Font.BOLD,14));
		per.setBounds(460,300,40,30);
		label.add(per);
		
		
		bar = new JProgressBar();
		bar.setForeground(Color.blue);
		bar.setOpaque(false);
		bar.setBackground(new Color(0,0,0,0));
		bar.setBounds(5, 330, 490, 13);
		label.add(bar);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/images/favicon.png"));
		frame.setIconImage(icon.getImage());
		
		frame.setSize(500,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Starting st = new Starting();
		frame.setVisible(true);
		try {
			for(int i = 0; i <= 100; i++) {
				Thread.sleep(100);
				st.per.setText(i +"%");
				if(i==10) {
					st.load.setText("Turning On Modules...");
				}
				if(i==20) {
					st.load.setText("Loading Modules...");
					st.bar.setForeground(Color.red);
				}
				if(i==50) {
					st.load.setText("Connecting to Database...");
					Conn c = new Conn();
					c.getStatement().executeQuery("show Databases");
				}
				if(i==70) {
					st.load.setText("Connetted Successfully !");
					st.bar.setForeground(Color.green);
				}
				if(i==80) {
					st.load.setText("Launching Application...");
				}
				st.bar.setValue(i);
			}
			for(int i = 0; i <= 40; i++) {
				Thread.sleep(40);
				if(i == 40) {
					SignIn.getInstance().setVisible(true);
					frame.setVisible(false);
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Oops Server not Found Try Again Later :(");
			System.exit(0);
			
		}
	}

}
