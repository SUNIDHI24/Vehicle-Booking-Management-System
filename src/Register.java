import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

//import javax.swing.ImageIcon;
//import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
//import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JComboBox;




public class Register {

	private JFrame frame;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField DOB;
	private JTextField C_add;
	private JTextField Phno;
	private JTextField new_usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	private JTextField mailID;
	private JPasswordField new_pwd;
	private JPasswordField new_pwd_con;
	private JLabel lblNewLabel_3;
	private JLabel lblyyyymmdd;
	private JComboBox<String> G;
	public Register() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name *");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(447, 35, 120, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLname = new JLabel("Last Name");
		lblLname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLname.setBounds(447, 67, 120, 21);
		frame.getContentPane().add(lblLname);
		
		Fname = new JTextField();
		Fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fname.setBounds(597, 33, 131, 25);
		frame.getContentPane().add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lname.setBounds(597, 67, 131, 25);
		frame.getContentPane().add(Lname);
		Lname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender *");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(447, 99, 82, 21);
		frame.getContentPane().add(lblGender);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDob.setBounds(577, 99, 65, 21);
		frame.getContentPane().add(lblDob);
		
		DOB = new JTextField();
		DOB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DOB.setBounds(634, 97, 94, 25);
		frame.getContentPane().add(DOB);
		DOB.setColumns(10);
		
		JLabel lblCadd = new JLabel("Address");
		lblCadd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadd.setBounds(447, 152, 100, 21);
		frame.getContentPane().add(lblCadd);
		
		C_add = new JTextField();
		C_add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_add.setBounds(447, 173, 281, 25);
		frame.getContentPane().add(C_add);
		C_add.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name *");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(447, 272, 120, 18);
		frame.getContentPane().add(lblUserName);
		
		Phno = new JTextField();
		Phno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Phno.setBounds(608, 238, 120, 25);
		frame.getContentPane().add(Phno);
		Phno.setColumns(10);
		
		new_usr = new JTextField();
		new_usr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		new_usr.setBounds(608, 269, 120, 25);
		frame.getContentPane().add(new_usr);
		new_usr.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(447, 301, 82, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmPassword.setBounds(447, 334, 162, 21);
		frame.getContentPane().add(lblConfirmPassword);
		
		G = new JComboBox<String>();
		G.setBounds(527, 99, 49, 25);
		frame.getContentPane().add(G);
		G.addItem("M");
		G.addItem("F");
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignup.setForeground(SystemColor.textText);
		btnSignup.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String firstname = Fname.getText();
				String lastname = Lname.getText();												
				String dob = DOB.getText();
				String add = C_add.getText();
				String mail = mailID.getText();
				String usr = new_usr.getText();
				String pwd = new_pwd.getText();
				String phone = Phno.getText();
				int len = phone.length();
				int l2 = dob.length();
				int len1 = pwd.length();
				if (firstname.matches("[a-zA-Z]+") == false){
					JOptionPane.showMessageDialog(null, "Enter Valid Name");
				}				
				if(l2 != 10 ){
					JOptionPane.showMessageDialog(null, "Invalid Date Format");
				}
				
				if(len != 10)  {
					JOptionPane.showMessageDialog(null, "Invalid Phone Number");
					
				}
				if(phone.matches("[0-9]+") == false )
				{
					JOptionPane.showMessageDialog(null, "Invalid Phone Number");
				}
				if(usr.matches("[a-zA-Z]+") == false)
				{
					JOptionPane.showMessageDialog(null, "Enter Valid User Name");	
					//return;
				}
				if(len1 >6)
				{
				if((new_pwd.getText()).equals(new_pwd_con.getText()))
				{
					
					try{
						String query = "insert into Customer(Fname ,Lname ,Gender ,DOB ,C_add ,mailID ,usr ,pwd ,phno) values ('"+firstname+"','"+lastname+"','"+G.getSelectedItem()+"','"+dob+"','"+add+"','"+mail+"','"+usr+"','"+pwd+"','"+phone+"'); ";
						PreparedStatement pst = connection.prepareStatement(query);
										
						pst.execute();
					
						JOptionPane.showMessageDialog(null, "Your Details Saved....\n Login with your username and password");
										
						pst.close();
				
						frame.dispose();
						login_page lp=new login_page();
						lp.setVisible(true);	
					
						return;
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Enter Valid Password");
				}	
			
				else{
					JOptionPane.showMessageDialog(null, "Enter atleast six characterss for password field");
				}
		}
		});
		btnSignup.setBackground(new Color(204, 51, 51));
		btnSignup.setBounds(513, 388, 170, 35);
		frame.getContentPane().add(btnSignup);
		
		JLabel lblMailid = new JLabel("mail_ID");
		lblMailid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMailid.setBounds(447, 209, 82, 20);
		frame.getContentPane().add(lblMailid);
		
		mailID = new JTextField();
		mailID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mailID.setBounds(580, 209, 148, 25);
		frame.getContentPane().add(mailID);
		mailID.setColumns(10);
		
		new_pwd = new JPasswordField();
		new_pwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		new_pwd.setBounds(608, 298, 120, 25);
		frame.getContentPane().add(new_pwd);
		
		new_pwd_con = new JPasswordField();
		new_pwd_con.setFont(new Font("Tahoma", Font.PLAIN, 15));
		new_pwd_con.setBounds(608, 332, 120, 25);
		frame.getContentPane().add(new_pwd_con);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\b5.jpg"));
		lblNewLabel_3.setBounds(0, 0, 441, 461);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Phno *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(447, 240, 71, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblyyyymmdd = new JLabel("(yyyy-mm-dd)");
		lblyyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblyyyymmdd.setBounds(634, 131, 112, 14);
		frame.getContentPane().add(lblyyyymmdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				login_page lp=new login_page();
				lp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(685, 427, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
	}

	public void setVisible(boolean b) {	
		frame.setVisible(true);
	}
}
