import java.awt.EventQueue;
//import java.awt.print.*;
//import javafx.print.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;

//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;


public class aft_booking {

	private JFrame frame;
	private JTextField Sloc;
	private JTextField Dloc;
	private JTextField date;
	private JTextField BID;
	private JTextField VRegNo;
	private JTextField Dname;
	private JTextField Phno;
	private JTextField Bno;
	private JTextField amt;
	private JTextField status;
	private JTextField features;
	private JTextField time;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aft_booking window = new aft_booking();
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
	private JTextField DID;
	private JTextField Distance;
	private JTextField rpkm;
	public aft_booking() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 809, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thanks For Booking");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(166, 0, 566, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblYourRideDetails = new JLabel("Your Ride Details:");
		lblYourRideDetails.setBackground(new Color(255, 255, 255));
		lblYourRideDetails.setForeground(new Color(0, 51, 255));
		lblYourRideDetails.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblYourRideDetails.setBounds(10, 66, 258, 30);
		frame.getContentPane().add(lblYourRideDetails);
		
		JLabel lblNewLabel_1 = new JLabel("Source Location");
		lblNewLabel_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 107, 145, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destination Location");
		lblNewLabel_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 168, 169, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setForeground(new Color(255, 255, 224));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 229, 94, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BID");
		lblNewLabel_4.setForeground(new Color(255, 255, 224));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 278, 46, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("VRegNo");
		lblNewLabel_5.setForeground(new Color(255, 255, 224));
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 304, 77, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Driver Name");
		lblNewLabel_6.setForeground(new Color(255, 255, 224));
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_6.setBounds(282, 105, 128, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Phone Number");
		lblNewLabel_7.setForeground(new Color(255, 255, 224));
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_7.setBounds(282, 168, 145, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		Sloc = new JTextField();
		Sloc.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		Sloc.setBackground(Color.WHITE);
		Sloc.setBounds(10, 138, 226, 22);
		frame.getContentPane().add(Sloc);
		Sloc.setColumns(10);
		
		Dloc = new JTextField();
		Dloc.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		Dloc.setBounds(10, 197, 226, 22);
		frame.getContentPane().add(Dloc);
		Dloc.setColumns(10);
		
		date = new JTextField();
		date.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		date.setBounds(114, 227, 122, 22);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		BID = new JTextField();
		BID.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		BID.setBounds(114, 279, 122, 22);
		frame.getContentPane().add(BID);
		BID.setColumns(10);
		
		VRegNo = new JTextField();
		VRegNo.setBounds(114, 304, 122, 22);
		frame.getContentPane().add(VRegNo);
		VRegNo.setColumns(10);
		
		Dname = new JTextField();
		Dname.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		Dname.setBounds(292, 139, 163, 22);
		frame.getContentPane().add(Dname);
		Dname.setColumns(10);
		
		Phno = new JTextField();
		Phno.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		Phno.setBounds(292, 201, 122, 22);
		frame.getContentPane().add(Phno);
		Phno.setColumns(10);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setForeground(new Color(0, 0, 0));
		lblBill.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblBill.setBounds(529, 72, 63, 30);
		frame.getContentPane().add(lblBill);
		
		JLabel lblNewLabel_8 = new JLabel("Bno");
		lblNewLabel_8.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel_8.setBounds(532, 174, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Amount");
		lblNewLabel_9.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel_9.setBounds(529, 315, 63, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Status");
		lblNewLabel_10.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel_10.setBounds(529, 284, 63, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		Bno = new JTextField();
		Bno.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		Bno.setBounds(618, 173, 86, 18);
		frame.getContentPane().add(Bno);
		Bno.setColumns(10);
		
		amt = new JTextField();
		amt.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		amt.setBounds(618, 315, 86, 18);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
		
		status = new JTextField();
		status.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		status.setBounds(618, 283, 86, 18);
		frame.getContentPane().add(status);
		status.setColumns(10);
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 16));
		lblReceipt.setBounds(579, 125, 77, 24);
		frame.getContentPane().add(lblReceipt);
		
		JLabel label = new JLabel("------------------------------------------");
		label.setFont(new Font("MS Reference Specialty", Font.BOLD, 13));
		label.setBounds(529, 141, 194, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("------------------------------------------");
		label_1.setFont(new Font("MS Reference Specialty", Font.BOLD, 13));
		label_1.setBounds(539, 342, 184, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblFeatures = new JLabel("Features");
		lblFeatures.setForeground(new Color(255, 255, 224));
		lblFeatures.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblFeatures.setBounds(292, 233, 100, 25);
		frame.getContentPane().add(lblFeatures);
		
		features = new JTextField();
		features.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		features.setBounds(292, 266, 189, 22);
		frame.getContentPane().add(features);
		features.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(649, 443, 116, 39);
		frame.getContentPane().add(btnClose);
		
		time = new JTextField();
		time.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		time.setBounds(114, 255, 122, 22);
		frame.getContentPane().add(time);
		time.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(255, 255, 224));
		lblTime.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTime.setBounds(10, 257, 65, 17);
		frame.getContentPane().add(lblTime);
		
		
		
			
		JButton btnView = new JButton("View");
		btnView.setBackground(new Color(219, 112, 147));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					String query = " select * from aft_booking where Bno=(select max(Bno) from aft_booking ); ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
				//	if(Mode.contains("Online"))
					//{
					//	amt.setText("Paid");
				//	}
					
					while(rs.next())
					{
						Sloc.setText(rs.getString("Sloc"));
						Dloc.setText(rs.getString("Dloc"));
						date.setText(rs.getString("DateOfBooking"));
						time.setText(rs.getString("TimeOfBooking"));
						BID.setText(rs.getString("BID"));
						VRegNo.setText(rs.getString("VRegNo"));
						Dname.setText(rs.getString("Dname"));
						Phno.setText(rs.getString("Phone"));
						DID.setText(rs.getString("Phone"));
						features.setText(rs.getString("features"));
						Bno.setText(rs.getString("Bno"));
						Distance.setText(rs.getString("distance"));
						rpkm.setText(rs.getString("rpkm"));
						amt.setText(rs.getString("amt"));
						status.setText(rs.getString("status"));
					}
					pst.close();
					rs.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnView.setBounds(61, 428, 109, 39);
		frame.getContentPane().add(btnView);
		
		
		
		
		JLabel labelDD = new JLabel("DID");
		labelDD.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		labelDD.setForeground(new Color(255, 255, 240));
		labelDD.setBounds(10, 337, 46, 22);
		frame.getContentPane().add(labelDD);
		
		DID = new JTextField();
		DID.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		DID.setBounds(114, 337, 122, 22);
		frame.getContentPane().add(DID);
		DID.setColumns(10);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblDistance.setBounds(529, 209, 79, 14);
		frame.getContentPane().add(lblDistance);
		
		Distance = new JTextField();
		Distance.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		Distance.setBounds(618, 199, 86, 20);
		frame.getContentPane().add(Distance);
		Distance.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Rate per km");
		lblNewLabel_12.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel_12.setBounds(529, 227, 152, 22);
		frame.getContentPane().add(lblNewLabel_12);
		
		rpkm = new JTextField();
		rpkm.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		rpkm.setBounds(618, 252, 86, 20);
		frame.getContentPane().add(rpkm);
		rpkm.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\rr2.png"));
		lblNewLabel_11.setBounds(505, 116, 242, 243);
		frame.getContentPane().add(lblNewLabel_11);
		
		
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\WhatsApp Image 2020-12-22 at 9.44.56 PM.jpeg"));
		label_2.setBounds(0, 0, 793, 521);
		frame.getContentPane().add(label_2);
		
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
