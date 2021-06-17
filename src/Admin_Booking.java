import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class Admin_Booking {

	private JFrame frame;
	private JTextField Sloc;
	private JTextField Dloc;
	private JTextField date;
	private JTextField time;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Booking window = new Admin_Booking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable1()
	{
		try{
			String query = "select * from booking ";
			PreparedStatement pst = connection.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	Connection connection= null;
	private JTextField BID;
	private JTextField CID;
	private JTextField VRegNo;
	private JTextField rpkm;
	private JTextField distance;
	private JTextField amt;
	public Admin_Booking() {
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
		
		JLabel lblSloc = new JLabel("Sloc");
		lblSloc.setForeground(new Color(0, 0, 0));
		lblSloc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSloc.setBounds(10, 0, 46, 25);
		frame.getContentPane().add(lblSloc);
		
		JLabel lblDloc = new JLabel("Dloc");
		lblDloc.setForeground(new Color(0, 0, 0));
		lblDloc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDloc.setBounds(10, 25, 46, 25);
		frame.getContentPane().add(lblDloc);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDate.setBounds(10, 50, 46, 25);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(0, 0, 0));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTime.setBounds(10, 75, 46, 25);
		frame.getContentPane().add(lblTime);
		
		Sloc = new JTextField();
		Sloc.setBounds(66, 4, 122, 20);
		frame.getContentPane().add(Sloc);
		Sloc.setColumns(10);
		
		Dloc = new JTextField();
		Dloc.setBounds(66, 29, 122, 20);
		frame.getContentPane().add(Dloc);
		Dloc.setColumns(10);
		
		date = new JTextField();
		date.setBounds(66, 54, 122, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.setBounds(66, 79, 122, 20);
		frame.getContentPane().add(time);
		time.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(123, 104, 238));
		btnSearch.setFont(new Font("Forte", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from booking where BID = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, BID.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Invalid BID");
					pst.close();
					rs1.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(664, 20, 110, 39);
		frame.getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_page ap=new Admin_page();
				ap.setVisible(true);
			}
		});
		btnBack.setBounds(685, 416, 89, 34);
		frame.getContentPane().add(btnBack);
		
		JButton btnView = new JButton("view");
		btnView.setBackground(new Color(238, 232, 170));
		btnView.setFont(new Font("Forte", Font.PLAIN, 14));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from booking ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
										
					table.setModel(DbUtils.resultSetToTableModel(rs));					
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Table is Empty");
					pst.close();
					rs1.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnView.setBounds(523, 21, 110, 36);
		frame.getContentPane().add(btnView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 764, 167);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row=table.getSelectedRow();
					String BID_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from booking where BID= '"+BID_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next())
					{
						BID.setText(rs.getString("BID"));
						VRegNo.setText(rs.getString("VRegNo"));
						CID.setText(rs.getString("CID"));
						Sloc.setText(rs.getString("Sloc"));	
						Dloc.setText(rs.getString("Dloc"));	
						date.setText(rs.getString("DateOfBooking"));
						time.setText(rs.getString("TimeOfBooking"));
						rpkm.setText(rs.getString("rpkm"));
						distance.setText(rs.getString("distance"));
						amt.setText(rs.getString("amt"));	
					}
					pst.close();
					rs.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblBid = new JLabel("BID");
		lblBid.setForeground(new Color(0, 0, 0));
		lblBid.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBid.setBounds(215, 7, 46, 18);
		frame.getContentPane().add(lblBid);
		
		JLabel lblCid = new JLabel("CID");
		lblCid.setForeground(new Color(0, 0, 0));
		lblCid.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCid.setBounds(10, 167, 46, 18);
		frame.getContentPane().add(lblCid);
		
		JLabel lblNewLabel = new JLabel("VRegNo");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 110, 66, 18);
		frame.getContentPane().add(lblNewLabel);
		
		BID = new JTextField();
		BID.setBounds(280, 5, 86, 20);
		frame.getContentPane().add(BID);
		BID.setColumns(10);
		
		CID = new JTextField();
		CID.setBounds(66, 167, 86, 20);
		frame.getContentPane().add(CID);
		CID.setColumns(10);
		
		VRegNo = new JTextField();
		VRegNo.setBounds(66, 110, 122, 20);
		frame.getContentPane().add(VRegNo);
		VRegNo.setColumns(10);
		
		JLabel lblRpkm = new JLabel("rpkm");
		lblRpkm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRpkm.setForeground(new Color(0, 0, 0));
		lblRpkm.setBounds(10, 139, 46, 19);
		frame.getContentPane().add(lblRpkm);
		
		rpkm = new JTextField();
		rpkm.setBounds(66, 138, 122, 20);
		frame.getContentPane().add(rpkm);
		rpkm.setColumns(10);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDistance.setForeground(new Color(0, 0, 0));
		lblDistance.setBounds(198, 51, 81, 25);
		frame.getContentPane().add(lblDistance);
		
		distance = new JTextField();
		distance.setBounds(280, 55, 86, 20);
		frame.getContentPane().add(distance);
		distance.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmount.setForeground(new Color(0, 0, 0));
		lblAmount.setBounds(198, 29, 66, 25);
		frame.getContentPane().add(lblAmount);
		
		amt = new JTextField();
		amt.setBounds(280, 30, 86, 20);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BID.setText("");
					VRegNo.setText("");
					CID.setText("");
					Sloc.setText("");	
					Dloc.setText("");	
					date.setText("");
					time.setText("");
					rpkm.setText("");
					distance.setText("");
					amt.setText("");	
					
					String query = "select * from booking where BID= '"+BID+"' ;";
					PreparedStatement ps;				
					ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Forte", Font.PLAIN, 14));
		btnClear.setBounds(596, 70, 110, 39);
		frame.getContentPane().add(btnClear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\b18.png"));
		label.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
