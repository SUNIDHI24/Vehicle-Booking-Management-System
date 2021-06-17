import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class vehicle_type {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehicle_type window = new vehicle_type();
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
	public vehicle_type() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textInactiveText);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login_page lp=new login_page();
				lp.setVisible(true);
			}
		});
		btnHome.setBackground(SystemColor.activeCaption);
		btnHome.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnHome);
		
		JButton btnNewButton = new JButton("Auto");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int vid_=1;
				frame.dispose();
				auto_confirm ak=new auto_confirm();
				ak.setVisible(true);
			}
		});
		btnNewButton.setBounds(118, 188, 110, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bike");
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				bike_confirm bk=new bike_confirm();
				bk.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(326, 188, 98, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Car mini(non A/C)");
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mini_confirm mi=new mini_confirm();
				mi.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(541, 188, 233, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Car max(A/C)");
		btnNewButton_3.setBackground(new Color(238, 232, 170));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				max_confirm mx=new max_confirm();
				mx.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(181, 380, 140, 32);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Car Prime(A/C,free wifi)");
		btnNewButton_4.setBackground(new Color(176, 196, 222));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				prime_confirm pr=new prime_confirm();
				pr.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(452, 380, 236, 32);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\auto1.jpg"));
		label.setBounds(93, 53, 149, 124);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\bike.jpg"));
		label_1.setBounds(274, 53, 195, 124);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(new Color(255, 255, 255));
		label_2.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\mini.jpg"));
		label_2.setBounds(582, 53, 147, 124);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBackground(new Color(255, 255, 255));
		label_3.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\max.jpg"));
		label_3.setBounds(181, 278, 169, 91);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\prime.jpg"));
		label_4.setBounds(474, 262, 214, 107);
		frame.getContentPane().add(label_4);
		
		
		
		JButton btnNewButton_5 = new JButton("Give FeedBack");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				FeedBack fb=new FeedBack();
				fb.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(250, 128, 114));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(128, 11, 179, 31);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\ca.jpg"));
		label_5.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label_5);
	
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
