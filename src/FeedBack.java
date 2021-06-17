import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
//import javax.swing.ImageIcon;

public class FeedBack {

	private JFrame frame;
	private JTextField cmts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBack window = new FeedBack();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection= null;
	public FeedBack() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(255, 255, 204));
		lblRating.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 23));
		lblRating.setBounds(8, 69, 112, 26);
		frame.getContentPane().add(lblRating);
		
		JLabel lblCmts = new JLabel("Comments");
		lblCmts.setForeground(new Color(255, 255, 204));
		lblCmts.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 23));
		lblCmts.setBounds(8, 133, 192, 26);
		frame.getContentPane().add(lblCmts);
		
		cmts = new JTextField();
		cmts.setBounds(184, 133, 251, 26);
		frame.getContentPane().add(cmts);
		cmts.setColumns(10);
		
		JComboBox<String> rating = new JComboBox<String>();
		rating.setBounds(135, 69, 85, 26);
		frame.getContentPane().add(rating);
		rating.addItem("1");
		rating.addItem("2");
		rating.addItem("3");
		rating.addItem("4");
		rating.addItem("5");
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
												
						String cmt = cmts.getText();
						String q1="select DID from aft_booking where BID= (select max(BID) from aft_booking);";
						PreparedStatement dd = connection.prepareStatement(q1);					
						dd.executeQuery();
						ResultSet rd =dd.executeQuery();
						if(rd.next())
						{
							
							String did=rd.getString("DID");
							String qm="select myCID from login_history where Hno= (select max(Hno) from login_history);";
							PreparedStatement pm = connection.prepareStatement(qm);					
							pm.executeQuery();
							ResultSet rm = pm.executeQuery();
							if(rm.next())
							{
							String cid = rm.getString("myCID");
							String query = "insert into feedback(CID,DID,rating,cmts) values('"+cid+"','"+did+"','"+rating.getSelectedItem()+"','"+cmt+"') ; ";
							PreparedStatement pst = connection.prepareStatement(query);					
							pst.execute();
							JOptionPane.showMessageDialog(null, "Thank You for giving your valuable FeedBack....\n Your Response Is saved");
							
					
							pst.close();
							}
							
						}
					}catch(Exception e1)
					{
					e1.printStackTrace();
					}							    					
			}
		});
		btnNewButton.setBounds(57, 235, 143, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				vehicle_type vt=new vehicle_type();
				vt.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(509, 412, 99, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(675, 412, 99, 38);
		frame.getContentPane().add(btnExit);
		
		JLabel lblTolowesthighest = new JLabel("1 to 5(1-lowest,5-highest)");
		lblTolowesthighest.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTolowesthighest.setForeground(new Color(255, 255, 255));
		lblTolowesthighest.setBounds(251, 80, 148, 14);
		frame.getContentPane().add(lblTolowesthighest);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\taxi1.jpg"));
		label.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label);				
			
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
