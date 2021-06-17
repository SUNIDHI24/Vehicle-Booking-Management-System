import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.UIManager;
import java.awt.Color;

public class max_confirm {

	private JFrame frame;
	private JTextField date;
	private JTextField time;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					max_confirm window = new max_confirm();
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
	public max_confirm() {
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
		
		JLabel lblSourceLocation = new JLabel("Source Location");
		lblSourceLocation.setForeground(Color.BLACK);
		lblSourceLocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSourceLocation.setBounds(10, 37, 144, 25);
		frame.getContentPane().add(lblSourceLocation);
		
		JComboBox<String> SLoc = new JComboBox<String>();
		SLoc.setBounds(198, 39, 204, 25);
		frame.getContentPane().add(SLoc);				
		SLoc.addItem("Select Source Location");
		SLoc.addItem("J P Nagar");
		SLoc.addItem("Kuvempu Nagar");
		SLoc.addItem("Jayalakshmipuram");
		SLoc.addItem("Saraswathipuram");
		SLoc.addItem("Hebbal");
		SLoc.addItem("Sidhartha Layout");
		SLoc.addItem("Bannimatap");
		SLoc.addItem("Mysore Palace");
		SLoc.addItem("Hootgalli");
		SLoc.addItem("Bogadi");
		
		JLabel lblDestinationLocation = new JLabel("Destination Location");
		lblDestinationLocation.setForeground(Color.BLACK);
		lblDestinationLocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDestinationLocation.setBounds(10, 71, 194, 25);
		frame.getContentPane().add(lblDestinationLocation);
		
		JComboBox<String> DLoc = new JComboBox<String>();
		DLoc.setBounds(198, 75, 204, 25);
		frame.getContentPane().add(DLoc);
		DLoc.addItem("Select Destination Location");
		DLoc.addItem("J P Nagar");
		DLoc.addItem("Kuvempu Nagar");
		DLoc.addItem("Jayalakshmipuram");
		DLoc.addItem("Saraswathipuram");
		DLoc.addItem("Hebbal");
		DLoc.addItem("Sidhartha Layout");
		DLoc.addItem("Bannimatap");
		DLoc.addItem("Mysore Palace");
		DLoc.addItem("Hootgalli");
		DLoc.addItem("Bogadi");
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(10, 112, 46, 25);
		frame.getContentPane().add(lblDate);
		
		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		date.setBounds(198, 107, 122, 25);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(Color.BLACK);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(10, 148, 46, 25);
		frame.getContentPane().add(lblTime);
		
		time = new JTextField();
		time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		time.setBounds(198, 147, 122, 25);
		frame.getContentPane().add(time);
		time.setColumns(10);
		
		JLabel lblModeOfPayment = new JLabel("Mode Of Payment");
		lblModeOfPayment.setForeground(Color.WHITE);
		lblModeOfPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModeOfPayment.setBounds(10, 184, 131, 22);
		frame.getContentPane().add(lblModeOfPayment);
		
		JComboBox<String> Mode = new JComboBox<String>();
		Mode.setBounds(198, 183, 122, 22);
		frame.getContentPane().add(Mode);
		Mode.addItem("Cash");
		Mode.addItem("Online");
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int dis=0;
					if(SLoc.getSelectedItem().toString() == DLoc.getSelectedItem().toString())
					{
						JOptionPane.showMessageDialog(null, "Invalid source and destination location");	
						return;
					}
					if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Saraswathipuram") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Saraswathipuram"))
						dis=6;							
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Jayalakshmipuram") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Jayalakshmipuram"))
						dis=10;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Kuvempu Nagar") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Kuvempu Nagar"))
						dis=4;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Hebbal") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Hebbal"))
						dis=19;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Sidhartha Layout") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Sidhartha Layout"))
						dis=10;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=11;											
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=8;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=16;					
					else if((SLoc.getSelectedItem().toString() == "J P Nagar" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "J P Nagar" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=11;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Jayalakshmipuram") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Jayalakshmipuram"))
						dis=4;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Kuvempu Nagar") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Kuvempu Nagar"))
						dis=2;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Hebbal") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Hebbal"))
						dis=11;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Sidhartha Layout") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Sidhartha Layout"))
						dis=7;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=7;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=3;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=9;					
					else if((SLoc.getSelectedItem().toString() == "Saraswathipuram" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Saraswathipuram" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Kuvempu Nagar") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Kuvempu Nagar"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Hebbal") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Hebbal"))
						dis=8;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Sidhartha Layout") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Sidhartha Layout"))
						dis=9;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Jayalakshmipuram" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Jayalakshmipuram" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Hebbal") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Hebbal"))
						dis=13;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Sidhartha Layout") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Sidhartha Layout"))
						dis=8;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=8;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=10;					
					else if((SLoc.getSelectedItem().toString() == "Kuvempu Nagar" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Kuvempu Nagar" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Hebbal" && DLoc.getSelectedItem().toString() == "Sidhartha Layout") || (DLoc.getSelectedItem().toString() == "Hebbal" && SLoc.getSelectedItem().toString() == "Sidhartha Layout"))
						dis=18;					
					else if((SLoc.getSelectedItem().toString() == "Hebbal" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "Hebbal" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=8;					
					else if((SLoc.getSelectedItem().toString() == "Hebbal" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Hebbal" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=11;					
					else if((SLoc.getSelectedItem().toString() == "Hebbal" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Hebbal" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=4;					
					else if((SLoc.getSelectedItem().toString() == "Hebbal" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Hebbal" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=7;					
					else if((SLoc.getSelectedItem().toString() == "Sidhartha Layout" && DLoc.getSelectedItem().toString() == "Bannimatap") || (DLoc.getSelectedItem().toString() == "Sidhartha Layout" && SLoc.getSelectedItem().toString() == "Bannimatap"))
						dis=7;					
					else if((SLoc.getSelectedItem().toString() == "Sidhartha Layout" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Sidhartha Layout" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Sidhartha Layout" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Sidhartha Layout" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=13;					
					else if((SLoc.getSelectedItem().toString() == "Sidhartha Layout" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Sidhartha Layout" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=11;					
					else if((SLoc.getSelectedItem().toString() == "Bannimatap" && DLoc.getSelectedItem().toString() == "Mysore Palace") || (DLoc.getSelectedItem().toString() == "Bannimatap" && SLoc.getSelectedItem().toString() == "Mysore Palace"))
						dis=5;					
					else if((SLoc.getSelectedItem().toString() == "Bannimatap" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Bannimatap" && SLoc.getSelectedItem().toString() == "Hootgalli"))
						dis=11;					
					else if((SLoc.getSelectedItem().toString() == "Bannimatap" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Bannimatap" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=12;					
					else if((SLoc.getSelectedItem().toString() == "Mysore Palace" && DLoc.getSelectedItem().toString() == "Hootgalli") || (DLoc.getSelectedItem().toString() == "Mysore Palace" && SLoc.getSelectedItem().toString() == "Hootgalli"))
					 	dis=7;
					else if((SLoc.getSelectedItem().toString() == "Hootgalli" && DLoc.getSelectedItem().toString() == "Bogadi") || (DLoc.getSelectedItem().toString() == "Hootgalli" && SLoc.getSelectedItem().toString() == "Bogadi"))
						dis=5;
					String VR;
					String mo=Mode.getSelectedItem().toString();
					String query1="select VRegNo from v_details where VID=4 and status ='available';";
					PreparedStatement ps = connection.prepareStatement(query1);
				
					ResultSet rs = ps.executeQuery();	
					
					if(rs.next())
					{	
						
						VR = rs.getString("VRegNo");
						String S=String.valueOf(SLoc.getSelectedItem());
						String D=String.valueOf(DLoc.getSelectedItem());					
						
						String qm="select myCID from login_history where Hno= (select max(Hno) from login_history);";
						PreparedStatement pm = connection.prepareStatement(qm);					
						pm.executeQuery();
						ResultSet rm = pm.executeQuery();
						if(rm.next())
						{
							String cid = rm.getString("myCID");
						String query = "insert into booking(VRegNo,CID,Sloc, Dloc, DateOfBooking, TimeOfBooking,rpkm,distance) values ('"+VR+"','"+cid+"','"+S+"','"+D+"','"+String.valueOf(java.time.LocalDate.now())+"','"+String.valueOf(java.time.LocalTime.now())+"',16,'"+dis+"'); ";
						PreparedStatement pst = connection.prepareStatement(query);					
						pst.execute();
					
						JOptionPane.showMessageDialog(null, "Booking Confirmed");
					
						pst.close();
						
						String q2="call amt_cal();";
						PreparedStatement p1 = connection.prepareStatement(q2);					
						p1.execute();
						
						p1.close();
						
						pm.close();
						rm.close();
						ps.close();
						rs.close();
						frame.dispose();
						aft_booking abk=new aft_booking();
						abk.setVisible(true);	
						}
					}
					if(mo.matches("Online"))
					{
						String query = " update billing set status = 'paid' where  BID=(select max(BID) from booking); ";
						PreparedStatement pt = connection.prepareStatement(query);
						
						  pt.execute();
					}
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		btnConfirmBooking.setBackground(new Color(255, 218, 185));
		btnConfirmBooking.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnConfirmBooking.setBounds(37, 245, 259, 47);
		frame.getContentPane().add(btnConfirmBooking);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				vehicle_type vt=new vehicle_type();
				vt.setVisible(true);
			}
		});
		btnCancle.setBounds(644, 418, 100, 35);
		frame.getContentPane().add(btnCancle);
		
		
		String d1=String.valueOf(java.time.LocalDate.now());
		String t1=String.valueOf(java.time.LocalTime.now());
		date.setText(d1);
		time.setText(t1);
		
		JLabel CID = new JLabel("");
		CID.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\car4.jpg"));
		CID.setBounds(0, 0, 816, 511);
		frame.getContentPane().add(CID);
				
				
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
