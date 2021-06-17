import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
//import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

//import javax.swing.JOptionPane;
public class login_page {

	private JFrame frame;
	private JTextField usr;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
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
	public login_page() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame.setBounds(100, 100, 878, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name *");
		lblUserName.setBackground(Color.LIGHT_GRAY);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblUserName.setBounds(564, 294, 126, 25);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassward = new JLabel("Password");
		lblPassward.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblPassward.setBounds(564, 343, 86, 25);
		frame.getContentPane().add(lblPassward);
		
		usr = new JTextField();
		usr.setFont(new Font("Arial", Font.PLAIN, 15));
		usr.setBounds(700, 296, 141, 25);
		frame.getContentPane().add(usr);
		usr.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("Arial", Font.PLAIN, 15));
		pwd.setEchoChar('*');
		pwd.setBounds(700, 345, 141, 25);
		frame.getContentPane().add(pwd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from customer where usr=? and pwd =? ;";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usr.getText());
					pst.setString(2, pwd.getText());
					
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()){
						count+=1;
						
					}
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null, "username and password is valid");
						frame.dispose();
						vehicle_type vt=new vehicle_type();
						vt.setVisible(true);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "username and password is Invalid......\nTry Again");
					}
					
					
					rs.close();
					pst.close();
					
					try{
						String myCID;
						String que1="select CID from customer where usr=? and pwd =?;";
						PreparedStatement ex = connection.prepareStatement(que1);
						ex.setString(1, usr.getText());
						ex.setString(2, pwd.getText());
						ResultSet er = ex.executeQuery();
						if(er.next())
						{
							myCID=er.getString("CID");
											
							String q1="insert into login_history(myCID) values ('"+myCID+"');"	;
							PreparedStatement ex1 = connection.prepareStatement(q1);					
							ex1.execute();
							ex1.close();
						}
						er.close();
						ex.close();
					}catch(Exception e2)
					{
						e2.printStackTrace();
					}						
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
					
			}
		});
		btnNewButton.setBounds(559, 394, 125, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Register r=new Register();
				r.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(731, 394, 110, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin Login");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Admin_login a=new Admin_login();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(245, 222, 179));
		btnNewButton_2.setBounds(664, 447, 130, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\main3.png"));
		label_1.setBounds(0, 0, 862, 496);
		frame.getContentPane().add(label_1);
		
		
	}
	

		
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
