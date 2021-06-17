import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin_login {

	private JFrame frame;
	private JTextField admin_name;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login window = new Admin_login();
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
	public Admin_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setForeground(new Color(0, 0, 0));
		lblAdminLogin.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 40));
		lblAdminLogin.setBounds(328, 11, 296, 50);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblAdminName = new JLabel("Admin Name");
		lblAdminName.setForeground(new Color(220, 20, 60));
		lblAdminName.setFont(new Font("Myanmar Text", Font.BOLD, 19));
		lblAdminName.setBounds(51, 83, 155, 32);
		frame.getContentPane().add(lblAdminName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(220, 20, 60));
		lblPassword.setFont(new Font("Myanmar Text", Font.BOLD, 19));
		lblPassword.setBounds(51, 127, 107, 33);
		frame.getContentPane().add(lblPassword);
		
		admin_name = new JTextField();
		admin_name.setBounds(246, 84, 148, 28);
		frame.getContentPane().add(admin_name);
		admin_name.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(246, 128, 148, 28);
		frame.getContentPane().add(pwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		btnLogin.setForeground(new Color(102, 0, 102));
		btnLogin.setBackground(new Color(216, 191, 216));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String[] anames = new String[] {"Harshitha","Sunidhi","Punith"};
				for(int i=0;i<anames.length;i++)
				{
				if(admin_name.getText().equals(anames[i]))
				{
					if(pwd.getText().contains("VBMS1")){
						frame.dispose();
						Admin_page ap=new Admin_page();
						ap.setVisible(true);
						return;
					}	
					else
					{
						JOptionPane.showMessageDialog(null, "Enter Valid Password");
						return;
					}	
				}
				}
				
					JOptionPane.showMessageDialog(null, "Invalid Admin Name");
			
			}
		});
		btnLogin.setBounds(246, 185, 129, 38);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(245, 245, 245));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login_page lp=new login_page();
				lp.setVisible(true);
			}
		});
		btnCancel.setBounds(431, 195, 101, 28);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\car.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
