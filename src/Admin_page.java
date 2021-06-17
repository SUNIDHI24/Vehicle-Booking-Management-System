import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Admin_page {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page window = new Admin_page();
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
	public Admin_page() {
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
		
		JButton btnNewButton = new JButton("Vehicle");
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_Vehicle av=new Admin_Vehicle();
				av.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setBounds(59, 26, 168, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Driver");
		btnNewButton_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_Driver ad=new Admin_Driver();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(545, 26, 176, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bill");
		btnNewButton_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_Bill abill=new Admin_Bill();
				abill.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(240, 255, 255));
		btnNewButton_2.setBounds(545, 204, 176, 49);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Booking");
		btnNewButton_3.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_Booking ab=new Admin_Booking();
				ab.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 228, 196));
		btnNewButton_3.setBounds(59, 191, 168, 48);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Feed Back");
		btnNewButton_4.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_FeedBack afb=new Admin_FeedBack();
				afb.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(255, 250, 205));
		btnNewButton_4.setBounds(316, 333, 159, 49);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login_page lp=new login_page();
				lp.setVisible(true);
			}
		});
		btnBack.setBackground(SystemColor.menu);
		btnBack.setBounds(680, 419, 94, 31);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\b4.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

}
